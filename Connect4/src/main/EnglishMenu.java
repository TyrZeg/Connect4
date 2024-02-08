package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class EnglishMenu extends JPanel {
    int whichOne;
    ImageIcon img = new ImageIcon(getClass().getResource("JavaMenu.jpg"));
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0,null);
    }
    EnglishMenu(){
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        westPanel.setPreferredSize(new Dimension(450, 1080));
        westPanel.setOpaque(false);
        gbc.weightx = 1;
        //gbc.ipady = 0;
        //gbc.ipadx = 0;
        
        JButton button = new MenuButtons("Offline Play", Color.WHITE, Color.YELLOW);
        gbc.insets = new Insets(300,0,130,0);
        gbc.gridy = 1;
        westPanel.add(button, gbc);
        button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
            setWhichOne(3);
        }
    });

        JButton button2 = new MenuButtons("Online Play", Color.WHITE, Color.YELLOW);
        gbc.insets = new Insets(0,0,130,0);
        gbc.gridy = 2;
        westPanel.add(button2, gbc);

        JButton button3 = new MenuButtons("Settings", Color.WHITE, Color.YELLOW);
        //gbc.ipadx = 150;
        gbc.gridy = 3;
        westPanel.add(button3, gbc);
        button3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {

            setWhichOne(2);
            JPanel settings = new Settings(false);
            //settings.setVisible(true);
            //add(settings);
            System.out.println("Hello");
        }
    });
        JButton button4 = new MenuButtons("Quit", Color.WHITE, Color.YELLOW);
        gbc.insets = new Insets(0,0,50,0);
        //gbc.ipadx = 100;
        gbc.gridy = 4;
        westPanel.add(button4, gbc);


        add(westPanel, BorderLayout.WEST);
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

