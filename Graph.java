import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel implements Observer
{
	private Game game;
	
	private Gui gui;
	
	private static final int SCALE  = 20;
	private static final int width  = SCALE * 18 + 14;
	private static final int height = SCALE * 18 + 37;
	
	private Color paleYellow = new Color(255,255,173);
	private Color purple 	 = new Color(174,54,250);
	private Color pacSpawn   = new Color(0,153,0);
	private Color ghostSpawn = new Color(114,0,0);
	private Color blue_gum	 = new Color(60,180,217);
	
	public Graph(Game g) 
	{
		this.game = g;
		this.setSize(width, height + 30);
	}
	
	
	public void setGui(Gui gui) 
	{
		this.gui = gui;
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		setBackground(Color.BLACK);
		
		for(int i = 0 ; i < this.game.getMap().getLength() ; ++i)
		{
			for(int j = 0 ; j < this.game.getMap().getLength() ; ++j)
			{
				switch(this.game.getMap().getMap()[i][j])
				{
					case Map.W :
						drawWalls(g, i, j);
					break;
					
					case Map.G : 
						drawGums(g, i, j);
					break;
					
					default :
					break;
				}
			}
		}
		
		//Spawn pacman
		g.setColor(pacSpawn);
		g.fillRect(3 * SCALE, 5 * SCALE, SCALE, SCALE);
		
		//Spawn ghosts
		g.setColor(ghostSpawn);
		g.fillRect(9 * SCALE, 9 * SCALE, SCALE, SCALE);
		
		drawGhosts(g);
		drawPacman(g);
		
		// Print score
		g.drawString(String.valueOf(game.getPlayer().getScore()), 300, 380);
		
		// Print lives left
		for(int i = 0; i < game.getPlayer().getLives() ; ++i)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(1 * i * 4 * (SCALE / 5), 93 * (SCALE / 5), SCALE / 2, SCALE / 2);
		}
	}
	
	public void drawPacman(Graphics g)
	{
		switch(game.getPlayer().nameState())
		{
			case NORMAL : 
				g.setColor(Color.YELLOW);
				g.fillOval(game.getPlayer().c.getX() * SCALE, game.getPlayer().c.getY() * SCALE, SCALE, SCALE);
			break;
			
			case SUPERPACMAN : 
				g.setColor(Color.ORANGE);
				g.fillOval(game.getPlayer().c.getX() * SCALE, game.getPlayer().c.getY() * SCALE, SCALE, SCALE);
			break;
			
			case INVISIBLE : 
				g.setColor(paleYellow);
				g.fillOval(game.getPlayer().c.getX() * SCALE, game.getPlayer().c.getY() * SCALE, SCALE, SCALE);
			break;
		}
	}
	
	public void drawGhosts(Graphics g)
	{
		for(int i = 0 ; i < 4 ; ++i)
		switch(game.getGhosts()[i].nameState())
		{
			case NORMAL :
				g.setColor(Color.RED);
				g.fillOval(game.getGhosts()[i].c.getX() * SCALE, game.getGhosts()[i].c.getY() * SCALE, SCALE, SCALE);
			break;
				
			case VULNERABLE :
				g.setColor(Color.BLUE);
				g.fillOval(game.getGhosts()[i].c.getX() * SCALE, game.getGhosts()[i].c.getY() * SCALE, SCALE, SCALE);
			break;
		}
	}
	
	public void drawGums(Graphics g, int i, int j)
	{
		for(int k = 0 ; k < game.getGums().length; ++k)
		{
			if(i == game.getGums()[k].c.getX() && j == game.getGums()[k].c.getY())
			{
				switch(game.getGums()[k].getType())
				{
					case 0 :
						drawBlueGum(g, i, j);
					break;

					case 1 :
						drawPurpleGum(g, i ,j);
					break;

					case 2 :
						drawOrangeGum(g, i ,j);
					break;

					case 3 :
						drawGreenGum(g, i ,j);
					break;
				}
			}			
		}
	}

	public void drawBlueGum(Graphics g, int i, int j)
	{
		int minScale = SCALE - SCALE/2;
		int i_center = i * SCALE + 5;
		int j_center = j * SCALE + 5;
		
		g.setColor(blue_gum);
		g.fillOval(i_center, j_center, minScale, minScale);
	}
	
	public void drawPurpleGum(Graphics g, int i, int j)
	{
		int minScale = SCALE - SCALE/2;
		int i_center = i * SCALE + 5;
		int j_center = j * SCALE + 5;
		
		g.setColor(purple);
		g.fillOval(i_center, j_center, minScale, minScale);
	}
	
	public void drawOrangeGum(Graphics g, int i, int j)
	{
		int minScale = SCALE - SCALE/2;
		int i_center = i * SCALE + 5;
		int j_center = j * SCALE + 5;
		
		g.setColor(Color.ORANGE);
		g.fillOval(i_center, j_center, minScale, minScale);
	}
	
	public void drawGreenGum(Graphics g, int i, int j)
	{
		int minScale = SCALE - SCALE/2;
		int i_center = i * SCALE + 5;
		int j_center = j * SCALE + 5;
		
		g.setColor(Color.GREEN);
		g.fillOval(i_center, j_center, minScale, minScale);
	}
	
	public void drawWalls(Graphics g, int i, int j)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(i * SCALE, j * SCALE, SCALE, SCALE);
	}

	@Override
	public void update() 
	{
		repaint();
	}
}
