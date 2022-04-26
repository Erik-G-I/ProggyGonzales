package gameState;

import core.DisplayText;
import core.Panel;
import java.awt.*;

public abstract class GameScreen extends DisplayText {

    Panel gp;
    public int cmd = 0;

    public abstract void draw(Graphics g2);

}
