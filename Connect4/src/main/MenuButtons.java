package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/**
 * This class represents a custom JButton with mouse events.
 */
public class MenuButtons extends JButton implements MouseListener {
    private Color mouseOverColor;
    private Color defaultColour;

    // Obtained from https://stackoverflow.com/questions/4585867/transparent-jbutton
    /**
     * Constructor for the MenuButtons class.
     * Initializes the button with text, default color, mouse over color and font size.
     * @param text The text to be displayed on the button.
     * @param defaultColour The default color of the button.
     * @param mouseOverColor The color of the button when the mouse is over it.
     * @param fontSize The font size of the text on the button.
     */
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
    /**
     * This method changes the color of the button when the mouse enters it.
     * @param e The MouseEvent object.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this) {
            this.setForeground(this.mouseOverColor);
        }
    }
    /**
     * This method changes the color of the button back to the default when the mouse exits it.
     * @param e The MouseEvent object.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setForeground(this.defaultColour);
        }
    }
}
