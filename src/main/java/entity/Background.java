
package entity;
 

import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.GamePanel;

/**
 * Class for the moving background
 */
public class Background{

    private final GamePanel gp;
    private final KeyHandler keyH;
    
    private BufferedImage startE, startMH, bryggen, fjell, bus, marketsE, marketsMH, worm, dirt, end;
    private int mapNum;
	int worldX = 0;
	int worldY = 515;
    final int speed = 3;
    String direction = "down";

    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        getImage();
  
    }

    public void getImage() {

        try {
        	startE = ImageIO.read(getClass().getResourceAsStream("/background/startE.png"));
        	startMH = ImageIO.read(getClass().getResourceAsStream("/background/startMH.png"));
        	bryggen = ImageIO.read(getClass().getResourceAsStream("/background/bryggen.png"));
        	fjell = ImageIO.read(getClass().getResourceAsStream("/background/fjell.png"));
        	bus = ImageIO.read(getClass().getResourceAsStream("/background/bus.png"));
        	marketsE = ImageIO.read(getClass().getResourceAsStream("/background/marketsE.png"));
        	marketsMH = ImageIO.read(getClass().getResourceAsStream("/background/marketsMH.png"));
        	worm = ImageIO.read(getClass().getResourceAsStream("/background/under2.png"));
        	dirt = ImageIO.read(getClass().getResourceAsStream("/background/underDirt.png"));
        	end = ImageIO.read(getClass().getResourceAsStream("/background/endE.png"));

        	
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates where the screen is drawn based on player 1
     */
    public void update() {
        mapNum = gp.getKeyH().getMapNum();
    	
        if (keyH.leftPressed1 || keyH.rightPressed1) {

            if (keyH.leftPressed1) {
                direction = "left";
                worldX += speed;
            } else if (keyH.rightPressed1) {
                direction = "right";
                worldX -= speed;
            }

        }
    }

    /**
     * Method to draw the screen
     * @param g2 graphics
     */
    public void draw(Graphics2D g2) {
    		
    		int worldCol = 0;
    		int worldRow = 0;
    		
    		if(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
    			
    			int worldX = worldCol * gp.tileSize;
    			int worldY = worldRow * gp.tileSize;
    			int screenX = worldX - gp.player1.worldX;
    			int screenY = worldY - gp.player1.worldY;
    			
    			if (mapNum == 1) {
    				firstMap(g2,screenX,screenY);
    			}
    			
    			if (mapNum == 2 || mapNum == 3) {
    				secondAndThirdMaps(g2,screenX,screenY);
    				if (mapNum == 2) {
    					secondMap(g2, screenX, screenY);
    				}
    			}
    		}
    		
    	}
    
    public void firstMap(Graphics2D g2, int screenX, int screenY) {
    	g2.drawImage(startE, screenX, screenY-790, 2000, 2200, null);	
    	g2.drawImage(marketsE, screenX+2000, screenY-790, 2000, 2200, null);
    	g2.drawImage(end, screenX+4000, screenY-790, 2000, 2200, null);
    }
    
    public void secondAndThirdMaps(Graphics2D g2, int screenX, int screenY) {
    	g2.drawImage(startMH, screenX, screenY-790, 2000, 2200, null);
		g2.drawImage(bryggen, screenX+2000, screenY-790, 2000, 2200, null);
		g2.drawImage(fjell, screenX+4000, screenY-790, 2000, 2200, null);
		g2.drawImage(marketsMH, screenX+6000, screenY-790, 2000, 2200, null);
		g2.drawImage(end, screenX+8000, screenY-790, 2000, 2200, null);
		g2.drawImage(bus, screenX+1200, screenY+1140, 200, 200, null);
    }
    
    public void secondMap(Graphics2D g2, int screenX, int screenY) {
    	g2.drawImage(dirt, screenX+3610, screenY+1300, 800, 500, null);
    	g2.drawImage(worm, screenX+3640, screenY+1250, 640, 500, null);
    }
    
}
