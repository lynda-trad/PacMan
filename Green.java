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
		new Gum(3); // Green --> type = 3

	}
	
	@Override
	public void effet()
	{
	//GameGraphics.newStructure() //Nouvelle structure de labyrinthe
		
	}
	
	// devra changer la grille sur laquelle on joue si on touche cette gum
	// donc il modifiera le tableau dont les cases representent les murs
}