package gameState;

import core.GamePanel;

import java.awt.*;

public class GameWon extends GameScreen {

    int widthOfScreen;

    public GameWon(GamePanel gp) {
        this.gp = gp;
        widthOfScreen = gp.screenWidth;
    }

    @Override
    public void draw(Graphics g2) {
        this.setGp(gp);
        this.setGraphics(g2);

        String text;

        Color transparent = new Color(0, 0, 0, 200);
        g2.setColor(transparent);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        text = "Proggy made it";
        g2.setColor(Color.BLACK);
        g2.drawString(text, centerText(text), gp.tileSize*3);
        g2.setColor(Color.RED);
        g2.drawString(text, centerText(text), gp.tileSize*3+10);

        text = "in time!";
        g2.setColor(Color.BLACK);
        g2.drawString(text, centerText(text), gp.tileSize*5);
        g2.setColor(Color.RED);
        g2.drawString(text, centerText(text), gp.tileSize*5+10);

        g2.setColor(Color.WHITE);
        this.draw(100);
        text = "Play again?";
        g2.drawString(text, centerText(text), gp.tileSize*7);

        g2.setColor(Color.WHITE);
        String yes = "yes";
        g2.drawString(yes, widthOfScreen / 5, 500);
        if (cmd == 1) {
            g2.drawString(">", widthOfScreen / 5 - 40, 500);
        }

        g2.setColor(Color.WHITE);
        String no = "no";
        g2.drawString(no, widthOfScreen / 2 + 200, 500);
        if (cmd == 2) {
            g2.drawString(">", widthOfScreen / 2 + 160, 500);
        }
    }
}
