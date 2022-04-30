package entity.player;

import core.CollisionCheck;
import core.GamePanel;
import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for player 2
 */
public class Player2 extends PlayerEntity {

    public KeyHandler keyH;

    public Player2(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        this.collisionChecker = new CollisionCheck(this);

        playerState = PlayerState.NORMAL;
        worldX = 100;
        setDefaultValues();
        getImage();
        this.playerNum = 2;
    }

    @Override
    public void update() {
        if (keyH.leftPressed2 || keyH.rightPressed2 || keyH.upPressed2) {
            if (keyH.rightPressed2) {
                previousDirection = direction;
                direction = "right";
            }
            else if (keyH.leftPressed2) {
                previousDirection = direction;
                direction = "left";
            }
            if (keyH.upPressed2) {
                previousDirection = direction;
                direction = "up";
            }

            // Is the tile Proggy is located in solid? default setting is false
            colliding = false;

            // updates to be true if Proggy collides with a solid tile
            collisionChecker.checkCollisionOnTile();

            PowerUp();

            if (colliding == false) {
                switch(direction) {
                    case "up":
                        jumpP2();
                        moveWhileJumping();
                        break;
                    case "down":
                        fall();
                        break;
                    case "right":
                        worldX += speed;
                        //jump();//jump instead of fall seems to give better results currently
                        fall();
                        break;
                    case "left":
                        worldX -= speed;
                        //jump();
                        fall();
                        break;
                }
            }
            updateSprite();
        }
    }

    /**
     * Jump method for player 2
     */
    public void jumpP2() {
        if(keyH.upPressed2 || (jumpStrength <= 0 && !onGround)) {
            super.jump();
        }
    }

    /**
     * Method to make it possible for player 2 to move left or right while in the air
     */

    private void moveWhileJumping () {
        String originalDir = previousDirection;
        int moveInAir = 0;
        if(keyH.leftPressed2 || keyH.rightPressed2) {

            if(keyH.leftPressed2) {
                originalDir = direction;
                direction = "left";
                moveInAir = -speed;
            }
            if(keyH.rightPressed2) {
                originalDir = direction;
                direction = "right";
                moveInAir = speed;
            }
            collisionChecker.checkCollisionOnTile();
            if(!colliding) {
                worldX += moveInAir;
            }
        }
        direction = originalDir;
    }

    @Override
    public void getImage() {
        if (playerState == PlayerState.NORMAL) {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_up1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_up2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_default1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_default2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_left2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_right2.png"));

            }catch(IOException e) {
                e.printStackTrace();
            }

        } else if (playerState == PlayerState.INVISIBLE)  {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_up1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_up2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_default1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_default2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_left2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_mask_right2.png"));

            }catch(IOException e) {
                e.printStackTrace();
            }

        } else if (playerState == PlayerState.FASTER)  {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_up1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_up2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_default1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_default2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_left2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_gold_right2.png"));

            }catch(IOException e) {
                e.printStackTrace();
            }

        } else if (playerState == PlayerState.VOI)  {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_right.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_left.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_right.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_left.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_left.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_right.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy2_voi_right.png"));

            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player1.worldX + gp.player1.playerX;
        int screenY = worldY - gp.player1.worldY + gp.player1.playerY;
        BufferedImage image = choseSprite();
        g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
    }
}
