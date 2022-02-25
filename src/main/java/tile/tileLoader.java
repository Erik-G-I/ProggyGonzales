package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GamePanel;

public class tileLoader extends Tile{

	Tile[] tiles;
	Tile[][] loadedMap;
	int numOfTiles = 2; //må oppdateres til antall tiles i spillet + transparent tile
	
	public tileLoader(GamePanel gp) {
		super(gp);
		
		this.tiles = new Tile[numOfTiles];
		this.loadedMap = new Tile[gp.maxScreenRow][gp.maxScreenCol];
		
		getTileImage();
	}


	
	public void getTileImage() {
		
		try {
			
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/transparent.png"));
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_gray.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		int xCord = 0;
		int yCord = 0;
		
		//tegn alle tiles
		for(Tile[] i: loadedMap) {
			for(Tile j: i) {
				g2.drawImage(j.image, xCord, yCord, gp.tileSize, gp.tileSize, null);
			}
		}
		
	}
	
}
