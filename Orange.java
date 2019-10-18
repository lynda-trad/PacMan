package pacman;

public class Orange extends Gum
{
	
	/*
	Orange
	500
	pacman devient orange et fantomes bleus 
	Quand le pacman est un superpacman, les fantomes deviennent vulnerables. Dans ce cas, ils se deplacent
	deux fois plus lentement et ils reviennent au centre du labyrinthe si ils sont touches par le pacman.
	*/
	
	public Orange()
	{
		super(2); // Orange --> type = 2
		
	}
	
	@Override
	public void effet(Pacman p, Ghosts g) 
	{
	p.beSuperPacman();
	g.beVulnerable();
	
	}
	
	//modifie aspect du pacman
	//rend fantome mangeable et deux fois plus lents -> fantome gereront eux memes si se font manger
	
}