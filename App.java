import javax.swing.JFrame;

public class App 
{
	public static void main(String[] args) 
	{
		Game game = new Game();
		
		Graph graph = new Graph(game);

		game.getPlayer().addObserver(graph);
		
		/*
		Gui gui = new Gui(game);
		graph.setGui(gui);
		*/
		
		JFrame frame = new JFrame("Pacman");
		
		frame.add(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(50, 50);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.addKeyListener(new MyListener(game.getPlayer()));
		
		while(true)
		{
			game.move();
		}
	}
}
