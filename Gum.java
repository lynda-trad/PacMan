package pacman;

public abstract class Gum extends Elements 
{
	private int state = 1;   // not eaten
	private int type;
	private int score;
	private int element = 2; // for the map
	
	@Override
	public int getState() 
	{
		return state;
	}

	public int getScore() 
	{
		return score;
	}
	
	public void setScore(int s) 
	{
		score = s;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}
	
	public void setState(int s) 
	{
		state = s;
	}

	@Override
	public int getElement() 
	{
		return element;
	}

	/////////////////////////////////////
	
	public void gumEaten()
	{
		state = 0;
	}
	
	/*
		Apres qu'une gum ait été consommée on doit  mettre son etat a 0 pour dire
		quelle ne doit plus apparaitre -> si tt gum mangées alors jeu gagné 
	*/
}