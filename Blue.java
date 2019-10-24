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
		super(0);  
	}
	
	public String toString()
	{
			if (this.eaten==true)
				return "Gum Blue de score " + this.score + " eaten";
			else
				return "Gum Blue de score " + this.score + " not eaten";
	}

	@Override
	public void effet() 
	{
		// TODO Auto-generated method stub
		
	}
	
}