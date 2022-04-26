package gameState;

import java.awt.Color;
import java.awt.Graphics;
import core.GamePanel;

public class Paused extends GameScreen {
	
	public Paused(GamePanel gp) {
		this.panel = gp;
	}

	@Override
	public void draw(Graphics g2) {
		this.setPanel(panel);
		this.setGraphics(g2);
		
		String s1,s2,s3,s4;
		
		if(panel.getLang() == Languages.NORWEGIAN) {
			s1 = "PAUSE";
			s2 = "Fortsette";
			s3 = "Prøv på nytt";
			s4 = "Tilbake til hovedmeny";
		}
		else {
			s1 = "PAUSED";
			s2 = "Resume";
			s3 = "Restart";
			s4 = "Back to Main Menu";

		}
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
		
		String str = ">";
		this.draw(100);
		g2.setColor(Color.BLACK);
		
		g2.drawString(s1, centerText(s1)-8, panel.tileSize*2);
		g2.setColor(Color.WHITE);
		g2.drawString(s1,centerText(s1), panel.tileSize*2);
		
		this.draw(75);
		g2.drawString(s2, centerText(s2), panel.tileSize*4);
		if (cmd == 0) {
			g2.drawString(str, centerText(str)-175, panel.tileSize*4);
		}
		
		g2.drawString(s3, centerText(s3), panel.tileSize*5);
		if (cmd == 1) {
			g2.drawString(str, centerText(str)-225, panel.tileSize*5);
		}
		
		g2.drawString(s4, centerText(s4), panel.tileSize*6);
		if (cmd == 2) {
			g2.drawString(str, centerText(str)-350, panel.tileSize*6);
		}
	}

}
