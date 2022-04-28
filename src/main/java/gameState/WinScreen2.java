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
		
		String s1, s2, s3, s4, s5, s6, s7, s8;
		String coins = Integer.toString(gp.collisionChecker.getCoins());
		String time = gp.getTimerDisplay().timeLeft();
		
		
		if (gp.getLang() == Languages.NORWEGIAN) {
			s2 = "Du plukket opp "+coins+" kr og hadde "+time+" igjen!";
			s7 = "Tilbake til hovedmeny";
			s8 = "Velg et annet level";
		}
		else {
			s2 = "You picked up "+coins+" kr and had "+time+" left!";
			s7 = "Back to main menu";
			s8 = "Choose another level";
		}

		this.setGp(gp);
		this.setGraphics(g2);
		
        Color transparent = new Color(0, 0, 0, 0x80);
        g2.setColor(transparent);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		
		g2.drawString("HighScore", centerText("HighScore"), gp.tileSize*2);

		g2.drawString(s2, centerText(s2), gp.tileSize*3);
		
		s2 = gp.highscores.getName(0)+ " - " + Integer.toString(gp.highscores.getScore(0));

		g2.drawString(s2, centerText(s2), gp.tileSize*5);

		s3 = gp.highscores.getName(1)+ " - " + Integer.toString(gp.highscores.getScore(1));
		g2.drawString(s3, centerText(s3), gp.tileSize*6);
		

		s4 = gp.highscores.getName(2)+ " - " + Integer.toString(gp.highscores.getScore(2));
		g2.drawString(s4, centerText(s4), gp.tileSize*7);
		
		
		s5 = gp.highscores.getName(3)+ " - " + Integer.toString(gp.highscores.getScore(3));
		g2.drawString(s5, centerText(s5), gp.tileSize*8);
		
		
		s6 = gp.highscores.getName(4)+ " - " + Integer.toString(gp.highscores.getScore(4));
		g2.drawString(s6, centerText(s6), gp.tileSize*9);
		
		this.draw(25);
		g2.drawString(s7, centerText(s7) - 150, gp.tileSize*10);
		if (cmd == 0) {
			g2.drawString(">", centerText(s7) - 180, gp.tileSize*10);
		}
		
		g2.drawString(s8, centerText(s8) + 150, gp.tileSize*10);
		if (cmd == 1) {
			g2.drawString(">", centerText(s8) + 120, gp.tileSize*10);
		}
	}
	
	

}
	

