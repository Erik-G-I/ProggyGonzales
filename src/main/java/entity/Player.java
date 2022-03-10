package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.CollisionCheck;
import core.GamePanel;
import core.KeyHandler;
import java.awt.Rectangle;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    private int weight;
    private int gravity;
    public static int floorHeight = 511; //512 px ned

    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        playerX = 480;
        playerY = 515;

        /* specifying where on the character it will collide with tiles. 
        We set this to the whole character since it only scrolls vertically */
        playerSolid = new Rectangle(12,1,gp.tileSize-12, gp.tileSize-2);

        
        setDefaultValues();
        getPlayerImage();
    
    }
    
    public void setDefaultValues() {
    	worldX = 0;
        //jo mindre y, jo høyere opp
    	worldY = 512;
        speed = 5;
        direction = "down";
        weight = 3;
        jumpStrength = 0;
        gravity = weight;

    }
    
    public void getPlayerImage() {
        
        try {
            
//            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
//            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
//            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
//            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
//            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
//            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
//            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
//            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        	
        	up1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_up-2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_down-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left-2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right-2.png"));

           // bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bakgrunn.jpg"));
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            
      	            

				if(keyH.upPressed == true ) {
					direction = "up";
//					jumpStrength = 36; // Hvor høyt proggy hopper
//					worldY -= jumpStrength; // Beveger spiller på y-aksen basert på hoppets styrke
//		    	    jumpStrength -= weight;



	
	            }
	            else if(keyH.downPressed == true) {
	                direction = "down";

	            }
	            else if(keyH.leftPressed == true) {
	                direction = "left";

	            }
	            else if(keyH.rightPressed == true) {
	                direction = "right";

	            }
                
                
                // ER tilen man er på en tile som kolliderer? I utgangspunktet ikke 
	            colliding = false;
//	            onGround = true;
                
                //blir oppdatert til å være det dersom den treffer en solid brikke
                gp.collisionChecker.checkTile(this);

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
    
    		
    public void jump() {
    	if(onGround == true && keyH.upPressed == true) {
    		jumpStrength = 30;
    		gravity = weight;
    	}
    	if(direction == "up") {
    		gp.collisionChecker.checkTile(this);
        	if(colliding == false) {
        		onGround = false;
        		worldY -= jumpStrength;
        		jumpStrength -= 1;
        		gp.collisionChecker.checkTile(this);
        		if(jumpStrength <=0 || colliding == true) {
        			direction = "down";
        			
        		}
        	}
        	else {
        		fall();
        	}
        	
    	}
    	if(direction == "down") {
    		fall();
    	}
    	

    }
    
    public void fall() {
    	String originalDir = direction;
    	direction = "down";
    	gp.collisionChecker.checkTile(this);
    	if(colliding == false || onGround == false) {
    		direction = originalDir;
    		worldY += gravity;
    		gravity += 1;
    	}
    	else {
    		onGround = true;
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
            if(spriteNum == 1) {
                image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
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

