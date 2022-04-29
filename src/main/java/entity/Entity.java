package entity;

import core.GamePanel;

import java.awt.*;

public abstract class Entity {

    public GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public String direction;

    /* specifying where on the character it will collide with tiles.
    We set this to the whole character since it only scrolls vertically */
    public Rectangle solid;

    public boolean colliding = false;
    public boolean onGround = true;
    public int weight;

    public Entity(GamePanel gp) {
        this.gp = gp;
        solid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);
    }

    public abstract void fall();

    public abstract void draw(Graphics2D g2);

    public abstract void update();

    public abstract void getImage();
}
