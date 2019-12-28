
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
	        	p.setPrevious(p.getDirection());
	    		p.setDirection(Direction.Up);
	        break;
	            
	        case KeyEvent.VK_DOWN:
	        	p.setPrevious(p.getDirection());
	    		p.setDirection(Direction.Down);
	        break;
	        
	        case KeyEvent.VK_LEFT:
	        	p.setPrevious(p.getDirection());
	    		p.setDirection(Direction.Left);
	        break;
	        
	        case KeyEvent.VK_RIGHT :
	        	p.setPrevious(p.getDirection());
	    		p.setDirection(Direction.Right);
	        break;
	     }
	    p.notifyObserver();
	}	
}