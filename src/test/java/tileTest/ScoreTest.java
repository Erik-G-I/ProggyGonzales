package tileTest;

import core.GamePanel;
import core.KeyHandler;
import entity.player.Player;
import entity.Score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    GamePanel gp = new GamePanel("/maps/testingMap.txt");
    KeyHandler keyH = new KeyHandler(gp);
    InputStream is = getClass().getResourceAsStream("/maps/testingMap.txt");
    Player p;
    Score score;
    @BeforeEach
    void beforeEach() {
    	this.p = new Player(gp, keyH);
        //p.setDefaultValues();
    }

    @Test
    void testMoneyDisappears() {
    	score = new Score(gp);
		int money = gp.collisionChecker1.getCoins();
		
        for(int i = 0; i < 5; i++) {
            keyH.rightPressed1 = true;
            p.update();
        }
        int newMoney = gp.collisionChecker1.getCoins();
        assertEquals(0, gp.loader.numOfTiles[1][8]);
        assertEquals(10, newMoney, "Coin did not disappear when Proggy tried to pick it up");
    }
    
    
    @Test
    void testScoreIncreases() {
        
        for(int i = 0; i < 5; i++) {
            keyH.rightPressed1 = true;
            p.update();
        }
        assertEquals( 10, gp.collisionChecker1.getCoins());
    }
}

