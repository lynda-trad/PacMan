
public class GhostNormalState extends GhostState 
{	
	protected GhostNormalState(Ghosts ghost) 
	{
		super(ghost);
	}
		
	@Override
	public void move() 
	{
		if(!ghost.game.isOut(ghost.x + ghost.getDirection().getX(), ghost.y + ghost.getDirection().getY()))
		{
			ghost.x += ghost.getDirection().getX();
			ghost.y += ghost.getDirection().getY();
		}	
	}
	
	@Override
	public GState getState()
	{
		return GState.NORMAL;
	}
	
}
