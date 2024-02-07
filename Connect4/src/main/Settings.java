package main;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings extends JPanel{
    static int whichOne;
    Settings(boolean language){
        //JPanel panel = new JPanel();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        //setPreferredSize(new Dimension(400,400));
        setVisible(true);
        JButton button = new BlankButtons("Hello");
        add(button);


        if(language){

        }else{

        }
        
    }

    public static int getWhichOne() {
        return whichOne;
      }
    
      // Setter
      public void setWhichOne(int newwhichOne) {
        Settings.whichOne = newwhichOne;
      }
}
