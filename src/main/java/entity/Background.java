package entity;

import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.GamePanel;

public class Background extends Entity {

    private GamePanel gp;
    private KeyHandler keyH;
    
    private BufferedImage startE, startMH, bryggen, fjell, bus, marketsE, marketsMH, end;
    private int mapNum;

    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getImage();
  
    }

    public void setDefaultValues() {
    	worldX = 0;
    	worldY = 515;
        speed = 3;
        direction = "down";
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
        	end = ImageIO.read(getClass().getResourceAsStream("/background/endE.png"));

        	
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        mapNum = gp.getKeyH().getMapNum();
    	
        if (keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.leftPressed == true) {
                direction = "left";
                worldX += speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                worldX -= speed;
            }

        }
    }

    public void draw(Graphics2D g2) {
    		
    		int worldCol = 0;
    		int worldRow = 0;
    		
    		if(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
    			
    			int worldX = worldCol * gp.tileSize;
    			int worldY = worldRow * gp.tileSize;
    			int screenX = worldX - gp.player.worldX;
    			int screenY = worldY - gp.player.worldY;
    			
    			if (mapNum == 1) {
    				firstMap(g2,screenX,screenY);
    			}
    			
    			if (mapNum == 2 || mapNum == 3) {
    				secondAndThirdMaps(g2,screenX,screenY);
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
		g2.drawImage(bus, screenX+1200, screenY+1200, 200, 200, null);
		
    }
    

}
