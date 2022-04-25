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
		gp.hobo[0].worldY = 512;
		
		
		gp.hobo[1] = new Hobo(gp);
		gp.hobo[1].worldX = 500;
		gp.hobo[1].worldY = 512;

		
		gp.hobo[2] = new Hobo(gp);
		gp.hobo[2].worldX = 600;
		gp.hobo[2].worldY = 512;

		gp.hobo[3] = new Hobo(gp);
		gp.hobo[3].worldX = 600;
		gp.hobo[3].worldY = 350;

	}
	
	
}
