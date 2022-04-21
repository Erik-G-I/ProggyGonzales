package core;

import java.util.ArrayList;

import enemies.Hobo;
import entity.PlayerState;
import enemies.entityEnemy;
import entity.Entity;


public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	

	public void setHobo() {
		gp.hobo[0] = new Hobo(gp);
		gp.hobo[0].worldX = gp.player.playerX - 200;
		gp.hobo[0].worldY = gp.player.playerY - 4;
		
		gp.hobo[1] = new Hobo(gp);
		gp.hobo[1].worldX = gp.player.playerX + 200;
		gp.hobo[1].worldY = gp.player.playerY - 4;
	}
	
	
}
