package entity.enemies;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import core.GamePanel;

import java.awt.Rectangle;

public class Unicef extends EntityEnemy{
	
    public Unicef(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
        this.getImage();
    }

    @Override
	public void getImage() {
	        
	        try {
	        	unicefRight = ImageIO.read(getClass().getResourceAsStream("/enemies/Unicef_left1.png"));
	        	unicefLeft = ImageIO.read(getClass().getResourceAsStream("/enemies/Unicef_left2.png"));

	        }catch(IOException e) {
	            e.printStackTrace();
	        }
	}

    /**
     * Makes enemies walk. By using Random, the player can't know for sure where the enemies next move is
     */
	@Override
	public void setAction() {
			
			movementCount ++;
			
			//the higher the movementcount, the longer between change of direction
			if(movementCount == 120) {
				
				Random random = new Random();
				int i = random.nextInt(100) + 1; //picks a random number from 1-100
				
				if(i <= 50) {
					direction = "enemyLeft";
				}
				if(i > 50) {
					direction = "enemyRight";
				}
				if(onGround = false) {
					direction = "down";
				}
			
				movementCount = 0;
			}
		}
}


