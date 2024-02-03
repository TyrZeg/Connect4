package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

    
class GUI extends JFrame {
   
        GUI() {
                ImageIcon icon = new ImageIcon("C:\\Users\\boobe\\Code\\Java\\Connect4\\Connect4\\src\\main\\Java UI.jpg");
                       JPanel mainMenu = new JPanel(new BorderLayout()) {
                       @Override
                       protected void paintComponent(Graphics g) {
                           super.paintComponent(g);
                           if (icon != null) {
                               g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                           }
                       }
                       };
                       add(mainMenu);
                       // Background Panel
           
                       
               
                       // Settings Panel
                      // JPanel settingsPanel = new JPanel();
                       //settingsPanel.add(new JLabel("Settings Panel"));
           
               
                       // Create a new panel for the west side with an HBox layout
                       JPanel westPanel = new JPanel();
                       westPanel.setLayout(new GridBagLayout());
                       GridBagConstraints gbc = new GridBagConstraints();
                       westPanel.setPreferredSize(new Dimension(450, 1080));
                       westPanel.setOpaque(false);
                       gbc.weightx = 1;
                       gbc.ipady = 80;
                       gbc.ipadx = 300;
                       
                       JButton button = PlainJButton("");
                       gbc.insets = new Insets(400,0,130,0);
                       gbc.gridy = 1;
                       westPanel.add(button, gbc);
                       button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            mainMenu.setVisible(false);
                            game();
                        }
                    });
           
                       JButton button2 = PlainJButton("");
                       gbc.insets = new Insets(0,0,110,0);
                       gbc.gridy = 2;
                       westPanel.add(button2, gbc);
           
                       JButton button3 = PlainJButton("");
                       gbc.ipadx = 200;
                       gbc.gridy = 3;
                       westPanel.add(button3, gbc);
           
                       JButton button4 = PlainJButton("");
                       gbc.insets = new Insets(0,0,200,0);
                       gbc.ipadx = 100;
                       gbc.gridy = 4;
                       westPanel.add(button4, gbc);
           
           
                       mainMenu.add(westPanel , BorderLayout.WEST);
                       // Add the components to the main panel
           
                       setVisible(true);

                       pack();
                       setDefaultCloseOperation(EXIT_ON_CLOSE);
                   }
               
           
                   //Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
                   public JButton PlainJButton (String Text){
                       JButton button = new JButton(Text);
                       button.setBorder(null);
                       button.setBorderPainted(true);
                       button.setContentAreaFilled(false);
                       button.setOpaque(false);
                       return button;
                   }

                   private void game(){
                    ImageIcon icon = new ImageIcon("C:\\Users\\boobe\\Code\\Java\\Connect4\\Connect4\\src\\main\\JavaMainUI.jpg");
                       JPanel gameMenu = new JPanel(new BorderLayout()) {
                       @Override
                       protected void paintComponent(Graphics g) {
                           super.paintComponent(g);
                           if (icon != null) {
                               g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                           }
                       }
                       };
                       add(gameMenu);
                   }

                   private void English(){

                   }

                   private void Arabic(){
                    
                   }
           }
           


