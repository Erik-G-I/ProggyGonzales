package tileTest;

import core.GamePanel;
import core.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tile.TileLoader;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderTest {

    final GamePanel gp = new GamePanel("/maps/testingMap.txt");
    TileLoader loader;
    final InputStream is = getClass().getResourceAsStream("/maps/testingMap.txt");

    @BeforeEach
    void beforeEach() {
        this.loader = new TileLoader(gp, is);
        loader.loadMap();
    }

    
    @Test
    public void testLoadTile() {
        assertEquals(1, loader.numOfTiles[0][7]);
    }

    
    @Test
    public void testPlayerCannotGoThroughTile() {
        KeyHandler keyH = new KeyHandler(gp);
    
        int startPos = gp.player1.worldY;
        keyH.upPressed1 = true;
        gp.player1.update();
        gp.player1.jumpP1();

        assertFalse(gp.player1.worldY < (startPos-gp.tileSize), "Proggy should not be able to go through tiles");
    }
}

