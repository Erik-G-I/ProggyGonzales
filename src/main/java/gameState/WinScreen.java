package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.GamePanel;

public class WinScreen extends GameScreen{


		GamePanel gp;
		
		public WinScreen(GamePanel gp) {
			this.gp = gp;
			
		}

		@Override
		public void draw(Graphics g2) {
			
			String s1;
			
			if (gp.getLang() == Languages.NORWEGIAN) {
				s1 = "Neste";
			}
			else {
				s1 = "Next";
			}
			
			this.setGp(gp);
			this.setGraphics(g2);
			
	    	
	        Color transparent = new Color(0, 0, 0, 0x80);
	        g2.setColor(transparent);
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			this.draw(50);
			g2.setColor(Color.WHITE);
			g2.drawString(s1, centerText(s1)-100, gp.tileSize*10);
			g2.drawString(">", centerText(">")-200, gp.tileSize*10);
			
		}
		
		

}
