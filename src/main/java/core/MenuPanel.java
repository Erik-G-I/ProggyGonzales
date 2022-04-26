package core;

import entity.PlayerState;
import gameState.*;
import sound.Sound;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends Panel implements Runnable {

    MenuKeyHandler keyH = new MenuKeyHandler(this);
    //GameKeyHandler gameKey;

    public GameState gameState;

    //Start menu
    public StartMenu menu;

    //Info screen
    public InfoScreen info;

    //Levels menu
    public LevelsMenu levels;

    //Show controls
    public GameControls ctrls;

    public LanguageScreen lS;

    public final GamePanel gamePanel;

    public JFrame frame;

    public MenuPanel(JFrame frame) {
        this.frame = frame;
        //this.maxScreenRow = 12;
        this.setPreferredSize(new Dimension(screenWidth, this.tileSize*12));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        this.frame.add(this);
        gameState = GameState.LANGUAGE_MENU;

        //get the language chosen by player
        lang = getLang();

        menu = new StartMenu(this);
        info = new InfoScreen(this);
        lS = new LanguageScreen(this);
        ctrls = new GameControls(this);
        levels = new LevelsMenu(this);
        gamePanel = new GamePanel(false, this);
        //gameKey = new GameKeyHandler(gamePanel);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        if (gameState != GameState.RUNNING_GAME) {
            lS.update();
        } else {
            gamePanel.update();
        }
        /*
        else {
            this.removeKeyListener(keyH);
            frame.remove(this);
            revalidate();
            repaint();

            JPanel p = new JPanel();
            p.setLayout(null);
            p.setBackground(Color.cyan);
            p.setBounds(100, 100, tileSize, tileSize);


            frame.add(gamePanel);
            this.frame.pack();
            this.frame.setVisible(true);
            gamePanel.startGameThread();
            selectingMapPath("/maps/easy.txt");
            System.out.println("Hei");
        }

         */
    }

    @Override
    public void run() {
        int FPS = 60;
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // 1: oppdaterer informasjon, som spillerens posisjon
                update();
                // 2: tegner skjermen på nytt med oppdatert informasjon
                repaint();
                gamePanel.fall();
                repaint();
                gamePanel.jump();
                repaint();

                delta--;
                drawCount++;
            }

            //display FPS in console
            if (timer >= 1000000000) {
//                System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        /*
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);

         */

        if (gameState == GameState.LANGUAGE_MENU) {
            //System.out.println("hei");
            lS.draw(g2);
        } else if (gameState == GameState.START_MENU) {
            System.out.println("hei");
            menu.draw(g2);
        }else if (gameState == GameState.INFO_SCREEN)
            info.draw(g2);
        else if (gameState == GameState.GAME_CONTROLS)
            ctrls.draw(g2);
        else if (gameState == GameState.LEVELS_MENU)
            levels.draw(g2);
        else if (gameState == GameState.RUNNING_GAME) {
            this.removeKeyListener(keyH);
            frame.remove(this);
            revalidate();
            repaint();
            frame.add(gamePanel);
            this.frame.pack();
            this.frame.setVisible(true);
            gamePanel.addKeyListener(gamePanel.keyH);
            gamePanel.startGameThread();
            selectingMapPath("/maps/easy.txt");
            }
        g2.dispose();
    }

    /**
     * This method is to avoid writing duplicate code for all levels
     * @param mapPath
     */
    public void selectingMapPath(String mapPath) {
        keyH.mapPath = mapPath;
        gamePanel.playSoundEffect(0);
        gamePanel.setMap(mapPath);
        gamePanel.resetLoader();
        gamePanel.setGame();
        gameState = GameState.RUNNING_GAME;
        gamePanel.startTimer();
    }


}



