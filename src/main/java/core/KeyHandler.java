package core;

import gameState.GameState;
import gameState.Languages;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.player.PlayerState;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed1, upPressed2, downPressed, leftPressed1, rightPressed1, leftPressed2, rightPressed2;
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
                	gp.stopMusic();
                	gp.playSoundEffect(0);
                    gp.gameState = GameState.LEVELS_MENU;
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
        		gp.playMusic(7);
        		if (gp.levels.cmd == 0) {
        			selectingMapPath("/maps/easy.txt");
        			mapNum = 1;
        			
        		}
        		if (gp.levels.cmd == 1) {
        			gp.stopMusic();
        			gp.playSoundEffect(0);
        			selectingMapPath("/maps/medium.txt");
        			mapNum = 2;
        			gp.playMusic(7);
        			
        		}
        		if (gp.levels.cmd == 2) {
        			selectingMapPath("/maps/hard.txt");
        			mapNum = 3;
        		}
        	}
        	code = KeyEvent.KEY_RELEASED;
        }

		if (gp.gameState == GameState.MULTIPLAYER_MENU) {
			if (code == KeyEvent.VK_DOWN) {
				gp.playSoundEffect(0);
				gp.multiMenu.cmd++;
				if (gp.multiMenu.cmd > 1) {
					gp.multiMenu.cmd = 0;
				}
			}
			if (code == KeyEvent.VK_UP) {
				gp.playSoundEffect(0);
				gp.multiMenu.cmd--;
				if (gp.multiMenu.cmd < 0) {
					gp.multiMenu.cmd = 1;
				}
			}
			if (code == KeyEvent.VK_ESCAPE)
				gp.gameState = GameState.LEVELS_MENU;

			if (code == KeyEvent.VK_ENTER) {
				if (gp.multiMenu.cmd == 0) {
					gp.multiGame = false;
					gp.gameState = GameState.RUNNING_GAME;
					System.out.println("he");
				}
				if (gp.multiMenu.cmd == 1) {
					gp.multiGame = true;
					gp.gameState = GameState.RUNNING_GAME;
				}
			}
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
            	gp.playMusic(7);
            	this.selectingMapPath(mapPath);
//            	gp.gameState = GameState.RUNNING_GAME;
            	gp.getGameOverObj().restart();
//            	gp.startTimer();
            }
            if (gp.getGameOverObj().cmd == 1 && code == KeyEvent.VK_ENTER) {
            	gp.stopMusic();
            	gp.playSoundEffect(0);
            	gp.playMusic(8);
                gp.gameState = GameState.START_MENU;
                gp.setGame();   
            }
        }

        if (gp.gameState == GameState.RUNNING_GAME) {
            // Up-arrow or space-button is pressed
            if (code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE) {
                upPressed1 = true;
            }
            if (e.getKeyChar() == 'w')
            	upPressed2 = true;

            // left-arrow is pressed
            if (code == KeyEvent.VK_LEFT) {
                leftPressed1 = true;
            }
            if (e.getKeyChar() == 'a')
            	leftPressed2 = true;


            // right-arrow is pressed
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed1 = true;
            }
            if (e.getKeyChar() == 'd')
            	rightPressed2 = true;


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
                for(int i: reader.list) {
                	gp.highscores.add(i);
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
        		gp.playMusic(8);
        	}
        	if (gp.wS2.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.setGame();
        		gp.gameState = GameState.LEVELS_MENU;
        		gp.playMusic(8);
        	}
        }
        
        if (gp.gameState == GameState.PAUSED_GAME) {
        	pS = gp.player1.playerState;
        	gp.stopTimer();
        	gp.player1.playerState = PlayerState.INVISIBLE;
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
        		gp.player1.playerState = pS;
        		gp.gameState = GameState.RUNNING_GAME;
        		gp.startTimer();
        	}
        	if(gp.pause.cmd == 1 && code == KeyEvent.VK_ENTER) {
        		this.selectingMapPath(this.mapPath);
        	}
        	if(gp.pause.cmd == 2 && code == KeyEvent.VK_ENTER) {
        		gp.stopMusic();
        		gp.playSoundEffect(0);
        		gp.playMusic(8);
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
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE) {
            upPressed1 = false;
        }
        if (e.getKeyChar() == 'w')
        	upPressed2 = false;
        
        // left arrow is released
        if (code == KeyEvent.VK_LEFT) {
            leftPressed1 = false;
        }
        if (e.getKeyChar() == 'a')
        	leftPressed2 = false;

        //right-arrow is released
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed1 = false;
        }
        if (e.getKeyChar() == 'd')
        	rightPressed2 = false;
         
        
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
		gp.gameState = GameState.MULTIPLAYER_MENU;
		gp.startTimer();
    }

}
