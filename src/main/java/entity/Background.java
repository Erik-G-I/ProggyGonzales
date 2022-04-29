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
public class Background {

    GamePanel gp;
    KeyHandler keyH;
    BufferedImage realfag;
    int x, y;
    int speed;
    String direction;

    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getImage();
    }

    /**
     * Set the default values for coordinates, speed and direction for the background
     */
    public void setDefaultValues() {
        x = 0;
        y = 515;
        speed = 3;
        direction = "down";
    }

    public void getImage() {
        try {
            realfag = ImageIO.read(getClass().getResourceAsStream("/graphics/realfagbygget åpen.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates where the screen is drawn based on player 1
     */
    public void update() {
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