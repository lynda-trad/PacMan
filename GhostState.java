public abstract class GhostState
{
	public static enum GState
	{
		NORMAL,
		VULNERABLE
	};
	
	protected Ghosts ghost;
	
	protected GhostState(Ghosts ghost)
	{
		this.ghost = ghost;
	}
		
	public abstract GState getState();
	public abstract void move();

}
