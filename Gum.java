package pacman;

public abstract class Gum extends Elements
{
	protected int 	  type;     			// 0 = Blue, 1 = Violet, 2 = Orange, 3 = Vert
	protected int 	  score; 				// 100 = Blue, 300 = Violet, 500 = Orange, 1000 = Vert
	protected int     compteur = 0;
	
	protected int 	  x;
	protected int     y;
	
	public Gum(int type, int x, int y)
	{
		this.type  = type;
		this.x = x; 
		this.y = y;
		
		switch(type)
		{
			case 0:
				this.score = 100;
				break;
			case 1:
				this.score = 300;
				break;	
			case 2:
				this.score = 500;
				break;
			case 3:
				this.score = 1000;
				break;
			default:
				this.score = 100;
		}
		
		++ this.compteur;
	}
	
	// Setter & Getter
	
	public int getCompteur()
	{
		return compteur;
	}
	
	public void setCompteur(int nbGum) 
	{
		compteur = nbGum;
	}
	
	public int getType() 
	{
		return type;
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}
	
	public int getScore() 
	{
		return this.score;
	}

	/////////////////////////////////////
	
	public void isEaten() 
	{
		-- compteur;
	}
	
	public abstract void effet(); // Effets sur le jeu (et Ghosts) 

	public void effet(Pacman p) 
	{
		// TODO Auto-generated method stub
		
	}

	/*
	public void effet(Pacman p, Ghosts[] ghosts) 
	{
		// TODO Auto-generated method stub
		
	}
	*/
	
}