package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import core.KeyHandler;
import tile.Tile;
import core.CollisionCheck;
import core.CollisionChecker;

import javax.imageio.ImageIO;

//import core.CollisionCheck;
import core.GamePanel;
import core.KeyHandler;
import java.awt.Rectangle;
import entity.Entity;
import javax.swing.Timer;

import core.GamePanel;
import timer.Time;


public class Score {

	private Font timeFont;
	//public int coins;
	private String showScore;
    GamePanel gp;

    
    public Score(GamePanel gp) {
		this.gp = gp;
		timeFont = new Font("Times New Roman",Font.BOLD,40);
		//coins = 0;
		showScore = new String();
	}
    
    public void showScore() {
    	/*if(!gp.loader.tiles[5].collission) {
			coins = 50;
		}*/
    	showScore = "Proggys ølpenger: " + gp.collisionChecker.coins;
	}
    
    public void draw(Graphics g2) {
    	
		g2.setFont(timeFont);
		g2.setColor(Color.BLACK);
		g2.drawString(showScore, gp.maxWorldRow/2,54);
	}
}