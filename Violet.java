package pacman;

public class Violet extends Gum
{
	/*
		Violet
		300
		pacman jaune pale
		Quand le pacman est invisible, il pourra traverser les fantomes sans perdre de vie.
	*/
	
	public Violet(int type, int x, int y)
	{
		super(1,x,y);
	}
	
	@Override
	public void effet(Pacman p) 
	{
		p.beInvisible();
	}
	
	/*
	public String toString()
	{
			if (this.eaten==true)
				return "Gum Violet de score " + this.score + " eaten";
			else
				return "Gum Violet de score " + this.score + " not eaten";
	}
*/
	
	@Override
	public void effet() {
		// TODO Auto-generated method stub
		
	}

}
