package entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import core.GamePanel;
import core.KeyHandler;
import entity.Score;

public class EnemyTest {

	final GamePanel gp = new GamePanel("/maps/testingMap.txt");
	KeyHandler keyH = new KeyHandler(gp);
	int startPos;
	Score score;

	
	@Test
	public void enemyFall() {
		for(int i = 0; i < gp.unicef.length; i++) {
        	if(gp.unicef[i] != null) {
				startPos = gp.unicef[i].worldY;
				gp.unicef[i].direction = "down";
        		gp.unicef[i].update();
	    		assertEquals(startPos + gp.unicef[i].weight, gp.unicef[i].worldY);
        	}
    		
		}
	}
	
	@Test
	public void enemyMoveRight() {
		
		for(int i = 0; i < gp.unicef.length; i++) {
	        if(gp.unicef[i] != null) {
				startPos = gp.unicef[i].worldX;
				gp.unicef[i].direction = "enemyRight";
        		gp.unicef[i].update();
		    	assertEquals(startPos + gp.unicef[i].speed, gp.unicef[i].worldX);
	       	}
	     }
	}
	
	@Test
	public void enemyMoveLeft() {
	
		for(int i = 0; i < gp.unicef.length; i++) {
	        if(gp.unicef[i] != null) {
				startPos = gp.unicef[i].worldX;
				gp.unicef[i].direction = "enemyLeft";
        		gp.unicef[i].update();
	    		assertEquals(startPos - gp.unicef[i].speed, gp.unicef[i].worldX);
        	}
	    }
	}
	
	@Test
    public void enemyCannotGoThroughTile() {
		    
		for(int i = 0; i < gp.unicef.length; i++) {
			if(gp.unicef[i] != null) {
		        startPos = gp.unicef[i].worldY;
		        gp.unicef[i].update();

        	}
		}
        assertTrue(startPos < startPos + gp.tileSize, "Enemies can't go through tiles");
    }
	
}
