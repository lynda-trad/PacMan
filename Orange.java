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
	public Orange() {
		super.setScore(500);
		super.setType (3); 		// type de gum 
	}
	
	//modifie aspect du pacman
	//rend fantome mangeable et deux fois plus lents -> fantome gereront eux memes si se font manger
	
}