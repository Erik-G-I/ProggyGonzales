package entity.enemies;

import java.awt.image.BufferedImage;

import core.GamePanel;
import entity.Entity;
import entity.player.PlayerState;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class EntityEnemy extends Entity {
    
    protected BufferedImage unicefLeft, unicefRight;
    public int movementCount = 0;

	public EntityEnemy(GamePanel gp) {
		super(gp);
		weight = 8;
	}

	public abstract void setAction();

	@Override
	public void update() {
		setAction();
		
		colliding = false;
		gp.collisionChecker1.checkEnemyOnTile(this);
		gp.collisionChecker2.checkEnemyOnTile(this);

		if (colliding == false) {
            switch(direction) {
            case "enemyLeft":
            worldX -= speed;
                break;
          
            case "enemyRight":
            worldX += speed;
                break;
            
            case "down":
            	fall();
            	break;
            }
        }
	}

	@Override
	public void getImage() {
	}

	GamePanel gp;

	@Override
    public void fall() {
    	String originalDir = direction;
    	direction = "down";
    	gp.collisionChecker1.checkEnemyOnTile(this);
		gp.collisionChecker2.checkEnemyOnTile(this);
    	if(colliding == false || onGround == false) {
    		onGround = false;
    		direction = originalDir;
    		worldY += weight;

    	}
    	else {
    		onGround = true;
    		worldY = ((worldY + speed)/gp.tileSize) * gp.tileSize;
    		direction = originalDir;
    	}
    }

    @Override
    public void draw(Graphics2D g2) {
		
    	BufferedImage image = null;

    	int screenX = worldX - gp.player1.worldX + gp.player1.playerX;
		int screenY = worldY - gp.player1.worldY + gp.player1.playerY;
		
		if(worldX + gp.tileSize > gp.player1.worldX - gp.player1.playerX &&
		   worldX - gp.tileSize < gp.player1.worldX + gp.player1.playerX &&
		   worldY + gp.tileSize > gp.player1.worldY - gp.player1.playerY &&
		   worldY - gp.tileSize < gp.player1.worldY + gp.player1.playerY) {
			
	        switch(direction) {
	        case "enemyLeft":
	        	image = unicefLeft;
	            break;
	            
	        case "enemyRight":
	        	image = unicefRight;
	            break;

	        case "down":
	        	image = unicefRight;
	            break;
	        }

			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
    }

	
}

