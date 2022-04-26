package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Panel;

public class StartMenu extends GameScreen {
	
	BufferedImage img;
	int y = 0;

    public StartMenu(Panel gp) {
        this.gp = gp;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/graphics/start.png"));
		} catch (IOException e) {
			e.printStackTrace();
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
    	
		g2.drawImage(img, 0, 0, gp.screenWidth, gp.screenHeight-68, null);
        Color transparent = new Color(0, 0, 0, 150);
        g.setColor(transparent);
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
    }

}

