package pacman;

public class Game 
{
	private Map map;
	
	private Pacman player;

	private Ghosts[] ghosts = new Ghosts[4];
	
	private Gum[] gums = new Gum[4];
	
	/*
	 * Gum feront partie de map donc plus besoin de les stocker 
	 * 
	//Gum
	private Blue 	 blue;
	private Violet 	 violet;
	private Green 	 green;
	private Orange   orange;
	
	 Initialisation du jeu : 
	 - cree 1 joueur, score 0, emplacement random ?, vies = 3, pas de pouvoir
	 - cree 4 fantomes, au centre, peuvent tuer au depart car pas de pouvoir, pas de ia, ils bougent de facon random
	 - cree 4 gums -> etat mis a 0 ( = existante), on les place de facon random petit a petit au fil du jeu
	 - cree une grille de jeu, place joueur en dessous du centre, fantomes dans le centre et gum je sais pas encore je crois
	 que cest au fur et a mesure
	 */
	
	public Game()
	{
		map = new Map();
		initializeGhosts();
		initializePlayer();
		initializeGum();
	}
	
	public void initializeGum()
	{
		gums[0] = new Blue  (0,1,2); // blue
		gums[1] = new Violet(1,1,9); // violet
		gums[2] = new Orange(2,7,5); // orange 
		gums[3] = new Green (3,4,2); // vert
	}

	public void initializePlayer()
	{
		player = new Pacman(this);
		player.x = 3;
		player.y = 3;
	}
	
	public void initializeGhosts()
	{
		ghosts[0] = new Ghosts(this, 1, 1);
		ghosts[1] = new Ghosts(this, 0, 9);
		ghosts[2] = new Ghosts(this, 9, 1);
		ghosts[3] = new Ghosts(this, 9, 9); 
	}
	
	public Map getMap() 
	{
		return map;
	}

	public void setMap(Map map) 
	{
		this.map = map;
	}
	
	public void step()
	{
		//pacman.move();
		//pour chaque fantome on move
			
	}

	public Pacman getPlayer() 
	{
		return player;
	}

	public void setPlayer(Pacman player) 
	{
		this.player = player;
	}

	public Ghosts[] getGhosts() {
		return ghosts;
	}

	public void setGhosts(Ghosts[] ghosts) {
		this.ghosts = ghosts;
	}

	public Gum[] getGums() {
		return gums;
	}

	public void setGums(Gum[] gums) {
		this.gums = gums;
	}
	
	
	public void move() 
	{
		player.cross();
		for(int i = 0 ; i < ghosts.length; ++i)
		{
			ghosts[i].move();
		}
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}