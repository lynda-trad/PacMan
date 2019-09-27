package pacman;

public class Player extends Elements
{
	private int score	= 0;	     // score du player
	private int lives 	= 3; // initialement trois vies
	private int element = 0;
	
	public int getScore() 
	{
		return score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public int getLives() 
	{
		return lives;
	}
	
	public void setLives(int lives)
	{
		this.lives = lives;
	}
	
	@Override
	public int getElement() {
		return element;
	}
	
	//////////////////////////////////////////////////
	
	public void addScore(Gum g)
	{ // apres avoir manger une gum on ajoute son score au score du player
		score += g.getScore();
	}	
	
	public void newLife()
	{	//Si le joueur depasse les 5000 points, il obtient une vie supplementaire.
		if(score > 5000)
		{
			++lives;
		}
	}	
	
	public void loseLife() 
	{
		lives--;
		if(lives == 0) //checks if dead
			gameOver();
	}
	
	public void gameOver()
	{
		
		if(lives == 0) //quand le pacman a perdu toutes ses vies    la partie est perdue.
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
}
