import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui 
{
	private static JFrame frame = new JFrame("Pacman");
	private static Game game;

	public JFrame getFrame() 
	{
		return frame;
	}
	
	public Gui(Game g, Graph graph)
	{	
		game = g;
		
		frame.add(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(50, 50);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.addKeyListener(new MyListener(game.getPlayer()));
	}

	public static void gameOver(String s, int i)
	{
		JOptionPane.showMessageDialog(frame, s + i);		
		System.exit(0);
	}
}