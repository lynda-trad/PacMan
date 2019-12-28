
public class GhostNormalState extends GhostState 
{	
	protected GhostNormalState(Ghosts ghost) 
	{
		super(ghost);
	}
		
	@Override
	public void move() 
	{
		if(!ghost.game.isOut(ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY()))
		{
			ghost.c = new Coordinate(ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY());
		}	
	}
	
	@Override
	public GState getState()
	{
		return GState.NORMAL;
	}
	
}
