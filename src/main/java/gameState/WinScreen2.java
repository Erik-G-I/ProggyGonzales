package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.GamePanel;


public class WinScreen2 extends GameScreen{
	
	GamePanel gp;
	
	public WinScreen2(GamePanel gp) {
		this.gp = gp;
		
	}

	@Override
	public void draw(Graphics g2) {
		
		String s1, s2;
		
		if (gp.getLang() == Languages.NORWEGIAN) {
			s1 = "ESC - Tilbake til hovedmeny";
			s2 = "Du vant!!";
		}
		else {
			s1 = "ESC - Back to main menu";
			s2 = "You won!!";
		}

		
		this.setGp(gp);
		this.setGraphics(g2);
		
    	
        Color transparent = new Color(0, 0, 0, 0x80);
        g2.setColor(transparent);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		
		g2.drawString(s2, centerText(s2), gp.tileSize*3);
		
		this.draw(30);
		g2.drawString(s1, centerText(s1)-100, gp.tileSize*10);
	}
	
	

}
	

