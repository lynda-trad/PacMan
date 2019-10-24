package pacman;

public abstract class Elements 
{
	//Chaque element sera reconnu par un int qui lui correspond
	/*
	 Rien   = 0
	 Murs 	= 1
	 Joueur = 2
	 Ghosts = 3
	 Gums 	= 4
	 */
	protected int element;
	
	// Chaque element a une position
	protected int x;
	protected int y;

	
	// Ghosts : 0 = normal, 1 = vulnerable
	// Pacman : 0 = normal, 1 = superPacman, 2 = invisible
	// Gum : boolean eaten or not dans abstract class Gum
	public int getState() 
	{
		return 0;
	}
	
	public int getElement() 
	{
		return this.element;
	}
	
	public void setElement(int element)
	{
		this.element = element;
	}
	
	//	Positions
	
	public int getX() 
	{
		return this.x;
	}
	
	public void setX(int x) 
	{
		 this.x = x;
	}
	
	public int getY() 
	{
		return this.y;
	}
	
	public void setY(int y) 
	{
		 this.y = y;
	}
	
}