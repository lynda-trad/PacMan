package pacman;

public class Ghosts extends Elements
{
	private int x,y ;
	private int element = 1;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getElement() {
		return element;
	}
	
	////////////////////////////////////////
	
	public void backToCenter() 
	{   // touché par pacman qd vulnerable -> gum orange
		x = y = 4;
		//mettre a jour map
	}

	public void checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		redirection();
	}
	
	public void redirection() 
	{
		/*
		Chaque fantome se deplace dans une direction jusqu'a ce qu'il atteigne un mur, puis choisit une nouvelle
		direction aleatoirement.
		*/
		
		// apres avoir atteint le mur, check haut droit gauche droite -> premier de libre et va la bas et continue son
		// voyage 
	}

	
}

