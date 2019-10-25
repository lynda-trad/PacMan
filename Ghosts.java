package pacman;

import pacman.Characters;

public class Ghosts extends Characters
{
	private int state ; // 0 = normal, 1 = vulnerable et ralenti
	//private int element = 3;
	
	private int ralenti; // incremente a chaque move et si impair on bouge pas
	
	public Ghosts(int x, int y) 
	{
		this.state = 0;
		this.x = x;
		this.y = y;
		ralenti = 0;
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

	public void checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		
		if(m.getMap()[x + 1][y] == Element.WALL) // en supposant quils vont toujours à droite, on nen sait rien
			redirection();
		else;
			
	}
	
	public void redirection() 
	{
		/*
		Chaque fantome se deplace dans une direction jusqu'a ce qu'il atteigne un mur, puis choisit une nouvelle
		direction aleatoirement.
		*/
		
		/* POSSIBLE FACON DE LE FAIRE 
		 *  aller tjrs a droite
		 * faire random de direction
		 * choisir si cest possible dy aller
		 * sinon random again 
		 * et on y go quand pas mur   
		*/
		
		if	   (m.getMap()[x + 1][y] != Element.WALL)
		{
			++x;
			// Forcer à sortir de fonction redirection en appelant quelque chose
		}
		else if(m.getMap()[x - 1][y]!= Element.WALL)
		{
			--x;
			//Forcer à sortir de fonction redirection en appelant quelque chose
		}
		else if(m.getMap()[x][y + 1]!= Element.WALL)
		{
			++y;
			//Forcer à sortir de fonction redirection en appelant quelque chose
		}
		else if(m.getMap()[x][y - 1]!= Element.WALL)
		{
			--y;
			//Forcer à sortir de fonction redirection en appelant quelque chose
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
		// TODO Auto-generated method stub
		//switch etat si jamais ralenti etc 
		switch(state)
		{
			case 0 : 
				redirection();
				break;
			case 1 :
				if(ralenti % 2 == 0)
					redirection();
				break;
		}
	}

	
}

