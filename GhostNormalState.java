
public class GhostNormalState extends GhostState 
{	
	protected GhostNormalState(Ghosts ghost) 
	{
		super(ghost);
	}
		
	@Override
	public void left() 
	{
		if(ghost.x - 1 >= 0)
		{
			if(ghost.x == 0)
			{
				ghost.specialLeft();
			}
			-- ghost.x;

		}	
	}
	
	@Override
	public void right() 
	{
		if(ghost.x + 1 < 18)
		{
			++ ghost.x;

		}	
	}
	
	@Override
	public void up() 
	{
		if(ghost.y == 0)
			ghost.specialUp();
		
		if(ghost.y - 1 >= 0)
		{
			-- ghost.y;
		}
	}
		
	@Override
	public void down()
	{
		if(ghost.y + 1 < 18)
		{
			++ ghost.y;
		}
	}
	
	@Override
	public GState getState()
	{
		return GState.NORMAL;
	}
	
}
