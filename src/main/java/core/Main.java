package core;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    
	public static void main(String[] args) {

	    Game game = new Game();
	    game.gameLoop();
	    /*
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setLayout(null);
        //window.setBounds(100, 0, 1024, 768);
        window.setResizable(false);
        window.setTitle("Proggy Gonzales");

        MenuPanel menuPanel = new MenuPanel();
        window.add(menuPanel);

        window.pack();

	     */

        //menuPanel.startGameThread();
        /*
        window.remove(menuPanel);
        GamePanel gamePanel = new GamePanel("/maps/gameMap.txt", false); // må endres når vi lager nytt map
        window.add(gamePanel);
        gamePanel.setBounds(0,12,1024, 750);
        gamePanel.startGameThread();
        gamePanel.playMusic(8);

         */

        /*
        if (gamePanel.gameState == GameState.START_MENU) {
            System.out.println("hei");
            Container con = window.getContentPane();
            con.removeAll();
            multiplePanels(window);
        }

         */
        
        //window.pack();
        /*
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        menuPanel.startGameThread();

         */

        //gamePanel.playMusic(8);


    }

    /*
    private static JFrame multiplePanels(JFrame frame) {
	        Border border = BorderFactory.createLineBorder(Color.BLACK);
	        Container con = frame.getContentPane();

	        GamePanel panel1 = new GamePanel(false);
	        GamePanel panel2 = new GamePanel(false);

	        panel1.setLayout(null);
	        panel2.setLayout(null);

	        panel1.setBounds(0,12,1024, 366);
            panel2.setBounds(0,390,1024, 366);

            panel1.setBorder(border);
            panel2.setBorder(border);

            con.add(panel1);
            con.add(panel2);

            //panel1.startGameThread();
            //panel2.startGameThread();

	        return frame;
    }
    
     */

}
