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
		this.score = 0;
		this.lives = 3;
		this.state = 0;
		this.game = g;
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
	
	
	/////////////////////////////
	

	public void notifyObserver()
	{
		for(Observer observer : observers)
		{
			observer.update();
		}
	}
	
	
	public void addScore(Gum g)
	{ 
		// apres avoir manger une gum on ajoute son score au score du player
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
		
		if(this.lives == 0) //checks if dead
			gameOver();
	}
	
	
	public void gameOver()
	{
		if(this.lives == 0) 				  //pacman a perdu toutes ses vies, game over
		{
			//	graph().gameOver(0);
			System.exit(0);
		}
	}
	
	
	public void eatGum(Gum g) 
	{
			if(g.getType() == 0) 			// Blue
			{
				this.addScore(g);
				g.isEaten();
			} 
			else if (g.getType() == 1) 	    // Violet = Pacman invisible
			{
				this.addScore(g);
				this.beInvisible(); 
				g.isEaten();
			} 
			else if (g.getType() == 2) 	    // Orange 
			{
				this.addScore(g);
				this.beSuperPacman();
				//	g.effet();  		    // Marche pas--> SuperPacman et les 4 Ghosts vuln�rables
				g.isEaten();
				for(int i = 0 ; i < game.getGhosts().length ; ++i)
				{
					game.getGhosts()[i].beVulnerable();
				}
			}
			else // Green 
			{
				this.addScore(g);
				//	g.effet(); 			    // Marche pas--> New Structure labyrinthe	
				g.isEaten();
			}
			
			game.getMap().getMap()[x][y] = Element.NONE;
			// ici on met a jour la map on met VIDE aux coordonn�es de Gum g
	}
	
	@Override
	public void move()
	{
		switch(direction)
		{
			case "LEFT"  :
				-- x;
			break;
			case "RIGHT" :
				++ x;
				break;
			case "UP" :
				-- y;
				break;
			case "DOWN"  :
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
			case "RIGHT" :
				future_x = x + 1;
				break;
			case "LEFT"  :
				future_x = x - 1;
				break;
			case "UP" :
				future_y = y - 1;
				break;
			case "DOWN" :
				future_y = y + 1;
				break;
		}
		
		//on a ses x et y dans elements
		
		/*
		je crois que tout ca equivaut a appeler :
			g.getMap().getElementCase(future_x, future_y);
		mais y a un soucis je peux pas 
		*/
		
		switch(game.getMap().getMap()[future_x][future_y])
		{
			case NONE :
				// rien donc on peut move
				move();
				break;
			case WALL : 
				// on ne fait rien pcq mur apres
				break;
			case PLAYER :
				// pas possible ici puisque soi meme
				break;
			case GHOST :
				// ghosts
				// verifie etat
				// peut perdre une vie
				switch(state)
				{
					case 0 :
						//normal
						loseLife();
						restartAfterCollision();
						break;
					case 1 :
						//superpacman
						move();
						for(int i = 0 ; i < game.getGhosts().length; ++i)
							if(future_x == game.getGhosts()[i].x && future_y == game.getGhosts()[i].y)
								game.getGhosts()[i].backToCenter();
						break;
					case 2 :
						//invisible
						move();
						break;
				}
				break;
			case GUM :
				// verifie type de gum
				// applique pouvoir au joueur
				//switch(g.getMap()[future_x][future_y].getElement().getType())

				move();
				for(int i = 0 ; i < game.getGums().length ; ++i)
					if(game.getGums()[i].x == future_x && game.getGums()[i].y == future_y)
						eatGum(game.getGums()[i]);
				
				break;
		}
	}
	
	public void restartAfterCollision()
	{
		x = 3;
		y = 3;
		
		game.getGhosts()[0].x = 2;
		game.getGhosts()[0].y = 1;
		
		game.getGhosts()[1].x = 1;
		game.getGhosts()[1].y = 8;
		
		game.getGhosts()[2].x = 5;
		game.getGhosts()[2].y = 7;
		
		game.getGhosts()[3].x = 2;
		game.getGhosts()[3].y = 4;
	}
	

	/*
	public String toString()
	{
		switch(this.state) 
		{
		case 0:
			return "Pacman jaune � l'�tat Normal avec un score de " + this.score + " et " + this.lives + " vies restantes.";
		case 1:
			return "Pacman orange � l'�tat SuperPacman avec un score de " + this.score + " et " + this.lives + " vies restantes.";
		case 2:
			return "Pacman jaune pale � l'�tat Invisible avec un score de " + this.score + " et " +this.lives + " vies restantes.";
		default:
			return "Pacman � l'�tat Normal avec un score de " + this.score + this.lives + " et " + " vies restantes.";
		}
	}
	*/
}
