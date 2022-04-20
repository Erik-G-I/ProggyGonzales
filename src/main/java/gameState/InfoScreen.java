package gameState;

import core.DisplayText;
import core.GamePanel;

import java.awt.*;

public class InfoScreen extends GameScreen {

    public InfoScreen(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void draw(Graphics g) {
        this.setGp(gp);
        this.setGraphics(g);
        
        String s1,s2, line1, line2, line3, line4, line5, line6;
        
        if(gp.getLang() == Languages.NORWEGIAN) {
            //Text
        	s1 = "Tilbake";
        	s2 = "neste";
            line1 = "Proggy Gonzales har lest hardt i hele år, men i dag hadde han sin site eksamen!";
            line2 = "For å feire skal han på eksamensfest, og må rekke butikken før ølsalget stenger. Han har";
            line3 = "donert alle pengene sine til unicef, og må derfor løpe gjennom Bergen sentrum og samle";
            line4 = "penger for å få råd. I tillegg må han unngå gateselgere som ikke gir seg uansett hvor";
            line5 = "hardt han sier at han allerede er fadder.";
            line6 = "";
        }
        else {
        	s1 = "Back";
        	s2 = "Next";
        	line1 = "Proggy Gonzales has been studying hard all year, but today he had his last exam!";
        	line2 = "To celebrate, he is going to a party, but he needs to get to the shop to buy beer before";
        	line3 = "closing time. He has donated all his money to Unicef so he has to collect all the money";
        	line4 = "he can find in the streets of Bergen. It is important to avoid meeting charity workers";
        	line5 = "with their collecting tins since they won't leave him alone, even though he keeps telling";
        	line6 = "them he already gives donations reguarly.";
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
        if (cmd == 1)
            g.drawString(">", x + gp.tileSize/2, y + height-40);

        g.drawString(s2, x + width-(gp.tileSize+32), y + height-40);
        if (cmd == 2)
            g.drawString(">", x + width-(2*gp.tileSize), y + height-40);


        Font textFont = new Font("Monospaced", Font.PLAIN, 14);
        g.setFont(textFont);

        g.drawString(line1, x+gp.tileSize/2, y+gp.tileSize);
        g.drawString(line2, x+gp.tileSize/2, y+gp.tileSize+25);
        g.drawString(line3, x+gp.tileSize/2, y+gp.tileSize+50);
        g.drawString(line4, x+gp.tileSize/2, y+gp.tileSize+75);
        g.drawString(line5, x+gp.tileSize/2, y+gp.tileSize+100);
        g.drawString(line6, x+gp.tileSize/2, y+gp.tileSize+125);

    }

}
