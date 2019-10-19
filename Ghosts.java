package pacman;

public class Ghosts extends Characters
{
	private int state ; // 0 = normal, 1 = vulnerable
	private int element = 1;  // 0 = Pacman, 1 = Ghosts, 2 = Gum , 3 = Mur
	
	public Ghosts() {
		this.state = 0;
	}
	
	@Override
	public int getElement()
	{
		return this.element;
	}
	
	public int getState() 
	{
		return this.state;
	}
	
	public void beNormal()
	{
		this.state = 0;
	}
	
	public void beVulnerable()
	{
		this.state = 1;
	}
	
	public String toString()
	{
		switch(this.state) {
		
		case 0:
			return "Ghost blanc à l'état Normal";
		case 1:
			return "Ghost bleu à l'état Vulnérable";
		default:
			return "Ghost blanc à l'état Normal";
		}
	
	}
	
	////////////////////////////////////////
	
	public void backToCenter() 
	{   // touché par pacman qd vulnerable -> gum orange
		x = y = 4;
		//mettre a jour map
	}

	public void checkWalls()
	{
		// verifie si ghost touche un mur pour se rediriger si besoin
		//if calcul collision donne oui 
		redirection();
	}
	
	public void redirection() 
	{
		/*
		Chaque fantome se deplace dans une direction jusqu'a ce qu'il atteigne un mur, puis choisit une nouvelle
		direction aleatoirement.
		*/
		
		// apres avoir atteint le mur, check haut droit gauche droite -> premier de libre et va la bas et continue son
		// voyage 
	}
	
	@Override
	public void move()
	{
		

	}
	
	public void moveSlow()
	{
		

	}
	
	@Override
	public void cross()
	{
		

	}
	
}

