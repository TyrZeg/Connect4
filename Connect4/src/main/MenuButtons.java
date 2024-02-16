package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MenuButtons extends JButton implements MouseListener {
    private Color mouseOverColor;
    private Color defaultColour;

    // Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
    public MenuButtons(String text, Color defaultColour, Color mouseOverColor, int fontSize) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 50));
        setForeground(defaultColour);
        this.defaultColour = defaultColour;
        this.mouseOverColor = mouseOverColor;
        addMouseListener(this);
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this) {
            this.setForeground(this.mouseOverColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setForeground(this.defaultColour);
        }
    }
}
