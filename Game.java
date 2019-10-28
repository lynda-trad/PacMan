package pacman;

import javax.swing.JOptionPane;

public class Game 
{
	private Map map;
	
	private Pacman player;

	private Ghosts[] ghosts = new Ghosts[4];

	private int compteurGum = 23;
	
	private int gum = 23;

	private Gum[] gums = new Gum[gum];
	
	private int powerTimer = 0;
	
	public Game()
	{
		map = new Map();
		initializeGhosts();
		initializePlayer();
		initializeGum();
	}
	
	public void initializeGum()
	{
		gums[0]  = new Blue  (0,1,1)  ; 	// blue 
		gums[1]  = new Blue  (0,11,12); 	// blue  
		gums[2]  = new Blue  (0,3,3)  ; 	// blue 
		gums[3]  = new Blue  (0,1,8)  ; 	// blue 
		gums[4]  = new Blue  (0,5,8)  ; 	// blue 
		gums[5]  = new Blue  (0,3,16) ; 	// blue 
		gums[6]  = new Blue  (0,3,12) ; 	// blue  
		gums[7]  = new Blue  (0,8,10) ; 	// blue  
		gums[8]  = new Blue  (0,14,12); 	// blue  
		gums[9]  = new Blue  (0,15,10); 	// blue  
		gums[10] = new Blue  (0,11,1) ; 	// blue  
		gums[11] = new Blue  (0,13,14); 	// blue  
		
		gums[12] = new Orange(2,1,16) ; 	// orange 
		gums[13] = new Orange(2,15,5) ; 	// orange
		gums[14] = new Orange(2,7,5)  ;  	// orange
		gums[15] = new Orange(2,16,14);		// orange
		gums[16] = new Orange(2,5,12);		// orange
	
		gums[17] = new Purple(1,9,1)  ;  	// violet
		gums[18] = new Purple(1,10,7) ; 	// violet
		gums[19] = new Purple(1,11,14);		// violet
		gums[20] = new Purple(1,1,10) ;		// violet
		gums[21] = new Purple(1,5,1) ;		// violet
	
		gums[22]  = new Green(3,16,16);		// vert
	}

	public void initializePlayer()
	{
		player = new Pacman(this);
		player.x = 3;
		player.y = 5;
	}
	
	public void initializeGhosts()
	{
		ghosts[0] = new Ghosts(this, 5, 1);
		ghosts[1] = new Ghosts(this, 16, 3);
		ghosts[2] = new Ghosts(this, 5, 12);
		ghosts[3] = new Ghosts(this, 15, 10); 
	}
	
	//Getter & Setter

	public int getCompteurGum() 
	{
		return compteurGum;
	}
	
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
	
	public void decCompteurGum()
	{
		--compteurGum;
	}
	
	////////////////////////////////

	public void restartAfterCollision()
	{
		getGhosts()[0].x = 5;
		getGhosts()[0].y = 1;
		
		getGhosts()[1].x = 16;
		getGhosts()[1].y = 3;
		
		getGhosts()[2].x = 5;
		getGhosts()[2].y = 12;
		
		getGhosts()[3].x = 15;
		getGhosts()[3].y = 10;
		
		getGhosts()[0].setState(0);
		getGhosts()[1].setState(0);
		getGhosts()[2].setState(0);
		getGhosts()[3].setState(0);
	}
	
	public void gameOver(int i)
	{
		if(i == 0)
			JOptionPane.showMessageDialog(null, "Game Over ! You lost !");
		else
			JOptionPane.showMessageDialog(null, "Game Over ! You won !");
		System.exit(0);
	}
	
	public void move() 
	{
		if(compteurGum == 0)
		{	
			gameOver(1);
		}
		
		for(int i = 0 ; i < ghosts.length; ++i)
		{
			ghosts[i].move();
		}
		
		player.cross();
		
		if(powerTimer > 0)
			--powerTimer;
		if(powerTimer == 0)
		{
			player.beNormal();
			for(int i = 0 ; i < ghosts.length; ++i)
			{
				ghosts[i].beNormal();
			}
		}
		
		try 
		{
			Thread.sleep(200);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public int getPowerTimer() 
	{
		return powerTimer;
	}

	public void setPowerTimer(int powerTimer) 
	{
		this.powerTimer = powerTimer;
	}

}