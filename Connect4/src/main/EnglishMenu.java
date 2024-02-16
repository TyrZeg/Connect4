package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EnglishMenu extends JPanel {
    private Settings settings = GUI.settings;
    private boolean settingsOpen = settings.settingsOpen;
    private ImageIcon img = new ImageIcon(getClass().getResource("../Pictures/JavaMenu.jpg"));

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    EnglishMenu() {
        setLayout(new BorderLayout());
        add(settings);

        // West Panel
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        westPanel.setPreferredSize(new Dimension(450, 1080));
        westPanel.setOpaque(false);
        gbc.weightx = 1;

        // Buttons
        JButton button = new MenuButtons("Offline Play", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(300, 0, 130, 0);
        gbc.gridy = 1;
        westPanel.add(button, gbc);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                settings.setWhichOne(3);
            }
        });

        JButton button2 = new MenuButtons("Online Play", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(0, 0, 130, 0);
        gbc.gridy = 2;
        westPanel.add(button2, gbc);

        JButton button3 = new MenuButtons("Settings", Color.WHITE, Color.YELLOW, 50);
        gbc.gridy = 3;
        westPanel.add(button3, gbc);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                add(settings);
                repaint();
                if (!settingsOpen) {
                    settingsOpen = true;
                    settings.setVisible(true);
                    System.out.println(settingsOpen);
                } else {
                    settings.setVisible(false);
                    settingsOpen = false;
                }

                System.out.println("Hello");
            }
        });
        JButton button4 = new MenuButtons("Quit", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridy = 4;
        westPanel.add(button4, gbc);

        add(westPanel, BorderLayout.WEST);
    }

}
