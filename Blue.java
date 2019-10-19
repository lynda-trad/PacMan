package pacman;

public class Blue extends Gum
{
	/*
	Bleu
	100
	rien
	*/
	public Blue()
	{
		super(0); // Blue --> type= 0  
	}
	
	public String toString()
	{
			if (this.eaten==true)
				return "Gum Blue de score " + this.score + " eaten";
			else
				return "Gum Blue de score " + this.score + " not eaten";

	}
	
}