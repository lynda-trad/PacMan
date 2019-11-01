
import javax.swing.JFrame;

public class Gui 
{
	private JFrame frame = new JFrame();
	private Graph graph;
	private Game game;
	
	public JFrame getFrame() 
	{
		return frame;
	}
	
	public Gui(Game g)
	{	
		game = g;
		
		frame.add(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(100, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.addKeyListener(new MyListener(game.getPlayer()));
	}
}