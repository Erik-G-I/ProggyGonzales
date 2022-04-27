package enemies;

import java.awt.image.BufferedImage;

import core.GamePanel;
import entity.PlayerState;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EntityEnemy {

    
    public int worldX, worldY;
    public int playerX, playerY;
    public int speed;
    
    protected BufferedImage unicefLeft;
	protected BufferedImage unicefRight;
    public String direction;
    public String previousDirection;

    public Rectangle playerSolid;
    public Rectangle enemySolid;
    public boolean colliding = false;
    public boolean onGround = false;
    private int gravity = 3;
    private int weight = 8;

    public EntityEnemy[] allEnemies ;

    public PlayerState enemyState = PlayerState.NORMAL;

    public int distance;
    public int movementCount = 0;


	public void setAction() {
		
	}

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

	GamePanel gp;
    
    
    public EntityEnemy(GamePanel gp) {
    	this.gp = gp;
    	
    }
    
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
    		gravity = weight;
    		
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
			
		//	if(gp.collisionChecker.looseMoney(gp.player, gp.unicef) == true) {
		//		image = uteliggerglad;
		//	}
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
    }

	
}

