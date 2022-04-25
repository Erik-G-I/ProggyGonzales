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
        direction = "down";
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
					direction = "vanlig";
				}
				if(i > 50) {
					direction = "vanligglad";
				}
				if(onGround = false) {
					direction = "down";
				}
			
				actionLockCounter = 0;
			}
			
			
		}
	
	

}


