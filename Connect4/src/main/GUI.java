package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

    
class GUI extends JFrame {
    int whichOne;
    int araWhichOne;
    GUI() {
        super("Connect 4");
        //Settings settings = new Settings(false);
        setLayout(new BorderLayout());
        ArabicMenu arabicMenu = new ArabicMenu();
        Game gameMenu = new Game();
        EnglishMenu menu = new EnglishMenu();
        add(menu);
        

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        do{

            whichOne = menu.getWhichOne();
            araWhichOne = arabicMenu.getWhichOne();

            if(araWhichOne == 1){
                arabicMenu.setWhichOne(0);
                arabicMenu.setVisible(false);
                menu.setVisible(true);
            }else if(whichOne == 2){
                menu.setWhichOne(0);
                add(arabicMenu);
                menu.setVisible(false);
                arabicMenu.setVisible(true);
                //
                //settings = new Settings(false);
                //add(settings, BorderLayout.CENTER);
                //settings.setVisible(true);
                
            }else if(whichOne == 3 || araWhichOne == 3){
                arabicMenu.setWhichOne(0);
                menu.setWhichOne(0);
                add(gameMenu);
                menu.setVisible(false);
                arabicMenu.setVisible(false);
                gameMenu.setVisible(true);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }while(!(whichOne == 3 || araWhichOne == 3));
        
        System.out.println("Hi");
    }

}
