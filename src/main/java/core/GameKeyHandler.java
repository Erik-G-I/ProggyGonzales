package core;

import gameState.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
public class GameKeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public float jumpSpeed;
    private GamePanel gamePanel;
    String mapPath;
    MenuKeyHandler menu;

    public GameKeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        //this.menu = new MenuKeyHandler();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*
        if (menu.map == 1) {
            selectingMapPath("/maps/easy.txt");
        } else if (menu.map == 2) {
            selectingMapPath("/maps/medium.txt");
        } else {
            selectingMapPath("/maps/hard.txt");
        }

         */
/*
        int code = e.getKeyCode();
        if(gamePanel.getGameOver() == true || gamePanel.getOutOfBounds() == true) {
            gamePanel.gameState = GameState.GAME_OVER;
            if(code == KeyEvent.VK_LEFT) {
                gamePanel.playSoundEffect(0);
                gamePanel.getGameOverObj().cmd--;
                if(gamePanel.getGameOverObj().cmd<0) {
                    gamePanel.getGameOverObj().cmd = 1;
                }
            }
            if(code==KeyEvent.VK_RIGHT) {
                gamePanel.playSoundEffect(0);
                gamePanel.getGameOverObj().cmd++;
                if(gamePanel.getGameOverObj().cmd>1) {
                    gamePanel.getGameOverObj().cmd = 0;
                }
            }
            if (gamePanel.getGameOverObj().cmd == 0 && code == KeyEvent.VK_ENTER) {
                gamePanel.stopMusic();
                gamePanel.playSoundEffect(0);
                gamePanel.playMusic(7);
                //this.selectingMapPath(mapPath);
                gamePanel.resetLoader();
                gamePanel.gameState = GameState.RUNNING_GAME;
                gamePanel.getGameOverObj().restart();
            	gamePanel.startTimer();
            }
            if (gamePanel.getGameOverObj().cmd == 1 && code == KeyEvent.VK_ENTER) {
                gamePanel.stopMusic();
                gamePanel.playSoundEffect(0);
                gamePanel.playMusic(8);
                gamePanel.gameState = GameState.START_MENU;
                gamePanel.setGame();
            }
        }

        if (gamePanel.gameState == GameState.RUNNING_GAME) {
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
                System.out.println("høyre");
            }
            if ((gamePanel.getGameOver() == false || gamePanel.getOutOfBounds() == false) && code == KeyEvent.VK_ESCAPE) {
                gamePanel.gameState = GameState.PAUSED_GAME;
            }
        }

        if (gamePanel.gameState == GameState.WIN_SCREEN) {
            if (code == KeyEvent.VK_ENTER) {
                gamePanel.gameState = GameState.WIN_SCREEN2;
            }
            code = KeyEvent.KEY_RELEASED;
        }

        if (gamePanel.gameState == GameState.WIN_SCREEN2) {
            if (code == KeyEvent.VK_ESCAPE) {
                gamePanel.stopMusic();
                gamePanel.setGame();
                gamePanel.gameState = GameState.START_MENU;
                gamePanel.playMusic(8);
            }
        }

        if (gamePanel.gameState == GameState.PAUSED_GAME) {
            gamePanel.stopTimer();
            if (code == KeyEvent.VK_DOWN) {
                gamePanel.playSoundEffect(0);
                gamePanel.pause.cmd++;
                if (gamePanel.pause.cmd > 2){
                    gamePanel.pause.cmd = 0;
                }
            }
            if (code == KeyEvent.VK_UP) {
                gamePanel.playSoundEffect(0);
                gamePanel.pause.cmd--;
                if (gamePanel.pause.cmd < 0) {
                    gamePanel.pause.cmd =  2;
                }
            }
            if(gamePanel.pause.cmd == 0 && code == KeyEvent.VK_ENTER) {
                gamePanel.playSoundEffect(0);
                gamePanel.gameState = GameState.RUNNING_GAME;

                gamePanel.startTimer();
            }
            if(gamePanel.pause.cmd == 1 && code == KeyEvent.VK_ENTER) {
                //this.selectingMapPath(this.mapPath);
            }
            if(gamePanel.pause.cmd == 2 && code == KeyEvent.VK_ENTER) {
                gamePanel.stopMusic();
                gamePanel.playSoundEffect(0);
                gamePanel.playMusic(8);
                gamePanel.gameState = GameState.START_MENU;
                gamePanel.setGame();
            }
            code = KeyEvent.VK_ESCAPE;
        }
    }

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

 */

    /**
     * This method is to avoid writing duplicate code for all levels
     * @param mapPath
     */
   /* private void selectingMapPath(String mapPath) {
        this.mapPath = mapPath;
        gamePanel.playSoundEffect(0);
        gamePanel.setMap(mapPath);
        gamePanel.resetLoader();
        gamePanel.setGame();
        gamePanel.gameState = GameState.RUNNING_GAME;
        gamePanel.startTimer();
    }


}

    */

