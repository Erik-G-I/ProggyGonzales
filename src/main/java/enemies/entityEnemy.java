package enemies;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import core.GamePanel;
import core.KeyHandler;
import entity.PlayerState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import core.AssetSetter;

public class entityEnemy {

    
    public int worldX, worldY;
    public int playerX, playerY;
    public int speed;
    
    protected BufferedImage uteligger;
	protected BufferedImage uteliggerglad;
    public String direction;
    public String previousDirection;
    
    public Rectangle playerSolid;
    public Rectangle enemySolid;
    public boolean colliding = false;
    public boolean onGround = true;
    private int gravity = 3;

    //public boolean onGround = true;
    public PlayerState enemyState = PlayerState.NORMAL;

    public int distance;
    public int actionLockCounter = 0;


	public void setAction() {
		
	}

	public void update() {
		setAction();
		
		colliding = false;
		gp.collisionChecker.checkEnemyOnTile(this);

		
		if (colliding == false) {
            switch(direction) {
            case "left":
            worldX -= speed;
                break;
          
            case "right":
            worldX += speed;
                break;
                
          
            }
        }


	}

	GamePanel gp;
    
    
    public entityEnemy(GamePanel gp) {
    	this.gp = gp;
    	
    }
    
    public void fall() {
    	String originalDir = direction;
    	direction = "left";
    	//gp.collisionChecker.checkCollisionOnTile(this);
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
    		gravity = 3;
    		
    	}
    }
    
    public void draw(Graphics2D g2) {
		
    	BufferedImage image = null;

    	int screenX = worldX - gp.player.worldX + gp.player.playerX;
		int screenY = worldY - gp.player.worldY + gp.player.playerY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.playerX && 
		   worldX - gp.tileSize < gp.player.worldX + gp.player.playerX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.playerY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.playerY) {
			
	        switch(direction) {
	        case "left":
	        	image = uteligger;
	            break;
	            
	        case "right":
	        	image = uteligger;
	            break;
	        
	    }       
			if(gp.player.worldX == gp.hobo[0].worldX && !(gp.player.worldY < gp.hobo[0].worldY)) {
				uteligger = uteliggerglad;			
			}
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
			
		}
    }
    
}

