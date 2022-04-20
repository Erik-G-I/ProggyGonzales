package gameState;

import core.DisplayText;
import core.GamePanel;

import java.awt.*;

public abstract class GameScreen extends DisplayText {

    GamePanel gp;
    public int cmd = 0;

    public abstract void draw(Graphics g2);
}
