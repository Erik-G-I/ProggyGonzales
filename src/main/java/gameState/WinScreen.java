package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import core.GamePanel;


public class WinScreen extends GameScreen{
	
	GamePanel gp;
	Image image;
	
	public WinScreen(GamePanel gp) {
		this.gp = gp;
		image = new ImageIcon(getClass().getResource("/graphics/ProggyEnding.gif")).getImage();
	}

	@Override
	public void draw(Graphics g2) {
		
		this.setGp(gp);
		this.setGraphics(g2);
		
		String s1;
		
		if (gp.getLang() == Languages.NORWEGIAN) {
			s1 = "ESC - Tilbake til hovedmeny";
		}
		else {
			s1 = "ESC - Back to main menu";
		}
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		g2.drawImage(image, 200, 200, 500, 500, null);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		g2.drawString(s1, centerText(s1)-100, gp.tileSize*10);
	}
	
	
}
