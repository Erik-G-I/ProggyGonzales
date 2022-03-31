package gameOver;

import core.GamePanel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class StartMenu implements ActionListener {

    GamePanel gp;
    Font font;
    public Boolean gameStarted = false;
    BufferedImage img;

    private final JButton playGame;
    private final JButton instructions;
    private final JFrame frame;


    public StartMenu(JFrame frame) {
        this.frame = frame;

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        this.playGame = addButton(buttons, "PLay");
        this.instructions = addButton(buttons, "How to play");

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(buttons);
        //frame.setMinimumSize(new Dimension(400, 400));
        //frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setVisible(true);
        frame.setLayout(null);


    }

    JButton addButton(JPanel buttons, String name) {
        JButton button = new JButton(name);
        button.setBounds(50, 100, 95, 30);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(20, 20)));
        buttons.add(button);
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameStarted) {
            if (e.getSource() == playGame) {
                GamePanel gamePanel = new GamePanel();
                frame.add(gamePanel);

                this.frame.pack();

                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);

                gamePanel.startGameThread();
                gameStarted = true;
            }
        }
    }
}
