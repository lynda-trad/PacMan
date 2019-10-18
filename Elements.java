package pacman;

public abstract class Elements 
{
	protected int element;  // 0 = Pacman, 1 = Ghosts, 2 = Gum , 3 = Mur
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
		this.element = e;
	}
	
	public int getX() 
	{
		return this.x;
	}
	
	public int setX(int x) 
	{
		 this.x = x;
	}
	
	public int getY() 
	{
		return this.y;
	}
	
	public int setY(int y) 
	{
		 this.y = y;
	}
	
}