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
		 Rien   = 0
		 Ghosts = 1
		 Gums 	= 2
		 Murs 	= 3
		 Joueur = 4
		 */
	}
	
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
	
	
	
}

