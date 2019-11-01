public abstract class Elements 
{
	/*Chaque element sera reconnu par un int qui lui correspond
	 Rien   = 0
	 Murs 	= 1
	 Joueur = 2
	 Ghosts = 3
	 Gums 	= 4
	 */
	
	protected Element element;
	
	public int getState() 
	{
		return 0;
	}
	
	public Element getElement() 
	{
		return this.element;
	}
	
}