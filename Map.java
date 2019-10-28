package pacman;

public class Map extends Elements
{
	
	private Element[][] map = 
		{
			{Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W}, 
			{Element.W, Element.G, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.G, Element.W, Element.G, Element.N, Element.N, Element.N, Element.N, Element.N, Element.G, Element.W}, 
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.G, Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.G, Element.N, Element.N, Element.W, Element.G, Element.W},
			{Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W},
			{Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.G, Element.W, Element.N, Element.N, Element.G, Element.W, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.N, Element.N, Element.N, Element.N, Element.N, Element.G, Element.W, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N},
			{Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.W, Element.N, Element.N, Element.N, Element.G, Element.N, Element.N, Element.N, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.G, Element.W, Element.G, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W, Element.G, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W},
			{Element.W, Element.G, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.W, Element.N, Element.N, Element.G, Element.W, Element.G, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.N, Element.W, Element.G, Element.N, Element.N, Element.W},
			{Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.G, Element.W, Element.W, Element.W, Element.N, Element.W},
			{Element.W, Element.N, Element.N, Element.N, Element.N, Element.G, Element.W, Element.N, Element.N, Element.N, Element.G, Element.W, Element.N, Element.N, Element.N, Element.N, Element.N, Element.W},
			{Element.W, Element.N, Element.N, Element.G, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.G, Element.W, Element.G, Element.W},
			{Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.N, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W, Element.W},
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
	
	public Element[][] getMap() 
	{
		return map;
	}
	
	public Element getElement() 
	{
		return this.element;
	}
	
	////////////////////////////////////////////////
	
	public void setNewMap() 
	{
		map[7][6]  = Element.N;
		map[1][16] = Element.N;
		map[2][16] = Element.N;
		map[9][8]  = Element.N;
		map[10][8] = Element.N;
		map[9][10] = Element.N;
		map[10][10]= Element.N;
		map[16][15]= Element.N;
		map[12][7] = Element.N;
		map[2][8] = Element.N;
		map[14][8] = Element.N;
		map[5][9] = Element.N;

		//map[13][11]= Element.W;
		map[14][3] = Element.W;
		
	}

	public int getLength() 
	{
		return length;
	}
	
}

