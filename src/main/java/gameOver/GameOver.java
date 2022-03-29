package gameOver;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;
import timer.Time;
import timer.TimerDisplay;

public class GameOver {

	GamePanel gp;
	TimerDisplay timerDisplay;
	Time time;
	int widthOfScreen;
	Font font;
	boolean isGameOver = false;
	BufferedImage img;
	
	public GameOver(GamePanel gp) {
		this.gp = gp;
		timerDisplay = gp.getTimerDisplay();
		time = timerDisplay.getTime();
		widthOfScreen = gp.screenWidth;
		font = new Font("Times New Roman",Font.BOLD,80);
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/graphics/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		isGameOver = time.getGameOver();
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(font);
		if(isGameOver==true) {
			g2.drawImage(img, widthOfScreen/3, 150, 380,500,null);
		}
	}
	
	public boolean gameOver() {
		return isGameOver;
	}
	
	public void isGameDone() {
		if(isGameOver) {
			Thread gameThread = null;
			gp.setGameThread(gameThread);
		}
	}
}
