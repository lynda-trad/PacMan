package pacman;

public abstract class Gum extends Elements
{
	protected boolean eaten; 
	protected int 	  type;     			// 0 = Blue, 1 = Violet, 2 = Orange, 3 = Vert
	protected int 	  score; 				// 100 = Blue, 300 = Violet, 500 = Orange, 1000 = Vert
	protected int 	  element;  			// Rien = 0, Murs = 1, Joueur = 2, Ghosts = 3, Gums = 4
	protected int     compteur = 0;
	
	public Gum(int type)
	{
		this.eaten = false;
		this.type  = type;
		
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
		
		this.element = 4;
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

	@Override
	public int getElement() 
	{
		return this.element;
	}

	public boolean getEaten() 
	{
		return this.eaten;
	}
	
	/////////////////////////////////////
	
	public void isEaten() 
	{
		this.eaten = true;
	}
	
	public void decrementeCompteur() 
	{
		-- compteur;
	}
	
	public abstract void effet(); // Effets sur le jeu (et Ghosts) 

	public void effet(Pacman p) 
	{
		// TODO Auto-generated method stub
		
	}

	/*
	public void effet(Pacman p, Ghosts[] ghosts) {
		// TODO Auto-generated method stub
		
	}
	*/
	

	/*
		Apres qu'une gum ait été consommée on doit  mettre son etat a 0 pour dire
		quelle ne doit plus apparaitre -> si tt gum mangées alors jeu gagné 
	*/
	
	
}