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
}