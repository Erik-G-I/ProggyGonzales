package tileTest;

import core.CollisionCheck;
import core.GamePanel;
import core.KeyHandler;
import entity.Entity;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tile.TileLoader;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    GamePanel gp = new GamePanel();
    TileLoader loader;
    InputStream is = getClass().getResourceAsStream("/maps/testingMap.txt");

    @BeforeEach
    void beforeEach() {
        this.loader = new TileLoader(gp, is);
        loader.loadMap();
    }

    @Test
    void testMoneyDisappears() {
        CollisionCheck check = new CollisionCheck(gp);
        KeyHandler keyH = new KeyHandler(gp);

        Player p = new Player(gp, keyH);
        p.setDefaultValues();

        while (p.worldX < 192) {
            keyH.rightPressed = true;
            p.update();
        }

        assertEquals(0, loader.numOfTiles[1][8]);
        assertEquals( 50, check.coins, "Coin did not disappear when Proggy tried to pick it up");
    }
}

