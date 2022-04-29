
package tile;

import java.awt.image.BufferedImage;

import core.GamePanel;

/**
 * Tile class
 * Stores x and y values for a tile,
 * as well as a buffered image
 *
 */
public class Tile {

	GamePanel gp;
	public BufferedImage image;
	public int x, y;

	// detects collission between character and tiles
	public boolean collission = false;

}
