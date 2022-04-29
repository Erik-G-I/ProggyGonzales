package gameState;

import core.DisplayText;
import core.GamePanel;
import java.awt.*;

/**
 * This is an abstract super class for the different gameScreens
 */
public abstract class GameScreen extends DisplayText {

    GamePanel gp;
    public int cmd = 0;

    /**
     * Method to draw the screen based on which state the game is in
     * @param g2
     */
    public abstract void draw(Graphics g2);

}
