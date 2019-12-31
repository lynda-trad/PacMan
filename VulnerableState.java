public class VulnerableState extends GhostState 
{	
	protected VulnerableState(Ghosts ghost) 
	{
		super(ghost);
	}
	
	@Override
	public void move() 
	{
		Coordinate dir = new  Coordinate (ghost.c.getX() + ghost.getDirection().getX(), ghost.c.getY() + ghost.getDirection().getY());

		if(!ghost.isOut(dir))
		{
			int ralenti = ghost.getRalenti();
			if(ralenti % 2 == 0)
			{
				ghost.c = dir;
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
