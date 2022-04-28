package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import core.GamePanel;

public class LanguageScreen extends GameScreen {

	private BufferedImage img1, img2;
	private int x = 0;
	private boolean drawNow;
	
	public LanguageScreen(GamePanel gp) {
		this.gp = gp;
		try {
			img1 = ImageIO.read(getClass().getResourceAsStream("/language/GB.png"));
			img2 = ImageIO.read(getClass().getResourceAsStream("/language/Norway.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		x += 2;
		if (x == gp.tileSize*3) {
			drawNow = true;
			x-=2;
		}
	}

	@Override
	public void draw(Graphics g2) {
		String str;
		this.setGraphics(g2);
		this.setGp(gp);
		this.draw(100);
		
		Color black = Color.BLACK;
		g2.setColor(black);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setColor(Color.WHITE);
		g2.drawImage(img1, x, gp.tileSize*3, 100, 100, null);
		if (cmd == 0) {
			if(drawNow) {
			g2.drawString(">", 150, gp.tileSize*3 + 75);
			this.draw(75);
			str = "Enter - to choose";
			g2.drawString(str, 150, gp.tileSize*8);
			}
		}
		
		g2.drawImage(img2, x + 500, gp.tileSize*3, 100, 100, null);
		if (cmd == 1) {
			g2.drawString(">", 650, gp.tileSize*3+75);
			this.draw(75);
			str = "Enter - for å velge";
			g2.drawString(str, 150, gp.tileSize*8);
		}
	}
	
	public boolean getDrawNow() {
		return drawNow;
	}
}
