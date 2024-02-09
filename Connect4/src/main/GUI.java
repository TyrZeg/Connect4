package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

class GUI extends JFrame {
    int whichOne;
    int araWhichOne;

    // Game
    private Game gameMenu = new Game();

    // Menu's
    private ArabicMenu arabicMenu = new ArabicMenu();
    private EnglishMenu menu = new EnglishMenu();

    public static Settings settings = new Settings(false);

    GUI() {
        super("Connect 4");
        // Settings settings = new Settings(false);
        setPreferredSize(new Dimension(1920, 1080));
        add(menu);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        do {

            whichOne = menu.getWhichOne();
            araWhichOne = arabicMenu.getWhichOne();

            if (araWhichOne == 1) {
                arabicMenu.setWhichOne(0);
                arabicMenu.setVisible(false);
                menu.setVisible(true);
            }
            if (whichOne == 2) {
                menu.setWhichOne(0);
                menu.setVisible(false);
                add(arabicMenu);
                arabicMenu.setVisible(true);
            } else {

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!(whichOne == 3 || araWhichOne == 3));

        arabicMenu.setWhichOne(0);
        menu.setWhichOne(0);
        add(gameMenu);
        menu.setVisible(false);
        arabicMenu.setVisible(false);
        gameMenu.setVisible(true);
        System.out.println("Hi");
    }

}
