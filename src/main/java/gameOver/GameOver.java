package gameOver;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import core.DisplayText;
import core.GamePanel;
import timer.TimerDisplay;

public class GameOver extends DisplayText{

	GamePanel gp;
	TimerDisplay timerDisplay;
	int widthOfScreen;
	Font font;
	boolean isGameOver = false;
	BufferedImage img;
	public int cmd = 1;
	
	public GameOver(GamePanel gp) {
		this.gp = gp;
		timerDisplay = gp.getTimerDisplay();
		widthOfScreen = gp.screenWidth;
	}
	
	public void update() {
		isGameOver = gp.getGameOver();
	}
	
	public void draw(Graphics g2) {
		this.draw(g2, 200);
		if (isGameOver == true) {
			
			g2.setColor(Color.BLACK);
			g2.drawString("GAME", widthOfScreen / 3, 200);
			g2.setColor(Color.RED);
			g2.drawString("GAME", widthOfScreen/3+10, 200);
			
			g2.setColor(Color.BLACK);
			g2.drawString("OVER", widthOfScreen / 3, 350);
			g2.setColor(Color.BLUE);
			g2.drawString("OVER", widthOfScreen / 3+10, 350);
			
			g2.setColor(Color.BLACK);
			this.draw(g2, 100);
			String restartStr = "Restart?";
			g2.drawString(restartStr, widthOfScreen / 3, 450);

			String yes = "yes";
			g2.drawString(yes, widthOfScreen / 5, 500);
			if (cmd == 1) {
				g2.drawString(">", widthOfScreen / 5 - 40, 500);
			}

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
	
	public void restart() {
		gp.setGame();
	}
}
