package tileTest;

import core.GameKeyHandler;
import core.GamePanel;
import entity.Player;
import entity.Score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    GamePanel gp = new GamePanel(false);
    GameKeyHandler keyH = new GameKeyHandler(gp);
    InputStream is = getClass().getResourceAsStream("/maps/testingMap.txt");
    Player p;
    Score score;
    @BeforeEach
    void beforeEach() {
    	this.p = new Player(gp, keyH);
        p.setDefaultValues();
    }

    @Test
    void testMoneyDisappears() {
    	score = new Score(gp);
		int money = gp.collisionChecker.coins;
		
        for(int i = 0; i < 5; i++) {
            keyH.rightPressed = true;
            p.update();
        }
        int newMoney = gp.collisionChecker.coins;
        assertEquals(0, gp.loader.numOfTiles[1][8]);
        assertEquals(10, newMoney, "Coin did not disappear when Proggy tried to pick it up");
    }
    
    
    @Test
    void testScoreIncreases() {
        
        for(int i = 0; i < 5; i++) {
            keyH.rightPressed = true;
            p.update();
        }
        assertEquals( 10, gp.collisionChecker.coins);
    }
}

