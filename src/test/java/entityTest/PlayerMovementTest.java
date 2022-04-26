package entityTest;

import core.GameKeyHandler;
import entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.GamePanel;
import entity.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerMovementTest {

	GamePanel gp = new GamePanel(false);
	GameKeyHandler keyH = new GameKeyHandler(gp);
	Player p;
	int startPos;
	Score score;

	@BeforeEach
	void beforeEach() {
		this.p = new Player(gp, keyH);
		p.setDefaultValues();
	}

	@Test
	public void testMoveRigtht() {
		startPos = p.worldX;
		keyH.rightPressed = true;
		p.update();

		assertEquals(startPos+p.speed, p.worldX);
	}


	@Test
	public void testMoveLeft() {
		startPos = p.worldX;
		keyH.leftPressed = true;
		p.update();

		assertEquals(startPos-p.speed, p.worldX);
	}

	@Test
	public void testPlayerJump() {
		startPos = p.worldY;
		keyH.upPressed = true;
		p.update();
		p.jump();

		assertTrue(p.worldY < startPos, "Proggy did not jump");
		assertTrue(p.worldY > 0, "Proggy jumped out of the frame");
	}

	


}
