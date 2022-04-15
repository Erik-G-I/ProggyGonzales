package tile;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import entity.Player;

import javax.imageio.ImageIO;

import core.GamePanel;

public class TileLoader {
	
	GamePanel gp;
	public Tile[] tiles;
	Tile[][] loadedMap;
	public int numOfTiles[][];

	InputStream is;
	int mapCols;
	int mapRows;
	
	
	public TileLoader(GamePanel gp, InputStream is) {
		// lag variabler som tar utgangspunkt i input stream sin size
		this.mapCols = 64;
		this.mapRows = 16;
		this.gp = gp;
		this.tiles = new Tile[20];
		this.numOfTiles = new int[64][16];
		this.is = is;
		
		getTileImage();
		loadMap();
	}


	public void loadMap() {
		BufferedReader reader;
		
		try {

			reader = new BufferedReader(new InputStreamReader(is));
			int row = 0;

			while(row < mapRows) {
				String line = reader.readLine();
				String[] lineArr = line.split(" ");

				for (int col = 0; col < lineArr.length; col++) {
					int num = Integer.parseInt(lineArr[col]);
					numOfTiles[col][row] = num;
					
				}
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
			// We want gray bricks to be categorized as a solid block
			tiles[1].collission = true;
			
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_red.png"));
			// We want red bricks to be categorized as a solid block

			tiles[2].collission = true;

			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			// We want grass to be categorized as a solid block

			tiles[3].collission = true;


			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt.png"));
			// We want dirt to be categorized as a solid block
			tiles[4].collission = true;
			
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_left.png"));
			// We want grass corners to be categorized as a solid block
			tiles[5].collission = true;
			
			tiles[6] = new Tile();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_right.png"));
			tiles[6].collission = true;

			tiles[7] = new Tile();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/graphics/100kr.png"));

			tiles[8] = new Tile();
			tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/graphics/200kr.png"));
			
			tiles[9] = new Tile();
			tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/enemies/uteligger.png"));
			
			tiles[10] = new Tile();
			tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/enemies/uteliggerglad.png"));
			
			tiles[11] = new Tile();
			tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/graphics/goldshoes_powerup.png"));

			tiles[12] = new Tile();
			tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/graphics/mask_powerup.png"));
			
			tiles[13] = new Tile();
			tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/graphics/start flagg.png"));

			tiles[14] = new Tile();
			tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/graphics/Voi.png"));



		} catch (Exception e) {
		}
		
	}
	
	
	public void draw(Graphics2D g2, int x) {
		
		int worldCol = 0; //x/gp.maxWorldCol;
		int bufferCol = 64;//worldCol + 16;
		
		int worldRow = 0;
		
		
		while(worldCol < bufferCol && worldRow < gp.maxWorldRow) {
			int tileNum = numOfTiles[worldCol][worldRow];
			
			int WorldX = worldCol * gp.tileSize;
			int WorldY = worldRow * gp.tileSize;
			int screenX = WorldX - gp.player.worldX + gp.player.playerX;
			int screenY = WorldY - gp.player.worldY + gp.player.playerY;
			
			
			g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			if(gp.player.playerX == tiles[5].x) {
				if(gp.player.playerY == tiles[5].y) {
					tiles[5] = tiles[0];
				}
			}
			g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
			worldCol ++;

			if(worldCol == bufferCol) {
				worldCol = 0;
				bufferCol ++;
				if(bufferCol >= 63) {
					bufferCol = 63;
				}
				worldRow  ++;
			}
		}
	}

}
