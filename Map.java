package pacman;

public class Map extends Elements
{
	
	private Element[][] map = 
		{ 
			{Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W}, 
			{Element.W, Element.G, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.G, Element.W}, 
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.G, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.G, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.G, Element.W},
			{Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W},
	};
	
	private int length = 18;
	
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

	public int getLength() 
	{
		return length;
	}
	
}

