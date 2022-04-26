package enemies;

import core.Panel;


public class EnemySetter {

	Panel gp;
	
	public EnemySetter(Panel gp) {
		this.gp = gp;
	}
	
	
	public void setHobo() {
		gp.unicef[0] = new Unicef(gp);
		gp.unicef[0].worldX = 350;
		gp.unicef[0].worldY = 300;
		
	/**	
		gp.unicef[1] = new Unicef(gp);
		gp.unicef[1].worldX = 500;
		gp.unicef[1].worldY = 300;

		gp.unicef[2] = new Unicef(gp);
		gp.unicef[2].worldX = 600;
		gp.unicef[2].worldY = 300;
		*/

		gp.unicef[3] = new Unicef(gp);
		gp.unicef[3].worldX = 1100;
		gp.unicef[3].worldY = 200;

		gp.unicef[4] = new Unicef(gp);
		gp.unicef[4].worldX = 1600;
		gp.unicef[4].worldY = 200;
	/**	
		gp.unicef[5] = new Unicef(gp);
		gp.unicef[5].worldX = 2300;
		gp.unicef[5].worldY = 200;
		
		gp.unicef[6] = new Unicef(gp);
		gp.unicef[6].worldX = 2550;
		gp.unicef[6].worldY = 200;
		
		gp.unicef[7] = new Unicef(gp);
		gp.unicef[7].worldX = 3100;
		gp.unicef[7].worldY = 200;
		
		gp.unicef[8] = new Unicef(gp);
		gp.unicef[8].worldX = 3700;
		gp.unicef[8].worldY = 200;
*/
		
	}
	
	
}
