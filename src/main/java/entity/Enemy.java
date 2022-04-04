package entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import core.GamePanel;
import tile.TileLoader;
import tile.Tile;

public class Enemy  {
	
	GamePanel gp;
	TileLoader tileLoader;
	public Tile[] enemy;
	Tile[][] loadedMap;
	public int numOfEnemies[][];
	InputStream is;
	int mapCols;
	int mapRows;

	public Enemy(TileLoader tileLoader, InputStream is) {
		// lag variable som tar utgangspunkt i input stream sin size
		this.mapCols = 64;
		this.mapRows = 12;
		this.tileLoader = tileLoader;
		//this.enemy = new Tile[20];
		//this.numOfEnemies = new int[64][12];
		this.is = is;
		
		getEnemyImage();
				
	}
	
	


	public void getEnemyImage() {
		
		try {
			enemy[9] = new Tile();
			enemy[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Attack.png"));
			
			enemy[10] = new Tile();
			enemy[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Dead.png"));


		} catch (Exception e) {
		}
	}
	
	

}
