package pacman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameGraphics extends JPanel
{
	private Game g;
	private	Gui gui;
	private int width, height;
	
	public GameGraphics() 
	{
		
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		width = getSize().width ;
		height= getSize().height;
		
		g.setColor(Color.BLACK);
		
		g.drawLine(width / 3, 0, width / 3, height);
		g.drawLine(width * 2 / 3, 0, width * 2 / 3, height);
		
		g.drawLine(0, height / 3, width, height / 3);
		g.drawLine(0, height * 2 / 3, width, height * 2 / 3);	

		//////////
		
	}
	
	public void gameOver(int i)
	{
		if(i == 0)
			JOptionPane.showMessageDialog(gui.getFrame(), "Game Over ! You lost !");
		else
			JOptionPane.showMessageDialog(gui.getFrame(), "Game Over ! You won !");
		System.exit(0);
	}
}
