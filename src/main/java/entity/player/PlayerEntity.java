package entity.player;

import core.CollisionCheck;
import core.GamePanel;
import entity.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract super class for the two players
 * Inherits from Entity
 */
public abstract class PlayerEntity extends Entity {

    public PlayerState playerState;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, jumpImg;
    public String previousDirection;

    public int jumpStrength;
    protected int gravity;

    public CollisionCheck collisionChecker;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public PlayerEntity(GamePanel gp) {
        super(gp);
    }

    /**
     * Set the default values for the players
     */
    public void setDefaultValues() {
        worldY = 512;
        speed = 5;
        direction = "right";
        previousDirection = direction;
        weight = 3;
        jumpStrength = 0;
        gravity = weight;
    }

    /**
     * Set gravity
     * @param gravity the gravity to be set
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * Method that updates sprite number to make it look like player is walking
     */
    protected void updateSprite() {
        // Updates picture that is used for player
        spriteCounter++;
        if(spriteCounter>15) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }
            else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    /**
     * Method to make player jump
     * Jumping image is based in what direction player previously had
     * If player hits his head, he will fall
     */
    protected void jump() {
        if(previousDirection == "right") {
            jumpImg = up1;
        }
        if(previousDirection == "left"){
            jumpImg = up2;
        }

        collisionChecker.checkCollisionOnTile();
        if(colliding == false) {
            if(onGround == true) {
                gp.playSoundEffect(3);
                jumpStrength = 15;
                worldY -= jumpStrength;
                jumpStrength +=12;
                onGround = false;

            }
            else if(onGround == false && jumpStrength > 0) {
                worldY -= jumpStrength;
                jumpStrength -= 1;
            }

            collisionChecker.checkCollisionOnTile();
            if(jumpStrength <=0 || colliding == true) {

                jumpStrength = 0;

                // how fast Proggy falls after hitting the maximum height
                gravity = weight;
                fall();
            }
        }
    }

    /**
     * Method to set the speed on player for the different power-ups
     */
    protected void PowerUp() {
        if (playerState == PlayerState.VOI) {
            speed=7;
        }
        if (playerState == PlayerState.FASTER) {
            speed=7;
        }
        if(playerState == PlayerState.NORMAL) {
            speed = 5;
        }
        if(playerState == PlayerState.INVISIBLE) {
            speed = 5;
        }
    }

    @Override
    public void fall() {
        String originalDir = direction;
        direction = "down";
        collisionChecker.checkCollisionOnTile();
        if(colliding == false || onGround == false) {
            onGround = false;
            direction = originalDir;
            worldY += gravity;

            if(gravity < 18) {
                gravity += 1;
            }
        }
        else {
            onGround = true;
            worldY = ((worldY + speed)/gp.tileSize) *gp.tileSize;
            direction = originalDir;
            gravity = weight;
        }
    }

    /**
     * Method that chooses which image is to be drawn based on sprite number
     * @return the image to be drawn
     */
    protected BufferedImage choseSprite() {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                image = jumpImg;
                break;
            case "down":
                if(previousDirection == "right") {
                    if(spriteNum == 1) {
                        image = down1;
                    }
                    if(spriteNum == 2) {
                        image = down1;
                    }
                }
                else {
                    if(spriteNum == 1) {
                        image = down2;
                    }
                    if(spriteNum == 2) {
                        image = down2;
                    }
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        return image;
    }


}



