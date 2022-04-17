package core;

import javax.swing.JFrame;

public class Main {

    
	public static void main(String[] args) {

        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Proggy Gonzales");
        
        GamePanel gamePanel = new GamePanel("/maps/gameMap.txt"); // må endres når vi lager nytt map
        window.add(gamePanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
        
    }

}
