package gameState;

import core.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class InfoScreen extends GameScreen {

    Image proggy;
    BufferedImage unicef, beggar, shop, shoes, voi;
    public int page = 1;

    public InfoScreen(GamePanel gp) {
        this.gp = gp;
    }

    private void loadImg() {
        //proggy = ImageIO.read(getClass().getResourceAsStream("/player/Proggy_default1.png"));
        proggy = new ImageIcon(getClass().getResource("/graphics/Proggy.gif")).getImage();
    }

    @Override
    public void draw(Graphics g) {
        loadImg();
        this.setGp(gp);
        this.setGraphics(g);
        
        String s1,s2, line1, line2, line3, line4, line5, line6, line7, line8;
        
        if(gp.getLang() == Languages.NORWEGIAN) {
            //Text
        	s1 = "Tilbake";
        	s2 = "neste";
            line1 = "Proggy Gonzales har lest hardt i hele år, men i dag hadde han sin siste eksamen!";
            line2 = "For å feire skal han på eksamensfest, og må rekke butikken før ølsalget stenger. Han har";
            line3 = "donert alle pengene sine til unicef, og må derfor løpe gjennom Bergen sentrum og samle";
            line4 = "penger for å få råd.";
            line5 = "I tillegg må han unngå Unicefarbeidere som ikke gir seg uansett hvor hardt han sier at han allerede er fadder, men det er ikke den eneste hindringen hans.";
            line6 = "Rundt om i Bergen er det også uteliggere som ber om penger. Proggy ikke har hjerte til";
            line7 = "å si nei når de spør, og må derfor holde seg unna de om han skal ha råd til øl.";
        }
        else {
        	s1 = "Back";
        	s2 = "Next";
        	line1 = "Proggy Gonzales has been studying hard all year, but today he had his last exam!";
        	line2 = "To celebrate, he is going to a party, but he needs to get to the shop to buy beer before";
        	line3 = "closing time.";
        	line4 = "He has donated all his money to Unicef so he has to collect all the money he can find";
        	line5 = "in the streets of Bergen.";
        	line6 = "It is important to avoid meeting Unicef charity workers with their collecting tins since they won't leave him alone, even though he keeps";
        	line7 = "telling them he already gives donations reguarly. There are also several beggar in the";
        	line8 = "streets, asking for money. Proggy cannot say no when they ask him, so he has to avoid them.";
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

        switch (page) {
            case 1:
                g.drawString(line1, x + gp.tileSize / 2, y + gp.tileSize + 125);
                g.drawString(line2, x + gp.tileSize / 2, y + gp.tileSize + 150);
                g.drawString(line3, x + gp.tileSize / 2, y + gp.tileSize + 175);

                g.drawImage(proggy, x + gp.tileSize, y + gp.tileSize + 225, null);
                g.drawString(line4, x + gp.tileSize / 2, y + gp.tileSize + 325);
                g.drawString(line5, x + gp.tileSize / 2, y + gp.tileSize + 350);

            case 2:
                g.drawString(line6, x+gp.tileSize/2, y+gp.tileSize+125);
        }

        /*
        g.drawString(line5, x+gp.tileSize/2, y+gp.tileSize+100);
        g.drawString(line6, x+gp.tileSize/2, y+gp.tileSize+125);
        g.drawString(line7, x+gp.tileSize/2, y+gp.tileSize+150);

         */


    }

}
