package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import core.DisplayText;
import core.GamePanel;

public class GameOver extends GameScreen{

	int widthOfScreen;
	Font font;
	boolean isGameOver = false;
	boolean isOutOfBounds = false;
	
	public GameOver(GamePanel gp) {
		this.gp = gp;
		widthOfScreen = gp.screenWidth;
	}
	
	public void update() {
		isGameOver = gp.getGameOver();
		isOutOfBounds = gp.getOutOfBounds();
	}

	@Override
	public void draw(Graphics g2) {
		
		this.setGraphics(g2);
		this.setGp(gp);
		
		this.draw(200);
		if (isGameOver == true || isOutOfBounds == true) {
			
			Color transparent = new Color(0, 0, 0, 200);
			g2.setColor(transparent);
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			String gameStr = "GAME";
			g2.setColor(Color.BLACK);
			g2.drawString(gameStr, centerText(gameStr), gp.tileSize*3);
			g2.setColor(Color.RED);
			g2.drawString(gameStr, centerText(gameStr), gp.tileSize*3+10);

			String overStr = "OVER";
			g2.setColor(Color.BLACK);
			g2.drawString(overStr, centerText(overStr), gp.tileSize*5);
			g2.setColor(Color.BLUE);
			g2.drawString(overStr, centerText(overStr), gp.tileSize*5+10);
			
			g2.setColor(Color.WHITE);
			this.draw(100);
			String restartStr = "Restart?";
			g2.drawString(restartStr, centerText(restartStr), gp.tileSize*7);
			
			g2.setColor(Color.WHITE);
			String yes = "yes";
			g2.drawString(yes, widthOfScreen / 5, 500);
			if (cmd == 1) {
				g2.drawString(">", widthOfScreen / 5 - 40, 500);
			}
			
			g2.setColor(Color.WHITE);
			String no = "no";
			g2.drawString(no, widthOfScreen / 2 + 200, 500);
			if (cmd == 2) {
				g2.drawString(">", widthOfScreen / 2 + 160, 500);
			}
		}
	}

	public boolean gameOver() {
		return isGameOver;
	}
	
	public boolean gameOverBounds() {
		return isOutOfBounds;
	}
	
	public void restart() {
		gp.setGame();
	}
}
