package main;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;

class GUI extends JFrame {
    private GameController gameController;

    // Game
    private Game gameMenu = new Game();

    // Menu's
    private ArabicMenu arabicMenu = new ArabicMenu();
    private EnglishMenu menu = new EnglishMenu();

    public static Settings settings = new Settings(false);

    /**
     * Constructor for the GUI class.
     * Initializes the GUI with a menu and game settings.
     */
    GUI() {
        super("Connect 4");
        setPreferredSize(new Dimension(1920, 1080));
        add(menu);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create GameController and pass necessary components
        gameController = new GameController(settings, gameMenu, menu, arabicMenu, this);

    }

    public void startOfflineGame() {
        System.out.println("HELLOO");
        Game gameMenu = new Game();
        add(gameMenu);
        menu.setVisible(false);
        arabicMenu.setVisible(false);
    }

    protected void ChangeLanguage() {
        boolean whichOne = settings.getWhichOne();
        if (!(whichOne)) {
            gameMenu.setVisible(false);
            arabicMenu.setVisible(false);
            menu.setVisible(true);
            menu.settingsOpen = false;
        } else {
            menu.setVisible(false);
            add(arabicMenu);
            // arabicMenu.add(settings);
            arabicMenu.setVisible(true);
            arabicMenu.settingsOpen = false;
        }
    }

    /**
     * This method creates the menu for the game.
     * It checks the settings to determine which menu to display.
     */
    /*
     * private void makeMenu() {
     * do {
     * int whichOne = settings.getWhichOne();
     * 
     * if (whichOne == 1) {
     * settings.setWhichOne(0);
     * gameMenu.setVisible(false);
     * arabicMenu.setVisible(false);
     * menu.setVisible(true);
     * menu.add(settings);
     * } else if (whichOne == 2) {
     * settings.setWhichOne(0);
     * menu.setVisible(false);
     * add(arabicMenu);
     * arabicMenu.add(settings);
     * arabicMenu.setVisible(true);
     * } else if (whichOne == 3) {
     * Game gameMenu = new Game();
     * add(gameMenu);
     * settings.setWhichOne(0);
     * menu.setVisible(false);
     * arabicMenu.setVisible(false);
     * // gameMenu.setVisible(true); // Commented out as it's already added above
     * } else if (whichOne == 4) {
     * setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     * }
     * try {
     * Thread.sleep(500);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * } while (!(settings.getWhichOne() == 4));
     * return;
     * }
     */
    public void quitGame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * The main method for the GUI class.
     * It sets the system property and creates a new GUI.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("Dsun.java2d.uiScale", "1.0");
        GUI myScreen = new GUI();
    }

}
