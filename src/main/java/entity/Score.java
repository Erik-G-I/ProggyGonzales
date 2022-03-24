package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import core.GamePanel;

public class Score {

    private Font timeFont;
    private String showScore;
    GamePanel gp;


    public Score(GamePanel gp) {
        this.gp = gp;
        timeFont = new Font("Times New Roman",Font.BOLD,40);
        showScore = new String();
    }

    public void showScore() {
        showScore = "Proggys ølpenger: " + gp.collisionChecker.coins;
    }

    public void draw(Graphics g2) {
        g2.setFont(timeFont);
        g2.setColor(Color.BLACK);
        g2.drawString(showScore, gp.maxWorldRow/2,54);
    }
}



