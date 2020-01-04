public abstract class Characters
{
	protected Game game;
	protected Coordinate c;
	
	public abstract void move();
	
	boolean isOut(Coordinate c)  				//indique si la position du pacman ou du ghost sort de l'ecran
	{
		if (c.getX() < 0 || c.getY() < 0)
			return true;
		
		if (c.getX() >= 18 || c.getY() >= 18)
			return true;
		
		return false;
	}
}