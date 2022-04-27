package gameState;

import java.awt.Color;
import java.awt.Graphics;
import core.GamePanel;

public class LevelsMenu extends GameScreen {
		
		public LevelsMenu(GamePanel gp) {
			this.gp = gp;
		}

		@Override
		public void draw(Graphics g2) {
			this.setGp(gp);
			this.setGraphics(g2);
			
			String s1, s2, s3, s4, s5;
			
			if (gp.getLang() == Languages.NORWEGIAN) {
				s5 = "ESC - Tilbake til hovedmeny";
				s1 = "NIVÅER";
				s2 = "Nivå 1 - Lett";
				s3 = "Nivå 2 - Middels";
				s4 = "Nivå 3 - Vanskelig";
			}
			else {
				s5 = "ESC - Back to main menu";
				s1 = "LEVELS";
				s2 = "Level 1 - Easy";
				s3 = "Level 2 - Medium";
				s4 = "Level 3 - Hard";
			}
			
			Color tranparent = new Color(0, 0, 0, 200);
			g2.setColor(tranparent);
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			this.draw(100);
			g2.setColor(Color.BLACK);
			g2.drawString(s1, centerText(s1)-8, gp.tileSize*2);
			g2.setColor(Color.WHITE);
			g2.drawString(s1, centerText(s1), gp.tileSize*2);
			
			this.draw(50);
			g2.drawString(s2, centerText(s2), gp.tileSize*5);
			if (cmd == 0) {
				g2.drawString(">", centerText(s2)-gp.tileSize, gp.tileSize*5);
			}

			g2.drawString(s3, centerText(s3), gp.tileSize*6);
			if (cmd == 1) {
				g2.drawString(">", centerText(s3)-gp.tileSize, gp.tileSize*6);
			}

			g2.drawString(s4, centerText(s4), gp.tileSize*7);
			if (cmd == 2) {
				g2.drawString(">", centerText(s4)-gp.tileSize, gp.tileSize*7);
			}
			
			g2.drawString(s5, centerText(s5), gp.tileSize*10);
		}
	}


