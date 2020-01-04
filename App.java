public class App 
{
	public static void main(String[] args) 
	{
		Game game = new Game();
		
		Graph graph = new Graph(game);

		game.getPlayer().addObserver(graph);
		
		Gui gui = new Gui(game, graph);
		
		while(true)
		{
			game.move();
		}
	}
}