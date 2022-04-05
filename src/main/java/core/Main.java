package core;

import gameOver.StartMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

		GamePanel gamePanel = new GamePanel();
		StartMenu menu = new StartMenu(gamePanel);

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Proggy Gonzales");

		window.add(gamePanel);

		//JPanel buttons = new JPanel();
		//buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		//buttons.setBorder(new EmptyBorder(10, 10, 30, 10));
		//JButton play = menu.addButton("Play");

		//window.add(play);

		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.startGameThread();


        /*if (menu.gameStarted) {
                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
                window.setTitle("Proggy Gonzales");

                GamePanel gamePanel = new GamePanel();
                window.add(gamePanel);

                window.pack();

                window.setLocationRelativeTo(null);
                window.setVisible(true);

                gamePanel.startGameThread();
        }*/
        
    }

}
