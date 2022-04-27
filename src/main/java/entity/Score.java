package entity;

import java.awt.Color;
import java.awt.Graphics;
import core.DisplayText;
import core.GamePanel;
import gameState.Languages;


public class Score extends DisplayText{

    //public int coins;
    private String showScore;
    GamePanel gp;


    public Score(GamePanel gp) {
        this.gp = gp;
        showScore = new String();
    }

    public void showScore() {
        int score = gp.collisionChecker1.getCoins() + gp.collisionChecker2.getCoins();
    	if(gp.getLang() == Languages.NORWEGIAN) {
    		showScore = "Proggys ølpenger: " + score;
    	}
    	else {
    		showScore = "Proggy's beer money: " + score;
    	}
        
    }

    public void draw(Graphics g2) {
    	this.setGraphics(g2);
    	this.draw(40);
        g2.setColor(Color.BLACK);
        g2.drawString(showScore, gp.maxWorldRow/2,54);
    }
}



