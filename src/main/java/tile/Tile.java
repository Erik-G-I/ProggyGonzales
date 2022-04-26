
package tile;

import java.awt.image.BufferedImage;

import core.Panel;

public class Tile {

	Panel gp;
	public BufferedImage image;
	public int x, y;

	// detects collission between character and tiles
	public boolean collission = false;
	
	
	public Tile() {
		BufferedImage image = this.image;
		
	}
	
	
}
