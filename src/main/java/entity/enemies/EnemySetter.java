package entity.enemies;

import core.GamePanel;


public class EnemySetter {

	final GamePanel gp;
	
	public EnemySetter(GamePanel gp) {
		this.gp = gp;
	}
	
	/**
	 * Places out unicef-enemies for each map
	 */
	public void setUnicef() {
		String map = gp.getMapPath();
		
		if(map == "/maps/easy.txt") {
			gp.unicef[0] = new Unicef(gp);
			gp.unicef[0].worldX = 320;
			gp.unicef[0].worldY = 500;
			
			
			gp.unicef[1] = new Unicef(gp);
			gp.unicef[1].worldX = 600;
			gp.unicef[1].worldY = 350;

			
			gp.unicef[2] = new Unicef(gp);
			gp.unicef[2].worldX = 1350;
			gp.unicef[2].worldY = 500;
			
			
			gp.unicef[3] = new Unicef(gp);
			gp.unicef[3].worldX = 2200;
			gp.unicef[3].worldY = 500;
			
			gp.unicef[4] = new Unicef(gp);
			gp.unicef[4].worldX = 3200;
			gp.unicef[4].worldY = 400;
			
		}
		if(map == "/maps/medium.txt") {
			
			gp.unicef[5] = new Unicef(gp);
			gp.unicef[5].worldX = 600;
			gp.unicef[5].worldY = 600;
			
			gp.unicef[6] = new Unicef(gp);
			gp.unicef[6].worldX = 1856;
			gp.unicef[6].worldY = 640;
			
			gp.unicef[7] = new Unicef(gp);
			gp.unicef[7].worldX = 3520;
			gp.unicef[7].worldY = 832;
			
			gp.unicef[8] = new Unicef(gp);
			gp.unicef[8].worldX = 5300;
			gp.unicef[8].worldY = 896;
			
			gp.unicef[17] = new Unicef(gp);
			gp.unicef[17].worldX = 6200;
			gp.unicef[17].worldY = 596;
			
			gp.unicef[18] = new Unicef(gp);
			gp.unicef[18].worldX = 7300;
			gp.unicef[18].worldY = 596;
			
			gp.unicef[19] = new Unicef(gp);
			gp.unicef[19].worldX = 7800;
			gp.unicef[19].worldY = 596;
		}
		if(map == "/maps/hard.txt") {
			
			gp.unicef[10] = new Unicef(gp);
			gp.unicef[10].worldX = 1856;
			gp.unicef[10].worldY = 768;
			
			gp.unicef[11] = new Unicef(gp);
			gp.unicef[11].worldX = 1920;
			gp.unicef[11].worldY = 768;
			
			gp.unicef[12] = new Unicef(gp);
			gp.unicef[12].worldX = 3328;
			gp.unicef[12].worldY = 832;

			gp.unicef[13] = new Unicef(gp);
			gp.unicef[13].worldX = 3380;
			gp.unicef[13].worldY = 832;
			
			gp.unicef[14] = new Unicef(gp);
			gp.unicef[14].worldX = 4416;
			gp.unicef[14].worldY = 768;
			
			gp.unicef[15] = new Unicef(gp);
			gp.unicef[15].worldX = 5632;
			gp.unicef[15].worldY = 768;
			
			gp.unicef[16] = new Unicef(gp);
			gp.unicef[16].worldX = 5888;
			gp.unicef[16].worldY = 704;
			
		}
	}
	
}
