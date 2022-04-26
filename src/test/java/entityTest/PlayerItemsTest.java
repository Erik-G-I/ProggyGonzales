package entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.GameKeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.GamePanel;
import entity.Player;
import entity.Score;

public class PlayerItemsTest {

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
	public void testSpeedBoost() {
		int normalSpeed = p.speed;
		//moves player to the right, and picks up speed boost
		for (int i = 0; i < 20; i++) {
			keyH.rightPressed = true;
			p.update();
		}
		
		int newSpeed = p.speed;
		assertTrue(newSpeed > normalSpeed);
		assertEquals(newSpeed, 7);
	}

	@Test
	public void testInvisible() {
		gp.collisionChecker.coins = 100;
		int money = gp.collisionChecker.coins;
		
		for(int i = 0; i < 40; i++) {
			keyH.rightPressed = true;
			p.update();
		}
		int newMoney = gp.collisionChecker.coins; // lagrer nye verdien til pengene
		
		assertEquals(newMoney, money + 10 - 15); // tar +10 -15 fordi player plukker opp 10kr, går så forbi en fiende, også plukker opp maske før neste fiende. Player skal altså bare miste 15kr fra første fiende
	}

	@Test
	public void testPlayerCanPickUp() {
		//TODO: lage når vi implementerer gjenstander
	}

	@Test
	public void testPlayerCanPickUpMoney() {
		score = new Score(gp);
		int money = gp.collisionChecker.coins;
		
		//moves player to the right, and picks up money
		for(int i = 0; i < 5; i++) {
			keyH.rightPressed = true;
			p.update();
		}
		
		
		int newScore = money + 10;

		assertTrue(gp.loader.numOfTiles[8][1] == 0);
		assertEquals(newScore, gp.collisionChecker.coins);
	}

	@Test
	public void testPlayerLosesMoney() {
		//TODO: lage når vi implementerer fiender
		gp.collisionChecker.coins = 100;
		int money = gp.collisionChecker.coins;
		
		for (int i = 0; i < 20; i++) {
			keyH.rightPressed = true;
			p.update();
		}
		
		int newScore = gp.collisionChecker.coins;
		//player.loseMoney / enemy.attackPlayer
		
		assertTrue(newScore < money);
		assertEquals(newScore, money + 10 - 15);
	}
}
