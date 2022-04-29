package entity.enemies;

import java.awt.image.BufferedImage;

import core.GamePanel;
import entity.Entity;

import java.awt.Graphics2D;

/**
 * Abstract superclass for the moving enemies
 * Inherits from Entity
 */
public abstract class EntityEnemy extends Entity {
    
    protected BufferedImage unicefLeft, unicefRight;
    public int movementCount = 0;

	public EntityEnemy(GamePanel gp) {
		super(gp);
		weight = 8;
	}

	/**
	 * Method to make the enemies move by themselves
	 */
	public abstract void setAction();

	/**
	 * Uses the setAction from Unicef to get the enemies to move 
	 * Uses collisionChecker so enemy cant go through tiles
	 */
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
		
    	BufferedImage image = unicefLeft;

    	int screenX = worldX - gp.player1.worldX + gp.player1.playerX;
		int screenY = worldY - gp.player1.worldY + gp.player1.playerY ;
		
		if(worldX + gp.tileSize > gp.player1.worldX - gp.player1.playerX &&
		   worldX - gp.tileSize < gp.player1.worldX + gp.player1.playerX &&
		   worldY + gp.tileSize > gp.player1.worldY - gp.player1.playerY &&
		   worldY - gp.tileSize < gp.player1.worldY + gp.player1.playerY) {

			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
    }

	
}

