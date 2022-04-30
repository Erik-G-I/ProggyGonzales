package entityTest;

import core.GamePanel;
import core.KeyHandler;
import entity.Score;
import entity.enemies.EntityEnemy;
import entity.player.Player2;
import entity.player.PlayerState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Player2ItemsTest {

    final GamePanel gp = new GamePanel("/maps/testingMap.txt");
    final KeyHandler keyH = new KeyHandler(gp);
    Player2 p;
    EntityEnemy[] unicef;
    int startPos;
    Score score;

    @BeforeEach
    void beforeEach() {
        this.p = new Player2(gp, keyH);
        p.setDefaultValues();
    }

    @Test
    public void testSpeedBoost() {
        int normalSpeed = p.speed;
        //moves player to the right, and picks up speed boost
        for (int i = 0; i < 20; i++) {
            keyH.rightPressed2 = true;
            p.update();
        }

        int newSpeed = p.speed;
        assertTrue(newSpeed > normalSpeed);
        assertEquals(newSpeed, 7);
    }

    @Test
    public void testInvisible() {
        gp.collisionChecker2.setCoins(100);
        int money = gp.collisionChecker2.getCoins();

        for(int i = 0; i < 40; i++) {
            keyH.rightPressed2 = true;
            p.update();
        }
        int newMoney = gp.collisionChecker2.getCoins(); // lagrer nye verdien til pengene

        assertEquals(newMoney, money + 10 - 15); // tar +10 -15 fordi player plukker opp 10kr, går så forbi en fiende, også plukker opp maske før neste fiende. Player skal altså bare miste 15kr fra første fiende
    }

    @Test
    public void testPlayerCanPickUp() {
        for(int i = 0; i < 40; i++) {
            keyH.rightPressed2 = true;
            p.update();
        }
        assertNotSame(p.playerState, PlayerState.NORMAL);
    }

    @Test
    public void testPlayerCanPickUpMoney() {
        score = new Score(gp);
        int money = gp.collisionChecker2.getCoins();

        //moves player to the right, and picks up money
        for(int i = 0; i < 5; i++) {
            keyH.rightPressed2 = true;
            p.update();
        }


        int newScore = money + 10;

        assertEquals(0, gp.loader.numOfTiles[8][1]);
        assertEquals(newScore, gp.collisionChecker2.getCoins());
    }


    @Test
    public void playerLosesMoneyHomeless() {
        gp.collisionChecker2.setCoins(100);
        int money = gp.collisionChecker2.getCoins();

        for (int i = 0; i < 20; i++) {
            keyH.rightPressed2 = true;
            p.update();
        }

        int newScore = gp.collisionChecker2.getCoins();

        assertTrue(newScore < money);
        assertEquals(newScore, money + 10 - 15);
    }

    @Test
    public void playerLosesMoneyUnicef() {
        gp.collisionChecker2.setCoins(100);
        int money = gp.collisionChecker2.getCoins();
        int newScore = 0;

        for (int i = 0; i < 20; i++) {
            if(gp.collisionChecker2.takenMoney) {
                unicef[i].update();
                newScore = gp.collisionChecker2.getCoins();
            }

        }

        assertTrue(newScore < money);

    }
}

