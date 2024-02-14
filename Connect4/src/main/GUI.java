package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

class GUI extends JFrame {
    int whichOne;

    // Game
    private Game gameMenu = new Game();

    // Menu's
    private ArabicMenu arabicMenu = new ArabicMenu();
    private EnglishMenu menu = new EnglishMenu();

    public static Settings settings = new Settings(false);

    GUI() {
        super("Connect 4");
        setPreferredSize(new Dimension(1920, 1080));
        add(menu);
        
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        do {

            whichOne = settings.getWhichOne();

            if (whichOne == 1) {
                settings.setWhichOne(0);
                arabicMenu.setVisible(false);
                menu.setVisible(true);
                menu.add(settings);
            }
            else if (whichOne == 2) {
                settings.setWhichOne(0);
                menu.setVisible(false);
                add(arabicMenu);
                arabicMenu.add(settings);
                arabicMenu.setVisible(true);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!(whichOne == 3));

        add(gameMenu);
        menu.setVisible(false);
        arabicMenu.setVisible(false);
        gameMenu.setVisible(true);
        /* *
        while(true){
            if(!gameMenu.getTurn()){
                gameMenu.makeGameButtons();
                repaint();
            }
        }
    }
*/
    }
    public static void main(String args[]) {

        @SuppressWarnings("unused")
        GUI myScreen = new GUI();

    }
}
