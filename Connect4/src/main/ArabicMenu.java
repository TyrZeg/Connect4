package main;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents an Arabic menu in the GUI.
 * It extends JPanel and contains settings, a boolean to check if settings are
 * open, and an image for the menu.
 */
public class ArabicMenu extends JPanel {
    private JButton settingsButton;
    private JButton offlinePlayButton;
    private JButton onlinePlayButton;
    private JButton quitButton;
    private Settings settings = GUI.settings;
    boolean settingsOpen = false;

    private ImageIcon img = new ImageIcon(getClass().getResource("/Pictures/JavaMenu.jpg"));
   

    /**
     * printing the Arabic menu frame and buttons
     * for the first window pop up
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Constructs an ArabicMenu object.
     * This constructor initializes the layout, adds settings, creates a west panel
     * with a grid bag layout,
     * and adds four buttons with specific actions to the west panel.
     * The first button allows the user to play without connection, the second
     * button allows the user to play with connection,
     * the third button opens the settings if they are not open and hides them if
     * they are open,
     * and the fourth button is for exiting.
     */

    ArabicMenu() {
        setLayout(new BorderLayout());
        add(settings);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        westPanel.setPreferredSize(new Dimension(450, 1080));
        westPanel.setOpaque(false);
        gbc.weightx = 1;

        offlinePlayButton = new MenuButtons("تلعب من دون إتصال", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(300, 0, 130, 0);
        gbc.gridy = 1;
        westPanel.add(offlinePlayButton, gbc);
        offlinePlayButton.setActionCommand("OfflinePlayButton");

        onlinePlayButton = new MenuButtons("تلعب مع  إتصال", Color.WHITE, Color.YELLOW, 50);
        gbc.insets = new Insets(0, 0, 130, 0);
        gbc.gridy = 2;
        westPanel.add(onlinePlayButton, gbc);

        settingsButton = new MenuButtons("الاعدادات", Color.WHITE, Color.YELLOW, 50);
        gbc.gridy = 3;
        westPanel.add(settingsButton, gbc);
        settingsButton.setActionCommand("SettingsButton");


        quitButton = new MenuButtons("غادر", Color.WHITE, Color.YELLOW, 50);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 50, 0);
        westPanel.add(quitButton, gbc);
        quitButton.setActionCommand("QuitButton");


        add(westPanel, BorderLayout.WEST);

        setVisible(false);
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

    void toggleSettings() {
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
}
