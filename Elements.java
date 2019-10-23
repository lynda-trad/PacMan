package pacman;

public abstract class Elements 
{
	protected int element;  
	/*
	 		 Rien   = 0
			 Murs 	= 1
			 Joueur = 2
			 Ghosts = 3
			 Gums 	= 4
	*/
	protected int x;
	protected int y;

	
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