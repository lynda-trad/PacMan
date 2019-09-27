package pacman;

public abstract class Gum 
{
	private int state;
	private int type;
	private int score;

	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setState(int s) {
		state = s;
	}

	/*
		Apres qu'une gum ait été consommée on doit  mettre son etat a 0 pour dire
		quelle ne doit plus apparaitre -> si tt gum mangées alors jeu gagné 
	*/
}
