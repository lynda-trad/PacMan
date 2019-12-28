import java.util.ArrayList;

public class Ghosts extends Characters
{
	private GhostState state;

	private int ralenti;    // incremente a chaque move et si impair on bouge pas
	
	private Direction direction;

	private ArrayList<Observer> observers;
	
	public Ghosts(Game g, int x, int y)
	{
		this.game = g;
		this.state = new GhostNormalState(this);
		this.c = new Coordinate(x, y);
		//this.x = x;
		//this.y = y;
		this.ralenti = 0;
		this.direction = Direction.Left;
		this.observers = new ArrayList<Observer>();
	}
	
	public Direction getDirection() 
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
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
	
	public int getRalenti() 
	{
		return this.ralenti;
	} 
	
	public void setRalenti(int ralenti) 
	{
		this.ralenti = ralenti;
	} 
	
	public GhostState getGhostState() 
	{
		return this.state;
	} 
	
	void changeState(GhostState state)
	{
		this.state = state;
	}
	
	public GhostState.GState nameState() 
	{
		return state.getState();
	}
	
	public void beNormal()
	{
		this.changeState(new GhostNormalState(this) );
	}
	
	public void beVulnerable()
	{
		this.changeState(new VulnerableState(this) );

	}
	
	////////////////////////////////////////
	
	public void backToCenter() 
	{   
		c = new Coordinate (9, 9);
		//this.x = 9;
		//this.y = 9;
	}
	;
	public void randomDirection() 
	{
		int dir = (int) (Math.random() * 4 + 0);
		
		switch(dir)
		{
			case 0: 
				direction = Direction.Left;
				break;

			case 1: 
				direction = Direction.Right;
				break;

			case 2:
				direction =  Direction.Up;
				break;

			case 3: 
				direction = Direction.Down;
				break;
		}
	}
	
	public boolean checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		
		switch(direction)
		{
			case Left: // left
				if(c.getX() == 0)
					specialLeft();
				if(game.getMap().getMap()[c.getX() - 1][c.getY()] == Element.W || c.getX() - 1 < 0)
				{
					randomDirection();
					return true;
				}
				else
					return false;
		
			case Right: // right
				if(game.getMap().getMap()[c.getX() + 1][c.getY()] == Element.W || c.getX() + 1 > 18)
				{
					randomDirection();
					return true;
				}
				else
					return false;
			
			case Up: // up 
				if(c.getY() == 0)
					specialUp();
				if(game.getMap().getMap()[c.getX()][c.getY() - 1] == Element.W || c.getY() - 1 < 0)
				{
					randomDirection();
					return true;
				}
				else
					return false;
				
			case Down: // down
				if(game.getMap().getMap()[c.getX()][c.getY() + 1] == Element.W || c.getY() + 1 > 18)
				{
					randomDirection();
					return true;
				}
				else
					return false;
				
			default :
				return false;
		}
	}
	
	@Override	
	public void move()
	{
		specialRight();
		specialDown();
		
		if(!checkWalls())
		{
			switch(direction)
			{
				case Left	: 
					if(c.getX() == 0) 
						specialLeft();
					state.move();
				break;
				
				case Right  : 
					state.move();
				break;
				
				case Up 	:
					if(c.getY() == 0) 
						specialUp();
					state.move();
				break;
				
				case Down  	: 
					state.move();
				break;
			}
		}
		notifyObserver();
	}

	public void specialLeft()
	{
		if( c.getX() - 1 < 0 && c.getY() == 8)
		{
			c = new Coordinate(17, 8);
			//x = 17;
			//y = 8 ;
		}
	}
	
	public void specialRight()
	{
		if( c.getX() + 1 > 17 && c.getY() == 8)
		{
			c = new Coordinate(0, 8);
			//x =  0;
			//y =  8;
		}
	}
	
	public void specialUp()
	{
		if( c.getY() - 1 < 0 && c.getX() == 7)
		{
			c = new Coordinate(7, 17);
			//x = 7 ;
			//y = 17;
		}
	}
	
	public void specialDown()
	{
		if( c.getY() + 1 > 17 && c.getX() == 7)
		{
			c = new Coordinate(7, 0);
			//x =  7;
			//y =  0;
		}
	}
}