package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.DisplayText;
import core.GamePanel;

public class GameControls extends GameScreen {
	
	public GameControls(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void draw(Graphics g2) {
		this.setGp(gp);
		this.setGraphics(g2);
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(100);
		String ctr = "CONTROLS";
		g2.setColor(Color.BLACK);
		g2.drawString(ctr, centerText(ctr)-10, gp.tileSize*2);
		g2.setColor(Color.WHITE);
		g2.drawString(ctr, centerText(ctr), gp.tileSize*2);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		ctr = "Arrow UP or W or Space    -    Jump";
		g2.drawString(ctr, centerText(ctr), gp.tileSize*4);
		
		ctr = "Arrow Left or A    -    Move left";
		g2.drawString(ctr, centerText(ctr), gp.tileSize*5);
		
		ctr = "Arrow Right or D    -    Move right";
		g2.drawString(ctr, centerText(ctr), gp.tileSize*6);
		
		ctr = "ESC    -    Pause Menu";
		g2.drawString(ctr, centerText(ctr), gp.tileSize*7);
		
		ctr = "ESC to go back to Main Menu";
		g2.drawString(ctr, gp.tileSize*2, gp.tileSize*10);
		ctr = ">";
		g2.drawString(ctr, gp.tileSize*2-25, gp.tileSize*10);
		
	}
}

