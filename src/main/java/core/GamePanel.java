package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings
    final int originalTileSize = 32; // 32x32 tiles
    final int scale = 2;
    
    public final int tileSize = originalTileSize * scale; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;     // 1024px
    final int screenHeight = tileSize * maxScreenRow;    // 768px
    
    // FPS
    int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    
    
    
    public GamePanel() {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        
        gameThread = new Thread(this);
        gameThread.start();
    }
     

//    @Override
//    public void run() {
//        
//        while(gameThread != null) {
//            
//            double drawInterval = 1000000000/FPS; // draws the screen every 0.01666 seconds
//            double nextDrawTime = System.nanoTime() + drawInterval;
//            
//            // 1: update information, such as the characters position
//            update();
//            
//            // 2: draw the screen with the updated information
//            repaint();
//            
//            
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000; // convert nanotime to milliseconds for Thread.sleep
//                
//                if(remainingTime <0) {
//                    remainingTime = 0;
//                }
//                
//                Thread.sleep((long) remainingTime);
//                
//                nextDrawTime += drawInterval;
//                
//                
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        
//    }
    
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
                // 1: update information, such as the characters position
                update();
                // 2: draw the screen with the updated information
                repaint();
                
                jump();
                repaint();

                delta--;
                drawCount++;
            }
            
            //display FPS in console
            if(timer >= 1000000000) {
                System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
            
        }
    }
    
    
    public void update() {
        player.update();
    }
    
    public void jump() {
    	player.jump();
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        player.draw(g2);
        
        g2.dispose();
    }
    
}

