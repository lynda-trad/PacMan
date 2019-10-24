package pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyListener extends KeyAdapter 
{
	private Pacman p;
	
	public MyListener(Pacman p)
	{
		this.p = p;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
	    switch( keyCode ) 
	    { 
	        case KeyEvent.VK_UP:
	    		p.setDirection("UP");
	            break;
	        case KeyEvent.VK_DOWN:
	    		p.setDirection("DOWN");
	            break;
	        case KeyEvent.VK_LEFT:
	    		p.setDirection("LEFT");
	            break;
	        case KeyEvent.VK_RIGHT :
	    		p.setDirection("RIGHT");
	            break;
	     }
	}	
}