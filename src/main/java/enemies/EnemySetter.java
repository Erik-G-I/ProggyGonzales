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
			gp.hobo[0].worldX = 128;
			gp.hobo[0].worldY = 352;
			
			
			gp.hobo[1] = new Hobo(gp);
			gp.hobo[1].worldX = 384;
			gp.hobo[1].worldY = 288;

			
			gp.hobo[2] = new Hobo(gp);
			gp.hobo[2].worldX = 768;
			gp.hobo[2].worldY = 416;
			
			gp.hobo[3] = new Hobo(gp);
			gp.hobo[3].worldX = 1184;
			gp.hobo[3].worldY = 320;
		}
		if(map == "/maps/medium.txt") {
			

			gp.hobo[4] = new Hobo(gp);
			gp.hobo[4].worldX = 1600;
			gp.hobo[4].worldY = 200;
			
			gp.hobo[5] = new Hobo(gp);
			gp.hobo[5].worldX = 2300;
			gp.hobo[5].worldY = 200;
		}
		if(map == "/maps/hard.txt") {
			gp.hobo[6] = new Hobo(gp);
			gp.hobo[6].worldX = 2550;
			gp.hobo[6].worldY = 200;
			
			gp.hobo[7] = new Hobo(gp);
			gp.hobo[7].worldX = 3100;
			gp.hobo[7].worldY = 200;
			
			gp.hobo[8] = new Hobo(gp);
			gp.hobo[8].worldX = 3700;
			gp.hobo[8].worldY = 200;

		}
		

		
		
		
		
	}
	
	
}
