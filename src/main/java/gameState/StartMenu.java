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

        text = "Play Game";
        g.drawString(text, centerText(text),gp.tileSize*6);
        if (cmd == 0) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*6);
        }

        text = "About";
        g.drawString(text, centerText(text),gp.tileSize*7);
        if (cmd == 1) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*7);
        }
        
        text = "Controls";
        g.drawString(text, centerText(text), gp.tileSize*8);
        if(cmd == 2) {
        	g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*8);
        }

        text = "Quit";
        g.drawString(text, centerText(text),gp.tileSize*9);
        if (cmd == 3) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*9);
        }

    }

}

