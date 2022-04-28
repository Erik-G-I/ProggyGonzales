package entity;

import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.GamePanel;
import entity.player.PlayerEntity;

public class Background {

    GamePanel gp;
    KeyHandler keyH;
    BufferedImage realfag, bakgrunn;
    int x, y;
    int speed;
    String direction;

    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getImage();
    }

    public void setDefaultValues() {
    	x = 0;
    	y = 515;
        speed = 3;
        direction = "down";
    }

    public void getImage() {

        try {
        	realfag = ImageIO.read(getClass().getResourceAsStream("/graphics/realfagbygget åpen.png"));
//            bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bryggen1.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSprite() {
        if (keyH.leftPressed1 == true || keyH.rightPressed1 == true) {

            if (keyH.leftPressed1 == true) {
                direction = "left";
                x += speed;
            } else if (keyH.rightPressed1 == true) {
                direction = "right";
                x -= speed;
            }

        }
    }

    public void draw(Graphics2D g2) {
    		
    		int worldCol = 0;
    		int worldRow = 0;
    		
    		if(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
    			
    			int worldX = worldCol * gp.tileSize;
    			int worldY = worldRow * gp.tileSize;
    			int screenX = worldX - gp.player1.worldX + gp.player1.playerX + 63;
    			int screenY = worldY - gp.player1.worldY + gp.player1.playerY;
    			
    			g2.drawImage(realfag, screenX, screenY, 600, 800, null);
    			screenX += 750;

    			while(worldCol < gp.maxWorldRow) {
        			screenX += 1050;
        			worldCol ++;
        			
    			}
    		}
    	}
}
