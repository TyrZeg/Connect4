package main;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArabicMenu extends JPanel{

    int whichOne;
    ImageIcon img = new ImageIcon(getClass().getResource("JavaArabicUI.jpg"));
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0,null);
    }
    ArabicMenu(){
        setLayout(new BorderLayout());
        setVisible(true);

            // Create a new panel for the west side with an HBox layout
            JPanel westPanel = new JPanel();
            westPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            westPanel.setPreferredSize(new Dimension(450, 1080));
            westPanel.setOpaque(false);
            gbc.weightx = 1;
            gbc.ipady = 80;
            gbc.ipadx = 300;
            
            JButton button = new MenuButtons("", Color.WHITE, Color.YELLOW);
            gbc.insets = new Insets(400,0,130,0);
            gbc.gridy = 1;
            westPanel.add(button, gbc);
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                setWhichOne(3);
            }
        });

            JButton button2 = new MenuButtons("", Color.WHITE, Color.YELLOW);
            gbc.insets = new Insets(0,0,110,0);
            gbc.gridy = 2;
            westPanel.add(button2, gbc);

            JButton button3 = new MenuButtons("", Color.WHITE, Color.YELLOW);
            gbc.ipadx = 200;
            gbc.gridy = 3;
            westPanel.add(button3, gbc);
            button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                setWhichOne(1);
            }
        });

            JButton button4 = new MenuButtons("", Color.WHITE, Color.YELLOW);
            gbc.insets = new Insets(0,0,200,0);
            gbc.ipadx = 100;
            gbc.gridy = 4;
            westPanel.add(button4, gbc);


            add(westPanel , BorderLayout.WEST);
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
    




/*تلعب من دون إتصال


تلعب مع  إتصال


الاعدادات


غادر     */