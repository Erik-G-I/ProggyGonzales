package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;

import javax.swing.JPanel;

import entity.Background;
import entity.Player;
import entity.PlayerState;
import entity.Score;
import gameState.GameControls;
import gameState.GameOver;
import gameState.GameState;
import gameState.InfoScreen;
import gameState.LanguageScreen;
import gameState.Languages;
import gameState.LevelsMenu;
import gameState.Paused;
import gameState.StartMenu;
import gameState.WinScreen;
import gameState.WinScreen2;
import sound.Sound;
import tile.TileLoader;
import timer.TimerDisplay;

public class GamePanel extends JPanel implements Runnable{
	
    private String mapPath;
	private static final long serialVersionUID = 1L;
	// Screen settings
    final int originalTileSize = 32; // 32x32 tiles
    final int scale = 2;
    
    public final int tileSize = originalTileSize * scale; // 64
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;     // ...px
    public final int screenHeight = tileSize * maxScreenRow;    // ...px
    
    //World settings
    public final int maxWorldCol = 16;
    public final int maxWorldRow = 16;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    private PlayerState playerState = PlayerState.NORMAL;
    public boolean pickedUpPowerUp;

    //Map
    public InputStream is;

    // FPS
    int FPS = 60;

    //CollisionCheck 
    public CollisionCheck collisionChecker;

    KeyHandler keyH = new KeyHandler(this);
    public Player player;
    public Background bg;
    public TileLoader loader;
    
    //audio
    private Sound music = new Sound();
    private Sound soundEffect = new Sound();
    
    //Game Thread
    private Thread gameThread;
    
    //Timer
    private TimerDisplay timerDisplay = new TimerDisplay(this);
    
    public void startTimer() {
        timerDisplay.startTime();
    }
    
    public void stopTimer() {
    	timerDisplay.stopTime();
    }
    
    public void truePowerUpTimer() {
    	timerDisplay.startPowerUpTimerTrue();
    }
   
    //Score
    private Score score;

    //Game State
    public GameState gameState;

    //Start menu
    public StartMenu menu;

    //Info screen
    public InfoScreen info;
    
    //Pause menu
    public Paused pause;
    
    //Levels menu
    public LevelsMenu levels;
    
    //Show controls
    public GameControls ctrls;
    
    //Game Over if there is no time left
    private GameOver gO;
    //get GameOver object
    public GameOver getGameOverObj() {
    	return gO;
    }
    public boolean getGameOver() {
    	boolean gameO = this.timerDisplay.getTime().getGameOver();
    	return gameO;
    }
    public boolean getOutOfBounds() {
    	boolean out = collisionChecker.isOutOfBounds();
    	return out;
    }
    
    private Languages lang;
    public Languages getLang() {
    	return lang;
    }
    
    public void setLang(Languages lang) {
    	this.lang = lang;
    }
    
    public LanguageScreen lS;
    private WinScreen2 wS2;
    private WinScreen wS;
    
    public void setGame() {
    	
    	bg = new Background(this, keyH);
    	
    	//setter player state til normal før nytt player objekt blir laget
        playerState = PlayerState.NORMAL;
    	player = new Player(this, keyH);
    	
    	//get the language chosen by player
    	lang = getLang();
    	
    	timerDisplay = new TimerDisplay(this);
    	score =  new Score(this);
    	gO = new GameOver(this);
    	menu = new StartMenu(this);
    	info = new InfoScreen(this);
    	pause = new Paused(this);
    	lS = new LanguageScreen(this);
    	ctrls = new GameControls(this);
    	levels = new LevelsMenu(this);
    	wS = new WinScreen(this);
    	wS2 = new WinScreen2(this);
        collisionChecker = new CollisionCheck(this);
        
    }

    public GamePanel(String mapPath) {
    	this.mapPath = mapPath;
    	//setter mappet som skal spilles
    	setMap(mapPath);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      //  this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        gameState = GameState.LANGUAGE_MENU;
    	//loader mappet fra en tekstfil
    	loader =  new TileLoader(this, is);
        setGame();
    }
    
    
    
    public boolean pickedUpPowerUp() {
    	if (collisionChecker.getPickedUpPowerUp() == true) {
    		return true;
    	}
    	return false;
    }
    
    public void setPickedUpPowerUp(boolean pickedUpPowerUp) {
    	this.collisionChecker.setPickedUpPowerUp(pickedUpPowerUp);
    }

    public void startGameThread() {  
        gameThread = new Thread(this);
        gameThread.start();
    }

    public PlayerState getPlayerState() {
        return this.playerState;

    }
    
    public void setPlayerState(PlayerState playerState) {
    	this.playerState = playerState;
    }
    
    public void setMap(String mapPath) {
    	is = getClass().getResourceAsStream(mapPath);
    }
    
    public String getMapPath() {
    	return mapPath;
    }
    
	public void resetLoader() {
    	loader =  new TileLoader(this, is);
	}
    
    
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null) {
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1) {
                // 1: oppdaterer informasjon, som spillerens posisjon
                update();
                // 2: tegner skjermen på nytt med oppdatert informasjon
                repaint();
                fall();
                repaint();
                jump();
                repaint();
                

                delta--;
                drawCount++;
            }
            
            //display FPS in console
            if(timer >= 1000000000) {
//                System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
            
        }
    }
    
    
    
	public void update() {
        bg.update();
        gO.update();
        lS.update();
        if(this.keyH.enterPressed) {
        menu.update();
        }
        if(!gO.gameOver()) {
            score.showScore();
            if(!(gameState == GameState.GAME_OVER || gameState == GameState.WIN_SCREEN)) {
            player.update();
            }
        }
        if(!gO.gameOverBounds()) {
        	timerDisplay.update();
        }
        
    }
    
    public void jump() {
    	player.jump();
    }
    public void fall() {
    	player.fall();
    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        bg.draw(g2);
        
        loader.draw(g2, player.worldX);
        player.draw(g2);
        if (playerState == PlayerState.NORMAL) {
			this.player.getPlayerImage();
        }
        
        if (gameState == GameState.START_MENU)
            menu.draw(g);
        else if (gameState == GameState.INFO_SCREEN) {
            info.draw(g2);
        }
        else if(gameState == GameState.PAUSED_GAME) {
        	pause.draw(g2);
        }
        else if(gameState == GameState.GAME_CONTROLS) {
        	ctrls.draw(g2);
        }
        else if(gameState == GameState.LANGUAGE_MENU) {
        	lS.draw(g2);
        }
        else if (gameState == GameState.LEVELS_MENU) {
        	levels.draw(g2);
        }
        else if (gameState == GameState.WIN_SCREEN) {
        	wS.draw(g2);
        }
        else if (gameState == GameState.WIN_SCREEN2) {
        	wS2.draw(g2);
        }
        else {
            timerDisplay.draw(g2);
            score.draw(g2);
            gO.draw(g2);
            
        }
        g2.dispose();
    }
    
    
    public void playMusic(int i) {
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    public void stopMusic() {
    	music.stop();
    }
    public void playSoundEffect(int i) {
    	soundEffect.setFile(i);
    	soundEffect.play();
    }
}
