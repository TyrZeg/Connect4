package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
    
class GUI extends JFrame {
   
    private CardLayout cardLayout;
    private JPanel cardPanel;

        GUI() {
            setLayout(new BorderLayout());
    
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

            //cardPanel.add(settingsPanel, "settings");
    
            // Create a new panel for the west side with an HBox layout
            JPanel westPanel = new JPanel();
            westPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
    

            // Button Panel with buttons
            JButton b1 = new JButton("Hi");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    add(settingsPanel, BorderLayout.CENTER);
                    pack();
                }
            });
            westPanel.add(b1);
    
            // Add the components to the main panel
            add(cardPanel, BorderLayout.CENTER);
            add(westPanel, BorderLayout.WEST);
    
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
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
