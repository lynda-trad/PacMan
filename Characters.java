package pacman;

public abstract class Characters extends Elements // abstract ou interface?
{
	
	public abstract void cross(Game g, String direction); 
	
	public abstract void move(Game g, String direction);

//	public abstract void posActu();

}