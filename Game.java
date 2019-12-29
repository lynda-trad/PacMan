//import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Game 
{
	private Map map;
	
	private Pacman player;

	private Ghosts[] ghosts = new Ghosts[4];

	private int gum = 72;
	
	private int compteurGum = gum;

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

		gums[0]  = new Blue  (0, new Coordinate(1, 1)) ; 	// blue 
		gums[1]  = new Blue  (0, new Coordinate(3, 1)) ; 	// blue 
		gums[2]  = new Blue  (0, new Coordinate(5, 1)) ;	// blue
		gums[3]  = new Blue  (0, new Coordinate(7, 1)) ; 	// blue
		gums[4]  = new Blue  (0, new Coordinate(9, 1)) ; 	// blue 
		
		gums[5]  = new Purple(1, new Coordinate(11, 1));  	// violet
		
		gums[6] = new Blue  (0, new Coordinate(13, 1)) ; 	// blue  
		gums[7] = new Blue  (0, new Coordinate(15, 1)) ; 	// blue 
		 
		
		gums[8] = new Blue  (0, new Coordinate(16, 2)) ; 	// blue 

		
		gums[9]  = new Blue  (0, new Coordinate(1, 3)) ; 	// blue 
		gums[10] = new Blue  (0, new Coordinate(3, 3)) ; 	// blue 
		gums[11] = new Blue  (0, new Coordinate(5, 3)) ; 	// blue 
		gums[12] = new Blue  (0, new Coordinate(7, 3)) ; 	// blue
		gums[13] = new Blue  (0, new Coordinate(9, 3)) ; 	// blue
		gums[14] = new Blue  (0,new Coordinate(11, 3)) ; 	// blue
		gums[15] = new Blue  (0,new Coordinate(13, 3)) ; 	// blue
		gums[16] = new Blue  (0,new Coordinate(15, 3)) ; 	// blue
		
		
		gums[17] = new Blue  (0, new Coordinate(8, 4)) ;  	// blue
		
		
		gums[18] = new Blue  (0, new Coordinate(1, 5)) ;  	// blue
		gums[19] = new Blue  (0, new Coordinate(7, 5)) ;  	// blue
		gums[20] = new Blue  (0, new Coordinate(9, 5)) ;  	// blue
		gums[21] = new Blue  (0,new Coordinate(11, 5)) ;  	// blue
		gums[22] = new Blue  (0,new Coordinate(13, 5)) ;  	// blue
		gums[23] = new Blue  (0,new Coordinate(15, 5)) ;  	// blue

		
		gums[24] = new Blue  (0,new Coordinate(16, 6)) ; 	// blue
		

		gums[25] = new Blue  (0, new Coordinate(2, 7)) ; 	// blue
		gums[26] = new Blue  (0, new Coordinate(4, 7)) ; 	// blue
		gums[27] = new Blue  (0, new Coordinate(6, 7)) ;  	// blue
		gums[28] = new Blue  (0, new Coordinate(8, 7)) ; 	// blue
		gums[29] = new Blue  (0,new Coordinate(10, 7)) ; 	// blue
		gums[30] = new Blue  (0,new Coordinate(14, 7)) ; 	// blue
		gums[31] = new Blue  (0,new Coordinate(16, 7)) ; 	// blue
		
		
		gums[32] = new Blue  (0, new Coordinate(1, 8)) ; 	// blue
		gums[33] = new Blue  (0, new Coordinate(3, 8)) ; 	// blue
		gums[34] = new Blue  (0, new Coordinate(5, 8)) ; 	// blue
		gums[35] = new Blue  (0, new Coordinate(7, 8)) ; 	// blue
		gums[36] = new Blue  (0,new Coordinate(11, 8)) ; 	// blue
		gums[37] = new Blue  (0,new Coordinate(13, 8)) ; 	// blue
		gums[38] = new Blue  (0,new Coordinate(15, 8)) ; 	// blue   
		
		
		gums[39] = new Blue  (0, new Coordinate(8, 9)) ; 	// blue 

		
		gums[40] = new Blue  (0, new Coordinate(1, 10));	// blue
		gums[41] = new Blue  (0, new Coordinate(3, 10));	// blue
		gums[42] = new Blue  (0, new Coordinate(5, 10));	// blue
		gums[43] = new Blue  (0, new Coordinate(7, 10));	// blue
		gums[44] = new Blue  (0,new Coordinate(11, 10));	// blue
		gums[45] = new Blue  (0,new Coordinate(13, 10)); 	// blue   
		gums[46] = new Blue  (0,new Coordinate(15, 10)); 	// blue   
		
 
		gums[47]  = new Blue  (0,new Coordinate(8, 11));	// blue

		
		gums[48]  = new Blue  (0,new Coordinate(1, 12)); 	// blue 
		gums[49]  = new Blue  (0,new Coordinate(3, 12)); 	// blue  
		gums[50]  = new Blue  (0,new Coordinate(5, 12));	// blue
		gums[51]  = new Blue  (0,new Coordinate(7, 12)); 	// blue  
		gums[52]  = new Blue  (0,new Coordinate(11,12));	// blue
		gums[53]  = new Blue  (0,new Coordinate(13,12)); 	// blue 
		gums[54]  = new Blue  (0,new Coordinate(15,12)); 	// blue  
	

		gums[55]  = new Blue  (0,new Coordinate(8, 13));	// blue 
		
		
		gums[56] = new Blue  (0,new Coordinate(1, 14)) ;	    // blue 
		gums[57] = new Blue  (0,new Coordinate(3, 14)) ; 	// blue
		gums[58] = new Blue  (0,new Coordinate(5, 14)) ;	    // blue 
		gums[59] = new Blue  (0,new Coordinate(7, 14)) ; 	// blue 
		gums[60] = new Blue  (0,new Coordinate(9, 14)) ; 	// blue 
		gums[61] = new Blue  (0,new Coordinate(11,14)) ; 	// blue 
		gums[62] = new Blue  (0,new Coordinate(13,14)) ; 	// blue 
		gums[63] = new Blue  (0,new Coordinate(15,14)) ; 	// blue 
		
		
		gums[64] = new Blue  (0,new Coordinate(1, 16)) ; 	// blue
		
		gums[65] = new Orange(2,new Coordinate(3, 16)) ; 	// orange 
		
		gums[66] = new Blue  (0,new Coordinate(5, 16)) ; 	// blue  		
		gums[67] = new Blue  (0,new Coordinate(7, 16)) ; 	// blue 
		
		gums[68] = new Blue  (0,new Coordinate(9, 16)) ; 	// blue  		

		gums[69] = new Blue  (0,new Coordinate(11,16)) ; 	// blue


		gums[70] = new Blue  (0,new Coordinate(13,16)) ; 	// blue 		   

		
		gums[71] = new Green (3,new Coordinate(15,16)) ;	// vert 

	}

	public void initializePlayer()
	{
		player = new Pacman(this);
		player.c = new Coordinate(3, 5);
	}
	
	public void initializeGhosts()
	{
		ghosts[0] = new Ghosts(this, new Coordinate(3, 3));
		ghosts[1] = new Ghosts(this, new Coordinate(16, 3));
		ghosts[2] = new Ghosts(this, new Coordinate(3, 16));
		ghosts[3] = new Ghosts(this, new Coordinate(15, 10)); 
		
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
	
	boolean isOut(Coordinate c)  //indique si la position du pacman ou du ghost sort de l'écran
	{
		if (c.getX() < 0 || c.getY() < 0)
			return true;
		if (c.getX() >= 18 || c.getY() >= 18)
			return true;
		return false;
	}
	
	public void restartAfterCollision()
	{
		getGhosts()[0].c = new Coordinate (3, 3);
		getGhosts()[1].c = new Coordinate (16, 3);
		getGhosts()[2].c = new Coordinate (3, 16);
		getGhosts()[3].c = new Coordinate (15, 10);
		
		getGhosts()[0].beNormal();
		getGhosts()[1].beNormal();
		getGhosts()[2].beNormal();
		getGhosts()[3].beNormal();
	}
	
	public void gameOver(int i)
	{
		if(i == 0)
			JOptionPane.showMessageDialog(null, "Too bad, you lost ! Your score : " + player.getScore());
		else
			JOptionPane.showMessageDialog(null, "Great job, you won ! Your score : " + player.getScore());
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