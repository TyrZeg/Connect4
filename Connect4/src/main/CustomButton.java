package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/**
 * The CustomButton class extends JButton and implements MouseListener to create a custom-styled button
 * with rounded corners and dynamic background colors based on user interactions.
 * It allows setting a custom radius for rounded corners and handles mouse events to change the button's appearance.
 *
 * @author Ihab Alobidat / Brayden Johnston
 */
public class CustomButton extends JButton implements MouseListener {

    // Radius for rounded corners
    private int radius = 100;

    // Transparency values for default and hover background colors
    private final Color transparent = new Color(0, 0, 0, 0.1f); // Alpha value: 128 (50% transparency)

    // Colors for different states
    private Color defaultColor = transparent;
    private Color color = defaultColor;
    private int colorSet = 0;

    // Transparent colors for hover states
    private final Color transparentOrange = new Color(255, 200, 0, 128); // RGB for orange is (255, 200, 0)
    private final Color transparentPurple = new Color(128, 0, 128, 128); // RGB for purple is (128, 0, 128)

    // Opaque colors
    private final Color orange = new Color(255, 200, 0, 255); // RGB for orange is (255, 200, 0)
    private final Color purple = new Color(128, 0, 128, 255); // RGB for purple is (128, 0, 128)

    /**
     * Constructs a new CustomButton and adds a MouseListener to handle mouse events.
     */
    CustomButton() {
        addMouseListener(this);
    }

    /**
     * Paints the component with rounded corners and the specified background color.
     *
     * @param gs The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics gs) {
        Graphics2D g2 = (Graphics2D) gs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded opaque button with the appropriate background color
        g2.setColor(getColor());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(gs);
    }

    /**
     * Sets the radius for rounded corners.
     *
     * @param radius The radius for rounded corners.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Retrieves the current background color of the button.
     *
     * @return The current background color.
     */
    public Color getColor() {
        return color;
    }

    // MouseListener methods

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used in this implementation
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Sets the background color based on the player and updates the colorSet flag
        this.color = Game.getPlayer() == 1 ? orange : purple;
        colorSet = Game.getPlayer();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used in this implementation
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Sets the transparent background color for hover states based on the player
        if (colorSet != 0) {
            // Do nothing
        } else {
            this.color = Game.getPlayer() == 1 ? transparentOrange : transparentPurple;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Resets the background color to transparent if not in a colorSet state
        if (colorSet != 0) {
            // Do nothing
        } else {
            if (e.getSource() == this) {
                this.color = transparent;
            }
        }
    }
}