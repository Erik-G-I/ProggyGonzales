package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;
import core.KeyHandler;
import tile.Tile;

import java.awt.Rectangle;

public class Enemy extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    private int weight;
    private int gravity;
    private BufferedImage jumpImg = null;

    
    public Enemy(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        playerX = 600;
        playerY = 600;

        /* specifying where on the character it will collide with tiles. 
        We set this to the whole character since it only scrolls vertically */
        playerSolid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);
        
        
        setDefaultValues();
        getEnemyImage();
    
    }
    
    public void setDefaultValues() {
    	worldX = 64;
        //jo mindre y, jo høyere opp
    	worldY = 512;
        speed = 5;
        direction = "right";
        previousDirection = direction;
        weight = 3;
        jumpStrength = 0;
        gravity = weight;

    }
    
    public void getEnemyImage() {
        
        try {
            
        	
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

           // bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bakgrunn.jpg"));
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() throws IOException {
           
               
    	
                // Is the tile enemy is located in solid? default setting is false
	            colliding = false;
                
                // updates to be true if Enemy collides with a solid tile
                gp.collisionChecker.checkCollisionOnTile(this);

                // If collision is false, enemy moves. else: direction stops. 
                if (colliding == false) {
                    switch(direction) {
                    case "down":
                    fall();
                        break;
                    case "right":
                    worldX += speed;
                    
                        break;
                    case "left":
                    worldX -= speed; 
                    
                        break;
                    }
                }

				// oppdaterer bilde som blir brukt til enemy
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
    
    
    

    public void fall() {
    	String originalDir = direction;
    	direction = "down";
    	gp.collisionChecker.checkCollisionOnTile(this);
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
        
        g2.drawImage(image, 500, 500, gp.tileSize, gp.tileSize, null);
    }
        
    
   
}
