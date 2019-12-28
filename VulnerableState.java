
public class VulnerableState extends GhostState 
{	
	protected VulnerableState(Ghosts ghost) 
	{
		super(ghost);
	}
	
	@Override
	public void move() 
	{
		if(!ghost.game.isOut(ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY()))
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				ghost.c = new Coordinate(ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY());
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
