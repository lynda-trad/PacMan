
public class GhostNormalState extends GhostState 
{	
	protected GhostNormalState(Ghosts ghost) 
	{
		super(ghost);
	}
		
	@Override
	public void move() 
	{
		Coordinate dir = new  Coordinate (ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY());

		if(!ghost.isOut(dir))
		{
			ghost.c = dir;
		}	
	}
	
	@Override
	public GState getState()
	{
		return GState.NORMAL;
	}
	
}
