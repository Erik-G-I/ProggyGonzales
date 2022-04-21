package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;

public class StartMenu extends GameScreen {
	
	BufferedImage img;
	int y = 0;

    public StartMenu(GamePanel gp) {
        this.gp = gp;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
	public void update() {
		y += 6;
		if (y == gp.tileSize*6) {
			y-=6;
		}
	}

    @Override
    public void draw(Graphics g) {
    	
        this.setGp(gp);
        this.setGraphics(g);
        
        String s2, s3, s4, s5;
        
        if(gp.getLang() == Languages.NORWEGIAN) {
        	s2 = "Start";
        	s3 = "Om spillet";
        	s4 = "Kontroller";
        	s5 = "Avslutt";
        }
        else {
        	s2 = "Play Game";
        	s3 = "About";
        	s4 = "Controls";
            s5 = "Quit";
        }
    	
//        Color transparent = new Color(0, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        String text;

        // Title
        this.draw(110);
        g.setColor(Color.BLACK);
        text = "Proggy Gonzales";
        g.drawString(text, centerText(text)-5,gp.tileSize*4);
        g.setColor(Color.WHITE);
        g.drawString(text, centerText(text),gp.tileSize*4);

        // Menu
        this.draw(50);
        g.setColor(Color.WHITE);

        g.drawString(s2, centerText(s2),gp.tileSize*6);
        if (cmd == 0) {
            g.drawString(">", centerText(s2)-gp.tileSize,gp.tileSize*6);
        }

        g.drawString(s3, centerText(s3),gp.tileSize*7);
        if (cmd == 1) {
            g.drawString(">", centerText(s3)-gp.tileSize,gp.tileSize*7);
        }
        
        g.drawString(s4, centerText(s4), gp.tileSize*8);
        if(cmd == 2) {
        	g.drawString(">", centerText(s4)-gp.tileSize,gp.tileSize*8);
        }

        g.drawString(s5, centerText(s5),gp.tileSize*9);
        if (cmd == 3) {
            g.drawString(">", centerText(s5)-gp.tileSize,gp.tileSize*9);
        }
		g2.drawImage(img, 100, y, 300, 300, null);
    }

}

