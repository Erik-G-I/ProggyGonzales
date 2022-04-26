package core;

import gameState.GameState;
import gameState.Languages;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    private MenuPanel panel;
    public int map = 1;
    String mapPath;
    
    public MenuKeyHandler(MenuPanel panel) {
    	this.panel = panel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (panel.gameState == GameState.LANGUAGE_MENU) {
        	if (code == KeyEvent.VK_LEFT) {
        		panel.playSoundEffect(0);
        		panel.lS.cmd--;
        		if(panel.lS.cmd<0) {
        			panel.lS.cmd = 1;
        		}
        	}
        	if (code == KeyEvent.VK_RIGHT) {
        		panel.playSoundEffect(0);
        		panel.lS.cmd++;
        		if(panel.lS.cmd > 1) {
        			panel.lS.cmd = 0;
        		}
        	}
        	if(panel.lS.getDrawNow()) {
        	if (panel.lS.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		panel.setLang(Languages.ENGLISH);
        		code = KeyEvent.KEY_RELEASED;
        		panel.gameState = GameState.START_MENU;
				System.out.println("h");
        	}
        	if (panel.lS.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		panel.setLang(Languages.NORWEGIAN);
        		code = KeyEvent.KEY_RELEASED;
        		panel.gameState = GameState.START_MENU;
        	}
        	}
        }

        if (panel.gameState == GameState.START_MENU) {
            if (code == KeyEvent.VK_DOWN) {
                panel.playSoundEffect(0);
                panel.menu.cmd++;
                if (panel.menu.cmd > 3)
                    panel.menu.cmd = 0;
            }
            if (code == KeyEvent.VK_UP) {
            	panel.playSoundEffect(0);
                panel.menu.cmd--;
                if (panel.menu.cmd < 0)
                    panel.menu.cmd = 3;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (panel.menu.cmd == 0) {
                	//panel.stopMusic();
                	panel.playSoundEffect(0);
                    panel.gameState = GameState.LEVELS_MENU;
					//panel.gameState = GameState.RUNNING_GAME;
                }
                if (panel.menu.cmd == 1) {
                	panel.playSoundEffect(0);
                    panel.gameState = GameState.INFO_SCREEN;
                }
                
                if (panel.menu.cmd == 2) {
                	panel.playSoundEffect(0);
                	panel.gameState = GameState.GAME_CONTROLS;
                	
                }
                if (panel.menu.cmd == 3) {
                	panel.playSoundEffect(0);
                    System.exit(0);
                }
            }
            code = KeyEvent.KEY_RELEASED;
        }

        if (panel.gameState == GameState.LEVELS_MENU) {
        	if (code == KeyEvent.VK_DOWN) {
        		panel.playSoundEffect(0);
        		panel.levels.cmd++;
        		if (panel.levels.cmd > 2) {
        			panel.levels.cmd = 0;
        		}
        	}
        	if (code == KeyEvent.VK_UP) {
        		panel.playSoundEffect(0);
        		panel.levels.cmd--;
        		if (panel.levels.cmd < 0) {
        			panel.levels.cmd = 2;
        		}
        	}
        	if (code == KeyEvent.VK_ESCAPE) {
        		panel.gameState = GameState.START_MENU;
        	}
        	if (code == KeyEvent.VK_ENTER) {
        		panel.playMusic(7);
        		if (panel.levels.cmd == 0) {
        			//selectingMapPath("/maps/easy.txt");
					map = 1;
					panel.gameState = GameState.RUNNING_GAME;
        		}
        		if (panel.levels.cmd == 1) {
        			panel.stopMusic();
        			panel.playSoundEffect(0);
        			//selectingMapPath("/maps/medium.txt");
        			panel.playMusic(7);
        			map = 2;
        		}
        		if (panel.levels.cmd == 2) {
        			//selectingMapPath("/maps/hard.txt");
					map = 3;
        		}
        	}
        	code = KeyEvent.KEY_RELEASED;
        }

        if (panel.gameState == GameState.INFO_SCREEN) {
            if (code == KeyEvent.VK_RIGHT) {
            	panel.playSoundEffect(0);
                panel.info.cmd++;
                if (panel.info.cmd > 2)
                    panel.info.cmd = 0;
            }

            if (code == KeyEvent.VK_LEFT) {
            	panel.playSoundEffect(0);
                panel.info.cmd--;
                if (panel.info.cmd < 0)
                    panel.info.cmd = 2;
            }
            if (code == KeyEvent.VK_ENTER) {
            	panel.playSoundEffect(0);
                if (panel.info.cmd == 1) {
                	if (panel.info.page == 1) {
						panel.info.cmd = 0;
						panel.gameState = GameState.START_MENU;
					} else
                		panel.info.page--;
                }

                if (panel.info.cmd == 2 && panel.info.page != 3) {
                	panel.info.page++;
                }

            }
        }
        
        if(panel.gameState == GameState.GAME_CONTROLS) {
        	panel.playSoundEffect(0);
        	if(code == KeyEvent.VK_ESCAPE) {
        		panel.gameState = GameState.START_MENU;
        	}
        }

        if(panel.gamePanel.getGameOver() == true || panel.gamePanel.getOutOfBounds() == true) {
        	panel.gameState = GameState.GAME_OVER;
        	if(code == KeyEvent.VK_LEFT) {
        		panel.playSoundEffect(0);
        		panel.gamePanel.getGameOverObj().cmd--;
        		if(panel.gamePanel.getGameOverObj().cmd<0) {
        			panel.gamePanel.getGameOverObj().cmd = 1;
        		}
        	}
        	if(code==KeyEvent.VK_RIGHT) {
        		panel.playSoundEffect(0);
        		panel.gamePanel.getGameOverObj().cmd++;
        		if(panel.gamePanel.getGameOverObj().cmd>1) {
        			panel.gamePanel.getGameOverObj().cmd = 0;
        		}
        	}
            if (panel.gamePanel.getGameOverObj().cmd == 0 && code == KeyEvent.VK_ENTER) {
            	panel.stopMusic();
            	panel.playSoundEffect(0);
            	panel.playMusic(7);
            	panel.selectingMapPath(mapPath);
//            	gp.gameState = GameState.RUNNING_GAME;
            	panel.gamePanel.getGameOverObj().restart();
//            	gp.startTimer();
            }
            if (panel.gamePanel.getGameOverObj().cmd == 1 && code == KeyEvent.VK_ENTER) {
            	panel.stopMusic();
            	panel.playSoundEffect(0);
            	panel.playMusic(8);
                panel.gameState = GameState.START_MENU;
                panel.gamePanel.setGame();
            }
        }

        if (panel.gameState == GameState.RUNNING_GAME) {
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
            if ((panel.gamePanel.getGameOver() == false || panel.gamePanel.getOutOfBounds() == false) && code == KeyEvent.VK_ESCAPE) {
            	panel.gameState = GameState.PAUSED_GAME;
            }
        }
        
        if (panel.gameState == GameState.WIN_SCREEN) {
        	if (code == KeyEvent.VK_ENTER) {
        		panel.gameState = GameState.WIN_SCREEN2;
        	}
        	code = KeyEvent.KEY_RELEASED;
        }
        
        if (panel.gameState == GameState.WIN_SCREEN2) {
        	if (code == KeyEvent.VK_ESCAPE) {
        		panel.stopMusic();
        		panel.gamePanel.setGame();
        		panel.gameState = GameState.START_MENU;
        		panel.playMusic(8);
        	}
        }
        
        if (panel.gameState == GameState.PAUSED_GAME) {
        	panel.gamePanel.stopTimer();
        	if (code == KeyEvent.VK_DOWN) {
        		panel.playSoundEffect(0);
        		panel.gamePanel.pause.cmd++;
        		if (panel.gamePanel.pause.cmd > 2){
        			panel.gamePanel.pause.cmd = 0;
        		}
        	}
        	if (code == KeyEvent.VK_UP) {
        		panel.playSoundEffect(0);
        		panel.gamePanel.pause.cmd--;
        		if (panel.gamePanel.pause.cmd < 0) {
        			panel.gamePanel.pause.cmd =  2;
        		}
        	}
        	if(panel.gamePanel.pause.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		panel.playSoundEffect(0);
        		panel.gameState = GameState.RUNNING_GAME;
        		
        		panel.gamePanel.startTimer();
        	}
        	if(panel.gamePanel.pause.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		panel.selectingMapPath(this.mapPath);
        	}
        	if(panel.gamePanel.pause.cmd == 2 && code == KeyEvent.VK_ENTER) {
        		panel.stopMusic();
        		panel.playSoundEffect(0);
        		panel.playMusic(8);
        		panel.gameState = GameState.START_MENU;
        		panel.gamePanel.setGame();
        	}
        	code = KeyEvent.VK_ESCAPE;
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

    /**
     * This method is to avoid writing duplicate code for all levels
     * @param mapPath
     */
    /*private void selectingMapPath(String mapPath) {
    	this.mapPath = mapPath;
		panel.playSoundEffect(0);
		panel.setMap(mapPath);
		panel.resetLoader();
		panel.setGame();
		panel.gameState = GameState.RUNNING_GAME;
		panel.startTimer();
    }

     */

}
