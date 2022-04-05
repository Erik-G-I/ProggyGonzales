package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public float jumpSpeed;
    private GamePanel gp;
    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(gp.getGameOver()==true) {
        	if(code==KeyEvent.VK_LEFT) {
        		leftPressed = true;
        		gp.gOO().cmd--;
        		if(gp.gOO().cmd<1) {
        			gp.gOO().cmd = 1;
        		}
        	}
        	if(code==KeyEvent.VK_RIGHT) {
        		rightPressed = true;
        		gp.gOO().cmd++;
        		if(gp.gOO().cmd>2) {
        			gp.gOO().cmd = 2;
        		}
        	}
            if (gp.gOO().cmd==1 && code == KeyEvent.VK_ENTER) {
            	gp.gOO().restart();
            }
        }
        
        // Up-arrow or space-button is pressed
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE || e.getKeyChar() == 'w') {
          upPressed = true;
        }
        // left-arrow is pressed 
        if (code == KeyEvent.VK_LEFT || e.getKeyChar() == 'a') {
            leftPressed = true;
            
        }
        // right-arrow is pressed 
        if (code == KeyEvent.VK_RIGHT || e.getKeyChar() == 'd') {
            rightPressed = true;
        }
    }

    // releasing the buttons
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        // space-button or up-arrow is released 
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE || e.getKeyChar() == 'w') {
            upPressed = false;
        }
        
        // left arrow is released
        if (code == KeyEvent.VK_LEFT || e.getKeyChar() == 'a') {
            leftPressed = false;
            
        }
        //right-arrow is released
        if (code == KeyEvent.VK_RIGHT || e.getKeyChar() == 'd') {
            rightPressed = false;
        }
         
        
    }

}
