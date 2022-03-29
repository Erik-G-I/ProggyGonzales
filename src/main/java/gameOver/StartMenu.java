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
    Boolean gameStarted = false;
    BufferedImage img;

    private final JButton playGame;
    private final JButton instructions;
    private final JFrame frame;


    public StartMenu(GamePanel gp) {
        this.gp = gp;

        frame = new JFrame();
        frame.setTitle("Game menu");

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        playGame = addButton(buttons, "Play Proggy Gonzales");
        instructions = addButton(buttons, "Instructions");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(buttons);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setVisible(true);
    }

    JButton addButton(JPanel buttons, String name) {
        JButton button = new JButton();
        button.setText(name);
        button.setFont(new Font("Times new roman", Font.BOLD, 40));
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(new BevelBorder(10));

        buttons.add(Box.createRigidArea(new Dimension(20, 20)));
        buttons.add(button);
        return button;
    }

    public void draw(Graphics g) {
        while (!gameStarted) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
