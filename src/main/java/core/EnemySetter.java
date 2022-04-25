package core;

import java.util.ArrayList;

import enemies.Hobo;
import entity.PlayerState;
import enemies.entityEnemy;
import entity.Entity;


public class EnemySetter {

	GamePanel gp;
	
	public EnemySetter(GamePanel gp) {
		this.gp = gp;
	}
	

	public void setHobo() {
		gp.hobo[0] = new Hobo(gp);
		gp.hobo[0].worldX = gp.player.playerX - 200;
		gp.hobo[0].worldY = 512;
		
		
		gp.hobo[1] = new Hobo(gp);
		gp.hobo[1].worldX = gp.player.playerX + 200;
		gp.hobo[1].worldY = 512;

		
		gp.hobo[2] = new Hobo(gp);
		gp.hobo[2].worldX = gp.player.playerX + 600;
		gp.hobo[2].worldY = 512;

	}
	
	
}
