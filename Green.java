package pacman;

public class Green extends Gum
{
	/*
	Vert 
	1000 
	Modifie la structure du labyrinthe
	*/
	
	public Green() 
	{	
		super.setScore(1000);
		super.setType (4); 		// type de gum 
	}
	
	// devra changer la grille sur laquelle on joue si on touche cette gum
	// donc il modifiera le tableau dont les cases representent les murs
	
}