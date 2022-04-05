package gameOver;

import core.GamePanel;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StartMenu extends JComponent {

    GamePanel gp;
    Font font;
    BufferedImage img;

    public int commandNum = 0;



    public StartMenu(GamePanel gp) {
        this.gp = gp;

        /*
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(buttons);
        //frame.setMinimumSize(new Dimension(400, 400));
        //frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setVisible(true);
        frame.setLayout(null);
         */
    }


    public void draw(Graphics g) {
        Color transparentRed = new Color(0, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
        g.setColor(transparentRed);
        g.fillRect(0, 0, gp.screenWidth, gp.screenHeight);


        // Title
        Font titleFont = new Font("Times New Roman",Font.BOLD,90);
        g.setFont(titleFont);
        g.setColor(Color.BLACK);
        g.drawString("Proggy Gonzales", gp.screenWidth/5-5,gp.tileSize*4);
        g.setColor(Color.WHITE);
        g.drawString("Proggy Gonzales", gp.screenWidth/5,gp.tileSize*4);

        // Menu
        Font menuFont = new Font("Times New Roman",Font.PLAIN,50);
        g.setFont(menuFont);
        g.setColor(Color.WHITE);
        g.drawString("Play game", gp.screenWidth/5,gp.tileSize*6);
        if (commandNum == 0) {
            g.drawString(">", gp.screenWidth/5-gp.tileSize,gp.tileSize*6);
        }

        g.drawString("About", gp.screenWidth/5,gp.tileSize*7);
        if (commandNum == 1) {
            g.drawString(">", gp.screenWidth/5-gp.tileSize,gp.tileSize*7);
        }

        g.drawString("Quit", gp.screenWidth/5,gp.tileSize*8);
        if (commandNum == 2) {
            g.drawString(">", gp.screenWidth/5-gp.tileSize,gp.tileSize*8);
        }



    }

}
