package pacman;

public class Game 
{
	private Map map;
	
	private Pacman player;

	private Ghosts[] ghosts = new Ghosts[4];
	
	private Gum[] gums = new Gum[4];
	
	public Game()
	{
		map = new Map();
		initializeGhosts();
		initializePlayer();
		initializeGum();
	}
	
	public void initializeGum()
	{
		gums[0] = new Blue  (0,1,2); // blue  
		gums[1] = new Violet(1,8,1); // violet
		gums[2] = new Orange(2,5,7); // orange 
		gums[3] = new Green (3,2,4); // vert
	}

	public void initializePlayer()
	{
		player = new Pacman(this);
		player.x = 3;
		player.y = 3;
	}
	
	public void initializeGhosts()
	{
		ghosts[0] = new Ghosts(this, 1, 1);
		ghosts[1] = new Ghosts(this, 8, 3);
		ghosts[2] = new Ghosts(this, 1, 8);
		ghosts[3] = new Ghosts(this, 8, 8); 
	}
	
	//Getter & Setter
	
	public Map getMap() 
	{
		return map;
	}

	public void setMap(Map map) 
	{
		this.map = map;
	}
	
	public Pacman getPlayer() 
	{
		return player;
	}

	public void setPlayer(Pacman player) 
	{
		this.player = player;
	}

	public Ghosts[] getGhosts() 
	{
		return ghosts;
	}

	public void setGhosts(Ghosts[] ghosts) 
	{
		this.ghosts = ghosts;
	}

	public Gum[] getGums() 
	{
		return gums;
	}

	public void setGums(Gum[] gums) 
	{
		this.gums = gums;
	}
	
	////////////////////////////////
	
	public void move() 
	{
		player.cross();
		for(int i = 0 ; i < ghosts.length; ++i)
		{
			ghosts[i].move();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}