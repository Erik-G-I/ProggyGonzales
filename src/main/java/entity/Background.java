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


    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getImage();

    }

    public void setDefaultValues() {
        x = 0;
        y = 0;
        speed = 3;
        direction = "down";
    }

    public void getImage() {

        try {
            bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bakgrunn.jpg"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.leftPressed == true) {
                direction = "left";
                x+= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x-= speed;
            }

        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bakgrunn, x, y, 1000, 700, null);
    }

}
