package pacman;

import javax.swing.JPanel;

public abstract class Characters extends Elements // abstract ou interface?
{
	protected GameGraphics g;
	
	public abstract void cross(Game g, String direction); 
	
	public abstract void move(Game g, String direction);

//	public abstract void posActu();

}