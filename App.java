package pacman;

import javax.swing.JFrame;

public class App 
{

	public static void main(String[] args) 
	{
		// cree un Jframe
		Game game = new Game();
		Graph graph = new Graph(game);
		
		JFrame frame = new JFrame();
		frame.add(graph);
		
		frame.setSize(graph.getSize());
		frame.setLocation(100, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		game.getPlayer().addObserver(graph);
		frame.addKeyListener(new MyListener(game.getPlayer()));
		
		while(true)
		{
			game.move();
		}
//		
////Test Pacman, différents états 
//		System.out.println("//////PACMAN///// --> OK!/");
//		Pacman p = new Pacman();
//		System.out.println(p.getElement()); // element = 0
//		System.out.println(p);
//		
//		p.beInvisible();
//		
//		System.out.println(p);
//		
//		p.beSuperPacman();
//		
//		System.out.println(p);
//		
//		p.beNormal();
//		
//		System.out.println(p);
//
////Test Ghosts, différents états 
//		System.out.println("//////GHOSTS////// --> OK!");
//		
//		Ghosts g= new Ghosts();
//		
//		System.out.println(g.getElement()); // element = 1
//		System.out.println(g);
//		
//		g.beVulnerable();
//		
//		System.out.println(g);
//
////Test Gum, différents états 
//		System.out.println("//////GUM////// --> OK!");
//		
//		Blue   b  = new Blue();
//		Violet v  = new Violet();
//		Orange o  = new Orange();
//		Green  gr = new Green();
//		
//		System.out.println(b);
//		System.out.println(v);
//		System.out.println(o);
//		System.out.println(gr);
//		
//		System.out.println(gr.getElement()); // element = 2
//		System.out.println(b.getElement()); // element = 2
//		System.out.println(b.getCompteur()); // Meme compteur pour tous les gum
//		System.out.println(v.getCompteur());// Meme compteur pour tous les gum = 4
//		
////		o.decrementeCompteur();
//		
//		System.out.println(gr.getCompteur());
//		System.out.println(b.getEaten()); // false par défaut
//		
////		b.isEaten(); // devient true
//		
//		System.out.println(b.getEaten()); //true
//		System.out.println(b); // eaten
//
////Test Pacman, Ghosts et Gum, les fonctions et méthodes
//		System.out.println("//////Fonctions et Methodes////// --> OK!");
//		
//		p.setScore(6000); 
//		p.newLife();// Vérification pour gagner une vie et initialiser le score
//		
//		System.out.println(p);
//		
//		p.loseLife();// Vérification pour perdre une vie 
//		
//		System.out.println(p);
//		
////		p.setLives(0);
////		p.loseLife();
////		System.out.println(p); // Verification si plus de vies
//		
////Manger la Gum Blue b
//		System.out.println("//////Manger Gum Blue////// --> OK!");
//		
//		p.eatGum(b); // b de type Blue donc ajouter score et décrémenter compteur
//		
//		System.out.println(b);
//		System.out.println(b.getType()); // Blue = 0
//		System.out.println(b.getCompteur());
//		System.out.println(p);
//
//		
////Manger la Gum Violet v
//		System.out.println("//////Manger Gum Violet////// --> OK!");
//		
//		p.eatGum(v); // v de type Violet donc ajouter score + décrémenter compteur + effet p invisible
//		
//		System.out.println(v);
//		System.out.println(v.getType()); // Violet = 1
//		System.out.println(v.getCompteur());
//		System.out.println(p);
//
//				
////Manger la Gum Orange o
//		System.out.println("//////Manger Gum Orange////// --> Pb effet! (Les 4 Fantomes Vulnérables)");
//		
//		p.eatGum(o); // o de type Orange donc ajouter score + décrémenter compteur + effet p superPacman et g vulnerable
//		
//		System.out.println(o);
//		System.out.println(o.getType()); // Orange = 2
//		System.out.println(o.getCompteur());
//		System.out.println(p);
//		
////Manger la Gum Green gr 
//		System.out.println("//////Manger Gum Green////// --> Pb effet! (Nouvelle Structure Labyrinthe)");
//		
//		p.eatGum(gr); // gr de type Green donc ajouter score + décrémenter compteur + effet nouvelle structure labyrinthe
//		
//		System.out.println(gr);
//		System.out.println(gr.getType()); // Green = 3
//		System.out.println(gr.getCompteur());
//		System.out.println(p);
//	}

	}
	}
