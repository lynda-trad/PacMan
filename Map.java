package pacman;

public class Map extends Elements
{
	private Element[][] map = 
		{ 
			{Element.WALL, Element.WALL, Element.WALL, Element.WALL,  Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL}, 
			{Element.WALL, Element.NONE, Element.GUM,  Element.NONE,  Element.NONE, Element.NONE, Element.NONE, Element.NONE, Element.NONE, Element.WALL}, 
			{Element.WALL, Element.NONE, Element.NONE, Element.NONE,  Element.GUM,  Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.NONE, Element.NONE,  Element.NONE, Element.WALL, Element.WALL, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.WALL, Element.GUM,  Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.WALL, Element.WALL, Element.WALL, Element.WALL},
			{Element.WALL, Element.NONE, Element.WALL, Element.NONE,  Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.WALL, Element.WALL},
			{Element.WALL, Element.GUM,  Element.NONE, Element.NONE,  Element.WALL, Element.NONE, Element.NONE, Element.NONE, Element.NONE, Element.WALL},
			{Element.WALL, Element.WALL, Element.WALL, Element.WALL,  Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL, Element.WALL},
	};
	
	/*
	 * On met que les pacgum, les murs et le vide 
	 * 
	 * comme ca si fantome passe sur pacgum, 
	 * lemplacement ne devient pas vide quand il se fait manger par superpacman
	 * et emplacement de gum ne se fait pas ecraser par celui du ghost
	 */

	public Map()
	{
		//map initialise plus haut 
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
	
}

