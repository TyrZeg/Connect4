package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnglishMenu extends JPanel {
    private JButton settingsButton;
    private JButton offlinePlayButton;
    private JButton onlinePlayButton;
    private JButton quitButton;
    private Settings settings = GUI.settings;
    private ImageIcon img = new ImageIcon(getClass().getResource("/Pictures/JavaMenu.jpg"));
    boolean settingsOpen = false;

    /**
     * printing the Arabic menu frame and buttons
     * for the first window pop up
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    EnglishMenu() {
        setLayout(new BorderLayout());
        add(settings);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        westPanel.setPreferredSize(new Dimension(450, 1080));
        westPanel.setOpaque(false);
        gbc.weightx = 1;

        offlinePlayButton = new MenuButtons("Offline Play", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(300, 0, 130, 0);
        gbc.gridy = 1;
        westPanel.add(offlinePlayButton, gbc);
        offlinePlayButton.setActionCommand("OfflinePlayButton");

        onlinePlayButton = new MenuButtons("Online Play", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(0, 0, 130, 0);
        gbc.gridy = 2;
        westPanel.add(onlinePlayButton, gbc);

        settingsButton = new MenuButtons("Settings", Color.WHITE, Color.YELLOW, 50);
        gbc.gridy = 3;
        westPanel.add(settingsButton, gbc);
        settingsButton.setActionCommand("SettingsButton");

        quitButton = new MenuButtons("Quit", Color.WHITE, Color.YELLOW, 50);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 50, 0);
        westPanel.add(quitButton, gbc);
        quitButton.setActionCommand("QuitButton");

        add(westPanel, BorderLayout.WEST);
    }


    void toggleSettings(){
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
    }

    public void addSettingsButtonActionListener(ActionListener listener) {
        settingsButton.addActionListener(listener);
    }

    public void addOfflinePlayButtonActionListener(ActionListener listener) {
        offlinePlayButton.addActionListener(listener);
    }

    public void addOnlinePlayButtonActionListener(ActionListener listener) {
        onlinePlayButton.addActionListener(listener);
    }

    public void addQuitButtonActionListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }
}
