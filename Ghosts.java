package pacman;

import java.util.ArrayList;

import pacman.Characters;

public class Ghosts extends Characters
{
	private int state ; 	// 0 = normal, 1 = vulnerable et ralenti
	
	private int ralenti;    // incremente a chaque move et si impair on bouge pas
	
	private int direction = 0;

	private ArrayList<Observer> observers;
	
	public Ghosts(Game g, int x, int y)
	{
		this.game = g;
		this.state = 0;
		this.x = x;
		this.y = y;
		this.ralenti = 0;
		this.direction = 0;
		this.observers = new ArrayList<Observer>();
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
	
	public int getState() 
	{
		return this.state;
	}
	
	public void setState(int state) 
	{
		this.state = state;
	}
	
	public void beNormal()
	{
		this.state = 0;
	}
	
	public void beVulnerable()
	{
		this.state = 1;
	}
	
	////////////////////////////////////////
	
	public void backToCenter() 
	{   
		this.x = 3;
		this.y = 5;
	}

	public boolean checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		
		switch(direction)
		{
			case 0: // left
				if(game.getMap().getMap()[x - 1][y] == Element.W || x - 1 < 0)
				{
					direction = (int) (Math.random() * 4 + 0);
					return true;
				}
				else
					return false;
		
			case 1: // right
				if(game.getMap().getMap()[x + 1][y] == Element.W || x + 1 > 18)
				{
					direction = (int) (Math.random() * 4 + 0);
					return true;
				}
				else
					return false;
			
			case 2: // up 
				if(game.getMap().getMap()[x][y - 1] == Element.W || y - 1 < 0)
				{
					direction = (int) (Math.random() * 4 + 0);
					return true;
				}
				else
					return false;
				
			case 3: // down
				if(game.getMap().getMap()[x][y + 1] == Element.W || y + 1 > 18)
				{
					direction = (int) (Math.random() * 4 + 0);
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
		specialLeft();
		specialRight();
		specialUp();
		specialDown();
		
		if(!checkWalls())
		{
			switch(direction)
			{
				case 0:   // left
					left();
				break;
				
				case 1  : //right
					right();
				break;
				
				case 2 :  // up
					up();
				break;
				
				case 3  : //Down
					down();
				break;
			}
		}
		notifyObserver();
	}
	
	public void left()
	{
		if(x - 1 > 0)
		{	if(state == 1)
			{
				if(ralenti % 2 == 0)
				{	-- x;
					++ralenti;
				}
				else
					++ralenti;
			}
			else
				-- x;
		}
	}
	
	public void right()
	{
		if(x + 1 < 18)
		{
			if(state == 1)
			{
				if(ralenti % 2 == 0)
				{
					++ x;
					++ralenti;
				}
				else
					++ralenti;
			}
			else 
				++ x;
		}
	}
	
	public void up() 
	{
		if(y - 1 > 0)
		{
			if(state == 1)
			{
				if(ralenti % 2 == 0)
				{
					-- y;
					++ralenti;
				}
				else
					++ralenti;
			}
			else 
				-- y;
		}
	}
	
	public void down()
	{
		if(y + 1 < 18)
		{
			if(state == 1)
			{
				if(ralenti % 2 == 0)
				{
					++ y;
					++ralenti;
				}
				else
					++ralenti;
			}
			else
				++ y;
		}
	}
	
	public void specialLeft()
	{
		if( x - 1 < 0 && y == 8) 		// NOT ok
		{
			x = 18;
			y = 8 ;
		}
	}
	
	public void specialRight() 			// ok
	{
		if( x + 1 > 17 && y == 8)
		{
			x =  0;
			y =  8;
		}
	}
	
	public void specialUp() 			// NOT ok
	{
		if( y - 1 < 0 && x == 7)
		{
			System.out.println("up");
			x = 7 ;
			y = 18;
		}
	}
	
	public void specialDown() 			// ok
	{
		if( y + 1 > 17 && x == 7)
		{
			x =  7;
			y =  0;
		}
	}
	
}
