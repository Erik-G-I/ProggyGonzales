package core;

import gameState.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
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

        if (gp.gameState == GameState.START_MENU) {
            if (code == KeyEvent.VK_DOWN) {
                gp.menu.cmd++;
                if (gp.menu.cmd > 3)
                    gp.menu.cmd = 0;
            }
            if (code == KeyEvent.VK_UP) {
                gp.menu.cmd--;
                if (gp.menu.cmd < 0)
                    gp.menu.cmd = 3;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.menu.cmd == 0) {
                    gp.gameState = GameState.RUNNING_GAME;
                    gp.startTimer();
                }
                if (gp.menu.cmd == 1) {
                    gp.gameState = GameState.INFO_SCREEN;
                }
                
                if (gp.menu.cmd == 2) {
                	gp.gameState = GameState.GAME_CONTROLS;
                }
                if (gp.menu.cmd == 3) {
                    System.exit(0);
                }
            }
        }

        if (gp.gameState == GameState.INFO_SCREEN) {
            if (code == KeyEvent.VK_RIGHT) {
                gp.info.cmd++;
                if (gp.info.cmd > 2)
                    gp.info.cmd = 0;
            }

            if (code == KeyEvent.VK_LEFT) {
                gp.info.cmd--;
                if (gp.info.cmd < 0)
                    gp.info.cmd = 2;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.info.cmd == 1) {
                    gp.gameState = GameState.START_MENU;
                    gp.info.cmd = 0;
                }

                if (gp.info.cmd == 2) {

                }
            }
        }
        
        if(gp.gameState == GameState.GAME_CONTROLS) {
        	if(code == KeyEvent.VK_ESCAPE) {
        		gp.gameState = GameState.START_MENU;
        	}
        }
        
        if(gp.getGameOver() == true || gp.getOutOfBounds() == true) {
        	if(code == KeyEvent.VK_LEFT) {
        		leftPressed = true;
        		gp.getGameOverObj().cmd--;
        		if(gp.getGameOverObj().cmd<1) {
        			gp.getGameOverObj().cmd = 1;
        		}
        	}
        	if(code==KeyEvent.VK_RIGHT) {
        		rightPressed = true;
        		gp.getGameOverObj().cmd++;
        		if(gp.getGameOverObj().cmd>2) {
        			gp.getGameOverObj().cmd = 2;
        		}
        	}
            if (gp.getGameOverObj().cmd == 1 && code == KeyEvent.VK_ENTER) {
            	gp.getGameOverObj().restart();
            	gp.startTimer();
            }
            if (gp.getGameOverObj().cmd == 2 && code == KeyEvent.VK_ENTER) {
                gp.setGame();
                gp.gameState = GameState.START_MENU;
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
            if((gp.getGameOver() == false || gp.getOutOfBounds() == false) && code == KeyEvent.VK_ESCAPE) {
            	gp.gameState = GameState.PAUSED_GAME;
            }
        }
        
        if (gp.gameState == GameState.PAUSED_GAME) {
        	gp.stopTimer();
        	if (code == KeyEvent.VK_DOWN) {
        		gp.pause.cmd++;
        		if (gp.pause.cmd > 3){
        			gp.pause.cmd = 3;
        		}
        	}
        	if (code == KeyEvent.VK_UP) {
        		gp.pause.cmd--;
        		if (gp.pause.cmd < 1) {
        			gp.pause.cmd =  1;
        		}
        	}
        	if(gp.pause.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		gp.gameState = GameState.RUNNING_GAME;
        		gp.startTimer();
        	}
        	if(gp.pause.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		gp.gameState = GameState.RUNNING_GAME;
        		gp.setGame();
        		gp.startTimer();
        	}
        	if(gp.pause.cmd == 2 && code == KeyEvent.VK_ENTER) {
        		gp.gameState = GameState.START_MENU;
        		gp.setGame();
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
