package enemies;

import java.util.ArrayList;

import core.GamePanel;
import entity.PlayerState;
import entity.Entity;


public class EnemySetter {

	GamePanel gp;
	
	public EnemySetter(GamePanel gp) {
		this.gp = gp;
	}
	

	public void setHobo() {
		String map = gp.getMapPath();
		
		if(map == "/maps/easy.txt") {
			gp.hobo[0] = new Hobo(gp);
			gp.hobo[0].worldX = 320;
			gp.hobo[0].worldY = 500;
			
			
			gp.hobo[1] = new Hobo(gp);
			gp.hobo[1].worldX = 600;
			gp.hobo[1].worldY = 350;

			
			gp.hobo[2] = new Hobo(gp);
			gp.hobo[2].worldX = 1350;
			gp.hobo[2].worldY = 500;
			
			
			gp.hobo[3] = new Hobo(gp);
			gp.hobo[3].worldX = 2200;
			gp.hobo[3].worldY = 500;
			
			gp.hobo[4] = new Hobo(gp);
			gp.hobo[4].worldX = 3200;
			gp.hobo[4].worldY = 400;
			
		}
		if(map == "/maps/medium.txt") {
			
			gp.hobo[5] = new Hobo(gp);
			gp.hobo[5].worldX = 600;
			gp.hobo[5].worldY = 600;
			
			gp.hobo[6] = new Hobo(gp);
			gp.hobo[6].worldX = 1856;
			gp.hobo[6].worldY = 640;
			
			gp.hobo[7] = new Hobo(gp);
			gp.hobo[7].worldX = 3520;
			gp.hobo[7].worldY = 832;
			
			gp.hobo[8] = new Hobo(gp);
			gp.hobo[8].worldX = 5300;
			gp.hobo[8].worldY = 896;
		}
		if(map == "/maps/hard.txt") {
			
			gp.hobo[9] = new Hobo(gp);
			gp.hobo[9].worldX = 384;
			gp.hobo[9].worldY = 640;
//			
			gp.hobo[10] = new Hobo(gp);
			gp.hobo[10].worldX = 1856;
			gp.hobo[10].worldY = 768;
//			
			gp.hobo[11] = new Hobo(gp);
			gp.hobo[11].worldX = 1920;
			gp.hobo[11].worldY = 768;
			
			gp.hobo[12] = new Hobo(gp);
			gp.hobo[12].worldX = 3328;
			gp.hobo[12].worldY = 832;

			gp.hobo[13] = new Hobo(gp);
			gp.hobo[13].worldX = 3380;
			gp.hobo[13].worldY = 832;
			
			gp.hobo[14] = new Hobo(gp);
			gp.hobo[14].worldX = 4416;
			gp.hobo[14].worldY = 768;
			
			gp.hobo[15] = new Hobo(gp);
			gp.hobo[15].worldX = 5632;
			gp.hobo[15].worldY = 768;
			
			gp.hobo[16] = new Hobo(gp);
			gp.hobo[16].worldX = 5888;
			gp.hobo[16].worldY = 704;
			
		}
		

		
		
		
		
	}
	
	
}
