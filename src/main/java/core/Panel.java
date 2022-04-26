package core;

import gameState.*;
import sound.Sound;

import javax.swing.*;

public abstract class Panel extends JPanel {


    private static final long serialVersionUID = 1L;
    // Screen settings
    final int originalTileSize = 32; // 32x32 tiles
    final int scale = 2;

    public int tileSize = originalTileSize * scale; // 64
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol;     // ...px
    public int screenHeight = tileSize * maxScreenRow;    // ...px

    //audio
    protected Sound music = new Sound();
    protected Sound soundEffect = new Sound();

    //Game Thread
    protected Thread gameThread;

    //Game State
    public GameState gameState;

    protected Languages lang;


    public Languages getLang() {
        return lang;
    }

    public void setLang(Languages lang) {
        this.lang = lang;
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSoundEffect(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }


}
