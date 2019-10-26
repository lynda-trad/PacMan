package pacman;

import java.util.ArrayList;

import pacman.Characters;

public class Ghosts extends Characters
{
	private int state ; 	// 0 = normal, 1 = vulnerable et ralenti
	
	private int direction;
	
	private int ralenti;    // incremente a chaque move et si impair on bouge pas

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
		this.y = 3;
	}

	public boolean checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		
		switch(direction)
		{
			case 0: // left
				if(game.getMap().getMap()[x - 1][y] == Element.WALL)
					direction = (int) (Math.random() * 3 + 1);
				return true;
		
			case 1: // right
				if(game.getMap().getMap()[x + 1][y] == Element.WALL)
					direction = (int) (Math.random() * 3 + 1);
				return true;
			
			case 2: // up 
				if(game.getMap().getMap()[x][y - 1] == Element.WALL)
					direction = (int) (Math.random() * 3 + 1);
				return true;

			case 3: // down
				if(game.getMap().getMap()[x][y + 1] == Element.WALL)
					direction = (int) (Math.random() * 3 + 1);
				return true;
				
			default :
				return false;
		}
	}

	@Override
	public void cross() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override	
	public void move()
	{
		if (!checkWalls())
		switch(direction)
		{
			case 0:   // left
				if(x - 1 > 0)
					if(state == 1)
					{
						if(ralenti % 2 == 0)
						{	++ x;
							++ralenti;
						}
						else
							++ralenti;
					}
					else
						++ x;
				break;
			case 1  : //right
				if(x + 1 < 10)
					if(state == 1)
					{
						if(ralenti % 2 == 0)
						{
							-- x;
							++ralenti;
						}
						else
							++ralenti;
					}
					else 
						-- x;
				break;
			case 2 :  // up
				if(y - 1 > 0)
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
				break;
			case 3  : //Down
				if(y + 1 < 10)
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
				break;
		}
		notifyObserver();
	}
	
}

