package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel implements Observer
{
	private Game game;
	
	private static final int SCALE  = 20;
	private static final int width  = SCALE * 18 + 14;
	private static final int height = SCALE * 18 + 37;
	
	private Color customColor = new Color(254,254,173); //jaunepale
	private JLabel jlabel;
	
	public Graph(Game g) 
	{
		this.game = g;
		this.setSize(width, height + 30);

		jlabel = new JLabel(String.valueOf(game.getPlayer().getScore()));
		jlabel.setLocation(height + 10, 0);
		jlabel.setFont(new Font("Verdana",1,20));
		add(jlabel);
	}
	
	@Override
	public void paintComponent(Graphics g) //appel�e par repaint 
	{
		super.paintComponent(g);
		
		setBackground(Color.DARK_GRAY);
		//set background color a gris	
		
		for(int i = 0 ; i < this.game.getMap().getLength() ; ++i)
		{
			for(int j = 0 ; j < this.game.getMap().getLength() ; ++j)
			{
				switch(this.game.getMap().getMap()[i][j])
				{
					case W :
						drawWalls(g, i, j);
					break;
					case G : 
						drawGums(g, i, j);
					break;
					default :
					break;
				}
			}
		}
		
		drawGhosts(g);
		drawPacman(g);
		
		jlabel.setText(String.valueOf(game.getPlayer().getScore()));
		
		// Print lives left
		for(int i = 0; i < game.getPlayer().getLives() ; ++i)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(1 * i * 2 * (SCALE / 5), 1 * (SCALE / 5), SCALE / 4, SCALE / 4);
		}
	}
	
	public void drawPacman(Graphics g)
	{
		switch(game.getPlayer().getState())
		{
			case 0 : // normal
				g.setColor(Color.YELLOW);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
			break;
			
			case 1 : // invisible
				g.setColor(Color.ORANGE);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
			break;
			
			case 2 : // superpacman
				g.setColor(customColor);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
			break;
		}
	}
	
	public void drawGhosts(Graphics g)
	{
		for(int i = 0 ; i < 4 ; ++i)
		switch(game.getGhosts()[i].getState())
			{
				case 0 :
					g.setColor(Color.RED);
					g.fillOval(game.getGhosts()[i].x * SCALE, game.getGhosts()[i].y * SCALE, SCALE, SCALE);
				break;
				
				case 1 :
					g.setColor(Color.BLUE);
					g.fillOval(game.getGhosts()[i].x * SCALE, game.getGhosts()[i].y * SCALE, SCALE, SCALE);
				break;
			}

		// couleur non impos�e apart bleu quand vulnerable
	}
	
	public void drawGums(Graphics g, int i, int j)
	{
		int minScale = SCALE - 20;
		if(i == game.getGums()[0].x && j == game.getGums()[0].y)
		{	
			System.out.println("blue");
			g.setColor(Color.BLUE);
			g.fillOval(i * SCALE, j * SCALE, minScale, minScale);
		}
		else
		if(i == game.getGums()[1].x && j == game.getGums()[1].y)
		{	
			g.setColor(Color.MAGENTA);
			g.fillOval(i * SCALE, j * SCALE, minScale, minScale);
		}
		else
		if(i == game.getGums()[2].x && j == game.getGums()[2].y)
		{	
			g.setColor(Color.ORANGE);
			g.fillOval(i * SCALE, j * SCALE, minScale, minScale);
		}
		else
		if(i == game.getGums()[3].x && j == game.getGums()[3].y)
		{	
			g.setColor(Color.GREEN);
			g.fillOval(i * SCALE, j * SCALE, minScale, minScale);
		}
	}
	
	public void drawWalls(Graphics g, int i, int j)
	{
		g.setColor(Color.BLACK);
		g.fillRect(i * SCALE, j * SCALE, SCALE, SCALE);
	}

	@Override
	public void update() 
	{
		repaint();
	}
}
