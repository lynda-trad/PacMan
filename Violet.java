package pacman;

public class Violet extends Gum
{
	
	/*
	Violet
	300
	pacaman jaune pale
	Quand le pacman est invisible et le pacman pourra traverser les fantomes sans perdre de vie.
	*/
	
	public Violet()
	{
		super(1); // Violet --> type = 1
	}
	

	@Override
	public void effet(Pacman p) 
	{
	p.beInvisible();
		
	}
	
	public String toString()
	{
			if (this.eaten==true)
				return "Gum Violet de score " + this.score + " eaten";
			else
				return "Gum Violet de score " + this.score + " not eaten";
			
	}

}
