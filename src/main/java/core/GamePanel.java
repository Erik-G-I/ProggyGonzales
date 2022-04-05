package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.InputStream;

import javax.swing.JPanel;

import entity.Background;
import entity.Player;
import entity.Score;
import gameOver.GameOver;
import tile.TileLoader;
import timer.TimerDisplay;

public class GamePanel extends JPanel implements Runnable{
	
    /**
	 * 
	 */
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
    public final int maxWorldRow = 12;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //Map
    public InputStream is;

    // FPS
    int FPS = 60;

    //CollisionCheck 
    public CollisionCheck collisionChecker = new CollisionCheck(this);

    KeyHandler keyH = new KeyHandler(this);
    public Player player;
    public Background bg;
    public TileLoader loader;
    
    //Game Thread
    private Thread gameThread;
    
    //Timer
    TimerDisplay timerDisplay = new TimerDisplay(this);
    public TimerDisplay getTimerDisplay() {
    	return timerDisplay;
    }
    
    //Score
    private Score score;
    
    //Game Over if there is no time left
    private GameOver gO;
    //get GameOver object
    public GameOver gOO() {
    	return gO;
    }
    public boolean getGameOver() {
    	boolean gameO = this.timerDisplay.getTime().getGameOver();
    	return gameO;
    }
    
    public void setGame() {
    	is = getClass().getResourceAsStream("/maps/testmap.txt");
    	bg = new Background(this, keyH);
    	player = new Player(this, keyH);
    	loader =  new TileLoader(this, is);
    	timerDisplay = new TimerDisplay(this);
    	timerDisplay.startTime();
    	score =  new Score(this);
    	gO = new GameOver(this);
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      //  this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        setGame();
    }

    public void startGameThread() {  
        gameThread = new Thread(this);
        gameThread.start();
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
        timerDisplay.update();
        if(!gO.gameOver()) {
            score.showScore();
            player.update();
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
        timerDisplay.draw(g2);
        score.draw(g2);
        gO.draw(g2);
        g2.dispose();
    }
    
}
