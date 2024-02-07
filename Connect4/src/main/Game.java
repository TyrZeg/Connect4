package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel{
    
    Game(){
      ImageIcon icon = new ImageIcon("C:\\Users\\boobe\\Code\\Java\\Connect4\\Connect4\\src\\main\\JavaMainUI.jpg");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Image image = icon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

        /*{
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (icon != null) {
                    g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                    }
            }
        };
        setContentPane(menu);
        */
        JLabel menu = new JLabel(new ImageIcon(image));
        add(menu);
        menu.setLayout(new BorderLayout());
        setVisible(true);
    }
}
