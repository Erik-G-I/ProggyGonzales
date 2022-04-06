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
        String text;

        //Back and next buttons
        this.draw(40);
        text = "Back";
        g.drawString(text, x + gp.tileSize, y + height-40);
        if (c == 1)
            g.drawString(">", x + gp.tileSize/2, y + height-40);

        text = "Next";
        g.drawString(text, x + width-(gp.tileSize+32), y + height-40);
        if (c == 2)
            g.drawString(">", x + width-(2*gp.tileSize), y + height-40);
    }

}
