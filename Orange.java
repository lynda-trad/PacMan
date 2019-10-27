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
	
	
}