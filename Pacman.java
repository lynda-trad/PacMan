package pacman;

import pacman.Gum;
import pacman.Characters;
import java.util.ArrayList;

public class Pacman extends Characters
{
	private int score;	    // score du player
	private int lives; 		// initialement trois vies
	private int state;  	// 0 = normal, 1 = superPacman, 2 = invisible

	private ArrayList<Observer> observers;
	
	private String direction;
	private String previous;

	private static final int fullTimer = 60;
	
	public Pacman (Game g)
	{
		this.game  	   =  g;
		this.score 	   =  0;
		this.state     =  0;
		this.lives 	   =  3;
		this.direction = "";
		this.previous  = "";
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
	
	public int getState() 
	{
		return this.state;
	}
	
	public String getDirection() 
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	
	public String getPrevious() 
	{
		return previous;
	}

	public void setPrevious(String previous) 
	{
		this.previous = previous;
	}
	
	/////////////////////////////
	
	public void beNormal() 
	{
		this.state = 0;
	}
	
	public void beSuperPacman() 
	{
		this.state = 1;
	}
	
	public void beInvisible() 
	{
		this.state = 2;
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
		if(this.score > 5000)
		{
			score = 0;
			++this.lives;
		}
	}	
	
	public void loseLife() 
	{
		if(this.lives > 0)
			--this.lives;
		
		if(this.lives == 0)
			game.gameOver(0);
	}
	
	/////////////////////////////
	
	public void eatGum(Gum g) 
	{
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
		switch(direction)
		{
			case "LEFT"  :
				if(x - 1 >= 0)
					-- x;
			break;
			
			case "RIGHT" :
				if(x + 1 < 18)
					++ x;
			break;
			
			case "UP"    :
				if(y - 1 >= 0)
					-- y;
			break;
			
			case "DOWN"  :
				if(y + 1 < 18)
					++ y;
			break;
		}
		notifyObserver();
	}
	
	public void cross()
	{
		int future_x = x;
		int future_y = y;
		
		switch(direction)
		{
			case "LEFT"  :
				specialLeft();
				future_x = x - 1;
			break;
			case "RIGHT" :
				specialRight();
				future_x = x + 1;
				break;
			case "UP" :
				specialUp();
				future_y = y - 1;
				break;
			case "DOWN" :
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
				direction = "";
			break;
		}	
	}
	
	public void wallCollision()
	{
		int previous_x = x;
		int previous_y = y;
		switch(previous)
		{
			case "LEFT"  :
				previous_x = x - 1;
			break;
			
			case "RIGHT" :
				previous_x = x + 1;
			break;
			
			case "UP" :
				previous_y = y - 1;
			break;
			
			case "DOWN" :
				previous_y = y + 1;
			break;
		}
		
		if(game.getMap().getMap()[previous_x][previous_y] != Element.W)
		{
			setDirection(previous);
			move();
		}
	}
	
	public boolean wallCollisionPower()
	{
		int future_x = x;
		int future_y = y;
		
		switch(direction)
		{
			case "LEFT"  :
				future_x = x - 1;
			break;
			case "RIGHT" :
				future_x = x + 1;
				break;
			case "UP" :
				future_y = y - 1;
				break;
			case "DOWN" :
				future_y = y + 1;
				break;
		}
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
					switch(state)
					{
						case 0 : //normal
							loseLife();
							restartAfterCollision();
						return true;
						
						case 1 : //superpacman
							ghostSuperPacman(i, future_x, future_y);
						return true;
						
						case 2 : //invisible
							ghostInvisible(future_x, future_y);
						return true;
					}
				}
		}
		return false;
	}
	
	public void ghostInvisible(int future_x, int future_y)
	{
		if(!wallCollisionPower())
		{
			if(game.getMap().getMap()[future_x][future_y] == Element.G)
			{
				move();
				for(int j = 0 ; j < game.getGums().length ; ++j)
					if(game.getGums()[j].x == future_x && game.getGums()[j].y == future_y)
						eatGum(game.getGums()[j]);
			}
			else
				move();
		}
	}
	
	public void ghostSuperPacman(int i, int future_x, int future_y)
	{
		if(!wallCollisionPower())
		{
		if(game.getMap().getMap()[future_x][future_y] == Element.G)
		{
			move();
			game.getGhosts()[i].backToCenter();
			for(int j = 0 ; j < game.getGums().length ; ++j)
			{
				if(game.getGums()[j].x == future_x && game.getGums()[j].y == future_y)
				{
					eatGum(game.getGums()[j]);
				}
			}
		}
		else
		{
			move();
			game.getGhosts()[i].backToCenter();
		}
		}
	}
	
	public void restartAfterCollision()
	{
		x = 3;
		y = 5;
		direction = "";
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
