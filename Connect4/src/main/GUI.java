package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

    
class GUI extends JFrame {
    int whichOne;
    int araWhichOne;
    GUI() {
        ArabicMenu arabicMenu = new ArabicMenu();
        Game gameMenu = new Game();
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        EnglishMenu menu = new EnglishMenu();
        add(menu);
        

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        do{
            whichOne = menu.getWhichOne();
            araWhichOne = arabicMenu.getWhichOne();

            if(whichOne == 2){
                menu.setWhichOne(0);
                add(arabicMenu);
                menu.setVisible(false);
                arabicMenu.setVisible(true);
            }else if(whichOne == 3 || araWhichOne == 3){
                arabicMenu.setWhichOne(0);
                menu.setWhichOne(0);
                add(gameMenu);
                menu.setVisible(false);
                arabicMenu.setVisible(false);
                gameMenu.setVisible(true);
            }else if(araWhichOne == 1){
                arabicMenu.setWhichOne(0);
                arabicMenu.setVisible(false);
                menu.setVisible(true);
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