package pacman;

public abstract class Characters extends Elements // abstract ou interface?
{
	protected Map m;
	protected Game g;
	protected Graph graph;
	
	protected int x;
	protected int y;
	
	public abstract void cross(); 
	
	public abstract void move();

//	public abstract void posActu();

}