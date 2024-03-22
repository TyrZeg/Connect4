package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    Color color = defaultColor;
    private int colorSet = 0; //used for highlight transparent color of mouse entry or exit (before clicking)

    // Transparent colors for hover states
    private final Color transparentOrange = new Color(255, 200, 0, 128); // RGB for orange is (255, 200, 0)
    private final Color transparentPurple = new Color(128, 0, 128, 128); // RGB for purple is (128, 0, 128)

    // Opaque colors
    final static Color orange = new Color(255, 200, 0, 255); // RGB for orange is (255, 200, 0)
    final static Color purple = new Color(128, 0, 128, 255); // RGB for purple is (128, 0, 128)

    
    private int row;
    private int col;
    public static int[][] board= new int[6][7];

    /**
     * Constructs a new CustomButton and adds a MouseListener to handle mouse events.
     */
    // Modify the constructor to take row and col as parameters
    CustomButton(int row, int col) {
        this.row = row;
        this.col = col;
        addMouseListener(this);
        for(int i = 0;i<6;i++) {
    		for(int j =0;j<7;j++) {
    			board[i][j]=0;
    		}
    		
    	}
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
    	
    	//CustomButton clickedButton = (CustomButton) e.getSource();
//        int column = clickedButton.getCol(); 
//       
//    	int emptyRow = chipPosition(column,Game.getPlayer());
//    	CustomButton newButton = null;
//    	if(emptyRow!=-1) {
//    	 newButton = Game.boardOBJ[emptyRow][column];
//    	}
//    	//Object ar= e.getSource();
//    	/*if (ar instanceof JButton)
//    	{
//    		JButton newBt = new JButton(); //creating new button
//    	}*/
//        // Sets the background color based on the player and updates the colorSet flag
//        newButton.color = Game.getPlayer() == 1 ? orange : purple;
//        
//        newButton.colorSet = Game.getPlayer();
//        // Print the location of the button
//        System.out.println("Button pressed at row " + row + ", col " + col);
//        
//       // this.chipPosition(getCol(), Game.getPlayer());
//
//        // Now you can use the row and col values to check for a win
//        if (checkForWin(row, col)) {
//            System.out.println("Player " + Game.getPlayer() + " wins!");
//            JOptionPane.showMessageDialog(null, "Player " + Game.getPlayer() + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
//        }
    
}

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used in this implementation
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Sets the transparent background color for hover states based on the player
        if (colorSet == 0) {
            // Do nothing
        } else {
            this.color = Game.getPlayer() == 1 ? transparentOrange : transparentPurple;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Resets the background color to transparent if not in a colorSet state
        if (colorSet == 0) {
            // Do nothing
        } else {
            if (e.getSource() == this) {
                this.color = transparent;
            }
        }
    }
 // Getter for row
    public int getRow() {
        return row;
    }

    // Setter for row
    public void setRow(int row) {
        this.row = row;
    }

    // Getter for col
    public int getCol() {
        return col;
    }

    // Setter for col
    public void setCol(int col) {
        this.col = col;
    }
    
    public int chipPosition(int col, int player) {
    	for(int i= 5;i>=0;i--) {
    		if(board[i][col]==0) {
    			board[i][col]=player;
    	    	return i;
//passes the row insrtead of boolean
    	    	
    		}
    	}
    	return -1;
    }

    public static boolean checkForWin(int row, int col) {
        int player = Game.getPlayer();
        System.out.println("currentPlayer in checkforwin"+player);
        System.out.println("CURRENT PLAYER: "+player + "CURRENT col:row " + col +"::" +row);
        // Check horizontal line
        for (int j = 0; j < 4; j++) {
            if (col - j >= 0 && col - j + 3 < 7 &&
                board[row][col - j] == player &&
                board[row][col - j + 1] == player &&
                board[row][col - j + 2] == player &&
                board[row][col - j + 3] == player) {
            	System.out.println("                                                 TESTING" + row + col + j + board[row][col]);
                return true;
            }
        }

        // Check vertical line
        for (int i = 0; i < 4; i++) {
            if (row - i >= 0 && row - i + 3 < 6 &&
                board[row - i][col] == player &&
                board[row - i + 1][col] == player &&
                board[row - i + 2][col] == player &&
                board[row - i + 3][col] == player) {
                return true;
            }
        }

        // Check main diagonal
        for (int i = 0; i < 4; i++) {
            if (row - i >= 0 && row - i + 3 < 6 && col - i >= 0 && col - i + 3 < 7 &&
                board[row - i][col - i] == player &&
                board[row - i + 1][col - i + 1] == player &&
                board[row - i + 2][col - i + 2] == player &&
                board[row - i + 3][col - i + 3] == player) {
                return true;
            }
        }

        // Check counter-diagonal
        for (int i = 0; i < 4; i++) {
            if (row - i >= 0 && row - i + 3 < 6 && col + i >= 3 && col + i < 7 &&
                board[row - i][col + i] == player &&
                board[row - i + 1][col + i - 1] == player &&
                board[row - i + 2][col + i - 2] == player &&
                board[row - i + 3][col + i - 3] == player) {
                return true;
            }
        }

        // No win
        return false;
    }
}