package pacman;

public abstract class Characters extends Elements // abstract ou interface?
{
	protected Game g;
	
	protected int x;
	protected int y;


	public abstract void cross(); 
	
	public abstract void move();

//	public abstract void posActu();

}