package entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.GamePanel;
import core.KeyHandler;
import entity.Player;
import entity.Score;

public class PlayerItemsTest {

	GamePanel gp = new GamePanel();
	KeyHandler keyH = new KeyHandler();
	Player p;
	int startPos;
	Score score;

	@BeforeEach
	void beforeEach() {
		this.p = new Player(gp, keyH);
		p.setDefaultValues();
	}
	
	@Test
	public void testSpeedBoost() {
		//TODO:
		//fullfør testen når vi implementerer gullsko
		assertTrue(false);
	}

	@Test
	public void testInvisible() {
		//TODO:
		//fullfør testen når vi implementerer munnbind
		assertTrue(false);
	}

	@Test
	public void testPlayerCanPickUp() {
		//TODO: lage når vi implementerer gjenstander
	}

	@Test
	public void testPlayerCanPickUpMoney() {
		score = new Score(gp);
		keyH.rightPressed = true;
		p.update();
		int money = gp.collisionChecker.coins;
		int newScore = money + 50;

		assertTrue(gp.loader.numOfTiles[8][1] == 0);
		assertEquals(newScore, gp.collisionChecker.coins);
	}

	@Test
	public void testPlayerLoosesMoney() {
		//TODO: lage når vi implementerer fiender
	}

	@Test
	public void testPlayerLoosesTime() {
		//TODO: lage når vi implementerer fiender og tid
	}
}
