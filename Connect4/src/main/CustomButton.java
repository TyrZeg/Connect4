package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class CustomButton extends JButton {
    private Color borderColor;

    private int radius = 100; // Set the radius for rounded corners
    final Color transparent = new Color(0, 0, 0, 0.1f); // Alpha value: 128 (50% transparency)
    private int player;
    private Color defaultColor = transparent;
    private Color color = defaultColor;

    private final  Color transparentOrange = new Color(255, 200, 0, 128);  // RGB for orange is (255, 200, 0)

    private final  Color transparentPurple = new Color(128, 0, 128, 128);  // RGB for purple is (128, 0, 128)
    private final  Color orange = new Color(255, 200, 0, 255);  // RGB for orange is (255, 200, 0)

    private final  Color purple = new Color(128, 0, 128, 255);  // RGB for purple is (128, 0, 128)


    @Override
    protected void paintComponent(Graphics gs) {
        Graphics2D g2 = (Graphics2D) gs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded opaque button with the appropriate background color

        g2.setColor(getColor());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(gs);
    }
// Make sure the button is opaque and the content area is filled
    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isContentAreaFilled() {
        return false;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setColor() {
        if(player == 0) {
        color = defaultColor;
        }else if(player == 1){
            System.out.println("testing inside player1 case");
        color= orange;

        }else {
            color= purple;

        }
    }

    public void hoverColor() {
        if(player == 0) {
            color = defaultColor;
            }else if(player == 1){
            color= transparentOrange;

            }else {
                color= transparentPurple;

            }
    }
    public Color getColor() {
        return color;
    }



    public void setPlayer(int player) {
        this.player = player;
    }
 

    public int getPlayer() {
        return player;
    }

}