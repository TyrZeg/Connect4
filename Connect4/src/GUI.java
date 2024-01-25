
import java.awt.*;

import javax.swing.*;
 
class GUI extends JFrame{
 

    GUI() {
        JButton b1;
        JLabel l1;

        setSize(1920, 1080);

        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("Java UI.jpg")));
        background.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        l1 = new JLabel("Here is a button");
        b1 = new JButton("I am a button");

        background.add(l1, gbc);

        gbc.gridy = 1;
        background.add(b1, gbc);

        add(background);

        setVisible(true);
    }

}