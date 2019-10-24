package pacman;

import javax.swing.JFrame;

public class Gui 
{
	private JFrame frame   = new JFrame();
	private GameGraphics graph = new GameGraphics();
	private Game g;
	
	public JFrame getFrame() 
	{
		return frame;
	}
	
	public Gui()
	{	
		frame.setContentPane(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(100, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.addKeyListener(new MyListener(this.g));
	}
}