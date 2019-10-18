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
		new Gum(1); // Violet --> type = 1
	}
	
	@Override
	public void effet(Pacman p) 
	{
	p.beInvisible();
		
	}
	
}
