package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import core.GamePanel;

public class TileLoader {

	GamePanel gp;
	Tile[] tiles;
	Tile[][] loadedMap;
	int numOfTiles = 2; //må oppdateres til antall tiles i spillet + transparent tile
	
	public TileLoader(GamePanel gp) {
		this.gp = gp;
		this.tiles = new Tile[numOfTiles];
		this.loadedMap = new Tile[gp.maxScreenRow][gp.maxScreenCol];
		
		getTileImage();
		loadMap();
	}

	private void loadMap() {
		BufferedReader reader;
		InputStream is = getClass().getResourceAsStream("/maps/testmap.txt");
		try {
			
			reader = new BufferedReader(new InputStreamReader(is));
			int row = 0;
			int col = 0;
			while(row < gp.maxScreenRow) {
				String line = reader.readLine();
				String[] lineArr = line.split(" ");
				while(col < gp.maxScreenCol) {
					loadedMap[row][col] = tiles[Integer.parseInt(lineArr[col])];
					col++;
				}
				col=0;
				row++;
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void getTileImage() {
		
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/transparent.png"));
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_gray.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void draw(Graphics2D g2) {
		
		int xCord = 0;
		int yCord = -gp.tileSize;
		
		//tegn alle tiles
		for(Tile[] i: loadedMap) {
			xCord = 0;
			yCord += gp.tileSize;
			for(Tile j: i) {
				g2.drawImage(j.image, xCord, yCord, gp.tileSize, gp.tileSize, null);
				xCord += gp.tileSize;
			}
		}
		
	}
	
}
