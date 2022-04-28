package core;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerGUI implements ActionListener{
    private static JPanel panel = new JPanel();
    private static JFrame nameWindow = new JFrame();
    private static JLabel userLabel;
    private static JTextField userName;
    private static JButton button;

    public void PlayerGui() {
        //Username input frame
        nameWindow.setBounds(750, 300, 250, 150);
        //nameWindow.setSize(250, 150);
        nameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameWindow.add(panel);


        panel.setLayout(null);
        
        // Text before input field
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //input field
        userName = new JTextField();
        userName.setBounds(50, 20, 165, 25);
        panel.add(userName);

        // Submit button
        button = new JButton("Submit name");
        button.setBounds(10, 80, 120, 25);
        button.addActionListener(new PlayerGUI());
        panel.add(button);


        nameWindow.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userName.getText();
        System.out.println(username);  
    }

    
    
}
