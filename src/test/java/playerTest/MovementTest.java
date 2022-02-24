package playerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	
}
