package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.GamePanel;


public class WinScreen2 extends GameScreen{
	
	GamePanel gp;
	
	public WinScreen2(GamePanel gp) {
		this.gp = gp;
		
	}

	@Override
	public void draw(Graphics g2) {
		
		String s1, s2, s3, s4, s5, s6, s7;
		
		if (gp.getLang() == Languages.NORWEGIAN) {
			s1 = "Tilbake til hovedmeny";
			s7 = "Velg et annet level";
		}
		else {
			s1 = "Back to main menu";
			s7 = "Choose another level";
		}

		this.setGp(gp);
		this.setGraphics(g2);
		
        Color transparent = new Color(0, 0, 0, 0x80);
        g2.setColor(transparent);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		
		g2.drawString("HighScore", centerText("HighScore"), gp.tileSize*2);
		
		s2 = gp.highscores.get(0).toString()+ " - " + gp.getPlayerName();

		g2.drawString(s2, centerText(s2), gp.tileSize*5);

		s3 = gp.highscores.get(1).toString();
		g2.drawString(s3, centerText(s3), gp.tileSize*5);
		

		s4 = gp.highscores.get(2).toString();
		g2.drawString(s4, centerText(s4), gp.tileSize*6);
		
		
		s5 = gp.highscores.get(3).toString();
		g2.drawString(s5, centerText(s5), gp.tileSize*7);
		
		
		s6 = gp.highscores.get(4).toString();
		g2.drawString(s6, centerText(s6), gp.tileSize*8);
		
		this.draw(25);
		g2.drawString(s1, centerText(s1) - 150, gp.tileSize*10);
		if (cmd == 0) {
			g2.drawString(">", centerText(s1) - 180, gp.tileSize*10);
		}
		
		g2.drawString(s7, centerText(s7) + 150, gp.tileSize*10);
		if (cmd == 1) {
			g2.drawString(">", centerText(s7) + 120, gp.tileSize*10);
		}
	}
	
	

}
	

