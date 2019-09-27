package pacman;

public class Map extends Elements
{
	private Elements[][] map;
	
	public Map()
	{
		map = new Elements[7][7];
		// initialise toutes les cases à 0 donc on va attribuer une valeur à tous les éléments du jeu 
		
		 /*
		 Numero d'élément
		 Joueur = 0
		 Ghosts = 1
		 Gums 	= 2
		 Murs 	= 3
		 */
	}
	
	public void getElementCase(int x, int y)
	{
		switch(map[x][y].getElement())
		{
				case 0:
					//player
					break;

				case 1:
					//ghost
					break;

				case 2:
					//gum
					map[x][y].getState();
					break;

				case 3:
					//wall
					break;
		}
	}
}

