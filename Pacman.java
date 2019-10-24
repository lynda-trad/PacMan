package pacman;

import pacman.Characters;
import pacman.Gum;

public class Pacman extends Characters
{
	private int score;	    // score du player
	private int lives; 		// initialement trois vies
	private int state;  	// 0 = normal, 1 = superPacman, 2 = invisible
	private int element; 	// Rien = 0, Murs = 1, Joueur = 2, Ghosts = 3, Gums = 4
	
	public Pacman ()
	{
		this.score = 0;
		this.lives = 3;
		this.state = 0;
		this.element = 2;
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
	
	@Override
	public int getElement() {
		return this.element;
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
	
	//////////////////////////////////////////////////
	
	public void addScore(Gum g)
	{ // apres avoir manger une gum on ajoute son score au score du player
		this.score += g.getScore();
	}	
	
	public void newLife()
	{	//Si le joueur depasse les 5000 points, il obtient une vie supplementaire.
		if(this.score > 5000)
		{
			initializeScore();
			++this.lives;
		}
	}	
	
	public void initializeScore()
	{
		this.score = 0;
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
			g.gameOver(0);
			System.exit(0);
		}
		else 		   						  //quand il n'y a plus de pacgommes, partie gagnee 
		{
			g.gameOver(1);
			System.exit(0);
		}
	}
	
	public void eatGum(Gum g) 
	{
		if (g.getEaten() == false)
		{
			if(g.getType() == 0) 			// Blue
			{
				this.addScore(g);
				g.isEaten();
				g.decrementeCompteur();
				
			} 
			else if (g.getType() == 1) 	// Violet = Pacman invisible
			{
				this.addScore(g);
				this.beInvisible(); 
				g.isEaten();
				g.decrementeCompteur();

			} 
			else if (g.getType() == 2) 	// Orange 
			{
				this.addScore(g);
				this.beSuperPacman();
				//	g.effet();  		// Marche pas--> SuperPacman et les 4 Ghosts vulnérables
				g.isEaten();
				g.decrementeCompteur();
			}
			else // Green 
			{
				this.addScore(g);
				//	g.effet(); 			// Marche pas--> New Structure labyrinthe	
				g.isEaten();
				g.decrementeCompteur();
			}
					
		}
		
	}
	
	@Override
	public void move(Game g, String direction)
	{
		//on a ses x et y dans elements
		cross(g, direction);
	}
	
	@Override
	public void cross(Game g, String direction)
	{
		int future_x = 0;
		int future_y = 0;
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
		
		switch(g.getMap()[future_x][future_y].getElement())
		{
			case 0 :
				// rien donc on peut move
				switchDirection(direction);
				break;
			case 1 : 
				// on ne fait rien pcq mur apres
				break;
			case 2 :
				// pas possible ici puisque soi meme
				break;
			case 3 :
				// ghosts
				// verifie etat
				// peut perdre une vie
				switch(state)
				{
					case 0 :
						//normal
						loseLife(); 
						break;
					case 1 :
						//superpacman
						//g.getMap()[future_x][future_y].backToCenter();
						break;
					case 2 :
						//invisible
						switchDirection(direction);
						break;
				}
				break;
			case 4 :
				// verifie type de gum
				// applique pouvoir au joueur
				//switch(g.getMap()[future_x][future_y].getElement().getType())
				
				break;
		}
	}
	
	public void switchDirection(String direction)
	{
		switch(direction)
		{
			case "RIGHT" :
				++ x;
				break;
			case "LEFT"  :
				-- x;
				break;
			case "UP" :
				-- y;
				break;
			case "DOWN"  :
				++ y;
				break;
		}
	}
	
	public String toString()
	{
		switch(this.state) 
		{
		case 0:
			return "Pacman jaune à l'état Normal avec un score de " + this.score + " et " + this.lives + " vies restantes.";
		case 1:
			return "Pacman orange à l'état SuperPacman avec un score de " + this.score + " et " + this.lives + " vies restantes.";
		case 2:
			return "Pacman jaune pale à l'état Invisible avec un score de " + this.score + " et " +this.lives + " vies restantes.";
		default:
			return "Pacman à l'état Normal avec un score de " + this.score + this.lives + " et " + " vies restantes.";
		}
	
	}
}
