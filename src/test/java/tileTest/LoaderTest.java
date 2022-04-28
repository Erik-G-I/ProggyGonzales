package tileTest;

import core.GamePanel;
import core.KeyHandler;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tile.TileLoader;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderTest {

    GamePanel gp = new GamePanel("/maps/testingMap.txt");
    TileLoader loader;
    InputStream is = getClass().getResourceAsStream("/maps/testingMap.txt");

    @BeforeEach
    void beforeEach() {
        this.loader = new TileLoader(gp, is);
        loader.loadMap();
    }

    
    @Test
    public void testLoadTile() {
        assertTrue(loader.numOfTiles[0][7] == 1);
    }

    
    @Test
    public void testPlayerCannotGoThroughTile() {
        KeyHandler keyH = new KeyHandler(gp);
    
        int startPos = gp.player.worldY;
        keyH.upPressed = true;
        gp.player.update();
        gp.player.jump();

        assertFalse(gp.player.worldY < (startPos-gp.tileSize), "Proggy should not be able to go through tiles");
    }
}

