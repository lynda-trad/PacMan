public abstract class PacmanState 
{
	public static enum PState
	{
		NORMAL, 
		SUPERPACMAN,
		INVISIBLE
	};
	
	protected Pacman pacman;
		
	protected PacmanState(Pacman pacman)
	{
		this.pacman = pacman;
	}
		
	public abstract PState getState();
	public abstract void ghostCollision(int i, Coordinate c);
		
}
		