public enum Direction
{
	
// Up(0,1) donc Up.getX() = 0 et Up.getY() = -1
	Still(0,0), Up(0, -1), Down(0, 1), Left(-1, 0), Right(1, 0);

	private int x;
	private int y;
	
	Direction(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}

//base sur snake -> à voir 

// dedans je met un couple x y 
// up -> 0 , 1 

//donc quand jaurai besoin de bouger je mettrai
// x += direction.x y += direction.y


//faire pareil pour coordonnées
//contient un x et un y 

//class qui ont besoin auront un Coordonnées c -> cet objet aura un x et y 
//et on les recup avec des getters
//pour faire plus propre
