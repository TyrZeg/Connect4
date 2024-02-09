package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {

    ImageIcon img = new ImageIcon(getClass().getResource("JavaGameBackround.jpg"));

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    Game() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int c = 0; c < 7; c++) {
            JButton button = new JButton("c");
            gbc.gridx = c;
            add(button, gbc);
            for (int i = 0; i < 6; i++) {
                JButton rbutton = new JButton("i");
                gbc.gridy = i;
                add(rbutton, gbc);
            }
        }
        setVisible(true);

    }
}
