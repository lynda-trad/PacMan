package pacman;

public class Map extends Elements
{
	private Element[][] map = 
		{ 
			{Element.WALL, Element.WALL, Element.WALL, Element.WALL,  Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL}, 
			{Element.WALL, Element.GHOST,Element.GUM,  Element.NONE,  Element.NONE, Element.NONE, Element.NONE, Element.NONE, Element.GHOST,Element.WALL}, 
			{Element.WALL, Element.NONE, Element.NONE, Element.NONE,  Element.GUM,  Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.NONE, Element.PLAYER,Element.NONE, Element.WALL, Element.WALL, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.WALL, Element.GUM,  Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.WALL, Element.WALL, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.GUM,  Element.NONE, Element.GHOST, Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.GHOST,Element.WALL},
			{Element.WALL, Element.WALL, Element.WALL, Element.WALL,  Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL},
	};
	
	/*
	 * On met que les pacgum, les murs et le vide 
	 * comme ca si fantome passe sur pacgum, 
	 * lemplacement ne devient pas vide quand il se fait manger par superpacman
	 * 
	 */

	public Map()
	{
		//map initialiser plus haut 
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
	
	public void setNewMap(Element[][] map) 
	{
		this.map = map;
	}
	
	/*
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
	*/
	
}

