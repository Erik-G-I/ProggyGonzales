package core;

import gameState.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public float jumpSpeed;
    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (gp.gameState == GameState.START_MENU) {
            if (code == KeyEvent.VK_UP) {
                gp.menu.commandNum--;
                if (gp.menu.commandNum < 0)
                    gp.menu.commandNum = 2;
            }
            if (code == KeyEvent.VK_DOWN) {
                gp.menu.commandNum++;
                if (gp.menu.commandNum > 2)
                    gp.menu.commandNum = 0;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.menu.commandNum == 0)
                    gp.gameState = GameState.RUNNING_GAME;
                if (gp.menu.commandNum == 1)
                    // TODO:
                if (gp.menu.commandNum == 2) {
                    System.exit(0);
                }
            }
        }

        if (gp.gameState == GameState.RUNNING_GAME) {
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
