/** 
public class Test {
    
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
    
    class GUI extends JFrame {
   
        private CardLayout cardLayout;
        private JPanel cardPanel;
    
        GUI() {
            setLayout(new BorderLayout()); // Use BorderLayout to organize components
    
            // Create the main panel with CardLayout
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);
    
            // Background Panel
            JPanel background = new JPanel();
            background.add(new JLabel(new ImageIcon(getClass().getResource("Java UI.jpg"))));
            cardPanel.add(background, "background");
    
            // Settings Panel
            JPanel settingsPanel = new JPanel();
            settingsPanel.add(new JLabel("Settings Panel"));
            cardPanel.add(settingsPanel, "settings");
    
            // Button Panel
            JButton b1 = PlainJButton("Hi");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "settings");
                }
            });

            // Add the components to the main panel
            add(cardPanel, BorderLayout.CENTER);
            add(b1,BorderLayout.WEST);

            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    

        //Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
        public JButton PlainJButton (String Text){
            JButton button = new JButton(Text);
            button.setBorder(null);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setOpaque(false);
            return button;
        }
    
    }
    class GUI extends JFrame {
    
        GUI() {
            setLayout(null); // Use null layout for absolute positioning
            setSize(1920, 1080);
    
            JLabel background = new JLabel(new ImageIcon(getClass().getResource("Java UI.jpg")));
            background.setBounds(0, 0, 1920, 1080); // Set the bounds to cover the entire frame
            add(background);
    

            JPanel Settings = new JPanel();
            Settings.setBounds(0, 0, 600, 600); // x, y, width, height
            add(Settings);

            JButton b1 = PlainJButton("");
            b1.setBounds(80, 320, 280, 80); // x, y, width, height
            add(b1);

            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    System.out.println("Hi");
                    JButton b2 = new JButton("HI");
                    b2.setBounds(0, 0, 280, 80); // x, y, width, height
                    add(b2);
                }
            });
    
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        */