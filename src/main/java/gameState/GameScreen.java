package gameState;

import core.DisplayText;
import core.GamePanel;
import core.Panel;

import java.awt.*;

public abstract class GameScreen extends DisplayText {

    Panel panel;
    public int cmd = 0;

    public abstract void draw(Graphics g2);

}
