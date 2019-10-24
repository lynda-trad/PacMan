package pacman;

public class Game 
{
	private Elements[][] map;
	
	private Pacman 	 player;
	private Ghosts[] ghosts;
	private Blue 	 blue;
	private Violet 	 violet;
	private Green 	 green;
	private Orange   orange;
	
	/*
	 Initialisation du jeu : 
	 - cree 1 joueur, score 0, emplacement random ?, vies = 3, pas de pouvoir
	 - cree 4 fantomes, au centre, peuvent tuer au depart car pas de pouvoir, pas de ia, ils bougent de facon random
	 - cree 4 gums -> etat mis a 0 ( = existante), on les place de facon random petit a petit au fil du jeu
	 - cree une grille de jeu, place joueur en dessous du centre, fantomes dans le centre et gum je sais pas encore je crois
	 que cest au fur et a mesure
	 */
	
	public void initializeGame()
	{
		
		
	}

	public Elements[][] getMap() 
	{
		return map;
	}

	public void setMap(Elements[][] map) 
	{
		this.map = map;
	}

}