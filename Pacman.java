import java.util.ArrayList;

public class Pacman extends Characters
{
	private int score;	    // score du player
	private int lives; 		// initialement trois vies
    private PacmanState state;
    

	private ArrayList<Observer> observers;
	
	private Direction direction;
	
	private Direction previous;

	private static final int fullTimer = 50;

	private int newLife = 0;
	
	public Pacman (Game g)
	{
		this.game  	   =  g;
		this.score 	   =  0;
		this.state = new PacmanNormalState(this);
		this.lives 	   =  3;
		this.direction = Direction.Still;
		this.previous  = Direction.Still;		
		this.observers = new ArrayList<Observer>();
	}
	
	/////////////////////////////
	
	public int getScore() 
	{
		return this.score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public int getLives() 
	{
		return this.lives;
	}
	
	public void setLives(int lives)
	{
		this.lives = lives;
	}
	
	void changeState(PacmanState state)
	{
		this.state = state;
	}
	
	public PacmanState.PState nameState() 
	{
		return state.getState();
	}
	
	public Direction getDirection() 
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public Direction getPrevious() 
	{
		return previous;
	}

	public void setPrevious(Direction previous) 
	{
		this.previous = previous;
	}
	/////////////////////////////
	
	public void beNormal() 
	{
		this.changeState(new PacmanNormalState(this) );
	}
	
	public void beSuperPacman() 
	{
		this.changeState(new SuperPacmanState(this) );

	}
	
	public void beInvisible() 
	{
		this.changeState(new InvisibleState(this) );

	}
	
	public void addObserver(Observer o)
	{
		observers.add(o);
	}

	public void notifyObserver()
	{
		for(Observer observer : observers)
		{
			observer.update();
		}
	}
	
	/////////////////////////////
	
	public void addScore(Gum g)
	{ 
		this.score += g.getScore();
		newLife();
	}	
	
	public void newLife()
	{
		if(this.score >= 5000 && newLife == 0)
		{
			++this.lives;
			newLife = 1;
		}
	}	
	
	public void loseLife() 
	{
		notifyObserver();
		if(this.lives > 0)
		{
			--this.lives;
		}
		if(this.lives == 0)
		{	
			game.gameOver(0);
		}
	}
	
	/////////////////////////////
	
	public void eatGum(Gum g) 
	{
		notifyObserver();
		switch(g.getType())
		{
			case 0 : // Blue
				eatBlue(g);
			break;
		
			case 1 : // Violet = Pacman invisible
				eatPurple(g);
			break;
			
			case 2 : // Orange = SuperPacman
				eatOrange(g);
			break;
			
			case 3 : // Green New Structure labyrinthe
				eatGreen(g);
			break;
		}
	}
	
	public void eatBlue(Gum g)
	{
		this.addScore(g);
		
		game.getMap().getMap()[x][y] = Element.N;
		game.decCompteurGum();
	}
	
	public void eatPurple(Gum g)
	{
		this.addScore(g);
		this.beInvisible(); 
		
		for(int i = 0 ; i < game.getGhosts().length ; ++i)
		{
			game.getGhosts()[i].beNormal();
		}

		game.getMap().getMap()[x][y] = Element.N;
		game.decCompteurGum();
		
		game.setPowerTimer(fullTimer);
	}
	
	public void eatOrange(Gum g)
	{
		this.addScore(g);
		this.beSuperPacman();
		
		for(int i = 0 ; i < game.getGhosts().length ; ++i)
		{
			game.getGhosts()[i].beVulnerable();
		}

		game.getMap().getMap()[x][y] = Element.N;
		game.decCompteurGum();
		
		game.setPowerTimer(fullTimer);
	}
	
	public void eatGreen(Gum g)
	{
		this.addScore(g);	    
		
		game.getMap().setNewMap();
		
		game.getMap().getMap()[x][y] = Element.N;
		game.decCompteurGum();
	}

	/////////////////////////////
	
	@Override
	public void move()
	{
		if(!game.isOut(x + direction.getX(), y + direction.getY()) && game.getMap().getMap()[x + direction.getX()][y + direction.getY()] != Element.W) 
		{
				x += direction.getX();
				y += direction.getY();
			
		}
		
		notifyObserver();
	}
	
	public void cross()
	{
		int future_x = x;
		int future_y = y;
		
		switch(direction)
		{
			case Left  :
				specialLeft();
				future_x = x - 1;
			break;
			case Right :
				specialRight();
				future_x = x + 1;
				break;
			case Up :
				specialUp();
				future_y = y - 1;
				break;
			case Down :
				specialDown();
				future_y = y + 1;
				break;
		}
		
		// si pas de collision fantome on verifie le reste
		if(!ghostCollision(future_x, future_y) && !ghostCollision(x,y))
		switch(game.getMap().getMap()[future_x][future_y])
		{
			case N :  // nothing
				move();
			break;
			case G  : // gums
				move();
				for(int i = 0 ; i < game.getGums().length ; ++i)
					if(game.getGums()[i].x == future_x && game.getGums()[i].y == future_y)
						eatGum(game.getGums()[i]);
			break;
			case W :
			//	wallCollision();
				direction = Direction.Still;
			break;
		}	
	}
	
	public void wallCollision()
	{
		int previous_x = x;
		int previous_y = y;
		switch(previous)
		{
			case Left  :
				previous_x = x - 1;
			break;
			
			case Right :
				previous_x = x + 1;
			break;
			
			case Up :
				previous_y = y - 1;
			break;
			
			case Down :
				previous_y = y + 1;
			break;
		}
		
		if(game.getMap().getMap()[previous_x][previous_y] != Element.W)
		{
			setDirection(previous);
			move();
		}
	}
	
	public boolean wallCollisionPower(int future_x, int future_y)
	{
		if(game.getMap().getMap()[future_x][future_y] == Element.W)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean ghostCollision(int future_x, int future_y)
	{
		for(int i = 0 ; i < game.getGhosts().length; ++i)
		{
			if(future_x == game.getGhosts()[i].x && future_y == game.getGhosts()[i].y)
			{
				state.ghostCollision(i, future_x, future_y);		
				return true;
			}
		}
		return false;
	}
	
	public void restartAfterCollision()
	{
		x = 3;
		y = 5;
		direction = Direction.Still;
		beNormal();
		game.restartAfterCollision();
	}
	
	public void specialLeft()
	{
		if( x - 1 < 0 && y == 8)
		{
			x = 18;
			y = 8 ;
		}
	}
	
	public void specialRight()
	{
		if( x + 1 > 17 && y == 8)
		{
			x = -1;
			y =  8;
		}
	}
	
	public void specialUp() 
	{
		if( y - 1 < 0 && x == 7)
		{
			x = 7 ;
			y = 18;
		}
	}
	
	public void specialDown()
	{
		if( y + 1 > 17 && x == 7)
		{
			x =  7;
			y = -1;
		}
	}
	
}
