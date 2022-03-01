package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;
import core.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    private float weight, jumpStrength;
    public static int floorHeight = 515; //512 px ned
    
    

    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = 480;
        screenY = 515;

        
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
					direction = "up";
					jumpStrength = 36; // Hvor høyt proggy hopper
					worldY -= jumpStrength; // Beveger spiller på y-aksen basert på hoppens styrke
		    	    jumpStrength -= weight;
		    	    worldY -= speed;
	
	            }
	            else if(keyH.downPressed == true) {
	                direction = "down";
	                worldY += speed;
	            }
	            else if(keyH.leftPressed == true) {
	                direction = "left";
	                worldX -= speed;
	            }
	            else if(keyH.rightPressed == true) {
	                direction = "right";
	                worldX += speed;
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
    	if (keyH.upPressed == true && worldY >= floorHeight) // Må være på bakken for å hoppe
    	      jumpStrength = 36; 
    		  worldY -= jumpStrength; 
    		  jumpStrength -= weight; // Gradvis tar av styrken på hoppet basert på vekten
        
    		if (worldY >= floorHeight) { 
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
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
        
    
}

