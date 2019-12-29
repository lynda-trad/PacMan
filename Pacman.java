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
		
		game.getMap().getMap()[c.getX()][c.getY()] = Element.N;
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

		game.getMap().getMap()[c.getX()][c.getY()] = Element.N;
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

		game.getMap().getMap()[c.getX()][c.getY()] = Element.N;
		game.decCompteurGum();
		
		game.setPowerTimer(fullTimer);
	}
	
	public void eatGreen(Gum g)
	{
		this.addScore(g);	    
		
		game.getMap().setNewMap();
		
		game.getMap().getMap()[c.getX()][c.getY()] = Element.N;
		game.decCompteurGum();
	}

	/////////////////////////////
	
	@Override
	public void move()
	{
		Coordinate dir = new  Coordinate (c.getX() + direction.getX(), c.getY() + direction.getY());
		
		// Si la position suivante du pacman ne sort pas de l'écran et ne correspond pas à un mur
		if(!game.isOut(dir) && game.getMap().getMap()[dir.getX()][dir.getY()] != Element.W) 
		{
			c = dir;
		}
		
		notifyObserver();
	}
	
	public void cross()
	{
		Coordinate current = new Coordinate (c.getX(), c.getY());
		Coordinate future = new Coordinate (c.getX() + direction.getX(), c.getY() + direction.getY());
		
		switch(direction)
		{
			case Left  :
				specialLeft();
				break;
			case Right :
				specialRight();
				break;
			case Up :
				specialUp();
				break;
			case Down :
				specialDown();
				break;
		}
		
		// si pas de collision fantome on verifie le reste
		if(!ghostCollision(future) && !ghostCollision(current))
		{
			switch(game.getMap().getMap()[c.getX() + direction.getX()][c.getY() + direction.getY()])
			{
				case N :  // nothing
					move();
					break;
				case G  : // gums
					move();
					for(int i = 0 ; i < game.getGums().length ; ++i)
						if(game.getGums()[i].c.equals(future))
							eatGum(game.getGums()[i]);
					break;
				case W :
					//	wallCollision();
					direction = Direction.Still;
					break;
			}
		}	
	}
	
	public void wallCollision()
	{
		Coordinate dir = new  Coordinate (c.getX() + direction.getX(), c.getY() + direction.getY());
		
		if(game.getMap().getMap()[dir.getX()][dir.getY()] != Element.W)
		{
			setDirection(previous);
			move();
		}
	}
	
	public boolean wallCollisionPower(Coordinate future)
	{
		if(game.getMap().getMap()[future.getX()][future.getY()] == Element.W)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean ghostCollision(Coordinate c)
	{
		for(int i = 0 ; i < game.getGhosts().length; ++i)
		{
			if(game.getGhosts()[i].c.equals(c))
			{
				state.ghostCollision(i, c);		
				return true;
			}
		}
		return false;
	}
	
	public void restartAfterCollision()
	{
		c = new Coordinate (3, 5);
		direction = Direction.Still;
		beNormal();
		game.restartAfterCollision();
	}
	
	public void specialLeft()
	{
		if( c.getX() - 1 < 0 && c.getY() == 8)
		{
			c = new Coordinate (18, 8);
		}
	}
	
	public void specialRight()
	{
		if(  c.getX() + 1 > 17 &&  c.getY() == 8)
		{
			c = new Coordinate (-1, 8);
		}
	}
	
	public void specialUp() 
	{
		if( c.getY()  - 1 < 0 && c.getX() == 7)
		{
			c = new Coordinate (7, 18);
		}
	}
	
	public void specialDown()
	{
		if( c.getY()  + 1 > 17 && c.getX() == 7)
		{
			c = new Coordinate (7, -1);
		}
	}
	
}
