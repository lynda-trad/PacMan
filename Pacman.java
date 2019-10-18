package pacman;

public class Pacman extends Characters
{
	protected int score;	     // score du player
	protected int lives; // initialement trois vies
	protected int state;  // 0 = normal, 1 = superPacman, 2 = invisible
	private int element; // 0 = Pacman, 1 = Ghosts, 2 = Gum , 3 = Mur
	
	public Pacman ()
	{
	this.score = 0;
	this.lives = 3;
	this.state = 0;
	this.element = 0;
	}
	
	public int getScore() 
	{
		return this.score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public int getLives() 
	{
		return this.lives;
	}
	
	public void setLives(int lives)
	{
		this.lives = lives;
	}
	
	public int getState() 
	{
		return this.state;
	}
	
	public void beNormal() 
	{
		this.state = 0;
	}
	
	public void beSuperPacman() 
	{
		this.state = 1;
	}
	
	public void beInvisible() 
	{
		this.state = 2;
	}
	
	
	@Override
	public int getElement() {
		return this.element;
	}
	
	//////////////////////////////////////////////////
	
	public void addScore(Gum g)
	{ // apres avoir manger une gum on ajoute son score au score du player
		this.score += g.getScore();
	}	
	
	public void newLife()
	{	//Si le joueur depasse les 5000 points, il obtient une vie supplementaire.
		if(this.score > 5000)
		{
			initializeScore();
			++this.lives;
		}
	}	
	
	public void initializeScore()
	{
		this.score = 0;
	}

	public void loseLife() 
	{
		this.lives--;
		if(this.lives == 0) //checks if dead
			gameOver();
	}
	
	public void gameOver()
	{
		
		if(this.lives == 0) //quand le pacman a perdu toutes ses vies    la partie est perdue.
		{
			System.out.println("noob");
			System.exit(0);
		}
		else 		   //quand il n'y a plus de pacgommes 	   	    la partie est gagnee 
		{
			System.out.println("noob");
			System.exit(0);
		}
		
	}
	
	public void eatGum(Gum g) 
	{
		if (g.eaten == false)
		{
			if(g.getType()==0)
			{
				this.addScore(g);
				g.isEaten();
				g.decrementeCompteur();
				
			} 
			else 
			{
				this.addScore(g);
				g.effet();
				g.isEaten();
				g.decrementeCompteur();

			}
					
		}
		
	}
	
	@Override
	public void move()
	{
		

	}
	
	@Override
	public void cross()
	{
		

	}
	
}
