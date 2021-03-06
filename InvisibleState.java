public class InvisibleState extends PacmanState
{

	protected InvisibleState(Pacman pacman) 
	{
		super(pacman);
	} 
		
	@Override
	public void ghostCollision(int i, Coordinate c) 
	{
		if(!pacman.wallCollisionPower(c))
		{
			pacman.move();
			
			if(pacman.game.getMap().getMap()[c.getX()][c.getY()] == Map.G)
			{
				for(int j = 0 ; j < pacman.game.getGums().length ; ++j)
				{
					if(pacman.game.getGums()[j].c.equals(c))
					{
						pacman.eatGum(pacman.game.getGums()[j]);
					}
				}
			}
			
			pacman.notifyObserver();
		}
	}
		
	@Override
	public PState getState()
	{
		return PState.INVISIBLE;
	}
}
