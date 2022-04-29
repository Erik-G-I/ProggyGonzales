package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;

public class MultiplayerMenu extends GameScreen {

	private BufferedImage img1, img2;
	
    public MultiplayerMenu(GamePanel gp) {
        this.gp = gp;
		try {
			img1 = ImageIO.read(getClass().getResourceAsStream("/background/1player.png"));
			img2 = ImageIO.read(getClass().getResourceAsStream("/background/2players.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
        
        if (gp.multiMenu.cmd == 0) {
        	 g2.drawImage(img1, 0, 0, gp.screenWidth, gp.screenHeight, null);
        }
        else if (gp.multiMenu.cmd == 1) {
        	g2.drawImage(img2, 0, 0, gp.screenWidth, gp.screenHeight, null);
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
