package tileTest;

import core.GameKeyHandler;
import core.GamePanel;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tile.TileLoader;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderTest {

    GamePanel gp = new GamePanel(false);
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
        GameKeyHandler keyH = new GameKeyHandler(gp);

        Player p = new Player(gp, keyH);
        p.setDefaultValues();

        int startPos = p.worldY;
        keyH.upPressed = true;
        p.update();
        p.jump();

        assertFalse(p.worldY < (startPos-gp.tileSize), "Proggy should not be able to go through tiles");
    }
}

