package entity;

import core.GamePanel;
import core.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player2 extends Entity {

    //public GamePanel gp;
    public KeyHandler keyH;
    private int weight;
    private int gravity;
    //int x;
    //int y;
    BufferedImage jumpImg = null;

    public Player2(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        playerX = 520;
        playerY = 515;

        /* specifying where on the character it will collide with tiles.
        We set this to the whole character since it only scrolls vertically */
        playerSolid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);

        setDefaultValues();
        getPlayerImage();
    }

    private void setDefaultValues() {
        worldX = 64;
        worldY = 704;
        speed = 5;
        direction = "right";
        previousDirection = direction;
        weight = 3;
        jumpStrength = 0;
        gravity = weight;
        playerState = PlayerState.NORMAL;
    }

    public void getPlayerImage() {
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
                right2 = ImageIO.read(getClass().getResourceAsStream("/player2/Proggy_voi_right.png"));

            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (keyH.leftPressed2 || keyH.rightPressed2 || keyH.upPressed2) {
            if (keyH.rightPressed2) {
                previousDirection = direction;
                direction = "right";
                //worldX += speed;
            }
            else if (keyH.leftPressed2) {
                previousDirection = direction;
                direction = "left";
                //worldX -= speed;
            }
            if (keyH.upPressed2) {
                previousDirection = direction;
                direction = "up";
                jump();
            }

            // Is the tile Proggy is located in solid? default setting is false
            colliding = false;

            // updates to be true if Proggy collides with a solid tile
            gp.collisionChecker2.checkCollisionOnTile();
            //System.out.println("Player 2: " + worldX);


            int rightCol = ((playerSolid.width + worldX) + speed) / gp.tileSize;
            int topRow = (playerSolid.y + worldY) / gp.tileSize;
            int bottomRow = (worldY - playerSolid.y + playerSolid.height) / gp.tileSize;
            //System.out.println("left: " + leftCol);
            //System.out.println("top: " + topRow);
            int cornerOne = this.gp.loader.numOfTiles[rightCol][topRow];
            int cornerTwo = this.gp.loader.numOfTiles[rightCol][bottomRow];
            System.out.println("[" + rightCol + "]" + "[" + bottomRow + "]:  " + cornerTwo);

            PowerUp();

            if (colliding == false) {
                switch(direction) {
                    case "up":
                        jump();
                        //moveWhileJumping();
                        break;
                    case "down":
                        fall();
                        break;
                    case "right":
                        //playerX += speed;
                        worldX += speed;
                        jump();//jump instead of fall seems to give better results currently
                        break;
                    case "left":
                        //playerX -= speed;
                        worldX -= speed;
                        jump();
                        break;
                }
            }

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
/*
        if (keyH.rightPressed1 || keyH.leftPressed1 || keyH.upPressed1) {
            //if (worldX <= gp.worldWidth && 0 <= worldX) {
                int oldY = playerY;
                if (keyH.leftPressed1)
                    //playerX += speed;
                if (keyH.rightPressed1)
                    //playerX -= speed;

            if (keyH.upPressed1) {
                if (jumpStrength <= 0) {
                    jumpStrength = 15;
                    worldY += jumpStrength;
                    jumpStrength -= 12;
                }
                if (jumpStrength > 0) {
                    worldY += jumpStrength;
                    jumpStrength +=1;
                }
            }


            }
        }

 */
    }

    // gives abilities on player for the different power-ups
    public void PowerUp() {
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

    // jump function that makes proggy collide also when jumping
    public void jump() {
        // Proggy needs to be on the ground while button is pressed in order to jump
        if(keyH.upPressed2 == true || (jumpStrength <= 0 && !onGround)) {
            //jump is initialized and depending on the previous direction we need different image sprites
            if(previousDirection == "right") {
                jumpImg = up1;
            }
            if(previousDirection == "left"){
                jumpImg = up2;
            }

            gp.collisionChecker2.checkCollisionOnTile();
            if(colliding == false) {
                if(onGround == true) {
                    gp.playSoundEffect(3);
                    // How fast the jump is upwards
                    jumpStrength = 15;
                    //playerY -= jumpStrength;
                    worldY -= jumpStrength;
                    jumpStrength +=12;
                    onGround = false;
                }
                if (onGround == false && jumpStrength > 0) {
                    //playerY -= jumpStrength;
                    worldY -= jumpStrength;
                    jumpStrength -=1;
                }

                gp.collisionChecker2.checkCollisionOnTile();

                if(jumpStrength <=0 || colliding == true) {
                    // setting jumpStrengt to 0 if you hit your head, so you dont keep going up
                    jumpStrength = 0;

                    // how fast Proggy falls after hitting the maximum height
                    gravity = weight;
                    fall();
                }
            }
        }
    }

    /*
    public void fall() {
        String originalDir = direction;
        direction = "down";
        gp.collisionChecker2.checkCollisionOnTile();
        if(colliding == false || onGround == false) {
            onGround = false;
            direction = originalDir;
            playerY += gravity;
            worldY += gravity;

            if(gravity < 18) {
                gravity += 1;
            }
        }
        else {
            onGround = true;
            jumpStrength = 0;
            playerY = ((playerY + speed)/gp.tileSize) * gp.tileSize;
            worldY = ((worldY + speed)/gp.tileSize) * gp.tileSize;
            direction = originalDir;
            gravity = weight;

        }
    }

     */

    public void fall() {
        String originalDir = direction;
        direction = "down";
        gp.collisionChecker2.checkCollisionOnTile();
        if(colliding == false || onGround == false) {
            onGround = false;
            direction = originalDir;
            worldY += weight;

        }
        else {
            onGround = true;
            worldY = ((worldY + speed)/gp.tileSize) * gp.tileSize;
            direction = originalDir;
            gravity = weight;

        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.playerX;
        int screenY = worldY - gp.player.worldY + gp.player.playerY;

        switch (direction) {
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                break;

            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "up":
                image = jumpImg;
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
    }



}
