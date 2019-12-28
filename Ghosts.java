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
		this.x = x;
		this.y = y;
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
		this.x = 9;
		this.y = 9;
	}
	
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
				if(x == 0)
					specialLeft();
				if(game.getMap().getMap()[x - 1][y] == Element.W || x - 1 < 0)
				{
					randomDirection();
					return true;
				}
				else
					return false;
		
			case Right: // right
				if(game.getMap().getMap()[x + 1][y] == Element.W || x + 1 > 18)
				{
					randomDirection();
					return true;
				}
				else
					return false;
			
			case Up: // up 
				if(y == 0)
					specialUp();
				if(game.getMap().getMap()[x][y - 1] == Element.W || y - 1 < 0)
				{
					randomDirection();
					return true;
				}
				else
					return false;
				
			case Down: // down
				if(game.getMap().getMap()[x][y + 1] == Element.W || y + 1 > 18)
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
				case Left: 
					if(x == 0) 
						specialLeft();
					state.move();
				break;
				
				case Right  : 
					state.move();
				break;
				
				case Up :
					if(y == 0) 
						specialUp();
					state.move();
				break;
				
				case Down  : 
					state.move();
				break;
			}
		}
		notifyObserver();
	}

	public void specialLeft()
	{
		if( x - 1 < 0 && y == 8)
		{
			x = 17;
			y = 8 ;
		}
	}
	
	public void specialRight()
	{
		if( x + 1 > 17 && y == 8)
		{
			x =  0;
			y =  8;
		}
	}
	
	public void specialUp()
	{
		if( y - 1 < 0 && x == 7)
		{
			x = 7 ;
			y = 17;
		}
	}
	
	public void specialDown()
	{
		if( y + 1 > 17 && x == 7)
		{
			x =  7;
			y =  0;
		}
	}
}