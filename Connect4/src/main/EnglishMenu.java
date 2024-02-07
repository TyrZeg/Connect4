package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class EnglishMenu extends JPanel {
    int whichOne;
    EnglishMenu(){
        
    ImageIcon img = new ImageIcon(getClass().getResource("Java UI.jpg"));
    JPanel menu = new JPanel()
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(img.getImage(), 0, 0,null);
        }
        };
        
    //Image bgImage = Toolkit.getDefaultToolkit().createImage("Java UI.jpg");
    //ImageIcon icon = new ImageIcon(getClass().getResource("Java UI.jpg"));
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //Image bgImage = icon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        add(menu);
        menu.setLayout(new BorderLayout());
        setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.RED));
            // Background Panel

            JPanel northPanel = new JPanel();
            JPanel southPanel = new JPanel();
            JPanel eastPanel = new JPanel();
            northPanel.setOpaque(false);
            southPanel.setOpaque(false);
            eastPanel.setOpaque(false);
            // Settings Panel
            // JPanel settingsPanel = new JPanel();
            //settingsPanel.add(new JLabel("Settings Panel"));


            // Create a new panel for the west side with an HBox layout
            JPanel westPanel = new JPanel();
            westPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            westPanel.setPreferredSize(new Dimension(380, 1080));
            westPanel.setOpaque(false);
            gbc.weightx = 1;
            //gbc.ipady = 0;
            //gbc.ipadx = 0;
            
            JButton button = new BlankButtons("Offline Play");
            gbc.insets = new Insets(200,0,90,0);
            gbc.gridy = 1;
            westPanel.add(button, gbc);
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                setWhichOne(3);
            }
        });

            JButton button2 = new BlankButtons("Online Play");
            gbc.insets = new Insets(0,0,90,0);
            gbc.gridy = 2;
            westPanel.add(button2, gbc);

            JButton button3 = new BlankButtons("Settings");
            //gbc.ipadx = 150;
            gbc.gridy = 3;
            westPanel.add(button3, gbc);
            button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                setWhichOne(2);
                JPanel settings = new Settings(false);
                //settings.
                //setVisible(false);
                //settings.setVisible(true);
                menu.add(settings);
                System.out.println("Hello");
            }
        });
            JButton button4 = new BlankButtons("Quit");
            gbc.insets = new Insets(0,0,50,0);
            //gbc.ipadx = 100;
            gbc.gridy = 4;
            westPanel.add(button4, gbc);


            menu.add(westPanel, BorderLayout.WEST);
            //menu.add(northPanel, BorderLayout.NORTH);
            //menu.add(southPanel, BorderLayout.SOUTH);
            //menu.add(eastPanel, BorderLayout.EAST);
            // Add the components to the main panel
        }


        public int getWhichOne() {
            return whichOne;
          }
        
          // Setter
          public void setWhichOne(int newwhichOne) {
            this.whichOne = newwhichOne;
          }
}

