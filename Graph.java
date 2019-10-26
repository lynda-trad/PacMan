package pacman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel implements Observer
{
	private Game game;
	
	private static final int width  = 50 * 10 + 14;
	private static final int height = 50 * 10 + 37;
	private static final int SCALE  = 50;
	
	public Graph(Game g) 
	{
		this.game = g;
		this.setSize(width, height);
	}
	
	@Override
	public void paintComponent(Graphics g) //appelée par repaint 
	{
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		//set background color a gris	

		for(int i = 0 ; i < this.game.getMap().getMap().length ; ++i)
		{
			for(int j = 0 ; j < this.game.getMap().getMap().length ; ++j)
			{
				switch(this.game.getMap().getMap()[i][j])
				{
					case WALL :
						drawWalls(g, i, j);
					break;
					case GUM : 
						drawGums(g, i, j);
					break;
					default :
					break;
				}
			}
		}
		
		drawGhosts(g);
		drawPacman(g);
		
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
				g.setColor(Color.YELLOW);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
				//jaune pale a chercher
			break;
			
			case 2 : // superpacman
				g.setColor(Color.ORANGE);
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

		// couleur non imposée apart bleu quand vulnerable
	}
	
	public void drawGums(Graphics g, int i, int j)
	{
		if(i == game.getGums()[0].x && j == game.getGums()[0].y)
		{	g.setColor(Color.BLUE);
			g.fillOval(i * SCALE, j * SCALE, SCALE, SCALE);
		}
		else
		if(i == game.getGums()[1].x && j == game.getGums()[1].y)
		{	g.setColor(Color.BLACK); //mettre purple
			g.fillOval(i * SCALE, j * SCALE, SCALE, SCALE);
		}
		else
		if(i == game.getGums()[2].x && j == game.getGums()[2].y)
		{	g.setColor(Color.ORANGE);
			g.fillOval(i * SCALE, j * SCALE, SCALE, SCALE);
		}
		else
		if(i == game.getGums()[3].x && j == game.getGums()[3].y)
		{	g.setColor(Color.GREEN);
			g.fillOval(i * SCALE, j * SCALE, SCALE, SCALE);
		}
	}
	
	public void drawWalls(Graphics g, int i, int j)
	{
		g.setColor(Color.BLACK);
		g.fillRect(i * SCALE, j * SCALE, SCALE, SCALE);
	}
	
	public void gameOver(int i)
	{
		if(i == 0)
			JOptionPane.showMessageDialog(this, "Game Over ! You lost !");
		else
			JOptionPane.showMessageDialog(this, "Game Over ! You won !");
		System.exit(0);
	}

	@Override
	public void update() 
	{
		repaint();
	}
}
