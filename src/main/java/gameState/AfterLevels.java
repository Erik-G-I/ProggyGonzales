package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import core.GamePanel;

public class AfterLevels extends GameScreen{
	
	private final GamePanel gp;
	private final Image image;
	
	public AfterLevels(GamePanel gp) {
		this.gp = gp;
		image = new ImageIcon(getClass().getResource("/screens/afterlevels.gif")).getImage();
	}

	@Override
	public void draw(Graphics g2) {
		
		this.setGp(gp);
		this.setGraphics(g2);
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		g2.drawImage(image, 250, 50, 600, 600, null);
		String s1 = "Start";
		
		g2.setColor(Color.WHITE);
		
		g2.drawString(s1, centerText(s1)-100, gp.tileSize*10);
		g2.drawString(">", centerText(">")-200, gp.tileSize*10);
		
		
	}
	
	

}
