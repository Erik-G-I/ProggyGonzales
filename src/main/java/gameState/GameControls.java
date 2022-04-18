package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.DisplayText;
import core.GamePanel;

public class GameControls extends DisplayText{

	GamePanel gp;
	
	public GameControls(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics g2) {
		this.setGp(gp);
		this.setGraphics(g2);
		
		String s1,s2,s3,s4,s5,s6;
		
		if(gp.getLang() == Languages.NORWEGIAN) {
			s1 = "Kontroller";
			s2 = "Arrow Up, W, Space    -    Jump";
			s3 = "Arrow Left or A    -    Move left";
			s4 = "Arrow Right or D    -    Move right";
			s5 = "ESC    -    Pause Menu";
			s6 = "ESC to go back to Main Menu";
		}
		else {
			s1 = "CONTROLS";
			s2 = "Pil opp, W, mellombar    -    Hopp";
			s3 = "Venstre pil, A    -    Gå til venstre";
			s4 = "Høyre pil, D    -    Gå til høyre";
			s5 = "ESC    -    Pause";
			s6 = "ESC    -    Tilbake til hovedmeny";
			
		}
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(100);
		g2.setColor(Color.BLACK);
		g2.drawString(s1, centerText(s1)-10, gp.tileSize*2);
		g2.setColor(Color.WHITE);
		g2.drawString(s1, centerText(s1), gp.tileSize*2);
		
		this.draw(50);
		g2.setColor(Color.WHITE);
		
		g2.drawString(s2, centerText(s2), gp.tileSize*4);
		
		g2.drawString(s3, centerText(s3), gp.tileSize*5);
		
		
		g2.drawString(s4, centerText(s4), gp.tileSize*6);

		g2.drawString(s5, centerText(s5), gp.tileSize*7);

		g2.drawString(s6, gp.tileSize*2, gp.tileSize*10);
		String s7 = ">";
		g2.drawString(s7, gp.tileSize*2-25, gp.tileSize*10);
		
	}
}

