package core;

import gameState.GameState;
import gameState.Languages;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.PlayerState;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public float jumpSpeed;
    private GamePanel gp;
    String mapPath;
    int mapNum;
    private PlayerState pS;
    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (gp.gameState == GameState.LANGUAGE_MENU) {
        	if (code == KeyEvent.VK_LEFT) {
        		gp.playSoundEffect(0);
        		gp.lS.cmd--;
        		if(gp.lS.cmd<0) {
        			gp.lS.cmd = 1;
        		}
        	}
        	if (code == KeyEvent.VK_RIGHT) {
        		gp.playSoundEffect(0);
        		gp.lS.cmd++;
        		if(gp.lS.cmd > 1) {
        			gp.lS.cmd = 0;
        		}
        	}
        	if(gp.lS.getDrawNow()) {
        	if (gp.lS.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		gp.setLang(Languages.ENGLISH);
        		code = KeyEvent.KEY_RELEASED;
        		gp.gameState = GameState.START_MENU;
        	}
        	if (gp.lS.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		gp.setLang(Languages.NORWEGIAN);
        		code = KeyEvent.KEY_RELEASED;
        		gp.gameState = GameState.START_MENU;
        	}
        	}
        }

        if (gp.gameState == GameState.START_MENU) {
            if (code == KeyEvent.VK_DOWN) {
                gp.playSoundEffect(0);
                gp.menu.cmd++;
                if (gp.menu.cmd > 3)
                    gp.menu.cmd = 0;
            }
            if (code == KeyEvent.VK_UP) {
            	gp.playSoundEffect(0);
                gp.menu.cmd--;
                if (gp.menu.cmd < 0)
                    gp.menu.cmd = 3;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.menu.cmd == 0) {
                	gp.playSoundEffect(0);
                    gp.gameState = GameState.LEVELS_MENU;
					gp.setPlayerName();
                }
                if (gp.menu.cmd == 1) {
                	gp.playSoundEffect(0);
                    gp.gameState = GameState.INFO_SCREEN;
                }
                
                if (gp.menu.cmd == 2) {
                	gp.playSoundEffect(0);
                	gp.gameState = GameState.GAME_CONTROLS;
                	
                }
                if (gp.menu.cmd == 3) {
                	gp.playSoundEffect(0);
                    System.exit(0);
                }
            }
            code = KeyEvent.KEY_RELEASED;
        }
        
        if (gp.gameState == GameState.LEVELS_MENU) {
        	if (code == KeyEvent.VK_DOWN) {
        		gp.playSoundEffect(0);
        		gp.levels.cmd++;
        		if (gp.levels.cmd > 2) {
        			gp.levels.cmd = 0;
        		}
        	}
        	if (code == KeyEvent.VK_UP) {
        		gp.playSoundEffect(0);
        		gp.levels.cmd--;
        		if (gp.levels.cmd < 0) {
        			gp.levels.cmd = 2;
        		}
        	}
        	if (code == KeyEvent.VK_ESCAPE) {
        		gp.gameState = GameState.START_MENU;
        	}
        	if (code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.playSoundEffect(0);
        		
        		if (gp.levels.cmd == 0) {
        			mapNum = 1;
        			selectingMapPath("/maps/easy.txt");
        			
        			
        		}
        		if (gp.levels.cmd == 1) {
        			mapNum = 2;
        			selectingMapPath("/maps/medium.txt");
        			
        			
        			
        		}
        		if (gp.levels.cmd == 2) {
        			mapNum = 3;
        			selectingMapPath("/maps/hard.txt");
        			
        		}
        		playMapMusic();
        	}
        	code = KeyEvent.KEY_RELEASED;
        }

        if (gp.gameState == GameState.INFO_SCREEN) {
            if (code == KeyEvent.VK_RIGHT) {
            	gp.playSoundEffect(0);
                gp.info.cmd++;
                if (gp.info.cmd > 2)
                    gp.info.cmd = 0;
            }

            if (code == KeyEvent.VK_LEFT) {
            	gp.playSoundEffect(0);
                gp.info.cmd--;
                if (gp.info.cmd < 0)
                    gp.info.cmd = 2;
            }
            if (code == KeyEvent.VK_ENTER) {
            	gp.playSoundEffect(0);
                if (gp.info.cmd == 1) {
                	if (gp.info.page == 1) {
						gp.info.cmd = 0;
						gp.gameState = GameState.START_MENU;
					} else
                		gp.info.page--;
                }

                if (gp.info.cmd == 2 && gp.info.page != 3) {
                	gp.info.page++;
                }

            }
        }
        
        if(gp.gameState == GameState.GAME_CONTROLS) {
        	gp.playSoundEffect(0);
        	if(code == KeyEvent.VK_ESCAPE) {
        		gp.gameState = GameState.START_MENU;
        	}
        }
        
        if(gp.getGameOver() == true || gp.getOutOfBounds() == true) {
        	gp.gameState = GameState.GAME_OVER;
        	if(code == KeyEvent.VK_LEFT) {
        		gp.playSoundEffect(0);
        		gp.getGameOverObj().cmd--;
        		if(gp.getGameOverObj().cmd<0) {
        			gp.getGameOverObj().cmd = 1;
        		}
        	}
        	if(code==KeyEvent.VK_RIGHT) {
        		gp.playSoundEffect(0);
        		gp.getGameOverObj().cmd++;
        		if(gp.getGameOverObj().cmd>1) {
        			gp.getGameOverObj().cmd = 0;
        		}
        	}
            if (gp.getGameOverObj().cmd == 0 && code == KeyEvent.VK_ENTER) {
            	gp.stopMusic();
            	gp.playSoundEffect(0);
            	playMapMusic();
            	this.selectingMapPath(mapPath);
//            	gp.gameState = GameState.RUNNING_GAME;
            	gp.getGameOverObj().restart();
//            	gp.startTimer();
            }
            if (gp.getGameOverObj().cmd == 1 && code == KeyEvent.VK_ENTER) {
            	gp.stopMusic();
            	gp.playSoundEffect(0);
            	gp.playMusic(10);
                gp.gameState = GameState.START_MENU;
                gp.setGame();   
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
            if ((gp.getGameOver() == false || gp.getOutOfBounds() == false) && code == KeyEvent.VK_ESCAPE) {
            	gp.gameState = GameState.PAUSED_GAME;
            }
        }
        
        if (gp.gameState == GameState.WIN_SCREEN) {
        	if (code == KeyEvent.VK_ENTER) {
        		String hsLevel = "highscore"+Integer.toString(mapNum)+".txt";
        		
        		//reads the highscore file to the corresponding level
        		ReadFromFile reader = new ReadFromFile();
                reader.readHighscore(hsLevel,5);
                gp.highscores.clear();
                for(int i = 0; i<5; i++) {
                	gp.highscores.addEntry(reader.table.getName(i), reader.table.getScore(i));
                }
                
        		System.out.println(gp.highscores.toString());
        		Highscore hs = new Highscore(gp);
        		
        		//updates the highscore for the current level
        		hs.updateHighscore(hsLevel);
        		System.out.println(gp.highscores.toString());
        		gp.gameState = GameState.WIN_SCREEN2;
        	}
        	code = KeyEvent.KEY_RELEASED;
        }
        
        if (gp.gameState == GameState.WIN_SCREEN2) {
        	
        	if (code == KeyEvent.VK_LEFT) {
        		gp.playSoundEffect(0);
        		gp.wS2.cmd--;
        		if(gp.wS2.cmd<0) {
        			gp.wS2.cmd = 1;
        		}
        	}
        	if (code == KeyEvent.VK_RIGHT) {
        		gp.playSoundEffect(0);
        		gp.wS2.cmd++;
        		if(gp.wS2.cmd > 1) {
        			gp.wS2.cmd = 0;
        		}
        	}
        	if (gp.wS2.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.setGame();
        		gp.gameState = GameState.START_MENU;
        		gp.playMusic(10);
        	}
        	if (gp.wS2.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.setGame();
        		gp.gameState = GameState.LEVELS_MENU;
        		gp.playMusic(8);
        	}
        }
        
        if (gp.gameState == GameState.PAUSED_GAME) {
        	pS = gp.getPlayerState();
        	gp.stopTimer();
        	gp.setPlayerState(PlayerState.INVISIBLE);
        	if (code == KeyEvent.VK_DOWN) {
        		gp.playSoundEffect(0);
        		gp.pause.cmd++;
        		if (gp.pause.cmd > 2){
        			gp.pause.cmd = 0;
        		}
        	}
        	if (code == KeyEvent.VK_UP) {
        		gp.playSoundEffect(0);
        		gp.pause.cmd--;
        		if (gp.pause.cmd < 0) {
        			gp.pause.cmd =  2;
        		}
        	}
        	if(gp.pause.cmd == 0 && code == KeyEvent.VK_ENTER) {
        		gp.playSoundEffect(0);
        		gp.setPlayerState(pS);
        		gp.gameState = GameState.RUNNING_GAME;
        		gp.startTimer();
        	}
        	if(gp.pause.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		this.selectingMapPath(this.mapPath);
        	}
        	if(gp.pause.cmd == 2 && code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.playSoundEffect(0);
        		gp.playMusic(10);
        		gp.gameState = GameState.START_MENU;
        		gp.setGame();
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
    
    
    private void playMapMusic() {
    	if(mapNum == 1) {
    		gp.playMusic(7);
    	}
    	if(mapNum == 2) {
    		gp.playMusic(8);
    	}
    	if(mapNum == 3) {
    		gp.playMusic(9);
    	}
    }
    
    /**
     * This method is to avoid writing duplicate code for all levels
     * @param mapPath
     */
    private void selectingMapPath(String mapPath) {
    	this.mapPath = mapPath;
		gp.playSoundEffect(0);
		gp.setMap(mapPath);
		gp.resetLoader();
		gp.setGame();
		gp.gameState = GameState.RUNNING_GAME;
		gp.startTimer();
    }

}
