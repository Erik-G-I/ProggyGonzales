package gameState;

import java.awt.Color;
import java.awt.Graphics;
import core.GamePanel;

public class GameOver extends GameScreen {

	int widthOfScreen;
	boolean isGameOver = false;
	boolean isOutOfBounds = false;
	boolean gameOverMusic = false;
	GamePanel gp;
	
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
		this.setPanel(gp);
		
		String s1, s2, s3;
		
		if(gp.getLang() == Languages.NORWEGIAN) {
			s1 = "Prøv på nytt?";
			s2 = "Ja";
			s3 = "Nei";
		}
		else {
			s1 = "Restart?";
			s2 = "Yes";
			s3 = "No";
		}
		
		this.draw(200);
		if (isGameOver == true || isOutOfBounds == true) {
			gp.gameState = GameState.GAME_OVER;
			if(gameOverMusic == false) {
				//gp.stopMusic();
				gp.playSoundEffect(5);
				gp.playMusic(9);
				gameOverMusic = true;
			}
			
			Color transparentRed = new Color(0, 0, 0, 200);
			g2.setColor(transparentRed);
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
			this.draw(65);
			g2.drawString(s1, centerText(s1), gp.tileSize*7);
			
			this.draw(55);
			g2.setColor(Color.WHITE);
			
			g2.drawString(s2, widthOfScreen / 5, 500);
			if (cmd == 0) {
				g2.drawString(">", widthOfScreen / 5 - 40, 500);
			}
			
			g2.drawString(s3, widthOfScreen / 2 + 200, 500);
			if (cmd == 1) {
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
		gameOverMusic = false;
	}
}
