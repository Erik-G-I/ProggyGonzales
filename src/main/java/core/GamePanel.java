package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.enemies.EnemySetter;
import entity.enemies.EntityEnemy;
import entity.Background;
import entity.player.Player1;
import entity.player.Player2;
import entity.player.PlayerState;
import entity.Score;
import gameState.*;
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
    public final int maxWorldRow = 20;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    public int coins;

    //Map
    public InputStream is;
    
    //Highscore list
    public Table highscores;

    // FPS
    int FPS = 60;

    //CollisionCheck 
    public CollisionCheck collisionChecker1;
    public CollisionCheck collisionChecker2;

    KeyHandler keyH = new KeyHandler(this);
    public Player1 player1;
    public Player2 player2;
    public EntityEnemy unicef[];
    public Background bg;
    public TileLoader loader;
    public EnemySetter eSetter = new EnemySetter(this);

    //Player Name
    String playerName;

    //audio
    private Sound music = new Sound();
    private Sound soundEffect = new Sound();
    
    //Game Thread
    private Thread gameThread;
    
    //Timer
    private TimerDisplay timerDisplay = new TimerDisplay(this);
    public TimerDisplay getTimerDisplay() {
    	return timerDisplay;
    }
    
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

    //Multiplayer menu
    public MultiplayerMenu multiMenu;

    public boolean multiGame;
    
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
        boolean out1 = collisionChecker1.isOutOfBounds();
        boolean out2 = collisionChecker2.isOutOfBounds();
        return out1||out2;
    }
    
    private Languages lang;
    public Languages getLang() {
    	return lang;
    }
    
    public void setLang(Languages lang) {
    	this.lang = lang;
    }
    
    public LanguageScreen lS;
    public WinScreen2 wS2;
    private WinScreen wS;
    
    public void setGame() {
    	
    	bg = new Background(this, keyH);
    	
    	//setter player state til normal før nytt player objekt blir laget
    	player1 = new Player1(this, keyH);
        player2 = new Player2(this, keyH);
    	
    	//get the language chosen by player
    	lang = getLang();
    	unicef = new EntityEnemy[50];
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
        multiMenu = new MultiplayerMenu(this);
        collisionChecker1 = player1.collisionChecker;
        collisionChecker2 = player2.collisionChecker;
        eSetter.setUnicef();
        multiGame = false;
        coins = 0;
    }

    public GamePanel(String mapPath) {
    	this.mapPath = mapPath;
    	//setter mappet som skal spilles
    	setMap(mapPath);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        //this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        highscores = new Table();
        gameState = GameState.LANGUAGE_MENU;
    	//loader mappet fra en tekstfil
    	loader =  new TileLoader(this, is);
        setGame();
    }
    
    
    // Will trigger a countdown of 10 seconds that makes the powerUp disappear when it ends
    public boolean p1pickedUpPowerUp() {
    	if (collisionChecker1.getPickedUpPowerUp()) {
    		return true;
    	}
    	return false;
    }
    public boolean p2pickedUpPowerUp() {
        if (collisionChecker2.getPickedUpPowerUp()) {
            return true;
        }
        return false;
    }


    public void setPickedUpPowerUp(int playerNum, boolean pickedUpPowerUp) {
        if (playerNum == 1)
            this.collisionChecker1.setPickedUpPowerUp(pickedUpPowerUp);
        else
            this.collisionChecker2.setPickedUpPowerUp(pickedUpPowerUp);
    }
    // Gets coins from CollisionChecker and is in this class so that it can be used in Time.java
    public int getCoinsInCollisionChecker(int playerNum) {
        if (playerNum == 1)
            return this.collisionChecker1.getCoins();
        else
            return this.collisionChecker2.getCoins();
    }
    // Calls on the method from CollisionChecker that reduces coins by 1 and is in this class so that it can be used in Time.java
    public void reduceCoinByOne(int playerNum) {
        if (playerNum == 1)
            this.collisionChecker1.reduceCoins();
        else
            this.collisionChecker2.reduceCoins();
    }

    /**
     * Sets player name in Player and can be recieved from GamePanel
     */
    public void setPlayerName() {
        String name = null;
        while (!isValidName(name)) {
            name = JOptionPane.showInputDialog("Type in your name");
            this.playerName = name;
        }
    }
    public String getPlayerName() {
        return this.playerName;
    }

    public static boolean isValidName(String name) {
		return name != null && !name.isBlank() && !name.contains(",");
	}

    public void startGameThread() {  
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Making it possible to read playerState
    public PlayerState getPlayerState1() {
        return this.player1.playerState;

    }

    public PlayerState getPlayerState2() {
        return this.player2.playerState;

    }
    // Making it possible to modify playerState
    public void setPlayerState1(PlayerState playerState) {
    	this.player1.playerState = playerState;
    }

    // Making it possible to modify playerState
    public void setPlayerState2(PlayerState playerState) {
        this.player2.playerState = playerState;
    }
    
    public void setMap(String mapPath) {
    	this.mapPath = mapPath;
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
        
        while(gameThread != null) {
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1) {
                // 1: oppdaterer informasjon, som spillerens posisjon
                update();
                // 2: tegner skjermen på nytt med oppdatert informasjon
                fall();
                jump();
                repaint();
                

                delta--;
            }
            
            //display FPS in console
            if(timer >= 1000000000) {
                timer = 0;
            }
            
        }
    }
    
    
    
	public void update() {
        bg.update();
        gO.update();
        lS.update();

        if(!gO.gameOver()) {
            score.showScore();
            if(!(gameState == GameState.GAME_OVER || gameState == GameState.WIN_SCREEN)) {
                player1.update();
                if (gameState == GameState.RUNNING_GAME && multiGame) {
                    player2.update();
                }
            }
        }
        if(!gO.gameOverBounds()) {
        	timerDisplay.update();
        }
        
        for(int i = 0; i < unicef.length; i++) {
        	if(unicef[i] != null) {
        		unicef[i].update();
        	}
        }
    }
    
    public void jump() {
        player1.jumpP1();
        player2.jumpP2();
    }
    public void fall() {
    	player1.fall();
        player2.fall();
    	for(int i = 0; i < unicef.length; i++) {
        	if(unicef[i] != null) {
        		unicef[i].fall(); 
        	}
        }

    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        bg.draw(g2);
        
        loader.draw(g2, player1.worldX);
        player1.draw(g2);
        if (getPlayerState1() == PlayerState.NORMAL) {
			this.player1.getImage();
        }
        if (getPlayerState2() == PlayerState.NORMAL) {
            this.player2.getImage();
        }
        if (multiGame)
            player2.draw(g2);
        
        for(int i = 0; i < unicef.length; i++) {
        	if(unicef[i] != null) {
        		unicef[i].draw(g2); 
        	}
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
        else if (gameState == GameState.MULTIPLAYER_MENU) {
            multiMenu.draw(g2);
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
