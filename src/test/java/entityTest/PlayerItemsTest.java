package entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.GamePanel;
import core.KeyHandler;
import entity.Player;
import entity.Score;
import timer.Time;

public class PlayerItemsTest {

	GamePanel gp = new GamePanel();
	KeyHandler keyH = new KeyHandler(gp);
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
		int newScore = money + 100;

		assertTrue(gp.loader.numOfTiles[8][1] == 0);
		assertEquals(newScore, gp.collisionChecker.coins);
	}

	@Test
	public void testPlayerLosesMoney() {
		//TODO: lage når vi implementerer fiender
		gp.collisionChecker.coins = 100;
		int money = gp.collisionChecker.coins;
		int newScore = money - 100;
		//player.loseMoney / enemy.attackPlayer
		
		assertEquals(newScore, gp.collisionChecker.coins);
	}

	@Test
	public void testPlayerLosesTime() {
		//TODO: lage når vi implementerer fiender og tid
		Time time = new Time(10, 0, "");
		//timer.getTime trenger en metode i timer
		int originalTime = 0;
		//player.loseTime / enemy.attackPlayer
		int newTime = 0;
		assertTrue(originalTime > newTime);
	}
}
