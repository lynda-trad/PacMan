package pacman;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

@SuppressWarnings("serial")
public class Circle extends JFrame
{
	public Circle()
    {
        setSize(240,240);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.drawOval(40,40,180,180);
        g.fillOval(40,40,180,180);
    }
 
    public static void main(String args[])
    {
        Circle t = new Circle();
        t.paint(null);
    }
}