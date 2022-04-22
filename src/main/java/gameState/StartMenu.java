package gameState;

import core.DisplayText;
import core.GamePanel;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends GameScreen {

    public StartMenu(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void draw(Graphics g) {
    	
        this.setGp(gp);
        this.setGraphics(g);
        
        String s2, s3, s4, s5, s6;
        
        if(gp.getLang() == Languages.NORWEGIAN) {
        	s2 = "Start";
        	s3 = "Om spillet";
        	s4 = "Kontroller";
        	s5 = "Avslutt";
        	s6 = "Mute";
        }
        else {
        	s2 = "Play Game";
        	s3 = "About";
        	s4 = "Controls";
            s5 = "Quit";
            s6 = "Mute";
        }
    	
        Color transparent = new Color(0, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
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

        g.drawString(s6, centerText(s6),gp.tileSize*9);
        if (cmd == 4) {
            g.drawString(">", centerText(s6)-gp.tileSize,gp.tileSize*9);
        }

    }

}

