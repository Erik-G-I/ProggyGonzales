package gameOverTest;

import core.GamePanel;
import core.KeyHandler;
import entity.player.Player1;
import gameState.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOverTest {

	GamePanel gp;
	KeyHandler keyH;
	Player1 p;

	@BeforeEach
	void beforeEach() {
		gp = new GamePanel("/maps/testingMap.txt");
		keyH = new KeyHandler(gp);
		p = new Player1(gp, keyH);
		p.setDefaultValues();
		gp.gameState = GameState.RUNNING_GAME;
	}

	@Test
	public void testGameOverOutOfBounds() {
		for (int i = 0; i < 10000; i++) {
			keyH.rightPressed1 = true;
			p.update();
		}
		assertTrue(p.collisionChecker.isOutOfBounds());
	}
}

