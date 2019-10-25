package pacman;

public abstract class Elements 
{
	
	// possiblement pas utile vu quon peut utiliser element directement 
	
	
	/*Chaque element sera reconnu par un int qui lui correspond
	 Rien   = 0
	 Murs 	= 1
	 Joueur = 2
	 Ghosts = 3
	 Gums 	= 4
	 */
	
	protected Element element;
	//a partir de ca on pourra appeler les fonctions dont on a besoin
	//par exemple backtoCenter pour les fantomes 
		
	/*
	 * On n'a plus besoin des x et y car les gum seront placées dès le debut du jeu
	 * on verifie dans lenum quoi est quoi et apres on appelle la fonction getEaten etc  
	 * 
	 * 
	 * 
	*/
	
	/*
	// Chaque element a une position
	protected int x;
	protected int y;
	*/
	
	//Getter & Setter
	
	// Ghosts : 0 = normal, 1 = vulnerable
	// Pacman : 0 = normal, 1 = superPacman, 2 = invisible
	// Gum : boolean eaten or not dans abstract class Gum
	public int getState() 
	{
		return 0;
	}
	
	public Element getElement() 
	{
		return this.element;
	}
	
	
	/*
	 * fonction getEaten -> score ++ 
	 * maj de la map mettre du vide a cet endroit 
	 * 
	 * par contre si fantome se font manger 
	 * ils changeront leur propre coordonnées, pas ceux de la map
	 * 
	 * */
}