import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui 
{
	private static JFrame frame = new JFrame("Pacman");
	private static Graph graph;
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

	public static void gameOver(int i)
	{
		if(i == 0)
			JOptionPane.showMessageDialog(frame, "Too bad, you lost ! Your score : " + game.getPlayer().getScore());
		else
			JOptionPane.showMessageDialog(frame, "Great job, you won ! Your score : " + game.getPlayer().getScore());
		
		System.exit(0);
	}
}