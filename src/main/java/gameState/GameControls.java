package gameState;

import java.awt.Color;
import java.awt.Graphics;

import core.DisplayText;
import core.GamePanel;

public class GameControls extends GameScreen {
	
	public GameControls(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void draw(Graphics g2) {
		this.setGp(gp);
		this.setGraphics(g2);
		
		String s1,s2,s3,s4,s5,s6,s7, s8, s9, s10, s11, s12;
		
		if(gp.getLang() == Languages.NORWEGIAN) {
			s1 = "KONTROLLER";
			s2 = "Spiller 1";
			s3 = "Pil opp, mellombar    -    Hopp";
			s4 = "Venstre pil    -    Gå til venstre";
			s5 = "Høyre pil    -    Gå til høyre";
			s6 = "Spiller 2";
			s7 = "W    -    Hopp";
			s8 = "A    -    Gå til venstre";
			s9 = "D    -    Gå til høyre";
			s10 = "ESC    -    Pause";
			s11 = "ESC    -    Tilbake til hovedmeny";
		}
		else {
			s1 = "CONTROLS";
			s2 = "Player 1";
			s3 = "Arrow Up, Space    -    Jump";
			s4 = "Arrow Left    -    Move left";
			s5 = "Arrow Right    -    Move right";
			s6 = "Player 2";
			s7 = "W    -    Jump";
			s8 = "A    -    Move left";
			s9 = "D    -    Move right";
			s10 = "ESC    -    Pause game";
			s11 = "ESC to go back to Main Menu";
		}
		
		Color transparentRed = new Color(0, 0, 0, 200);
		g2.setColor(transparentRed);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		this.draw(100);
		g2.setColor(Color.BLACK);
		g2.drawString(s1, centerText(s1)-10, gp.tileSize*2);
		g2.setColor(Color.WHITE);
		g2.drawString(s1, centerText(s1), gp.tileSize*2);

		this.draw(60);
		g2.setColor(Color.BLACK);
		g2.drawString(s2, centerText(s2)-5, gp.tileSize*3);
		g2.setColor(Color.WHITE);
		g2.drawString(s2, centerText(s2), gp.tileSize*3);

		this.draw(50);
		g2.drawString(s3, centerText(s3), gp.tileSize*4-15);

		g2.drawString(s4, centerText(s4), gp.tileSize*5-30);

		g2.drawString(s5, centerText(s5), gp.tileSize*6-45);

		this.draw(60);
		g2.setColor(Color.BLACK);
		g2.drawString(s6, centerText(s6)-5, gp.tileSize*7-15);
		g2.setColor(Color.WHITE);
		g2.drawString(s6, centerText(s6), gp.tileSize*7-15);

		this.draw(50);
		g2.drawString(s7, centerText(s7), gp.tileSize*8-30);

		g2.drawString(s8, centerText(s8), gp.tileSize*9-45);

		g2.drawString(s9, centerText(s9), gp.tileSize*10-60);

		g2.drawString(s10, centerText(s10), gp.tileSize*11-75);

		this.draw(40);
		g2.drawString(s11, centerText(s11), gp.tileSize*11);
		
	}
}

