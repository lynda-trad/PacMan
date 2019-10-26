package pacman;

import javax.swing.JFrame;

public class App 
{
	public static void main(String[] args) 
	{
		// cree un Jframe
		Game game = new Game();
		
		Graph graph = new Graph(game);

		game.getPlayer().addObserver(graph);
		
		/*
		Gui gui = new Gui(game);
		graph.setGui(gui);
		*/
		
		JFrame frame = new JFrame();

		frame.add(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(100, 100);
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
