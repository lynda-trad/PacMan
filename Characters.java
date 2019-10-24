package pacman;

public abstract class Characters extends Elements // abstract ou interface?
{
	protected GameGraphics graph;
	protected Map m;
	
	public abstract void cross(Game g, String direction); 
	
	public abstract void move(Game g, String direction);

//	public abstract void posActu();

}