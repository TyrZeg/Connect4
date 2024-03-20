package main;

import java.awt.Dimension;

import javax.swing.*;
/**
 * This class represents the GUI for the Connect 4 game.
 */
class GUI extends JFrame {
    int whichOne;

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

        makeMenu();

    }
    /**
     * This method creates the menu for the game.
     * It checks the settings to determine which menu to display.
     */
    private void makeMenu() {
        do {

            whichOne = settings.getWhichOne();

            if (whichOne == 1) {
                settings.setWhichOne(0);
                gameMenu.setVisible(false);
                arabicMenu.setVisible(false);
                menu.setVisible(true);
                menu.add(settings);
            } else if (whichOne == 2) {
                settings.setWhichOne(0);
                menu.setVisible(false);
                add(arabicMenu);
                arabicMenu.add(settings);
                arabicMenu.setVisible(true);
            } else if (whichOne == 3) {
                add(gameMenu);
                settings.setWhichOne(0);
                menu.setVisible(false);
                arabicMenu.setVisible(false);
                gameMenu.setVisible(true);
            }else if (whichOne == 4) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!(whichOne == 4));
        return;
    }
    /**
     * The main method for the GUI class.
     * It sets the system property and creates a new GUI.
     * @param args command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("Dsun.java2d.uiScale", "1.0");
        GUI myScreen = new GUI();
        

    }
}
