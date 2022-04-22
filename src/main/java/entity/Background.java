package entity;

import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.GamePanel;

public class Background extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    BufferedImage realfag, bakgrunn;

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
        	realfag = ImageIO.read(getClass().getResourceAsStream("/graphics/realfagbygget åpen.png"));
            bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bryggen1.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
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
    			int screenX = worldX - gp.players.get(0).worldX + gp.players.get(0).playerX + 63;
    			int screenY = worldY - gp.players.get(0).worldY + gp.players.get(0).playerY;
    			
    			g2.drawImage(realfag, screenX, screenY, 600, 800, null);
    			screenX += 750;

    			while(worldCol < gp.maxWorldRow) {
    				g2.drawImage(bakgrunn, screenX, screenY, 1000, 880, null);
        			screenX += 1050;
        			worldCol ++;
        			
    			}
    			
    			
    			
    		}
    		
    	}
    

}
