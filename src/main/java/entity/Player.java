package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//import core.CollisionCheck;
import core.GamePanel;
import core.KeyHandler;
import java.awt.Rectangle;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    private int weight;
    private int gravity;

    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        playerX = 480;
        playerY = 515;

        /* specifying where on the character it will collide with tiles. 
        We set this to the whole character since it only scrolls vertically */
        playerSolid = new Rectangle(12 ,1,gp.tileSize-12, gp.tileSize-1);

        
        setDefaultValues();
        getPlayerImage();
    
    }
    
    public void setDefaultValues() {
    	worldX = 64;
        //jo mindre y, jo høyere opp
    	worldY = 512;
        speed = 5;
        direction = "down";
        previousDirection = direction;
        weight = 3;
        jumpStrength = 0;
        gravity = weight;

    }
    
    public void getPlayerImage() {
        
        try {
            
        	
        	up1 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_right2.png"));

           // bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bakgrunn.jpg"));
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            
      	            

				if(keyH.upPressed == true ) {
					previousDirection = direction;
					direction = "up";
//					jumpStrength = 36; // Hvor høyt proggy hopper
//					worldY -= jumpStrength; // Beveger spiller på y-aksen basert på hoppets styrke
//		    	    jumpStrength -= weight;



	
	            }
	            else if(keyH.downPressed == true) {
	            	previousDirection = direction;
	                direction = "down";

	            }
	            else if(keyH.leftPressed == true) {
	            	previousDirection = direction;
	                direction = "left";

	            }
	            else if(keyH.rightPressed == true) {
	            	previousDirection = direction;
	                direction = "right";

	            }
                
                
                // Is the tile Proggy is located in solid? default setting is false
	            colliding = false;
//	            onGround = true;
                
                // updates to be true if Proggy collides with a solid tile
                gp.collisionChecker.checkCollisionOnTile(this);

                // IF collision is false, player moves. else: direction stops. 
                if (colliding == false) {
                    switch(direction) {
                    case "up":
                    jump();
                    
                    //jumpPossible = false;
//                    worldY -= speed;
                        break;
                    case "down":
                    fall();
                        break;
                    case "right":
                    worldX += speed;
                    jump();
                    
                        break;
                    case "left":
                    worldX -= speed; 
                    jump();
                    
                        break;
                    }
                }

				// oppdaterer bilde som blir brukt til player
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
    }
    
    // jump function that makes proggy collide also when jumping	
    public void jump() {
        // Proggy needs to be on the ground while button is pressed in order to jump
    	if(onGround == true && keyH.upPressed == true) {
    		// How fast the jump is upwards
            jumpStrength = 30;
            // how fast Proggy falls after hitting the maximum height
    		gravity = weight;
    		gp.collisionChecker.checkCollisionOnTile(this);
    		if(colliding == false) {
    			worldY -= jumpStrength;
    			onGround = false;
    		}
    		
    	}
        // Needs to check collision on the way up
    	if(onGround == false && jumpStrength > 0) {
    		gp.collisionChecker.checkCollisionOnTile(this);
            // will continue to jump as long as Proggy is not colliding with his head
        	if(colliding == false) {
                // moves Proggy the amount of pixels up specified by jumpstrength
        		worldY -= jumpStrength;
        		jumpStrength -= 1;
                // if proggy collides, the direction must change and he will fall down towards the ground
        		
        	}
            //if Proggy is already colliding, he will be affected by the fall
        	gp.collisionChecker.checkCollisionOnTile(this);
    		if(jumpStrength <=0 || colliding == true) {
//    			direction = "down";
    			fall();
    		}
        	
    	}
    }
    

    public void fall() {
    	String originalDir = direction;
    	direction = "down";
    	gp.collisionChecker.checkCollisionOnTile(this);
    	if(colliding == false || onGround == false) {
    		onGround = false;
    		direction = originalDir;
    		worldY += gravity;
    		gravity += 1;
    	}
    	else {
    		onGround = true;
    		jumpStrength = 0;
    		worldY = ((worldY + speed)/gp.tileSize) *gp.tileSize;
    		direction = originalDir;
    		gravity = weight;
    		
    	}
    }
    
    
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        //g2.drawImage(bakgrunn, 0,0, 1000, 700, null);
        
        BufferedImage image = null;
        switch(direction) {
        case "up":
        	if(previousDirection == "right") {
        		if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up1;
                }
        	}
        	else {
        		if(spriteNum == 1) {
                    image = up2;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
        	}
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
        
        g2.drawImage(image, playerX, playerY, gp.tileSize, gp.tileSize, null);
    }
        
    
}

