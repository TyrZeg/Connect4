package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class BlankButtons extends JButton {
        //Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
        public BlankButtons (String text){
            super(text);
            setFont(new Font("ComicSans", Font.PLAIN, 50));
            setForeground(Color.WHITE);
            setBorder(null);
            setBorderPainted(false);
            //setContentAreaFilled(false);
            setOpaque(false);
        }
}
