package pacman;

public abstract class Gum extends Elements
{
	protected static int compteur = 0;
	protected boolean eaten; 
	protected int type;  // 0 = Blue, 1 = Violet, 2 = Orange, 3 = Vert
	protected int score; // 100 = Blue, 300 = Violet, 500 = Orange, 1000 = Vert
	protected int element;  // 0 = Pacman, 1 = Ghosts, 2 = Gum , 3 = Mur
	
	public Gum(int type)
	{
		this.eaten = false;
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
		
		this.element = 2;
		this.compteur ++;
		
	}
	
	public int getCompteur()
	{
		return compteur;
	}
	
	public void setCompteur(int nbGum) 
	{
		compteur = nbGum;
	}
	
	public void decrementeCompteur() {
		compteur --;
	}
	
	public bool getEaten() 
	{
		return this.eaten;
	}
	
	public void isEaten() 
	{
		this.eaten = true;
	}

	public int getType() {
		return type;
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

	/////////////////////////////////////
	
	public abstract void effet(); // Effets sur le jeu (Pacman et Ghosts) 
	
	/*
		Apres qu'une gum ait �t� consomm�e on doit  mettre son etat a 0 pour dire
		quelle ne doit plus apparaitre -> si tt gum mang�es alors jeu gagn� 
	*/
}