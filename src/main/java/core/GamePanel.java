package core;

import entity.Background;
import entity.Player;
import entity.PlayerState;
import entity.Score;
import gameState.GameOver;
import gameState.GameState;
import gameState.WinScreen;
import tile.TileLoader;
import timer.TimerDisplay;

import java.io.InputStream;

public class GamePanel {

    //World settings
    public final int maxWorldCol = 16;
    public final int maxWorldRow = 16;
    public final int worldWidth;
    public final int worldHeight;

    public Panel panel;
    public PlayerState playerState;

    //Map
    public InputStream is;
    String mapPath;

    //CollisionCheck
    public CollisionCheck collisionChecker;

    //KeyHandler keyH;

    public Player player;
    public Background bg;
    public TileLoader loader;

    //Score
    public Score score;

    //Game Over if there is no time left
    public GameOver gO;

    public GamePanel(Panel panel, String mapPath) {
        this.panel = panel;

        worldWidth = panel.tileSize * maxWorldCol;
        worldHeight= panel.tileSize * maxWorldRow;
        this.mapPath = mapPath;
        setMap(mapPath);
        panel.gameState = GameState.RUNNING_GAME;
        loader = new TileLoader(this, is);
        bg = new Background(this, panel.keyH);
        playerState = PlayerState.NORMAL;
        player = new Player(this, panel.keyH);
        score = new Score(this);
        collisionChecker = new CollisionCheck(this);
    }

    public void setMap(String mapPath) {
        is = getClass().getResourceAsStream(mapPath);
    }

    public void resetLoader() {
        loader =  new TileLoader(this, is);
    }

    public boolean getGameOver() {
        boolean gameO = panel.getTimerDisplay().getTime().getGameOver();
        return gameO;
    }

    public boolean getOutOfBounds() {
        boolean out = collisionChecker.isOutOfBounds();
        return out;
    }

    // Will trigger a countdown of 10 seconds that makes the powerUp disappear when it ends
    public boolean pickedUpPowerUp() {
        if (collisionChecker.getPickedUpPowerUp() == true) {
            return true;
        }
        return false;
    }

    public void setPickedUpPowerUp(boolean pickedUpPowerUp) {
        this.collisionChecker.setPickedUpPowerUp(pickedUpPowerUp);
    }
    // Gets coins from CollisionChecker and is in this class so that it can be used in Time.java
    public int getCoinsInCollisionChecker() {
        return this.collisionChecker.getCoins();
    }
    // Calls on the method from CollisionChecker that reduces coins by 1 and is in this class so that it can be used in Time.java
    public void reduceCoinByOne() {
        this.collisionChecker.reduceCoins();
    }

    public void jump() {
        player.jump();
    }
    public void fall() {
        player.fall();
        for(int i = 0; i < unicef.length; i++) {
            if(unicef[i] != null) {
                unicef[i].fall();
            }
        }

    }


}
