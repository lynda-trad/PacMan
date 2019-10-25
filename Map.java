package pacman;

public class Map extends Elements
{
	private Element[][] map = 
		{ 
			{Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.VIDE, Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL}, 
			{Element.WALL, Element.GHOST,Element.GUM, Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.GHOST}, 
			{Element.WALL, Element.VIDE,  Element.VIDE, Element.WALL, Element.GUM, Element.VIDE,  Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.VIDE, Element.PLAYER,Element.WALL,Element.WALL, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.GUM,  Element.WALL, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.WALL, Element.WALL, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.VIDE, Element.VIDE, Element.WALL, Element.VIDE},
			{Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.WALL, Element.VIDE, Element.VIDE, Element.VIDE, Element.WALL, Element.VIDE},
			{Element.GHOST,Element.GUM,  Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.VIDE, Element.WALL, Element.GHOST},
	};
	
	/*
	 * On met que les pacgum, les murs et le vide 
	 * 
	 * comme ca si fantome pase sur pacgum, leplacement ne devient pas vide quand il se fait manger par superpacman
	 * 
	 * 
	 * */

	public Map()
	{
		// initialise toutes les cases à 0 donc on va attribuer une valeur à tous les éléments du jeu 
		
		 /*
		 Numero d'élément
		 Rien   = 0
		 Murs 	= 1
		 Gums 	= 4
		 
		 eux vont etre gerer par game
		 Joueur = 2
		 Ghosts = 3
		 */
	}

	public void setMap(Element[][] map) 
	{
		this.map = map;
	}

	public Element[][] getMap() 
	{
		return map;
	}
	
	public Element getElement() 
	{
		return this.element;
	}
	
	////////////////////////////////////////////////
	
	public void printMap()
	{
		for(int i = 0; i < 7; ++i)
		{
			for(int j = 0; j < 7; ++j)
			{
				System.out.println(map[i][j]);
			}
		}
	}
	/*
	public void setNewMap(Element[][] map) 
	{
		this.map = map;
	}
	*/
	
	// Pas utile je crois 
	/*
	public void getElementCase(int x, int y)
	{
		switch(map[x][y].getElement())
		{
				case 0:
					//rien
					break;

				case 1:
					//ghost
					break;

				case 2:
					//gum
					map[x][y].getState(); //savoir quel type de gum c'est pour appliquer le pouvoir
					
					
					break;

				case 3:
					//wall
					break;
					
				case 4:
					//joueur
					break;
		}
	}
	*/
}

