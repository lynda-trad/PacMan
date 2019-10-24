package pacman;

public abstract class Characters extends Elements // abstract ou interface?
{
	protected Map m;
	protected Game g;
	protected GameGraphics graph;
	
	public abstract void cross(); 
	
	public abstract void move();

//	public abstract void posActu();

}