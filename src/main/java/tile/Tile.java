package tile;

import java.awt.image.BufferedImage;

import core.GamePanel;

public class Tile {

	GamePanel gp;
	public BufferedImage image;
	public int x, y;
	
	
	public Tile(GamePanel gp) {
		BufferedImage image = this.image;
		this.gp = gp;
		
	}
	
	
}
