package playerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import core.GamePanel;
import core.KeyHandler;
import entity.Player;

public class MovementTest {

	GamePanel gp = new GamePanel();
	KeyHandler keyH = new KeyHandler();
	
	@Test
	public void testMoveRigtht() {
		Player p = new Player(gp, keyH);
		
		
		p.setDefaultValues();
		int startPos = p.x;
		keyH.rightPressed = true;
		p.update();
		
		assertEquals(startPos+p.speed, p.x);
	}
	
	
	@Test
	public void testMoveLeft() {
		Player p = new Player(gp, keyH);
		
		
		p.setDefaultValues();
		int startPos = p.x;
		keyH.leftPressed = true;
		p.update();
		
		assertEquals(startPos-p.speed, p.x);
	}
	
	@Test
	public void testSpeedBoost() {
		//TODO:
		//fullfør testen når vi implementerer gullsko
		assertFalse(true);
	}
	
	@Test
	public void testInvisible() {
		//TODO:
		//fullfør testen når vi implementerer munnbind
		assertFalse(true);
	}
	
	
}
