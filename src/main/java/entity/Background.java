
package entity;

import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.GamePanel;

public class Background extends Entity {
/**
    GamePanel gp;
    KeyHandler keyH;


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
            bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/City2_pale.png"));

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
    			int screenX = worldX - gp.player.worldX + gp.player.screenX;
    			int screenY = worldY - gp.player.worldY + gp.player.screenY;
    			
    			g2.drawImage(bakgrunn, screenX, screenY, 1100, 680, null);
    			
    			worldCol ++;
    			
    			if(worldCol == gp.maxWorldCol) {
    				worldCol = 0;
    				worldRow  ++;
    			}
    		}
    		
    	}*/
    

}
