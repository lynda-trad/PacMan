package pacman;

import java.util.ArrayList;

import pacman.Characters;
import pacman.Gum;

public class Pacman extends Characters
{
	private int score;	    // score du player
	private int lives; 		// initialement trois vies
	private int state;  	// 0 = normal, 1 = superPacman, 2 = invisible

	private ArrayList<Observer> observers;
	
	private String direction;

	public Pacman (Game g)
	{
		this.game  = g;
		this.score = 0;
		this.lives = 3;
		this.state = 0;
		this.direction = "";
		this.observers = new ArrayList<Observer>();
	}
	
	// Getter & Setter
	
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
	}	
	
	public void newLife()
	{	//Si le joueur depasse les 5000 points, il obtient une vie supplementaire.
		if(this.score > 5000)
		{
			score = 0;
			++this.lives;
		}
	}	
	
	public void loseLife() 
	{
		if(this.lives > 0)
			this.lives--;
		
		if(this.lives == 0)
			game.gameOver(0);
	}
	
	public void eatGum(Gum g) 
	{
			if(g.getType() == 0) 			// Blue
			{
				this.addScore(g);
				g.isEaten();

				game.getMap().getMap()[x][y] = Element.NONE;
				game.decCompteurGum();
			} 
			else if (g.getType() == 1) 	    // Violet = Pacman invisible
			{
				this.addScore(g);
				this.beInvisible(); 
				g.isEaten();

				game.getMap().getMap()[x][y] = Element.NONE;
				game.decCompteurGum();
			} 
			else if (g.getType() == 2) 	    // Orange 
			{
				this.addScore(g);
				this.beSuperPacman();
				g.isEaten();
				for(int i = 0 ; i < game.getGhosts().length ; ++i)
				{
					game.getGhosts()[i].beVulnerable();
				}

				game.getMap().getMap()[x][y] = Element.NONE;
				game.decCompteurGum();
			}
			else							 // Green New Structure labyrinthe	
			{
				this.addScore(g);	    
				g.isEaten();
				//change la map completement
			}
	}
	
	@Override
	public void move()
	{
		switch(direction)
		{
			case "LEFT"  :
				if( x - 1 > 0)
					-- x;
			break;
			case "RIGHT" :
				if( x + 1 < 10)
					++ x;
				break;
			case "UP" :
				if( y - 1 > 0)
					-- y;
				break;
			case "DOWN"  :
				if(y + 1 < 10)
					++ y;
				break;
		}
		notifyObserver();
	}
	
	@Override
	public void cross()
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
		
		// si pas de collision fantome on verifie le reste
		if(!ghostCollision(future_x, future_y))
		switch(game.getMap().getMap()[future_x][future_y])
		{
			case NONE :
				move();
			break;
			case GUM :
				move();
				for(int i = 0 ; i < game.getGums().length ; ++i)
					if(game.getGums()[i].x == future_x && game.getGums()[i].y == future_y)
						eatGum(game.getGums()[i]);
			break;
			default : // WALL
				break;
		}	
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
							move();
							game.getGhosts()[i].backToCenter();
						return true;
						case 2 : //invisible
							move();
						return true;
					}
				}
		}
		return false;
	}
	
	public void restartAfterCollision()
	{
		x = 3;
		y = 3;
		direction = "";
		beNormal();
		game.restartAfterCollision();
	}
	
}
