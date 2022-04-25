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
		gp.hobo[0] = new Hobo(gp);
		gp.hobo[0].worldX = 300;
		gp.hobo[0].worldY = 600;
		
		
		gp.hobo[1] = new Hobo(gp);
		gp.hobo[1].worldX = 500;
		gp.hobo[1].worldY = 512;

		
		gp.hobo[2] = new Hobo(gp);
		gp.hobo[2].worldX = 600;
		gp.hobo[2].worldY = 512;

		gp.hobo[3] = new Hobo(gp);
		gp.hobo[3].worldX = 1100;
		gp.hobo[3].worldY = 350;

		gp.hobo[4] = new Hobo(gp);
		gp.hobo[4].worldX = 1600;
		gp.hobo[4].worldY = 350;
		
		gp.hobo[5] = new Hobo(gp);
		gp.hobo[5].worldX = 2400;
		gp.hobo[5].worldY = 350;
		
		gp.hobo[6] = new Hobo(gp);
		gp.hobo[6].worldX = 2800;
		gp.hobo[6].worldY = 350;
		
		gp.hobo[7] = new Hobo(gp);
		gp.hobo[7].worldX = 3300;
		gp.hobo[7].worldY = 350;
		
		gp.hobo[8] = new Hobo(gp);
		gp.hobo[8].worldX = 3700;
		gp.hobo[8].worldY = 350;

	}
	
	
}
