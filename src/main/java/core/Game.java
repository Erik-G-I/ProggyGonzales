package core;

import gameState.GameState;

import javax.swing.*;
import java.awt.*;

public class Game {

    MenuPanel menuPanel;
    GamePanel gamePanel;
    String mapPath;

    JFrame window;

    public Game() {
        this.window = new JFrame();
        setWindow();
        this.menuPanel = new MenuPanel(window);
        //this.gamePanel = new GamePanel(false);
    }

    private void setWindow() {
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setResizable(false);
        this.window.setTitle("Proggy Gonzales");
    }

    public void gameLoop() {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.cyan);
        panel.setBounds(10,10,300,200);

        //Container c = this.window.getContentPane();

        //c.add(menuPanel);
        this.window.setLocationRelativeTo(null);
        /*
        window.add(gamePanel);
        gamePanel.startGameThread();
        selectingMapPath("/maps/easy.txt");

         */

        this.menuPanel.startGameThread();
        /*
        if (menuPanel.gameState == GameState.START_MENU) {
            System.out.println("Hei");

         */
            /*
            c.removeAll();
            c.validate();
            c.add(panel);

             */
            //c.add(gamePanel);
            //c.revalidate();
            //this.gamePanel.startGameThread();
            //selectingMapPath("/maps/easy.txt");
        //}
        this.window.pack();
        this.window.setVisible(true);
    }

}
