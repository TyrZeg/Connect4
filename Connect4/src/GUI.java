
import javax.swing.*;
import java.awt.*;


class GUI extends JFrame{


    GUI(){

        JPanel content = (JPanel) getContentPane();
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("Java UI.jpg"));
        JLabel label = new JLabel(backgroundImage);
        content.add(label, BorderLayout.CENTER);

        setContentPane(content);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

}