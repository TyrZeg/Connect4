package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameButtons extends JButton implements MouseListener {
    private Icon mouseOverColor;
    private Icon icon;
    // Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
    public GameButtons(Icon icon, Icon mouseOverColor) {
        super(icon);
        this.mouseOverColor = mouseOverColor;
        this.icon = icon;
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
            this.setIcon(this.mouseOverColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setIcon(this.icon);
        }
    }
}