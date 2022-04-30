package entity;

import core.GamePanel;

import java.awt.*;

/**
 * Abstract super class for moving characters
 */
public abstract class Entity {

    public final GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public String direction;

    /* specifying where on the character it will collide with tiles.
    We set this to the whole character since it only scrolls vertically */
    public final Rectangle solid;

    public boolean colliding = false;
    public boolean onGround = true;
    public int weight;

    public Entity(GamePanel gp) {
        this.gp = gp;
        solid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);
    }

    /**
     * Method to make the character fall when its not standing on anything
     */
    public abstract void fall();

    /**
     * Method to draw the character based on direction
     * @param g2 graphics
     */
    public abstract void draw(Graphics2D g2);

    /**
     * Updates the character based on collision and direction.
     * Updates sprite
     */
    public abstract void update();

    /**
     * Get each image for the character
     */
    public abstract void getImage();
}

