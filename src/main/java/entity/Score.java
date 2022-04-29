package entity;

import java.awt.Color;
import java.awt.Graphics;
import core.DisplayText;
import core.GamePanel;
import gameState.Languages;

/**
 * Class to show score
 */
public class Score extends DisplayText{

    private String showScore;
    GamePanel gp;

    public Score(GamePanel gp) {
        this.gp = gp;
        showScore = new String();
    }

    /**
     * Method to show score on the screen based on which language the game is in
     */
    public void showScore() {
        int score = gp.coins;
        if(gp.getLang() == Languages.NORWEGIAN) {
            showScore = "Proggys ølpenger: " + score;
        }
        else {
            showScore = "Proggy's beer money: " + score;
        }
    }

    /**
     * Method to draw the score on the screen
     * @param g2 graphics
     */
    public void draw(Graphics g2) {
        this.setGraphics(g2);
        this.draw(40);
        g2.setColor(Color.BLACK);
        g2.drawString(showScore, gp.maxWorldRow/2,54);
    }
}




