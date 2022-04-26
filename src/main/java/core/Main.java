package core;

import javax.swing.JFrame;

public class Main {

    
	public static void main(String[] args) {

        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Proggy Gonzales");
        
        Panel panel = new Panel("/maps/gameMap.txt"); // må endres når vi lager nytt map
        ReadFromFile reader = new ReadFromFile();
        
        window.add(panel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        panel.startGameThread();
        panel.playMusic(8);
        
    }

}
