package gameState;

import core.DisplayText;
import core.GamePanel;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends DisplayText {

    GamePanel gp;

    public int commandNum = 0;


    public StartMenu(GamePanel gp) {
        this.gp = gp;
    }


    public void draw(Graphics g) {
    	
        this.setGp(gp);
        this.setGraphics(g);
    	
        Color transparentRed = new Color(0, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
        g.setColor(transparentRed);
        g.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        String text;

        // Title
        //Font titleFont = new Font("Times New Roman",Font.BOLD,90);
        //g.setFont(titleFont);
        this.draw(110);
        g.setColor(Color.BLACK);
        text = "Proggy Gonzales";
        g.drawString(text, centerText(text)-5,gp.tileSize*4);
        g.setColor(Color.WHITE);
        g.drawString(text, centerText(text),gp.tileSize*4);

        // Menu
        //Font menuFont = new Font("Times New Roman",Font.PLAIN,65);
        //g.setFont(menuFont);
        this.draw(50);
        g.setColor(Color.WHITE);

        text = "Play Game";
        g.drawString(text, centerText(text),gp.tileSize*6);
        if (commandNum == 0) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*6);
        }

        text = "About";
        g.drawString(text, centerText(text),gp.tileSize*7);
        if (commandNum == 1) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*7);
        }

        text = "Quit";
        g.drawString(text, centerText(text),gp.tileSize*8);
        if (commandNum == 2) {
            g.drawString(">", centerText(text)-gp.tileSize,gp.tileSize*8);
        }

    }

}

