package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import core.GamePanel;
import core.KeyHandler;
import entity.Entity;

import java.awt.Rectangle;
import enemies.entityEnemy;

public class Hobo extends entityEnemy{

    GamePanel gp;
	
    
    public Hobo(GamePanel gp) {
        super(gp);	
        this.gp = gp;
        direction = "vanlig";
        speed = 1;
        enemySolid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);
        
        getHoboImage();
    }
    
	public void getHoboImage() {
	        
	        try {
	        	uteligger = ImageIO.read(getClass().getResourceAsStream("/enemies/uteligger.png"));
	            uteliggerglad = ImageIO.read(getClass().getResourceAsStream("/enemies/uteliggerglad.png"));
	            	  
	            
	            
	        }catch(IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public void setAction() {
			
			actionLockCounter ++;
			
			if(actionLockCounter == 40) {
				
				Random random = new Random();
				
				int i = random.nextInt(100) + 1; //pick up a number from 1-100
				
				if(i <= 50) {
					direction = "left";
				}
				if(i > 50) {
					direction = "right	";
				}
			
				actionLockCounter = 0;
			}
			
			
		}
	
	

}


/**

        playerSolid = new Rectangle(14 ,2,gp.tileSize-14, gp.tileSize-2);
        
        setDefaultValues();
        getEnemyImage();
    
    }

    public void setDefaultValues() {
        direction = "left";
        previousDirection = direction;
        jumpStrength = 0;
    }
    
    public void getEnemyImage() {
        
        try {
        	uteligger = ImageIO.read(getClass().getResourceAsStream("/enemies/uteligger.png"));
           // BufferedImage uteliggerglad = ImageIO.read(getClass().getResourceAsStream("/enemies/uteliggerglad.png"));
            
           // bakgrunn = ImageIO.read(getClass().getResourceAsStream("/graphics/bakgrunn.jpg"));
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void changeOnCollision() {

    	
    			worldX --;
                // Is the tile Proggy is located in solid? default setting is false
	            colliding = false;
                
                // updates to be true if Proggy collides with a solid tile
                gp.collisionChecker.checkCollisionOnTile(this);

                // IF collision is true, enemy changes way.  
                if (direction == "left" && colliding == true) {
                    direction = "right"; 
                    worldX ++;

                }    
                
                if (direction == "right" && colliding == true) {
                    direction = "left";
                    worldX --; 

                }    
    
    }
    
    
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        //g2.drawImage(bakgrunn, 0,0, 1000, 700, null);
        
        BufferedImage image = null;
        	image = uteligger;
        
        	int worldCol = 0; //x/gp.maxWorldCol;
    		int bufferCol = 64;//worldCol + 16;
    		
    		int worldRow = 0;
    		
    		while(worldCol < bufferCol && worldRow < gp.maxWorldRow) {
    			
    			int WorldX = worldCol * gp.tileSize;
    			int WorldY = worldRow * gp.tileSize;
    			int screenX = WorldX - gp.player.worldX + gp.player.playerX;
    			int screenY = WorldY - gp.player.worldY + gp.player.playerY;
    			
    			
    	        g2.drawImage(image, screenX, screenY + 200, gp.tileSize, gp.tileSize, null);
    			
    			worldCol ++;

    		}
    } 
 */

