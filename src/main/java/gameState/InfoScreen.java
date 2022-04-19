package gameState;

import core.DisplayText;
import core.GamePanel;

import java.awt.*;

public class InfoScreen extends DisplayText {

    GamePanel gp;
    public int c = 0;

    public InfoScreen(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics g) {
        this.setGp(gp);
        this.setGraphics(g);
        
        String s1,s2, line1, line2, line3, line4;
        
        if(gp.getLang() == Languages.NORWEGIAN) {
            //Text
        	s1 = "Tilbake";
        	s2 = "neste";
            line1 = "Proggy Gonzales har lest hardt i hele år, men i dag skal han på eksamensfest,";
            line2 = "og må rekke butikken før ølsalget stenger. Han har donert alle pengene sine til unicef";
            line3 = "så han må løpe gjennom Bergen sentrum og samle penger for å få råd. I tillegg må han unngå";
            line4 = "gateselgere som ikke gir seg uansett hvor hardt han sier at han allerede er fadder.";
        }
        else {
        	s1 = "Back";
        	s2 = "Next";
        	line1 = "";
        	line2 = "";
        	line3 = "";
        	line4 = "";
        }

        //Transparent background
        Color transparent = new Color(0, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
        g.setColor(transparent);
        g.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        //White background
        g.setColor(Color.WHITE);
        int width = gp.tileSize*(gp.maxScreenCol-4);
        int height = gp.tileSize*(gp.maxScreenRow-4);

        int x = gp.screenWidth/2 - (width/2);
        int y = gp.screenHeight/2 - (height/2);

        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);

        //Back and next buttons
        this.draw(40);
        
        g.drawString(s1, x + gp.tileSize, y + height-40);
        if (c == 1)
            g.drawString(">", x + gp.tileSize/2, y + height-40);

        g.drawString(s2, x + width-(gp.tileSize+32), y + height-40);
        if (c == 2)
            g.drawString(">", x + width-(2*gp.tileSize), y + height-40);


        Font textFont = new Font("Monospaced", Font.PLAIN, 14);
        g.setFont(textFont);

        g.drawString(line1, x+gp.tileSize/2, y+gp.tileSize);
        g.drawString(line2, x+gp.tileSize/2, y+gp.tileSize+25);
        g.drawString(line3, x+gp.tileSize/2, y+gp.tileSize+50);
        g.drawString(line4, x+gp.tileSize/2, y+gp.tileSize+75);

    }

}
