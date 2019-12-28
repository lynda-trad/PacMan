
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
	public void move() 
	{
		if(!ghost.game.isOut(ghost.x + ghost.getDirection().getX(), ghost.y + ghost.getDirection().getY()))
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				ghost.x += ghost.getDirection().getX();
				ghost.y += ghost.getDirection().getY();
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
