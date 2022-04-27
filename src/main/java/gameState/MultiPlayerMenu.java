package gameState;

import core.GamePanel;

import java.awt.*;

public class MultiPlayerMenu extends GameScreen {

    public MultiPlayerMenu(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void draw(Graphics g2) {
        this.setGp(gp);
        this.setGraphics(g2);

        String oneP, twoP, esc;

        if (gp.getLang() == Languages.NORWEGIAN) {
            oneP = "En spiller";
            twoP = "To spillere";
            esc = "ESC - Tilbake til nivåmeny";
        }
        else {
            oneP = "One player";
            twoP = "Two players";
            esc = "ESC - Back to levels menu";
        }

        Color tranparent = new Color(0, 0, 0, 200);
        g2.setColor(tranparent);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setColor(Color.WHITE);
        this.draw(75);
        g2.drawString(oneP, centerText(oneP), gp.tileSize*4);
        if (cmd == 0) {
            g2.drawString(">", centerText(oneP)-gp.tileSize, gp.tileSize*4);
        }

        g2.setColor(Color.WHITE);
        g2.drawString(twoP, centerText(twoP), gp.tileSize*7);
        if (cmd == 1) {
            g2.drawString(">", centerText(twoP)-gp.tileSize, gp.tileSize*7);
        }

        this.draw(40);
        g2.drawString(esc, centerText(esc), gp.tileSize*9);
    }
}
