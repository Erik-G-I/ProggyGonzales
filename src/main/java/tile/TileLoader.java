package tile;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import core.GamePanel;

public class TileLoader {
	
	GamePanel gp;
	public Tile[] tiles;
	Tile[][] loadedMap;
	public int numOfTiles[][];
	InputStream is;
	
	
	public TileLoader(GamePanel gp, InputStream is) {
		
		this.gp = gp;
		this.tiles = new Tile[20];
		this.numOfTiles = new int[gp.maxWorldCol][gp.maxWorldRow];
		this.is = is;
		
		getTileImage();
		loadMap();
	}



	public void loadMap() {
		BufferedReader reader;
		//InputStream is = getClass().getResourceAsStream("/maps/testmap.txt");

		try {
			
			reader = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row = 0;
			
			while(row < gp.maxWorldRow) {
				String line = reader.readLine();
				String[] lineArr = line.split(" ");

				while(col < gp.maxWorldCol) {
					int num = Integer.parseInt(lineArr[col]);
					numOfTiles[col][row] = num;
					col++;
				}
					col = 0;
					row++;
				
			}
			reader.close();
		
		} catch(Exception e) {
			
		}
		
	}
	
	
	public void getTileImage() {
		
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/transparent.png"));
			
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_gray.png"));
			tiles[1].collission = true;
			
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_red.png"));
			tiles[2].collission = true;

			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tiles[3].collission = true;


			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt.png"));
			tiles[4].collission = true;

			
		} catch (Exception e) {
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = numOfTiles[worldCol][worldRow];
			
			int WorldX = worldCol * gp.tileSize;
			int WorldY = worldRow * gp.tileSize;
			int screenX = WorldX - gp.player.worldX + gp.player.playerX;
			int screenY = WorldY - gp.player.worldY + gp.player.playerY;
			
			g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
			worldCol ++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow  ++;
			}
		}
	}

}
