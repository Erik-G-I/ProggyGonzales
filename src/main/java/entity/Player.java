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
    private float weight, jumpStrength;
    public static int floorHeight = 511; //512 px ned

    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        playerX = 480;
        playerY = 515;

        /* specifying where on the character it will collide with tiles. 
        We set this to the whole character since it only scrolls vertically */
        playerSolid = new Rectangle(0,0,gp.tileSize, gp.tileSize);

        
        setDefaultValues();
        getPlayerImage();
    
    }
    
    public void setDefaultValues() {
    	worldX = 0;
        //jo mindre y, jo høyere opp
    	worldY = floorHeight;
        speed = 5;
        direction = "down";
        weight = 3;


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
            
      	            
				if(keyH.upPressed == true && worldY >= floorHeight) {
					// jumping = true;
                    // new Thread(new thread()).start()
                    direction = "up";
					jumpStrength = 36; // Hvor høyt proggy hopper
					worldY -= jumpStrength; // Beveger spiller på y-aksen basert på hoppets styrke
		    	    jumpStrength -= weight;

	
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
                
                //blir oppdatert til å være det dersom den treffer en solid brikke
                gp.collisionChecker.checkTile(this);

                // IF collision is false, player moves. else: direction stops. 
                if (colliding == false) {
                    switch(direction) {
                    case "up":
                    worldY -= speed;
                        break;
                    case "down":
                    worldY += speed;
                        break;
                    case "right":
                    worldX += speed;
                        break;
                    case "left":
                    worldX -= speed; 
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
    	if (keyH.upPressed == true && worldY >= floorHeight) { // Må være på bakken for å hoppe
            jumpStrength = 36;
        }

    	worldY -= jumpStrength;
    	jumpStrength -= weight; // Gradvis tar av styrken på hoppet basert på vekten

        if (worldY >= floorHeight) { // && colliding == false) {
            worldY = floorHeight; // Passer på at ikke proggy faller gjennom bakken.
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

