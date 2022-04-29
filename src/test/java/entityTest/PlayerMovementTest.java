package entityTest;

import entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.GamePanel;
import core.KeyHandler;
import entity.player.Player1;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerMovementTest {

	GamePanel gp = new GamePanel("/maps/testingMap.txt");
	KeyHandler keyH = new KeyHandler(gp);
	Player1 p;
	int startPos;
	Score score;

	@BeforeEach
	void beforeEach() {
		this.p = new Player1(gp, keyH);
		p.setDefaultValues();
	}

	@Test
	public void testMoveRigtht() {
		startPos = p.worldX;
		keyH.rightPressed1 = true;
		p.update();

		assertEquals(startPos+p.speed, p.worldX);
	}


	@Test
	public void testMoveLeft() {
		startPos = p.worldX;
		keyH.leftPressed1 = true;
		p.update();

		assertEquals(startPos-p.speed, p.worldX);
	}

	@Test
	public void testPlayerJump() {
		startPos = p.worldY;
		keyH.upPressed1 = true;
		p.update();
		p.jumpP1();

		assertTrue(p.worldY < startPos, "Proggy did not jump");
		assertTrue(p.worldY > 0, "Proggy jumped out of the frame");
	}

	


}
