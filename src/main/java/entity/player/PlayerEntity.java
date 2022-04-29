package entity.player;

import core.CollisionCheck;
import core.GamePanel;
import entity.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class PlayerEntity extends Entity {

    public PlayerState playerState;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, jumpImg;
    public String previousDirection;

    public int jumpStrength;
    protected int gravity;

    public CollisionCheck collisionChecker;

    //brukes til å skape animasjon på spiller og fiender
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public PlayerEntity(GamePanel gp) {
        super(gp);
    }

    public void setDefaultValues() {
        worldY = 512;
        speed = 5;
        direction = "right";
        previousDirection = direction;
        weight = 3;
        jumpStrength = 0;
        gravity = weight;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public abstract void draw(Graphics2D g2);

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

    protected void jump() {
        //jump is initialized and depending on the previous direction we need different image sprites
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
                // How fast the jump is upwards
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
                // setting jumpStrengt to 0 if you hit your head, so you dont keep going up
                jumpStrength = 0;

                // how fast Proggy falls after hitting the maximum height
                gravity = weight;
                fall();
            }
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



