package pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyListener extends KeyAdapter 
{
	private Game g;
	
	public MyListener(Game g)
	{
		this.g = g;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
	    switch( keyCode ) 
	    { 
	        case KeyEvent.VK_UP:
	    		g.setDirection("UP");
	            break;
	        case KeyEvent.VK_DOWN:
	    		g.setDirection("DOWN");
	            break;
	        case KeyEvent.VK_LEFT:
	    		g.setDirection("LEFT");
	            break;
	        case KeyEvent.VK_RIGHT :
	    		g.setDirection("RIGHT");
	            break;
	     }
	}	
}