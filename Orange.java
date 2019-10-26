package pacman;

public class Orange extends Gum
{
	/*
		Orange
		500
		pacman devient orange et fantomes bleus 
		superpacman, fantomes -> vulnerables. 
		ghosts se deplacent deux fois plus lentement 
		ghosts reviennent au centre du labyrinthe si ils sont touches par le pacman.
	*/
	
	public Orange(int type, int x, int y)
	{
		super(2, x, y); 
	}
	
	// Rendre les 4 Fantomes du jeu vulnérables
	/*@Override
	public void effet(Pacman p, Ghosts ghosts[]) 
	{
		for(Ghosts g: ghosts)
		{
			g.beVulnerable();
		}
	
	}
	*/
	
	@Override
	public void effet() 
	{
		// TODO Auto-generated method stub
		
	}
	
	//modifie aspect du pacman
	//rend fantome mangeable et deux fois plus lents -> fantome gereront eux memes si se font manger
	

	/*
	public String toString()
	{
			if (this.eaten==true)
				return "Gum Orange de score " + this.score + " eaten";
			else
				return "Gum Orange de score " + this.score + " not eaten";	
	}
	 */
	
}