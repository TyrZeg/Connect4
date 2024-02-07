package main;

import javax.swing.JButton;

public class BlankButtons extends JButton {
        //Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
        JButton BlankButtons (String Text){
            JButton button = new JButton(Text);
            button.setBorder(null);
            button.setBorderPainted(true);
            //button.setContentAreaFilled(false);
            button.setOpaque(false);
            return button;
        }
}
