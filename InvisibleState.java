
public class InvisibleState extends PacmanState
{

	protected InvisibleState(Pacman pacman) 
	{
		super(pacman);
	} 
		
	@Override
	public void ghostCollision(int i, int future_x, int future_y) 
	{
		if(!pacman.wallCollisionPower(future_x, future_y))
		{
			pacman.move();
			if(pacman.game.getMap().getMap()[future_x][future_y] == Element.G)
			{
				for(int j = 0 ; j < pacman.game.getGums().length ; ++j)
					if(pacman.game.getGums()[j].x == future_x && pacman.game.getGums()[j].y == future_y)
						pacman.eatGum(pacman.game.getGums()[j]);
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
