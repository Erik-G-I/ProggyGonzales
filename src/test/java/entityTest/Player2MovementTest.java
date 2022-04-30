package entityTest;

import core.GamePanel;
import core.KeyHandler;
import entity.Score;
import entity.player.Player2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Player2MovementTest {

    final GamePanel gp = new GamePanel("/maps/testingMap.txt");
    final KeyHandler keyH = new KeyHandler(gp);
    Player2 p;
    int startPos;
    Score score;

    @BeforeEach
    void beforeEach() {
        this.p = new Player2(gp, keyH);
        p.setDefaultValues();
    }

    @Test
    public void testMoveRigtht() {
        startPos = p.worldX;
        keyH.rightPressed2 = true;
        p.update();

        assertEquals(startPos+p.speed, p.worldX);
    }


    @Test
    public void testMoveLeft() {
        startPos = p.worldX;
        keyH.leftPressed2 = true;
        p.update();

        assertEquals(startPos-p.speed, p.worldX);
    }

    @Test
    public void testPlayerJump() {
        startPos = p.worldY;
        keyH.upPressed2 = true;
        p.update();
        p.jumpP2();

        assertTrue(p.worldY < startPos, "Proggy did not jump");
        assertTrue(p.worldY > 0, "Proggy jumped out of the frame");
    }

}

