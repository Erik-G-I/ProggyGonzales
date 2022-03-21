package entity;

import core.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Enemy extends Entity {

    GamePanel gp;
    int xStart;
    int yStart;
    int xTurn;
    int yTurn;
    int path;
    int x;

    public Enemy(GamePanel gp, int xStart, int yStart, int path) {
        this.gp = gp;
        this.xStart = xStart;
        this.yStart = yStart;
        this.path = path;

        setDefaultValues();
        getEnemyImage();
    }

    public void setDefaultValues() {
        speed = 3;
        direction = "down";
        xTurn = xStart + path;
        yTurn = yStart;
        x = xStart;
    }

    public void getEnemyImage() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        while (this.x < this.xTurn) {
            //this.direction = "right";
            this.x += this.speed;
        }
        while (this.x > this.xStart) {
            //this.direction = "left";
            this.x -= this.speed;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(left1, x, yStart, gp.tileSize, gp.tileSize, null);
    }
}
