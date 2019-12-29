
public class PacmanNormalState extends PacmanState
{	
	public PacmanNormalState(Pacman pacman) 
	{
		super(pacman);
	} 
		
	@Override
	public void ghostCollision(int i, Coordinate c) 
	{
		pacman.loseLife();
		pacman.restartAfterCollision();	
	}
		
	@Override
	public PState getState()
	{
		return PState.NORMAL;
	}
		
}
