package pacman;

import pacman.Characters;

public class Ghosts extends Characters
{
	private int state ; // 0 = normal, 1 = vulnerable et ralenti
	//private int element = 3;
	
	private int direction;
	
	private int ralenti; // incremente a chaque move et si impair on bouge pas
	
	public Ghosts(Game g, int x, int y)
	{
		this.game = g;
		this.state = 0;
		this.x = x;
		this.y = y;
		this.ralenti = 0;
		this.direction = 0;
	}
	
	public int getState() 
	{
		return this.state;
	}
	
	public void beNormal()
	{
		this.state = 0;
	}
	
	public void beVulnerable()
	{
		this.state = 1;
	}
	
	public String toString()
	{
		switch(this.state) 
		{
		case 0:
			return "Ghost blanc à l'état Normal";
		case 1:
			return "Ghost bleu à l'état Vulnérable";
		default:
			return "Ghost blanc à l'état Normal";
		}
	
	}
	
	////////////////////////////////////////
	
	public void backToCenter(int x, int y) 
	{   // touché par pacman qd vulnerable -> gum orange
		this.x = this.y = 4;
		//mettre a jour map graphic -> repaint dans gamegraphics
	}

	public boolean checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		
		//on verifie selon la direction si prochain step est un mur 
		if(game.getMap().getMap()[x][y] == Element.WALL) 
			// en supposant quils vont toujours à droite, on nen sait rien
			
			//on fait random direction
			return true;
		
		return true;
		//redirection();
	}
	
	public void redirection() 
	{
		/*
		Chaque fantome se deplace dans une direction jusqu'a ce qu'il atteigne un mur, puis choisit une nouvelle
		direction aleatoirement.
		*/
		
		/*
		 * utiliser une fonctioh mathematiques qui me sort un int random entre 0 et 3 
		 * pour les 4 directions
		 * 
		 * tant quon touche pas de mur, le fantome contninue a aller dans la direction
		 * int direction.
		 * 
		 * on change le champ direction avec un nouveau random quand on touche un mur
		 *
		 */
		
		//utiliser cross avec un mur si collision on fait un random 
		
		
		//fonction fait un nouveau random, ca met a jour le champ direction
		if(x + 1 < 10)
		{
			if (game.getMap().getMap()[x + 1][y] != Element.WALL)
			{
				++x;
			// Forcer à sortir de fonction redirection en appelant quelque chose
			}
		}
		else 
			if (x - 1 > 0)
			{
				if(game.getMap().getMap()[x - 1][y]!= Element.WALL)
		{
			--x;
			//Forcer à sortir de fonction redirection en appelant quelque chose
		}
			}
		else 
			if(y + 1 < 10)
				{if(game.getMap().getMap()[x][y + 1]!= Element.WALL)
		{
			++y;
			//Forcer à sortir de fonction redirection en appelant quelque chose
		}
				}
		else 
			if(y - 1 > 0)
			{
				if(game.getMap().getMap()[x][y - 1]!= Element.WALL)
		{
			--y;
			//Forcer à sortir de fonction redirection en appelant quelque chose
		}	
			}
		// apres avoir atteint le mur, check haut droit gauche droite -> premier de libre et va la bas et continue son
		// voyage 
	}
	
	public void moveSlow()
	{
		

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
			case 0:
				++ x;
				break;
			case 1  : //right
				-- x;
				break;
			case 2 :
				-- y;
				break;
			case 3  : //Down
				++ y;
				break;
		}
	}
	
	
}

