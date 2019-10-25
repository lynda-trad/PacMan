package pacman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel implements Observer
{
	private Game game;
	//private Gui gui; 							// gui a besoin de jpanel pas linverse
	private int width, height 	   = 200; 		// 200 car tableau 10
	private static final int SCALE = 20;
	
	public Graph(Game g) 
	{
		this.game = g;
	}
	
	@Override
	public void paintComponent(Graphics g) //appelée par repaint 
	{
		super.paintComponent(g);
		width = getSize().width ;
		height= getSize().height;
		
		g.setColor(Color.BLACK);
		//set backgruo d color a gris
		
		g.drawLine(width / 3, 0, width / 3, height);
		g.drawLine(width * 2 / 3, 0, width * 2 / 3, height);
		
		g.drawLine(0, height / 3, width, height / 3);
		g.drawLine(0, height * 2 / 3, width, height * 2 / 3);	

		//////////
		
		for(int i = 0 ; i < this.game.getMap().getMap().length ; ++i)
		{
			for(int j = 0 ; j < this.game.getMap().getMap().length ; ++j)
			{
				switch(this.game.getMap().getMap()[i][j])
				{
					case WALL :
						drawWalls(g, i, j );
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
		//pour chaque ghost il va drawGhost();
		
		
		/*
		 * On va parcourir le tableau delement map et affiche un truc different selon
		 * lenum -> on utilisera pas des objets pour ca 
		 * si vide on remplit carré de 20 sur 20 en gris
		 * si mur on remplit carré de 20 sur 20 en noir
		 * si pacman on remplit carré de 20 sur 20 par un rond jaune etc 
		 * a chaque tour on verifie letat du pacman et des fantomes pour changer leur couleur 
		 * on fait un sleep pour prendre le temps de tout réafficher 
		 * 
		 * On parcourt la map et on affiche tout (murs, vide, pacgum) 
		 * puis on affiche par dessus pacman et fantomes en cherchant leur coordonnées dans Game
		 * */
		
	}
	
	public void drawPacman(Graphics g)
	{
		// dessiner pacman 
		
		//fillOval 
		//couleur selon le state
		//afficher a position  [x * scale][ y * scale}
		
		//Switch etat 
		switch(game.getPlayer().getState())
		{
			case 0 :
				g.setColor(Color.YELLOW);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
			break;
			
			case 1 :
				g.setColor(Color.YELLOW);
				g.fillOval(game.getPlayer().x * SCALE, game.getPlayer().y * SCALE, SCALE, SCALE);
				//jaune pale a chercher
			break;
			
			case 2 :
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
		{	g.setColor(Color.PINK); 						//purple
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
