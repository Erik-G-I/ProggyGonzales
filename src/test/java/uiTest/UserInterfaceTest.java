package uiTest;

import core.GamePanel;
import core.KeyHandler;
import gameState.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import timer.TimerDisplay;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInterfaceTest {

	GamePanel gp;
	KeyHandler keyH;
	
	@BeforeEach
	void beforeEach() {
		gp = new GamePanel("/maps/testingMap.txt");
		keyH = new KeyHandler(gp);
	}
	
	@Test
	public void timerDrawn() {
		// start game --> check that timer method is called
	}
	
	@Test
	public void startScreenDrawn() {
		//TODO: start game --> check that start screen method is called
	}
	
	@Test
	public void gameOverDrawn() {
		//TODO: timer runs out --> gameover method called
		gp.gameState = GameState.RUNNING_GAME;

		assertEquals(GameState.GAME_OVER, gp.gameState);

	}
}
