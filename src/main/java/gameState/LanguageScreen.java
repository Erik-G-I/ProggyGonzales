package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.DisplayText;
import core.GamePanel;

public class LanguageScreen extends DisplayText{
	
	GamePanel gp;
	public int cmd = 1;
	BufferedImage img1, img2;
	
	public LanguageScreen(GamePanel gp) {
		this.gp = gp;
		try {
			img1 = ImageIO.read(getClass().getResourceAsStream("/language/GB.png"));
			img2 = ImageIO.read(getClass().getResourceAsStream("/language/Norway.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics g2) {
		String str;
		this.setGraphics(g2);
		this.setGp(gp);
		this.draw(100);
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setColor(Color.WHITE);
		g2.drawImage(img1, 225, gp.tileSize*3, 100, 100, null);
		if (cmd == 1) {
			g2.drawString(">", 150, gp.tileSize*3+75);
			this.draw(75);
			str = "Enter - to choose";
			g2.drawString(str, 150, gp.tileSize*8);
		}
		
		g2.drawImage(img2, 700, gp.tileSize*3, 100, 100, null);
		if (cmd == 2) {
			g2.drawString(">", 650, gp.tileSize*3+75);
			this.draw(75);
			str = "Enter - for å velge";
			g2.drawString(str, 150, gp.tileSize*8);
		}
		
	}
}
