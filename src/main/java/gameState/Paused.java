package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.DisplayText;
import core.GamePanel;

public class Paused extends DisplayText {
	
	GamePanel gp;
	public int cmd = 1;
	
	public Paused(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics g2) {
		this.setGp(gp);
		this.setGraphics(g2);
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		String str = ">";
		this.draw(100);
		g2.setColor(Color.BLACK);
		String pStr = "PAUSED";
		g2.drawString(pStr, centerText(pStr)-8, gp.tileSize*2);
		g2.setColor(Color.WHITE);
		g2.drawString(pStr,centerText(pStr),gp.tileSize*2);
		
		this.draw(75);
		String resume = "Resume";
		g2.drawString(resume, centerText(resume), gp.tileSize*4);
		if (cmd == 1) {
			g2.drawString(str, centerText(str)-150, gp.tileSize*4);
		}
		
		String restart = "Restart";
		g2.drawString(restart, centerText(restart), gp.tileSize*5);
		if (cmd == 2) {
			g2.drawString(str, centerText(str)-150, gp.tileSize*5);
		}
		
		String back = "Back to Main Menu";
		g2.drawString(back, centerText(back), gp.tileSize*6);
		if (cmd == 3) {
			g2.drawString(str, centerText(str)-350, gp.tileSize*6);
		}
	}

}
