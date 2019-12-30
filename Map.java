
public class Map
{
	public static final char N = 'N';
	public static final char W = 'W';
	public static final char G = 'G';
	
	private char[][] map = 
		{
			{W, W, W, W, W, W, W, W, N, W, W, W, W, W, W, W, W, W}, 
			{W, G, N, G, N, G, N, N, G, W, G, N, G, N, G, N, G, W}, 
			{W, N, W, N, W, W, W, G, W, W, N, W, W, W, N, W, N, W},
			{W, G, W, G, W, G, W, N, G, N, G, W, G, N, G, W, G, W},
			{W, N, W, W, W, N, W, G, N, W, N, W, W, W, N, W, W, W},
			{W, G, N, G, W, G, N, N, G, W, G, N, G, W, G, N, G, W},
			{W, W, W, N, W, W, W, G, W, W, N, W, N, W, W, W, N, W},
			{N, G, N, G, N, G, W, N, G, N, G, W, G, N, G, N, G, N},
			{W, N, W, N, G, N, W, G, N, G, N, G, N, G, N, W, N, W},
			{W, G, W, G, W, G, W, N, W, N, W, W, W, W, G, W, G, W},
			{W, W, W, N, W, N, W, G, W, W, W, W, W, W, N, W, N, W},
			{W, G, W, G, W, G, W, N, G, W, G, N, G, N, G, W, G, W},
			{W, N, W, N, W, N, W, W, N, W, N, W, W, W, W, W, N, W},
			{W, G, W, G, W, G, W, N, G, N, G, N, G, W, G, N, G, W},
			{W, N, W, N, W, N, W, G, W, W, W, W, N, W, W, W, N, W},
			{W, G, N, G, N, G, W, N, G, N, G, W, G, N, G, N, G, W},
			{W, N, G, N, W, N, G, G, N, W, W, W, W, W, N, W, N, W},
			{W, W, W, W, W, W, W, W, N, W, W, W, W, W, W, W, W, W},
	};
	
	private int length = 18;
	
	/*
	 * On met que les pacgum, les murs et le vide 
	 * comme ca si fantome passe sur pacgum, 
	 * lemplacement ne devient pas vide quand il se fait manger par superpacman
	 * et emplacement de gum ne se fait pas ecraser par celui du ghost
	 */

	public Map()
	{
		//map initialise plus haut
	}
	
	public char[][] getMap() 
	{
		return map;
	}
	
	////////////////////////////////////////////////
	
	public void setNewMap() 
	{

		map[4] [3] = N;
		
		map[7][6]  = N;
		
		map[12][7] = N;
		
		map[2][8]  = N;
		map[9][8]  = N;
		map[10][8] = N;
		map[14][8] = N;
		
		map[5][9]  = N;
		
		map[9][10] = N;
		map[10][10]= N;

		map[3] [11]= N;
		
		map[16][15]= N;
		
		//map[13][11]= Element.W;
		map[14][3] = W;
		map[9][7]  = W;
		
	}

	public int getLength() 
	{
		return length;
	}
	
}

