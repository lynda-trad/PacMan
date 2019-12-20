
public class VulnerableState extends GhostState 
{
	private static final int TIMEOUT = 50;
	private int timer;
	
	protected VulnerableState(Ghosts ghost) 
	{
		super(ghost);
		timer = TIMEOUT;
	}
	
	@Override
	public void left() 
	{
		if(ghost.x - 1 >= 0)
		{
			if(ghost.x == 0)
				ghost.specialLeft();
			
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				-- ghost.x;
			    ghost.setRalenti(++ ralenti);
			}
			else
			    ghost.setRalenti(++ ralenti);
			
		}	
	}

	@Override
	public void right()
	{
		if(ghost.x + 1 < 18)
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				++ ghost.x;
			    ghost.setRalenti(++ ralenti);
			}
			else
			    ghost.setRalenti(++ ralenti);
		}
	}
	
	@Override
	public void up() 
	{
		if(ghost.y == 0)
			ghost.specialUp();
		
		if(ghost.y - 1 >= 0)
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				-- ghost.y;
			    ghost.setRalenti(++ ralenti);
			}
			else
			    ghost.setRalenti(++ ralenti);
			
		}
	}
	
	@Override
	public void down()
	{
		if(ghost.y + 1 < 18)
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				++ ghost.y;
			    ghost.setRalenti(++ ralenti);
			}
			else
			    ghost.setRalenti(++ ralenti);
		}
	}
		
	@Override
	public GState getState()
	{
		return GState.VULNERABLE;
	}
}
