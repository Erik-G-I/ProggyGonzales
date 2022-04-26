package gameState;

import java.awt.Color;
import java.awt.Graphics;
import core.GamePanel;
import core.Panel;

public class LevelsMenu extends GameScreen {
		
		public LevelsMenu(Panel panel) {
			this.panel = panel;
		}
		
		public void draw(Graphics g2) {
			this.setPanel(panel);
			this.setGraphics(g2);
			
			String s1, s2, s3, s4, s5;
			
			if (panel.getLang() == Languages.NORWEGIAN) {
				s5 = "ESC - Tilbake til hovedmeny";
			}
			else {
				s5 = "ESC - Back to main menu";
			}
			
			Color tranparent = new Color(0, 0, 0, 200);
			g2.setColor(tranparent);
			g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
			
			this.draw(100);
			s1 = "LEVELS";
			g2.setColor(Color.BLACK);
			g2.drawString(s1, centerText(s1)-8, panel.tileSize*2);
			g2.setColor(Color.WHITE);
			g2.drawString(s1, centerText(s1), panel.tileSize*2);
			
			this.draw(50);
			s2 = "Level 1 - Easy";
			g2.drawString(s2, centerText(s2), panel.tileSize*5);
			if (cmd == 0) {
				g2.drawString(">", centerText(s2)- panel.tileSize, panel.tileSize*5);
			}

			s3 = "Level 2 - Medium";
			g2.drawString(s3, centerText(s3), panel.tileSize*6);
			if (cmd == 1) {
				g2.drawString(">", centerText(s3)- panel.tileSize, panel.tileSize*6);
			}

			s4 = "Level 3 - Hard";
			g2.drawString(s4, centerText(s4), panel.tileSize*7);
			if (cmd == 2) {
				g2.drawString(">", centerText(s4)- panel.tileSize, panel.tileSize*7);
			}
			
			g2.drawString(s5, centerText(s5), panel.tileSize*10);
		}
	}


