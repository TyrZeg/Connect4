
package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {

    // ImageIcon and Icon for background images
    ImageIcon img = new ImageIcon(getClass().getResource("/Pictures/JavaGameBackround.jpg"));
    //JPanel gameBoard = new JPanel(new GridBagLayout());

    java.net.URL url = getClass().getResource("/Pictures/settingsIcon.jpg");
    Icon settingsIcon = new ImageIcon(url);

    // Components for the game board
    private Settings settings = GUI.settings;
    static int player = 1;
    public static CustomButton[][] boardOBJ = new CustomButton[6][7];
    
    private static int[][] board= new int[6][7];

    /**
     * Constructs a new Game object.
     * Initializes the game board, buttons, player information, and chat box.
     */
    Game() {
    	
    
    	
        System.out.println(url);

        setLayout(new BorderLayout());

       // gameBoard.setOpaque(false);

        JPanel pn1 = new JPanel(new GridLayout(6, 7)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Calculate the size of each cell.
                int cellWidth = getWidth() / 7;
                int cellHeight = getHeight() / 6;
                //for the circular rings color
                Color transparent = new Color(200, 200, 200, 250); // Alpha value: 128 (50% transparency)

                // Draw the game board.
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        g2d.setColor(transparent);
                        g2d.drawOval(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                    }
                }
            }
        };

        
        /*
      Columns: 0 1 2 3 4 5 6
Rows
0       [ ][ ][ ][ ][ ][ ][ ]
1       [ ][ ][ ][ ][ ][ ][ ]
2       [ ][ ][ ][ ][ ][ ][ ]
3       [ ][ ][ ][ ][ ][ ][ ]
4       [ ][ ][ ][ ][ ][ ][ ]
5       [ ][ ][ ][ ][ ][ ][ ]
         */
        // Create the buttons.
        for (int i = 0; i < 6;i++) {
            for (int j = 0; j < 7; j++) {
            	
            	
            	/*while(j<5 &&board[j][i]==0) {
            		System.out.println("Inside j loop, J =" + j + " i= "+ i);
            		j++;
            	}
            	if(j!=5) {
                	j--;
            	}*/
            	System.out.println("value of j: :: i"+ j + i);
                final CustomButton finalButton = new CustomButton(j,i);//btn[][] to store custome buttons, then use the board{}{} to get object
                														//button, then call the actionlistener of that button ?

                finalButton.setOpaque(false);
                finalButton.setContentAreaFilled(false);
                pn1.add(finalButton);
              
              //  j = boardOBJ[j][i].chipPosition(i,getPlayer());

                boardOBJ[i][j] = finalButton;
  boardOBJ[i][j].setCol(j);
                boardOBJ[i][j].setRow(i);
                //board[j][i] =1;
                // ActionListener for the buttons to switch player turns
                //chipPlacement(j,i);
               /// final int jj = j;
                //final int ii = i;
             // Inside your loop for creating buttons
                boardOBJ[i][j].addActionListener(e -> {
                    CustomButton clickedButton = (CustomButton) e.getSource();
                    int column = clickedButton.getCol();
                    int emptyRow = clickedButton.chipPosition(column,player); // Implement this method to find the lowest empty row
                    if (emptyRow != -1) {
                    	System.out.println("testing for current emptyrow and col" + emptyRow +"   ::  "+ column);
                        CustomButton buttonToChange = boardOBJ[emptyRow][column];
                        
                        buttonToChange.color = Game.getPlayer() == 1 ? CustomButton.orange : CustomButton.purple;
                        //buttonToChange.setColorForPlayer(getPlayer()); // Implement this method to set the color based on the player
                        buttonToChange.repaint(); // Repaint the button to show the new color
                        board[emptyRow][column] = getPlayer(); // Update the board array
                        setPlayer(getPlayer() == 1 ? 2 : 1); // Switch players
                        // Additional logic to check for a win...
                        CustomButton.checkForWin(emptyRow, column);
                    }
                });
            
        }
    }
       
//                boardOBJ[jj][i].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        setPlayer(getPlayer() == 1 ? 2 : 1);
//                        /*System.out.println(finalButton.getAlignmentX());
//                        finalButton.setEnabled(false);
//                        boardOBJ[jj][ii].setRow(jj);
//                        boardOBJ[jj][ii].setCol(ii);
//                        int newRow =  boardOBJ[jj][ii].chipPosition(ii,player);
//                        
//                        CustomButton btn = new CustomButton(newRow,ii);
//                        btn.color = new Color(255, 200, 150, 255);
//                        System.out.println("NEW COLORRRRRRRRRRRRRRRRRRR:"+btn.getColor()); 
//
//                        btn.setOpaque(false);
//                        btn.setContentAreaFilled(false);
//                        pn1.add(btn);*/
//                        //System.out.println("LOCATION OF BUTTON X" + finalButton.getX());
//                        //System.out.println("LOCATION OF BUTTON Y" + finalButton.getY());
//                    }
            

        // Add the pn1 panel to the gameBoard panel
        //gameBoard.add(pn1);
        add(pn1);
        // Add the gameBoard panel to the CENTER region of the main panel
        //add(gameBoard, BorderLayout.CENTER);

        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setOpaque(false);
        westPanel.setPreferredSize(new Dimension(330, 1080));
        add(westPanel, BorderLayout.WEST);

        JPanel optionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints mgbc = new GridBagConstraints();
        optionsPanel.setPreferredSize(new Dimension(300, 200));

        westPanel.add(optionsPanel, BorderLayout.NORTH);
        JButton settingsButton = new JButton(settingsIcon);
        settingsButton.setPreferredSize(new Dimension(60, 60));
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                settings.setWhichOne(true);//check this later
            }
        });

        mgbc.gridx = 1;
        mgbc.gridy = 1;
        optionsPanel.add(settingsButton, mgbc);

        JLabel turnTimer = new JLabel("Turn Time: ");
        JLabel gameTimer = new JLabel("Game Time: ");
        JLabel amountOfTurns = new JLabel("Turn: ");
        Font basicFont = new Font("Arial", Font.PLAIN, 24);
        turnTimer.setFont(basicFont);
        gameTimer.setFont(basicFont);
        amountOfTurns.setFont(basicFont);

        mgbc.gridx = 3;
        optionsPanel.add(amountOfTurns, mgbc);

        mgbc.gridy++;
        optionsPanel.add(turnTimer, mgbc);

        mgbc.gridy++;
        optionsPanel.add(gameTimer, mgbc);

        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setOpaque(false);
        eastPanel.setPreferredSize(new Dimension(330, 1080));
        add(eastPanel, BorderLayout.EAST);

        JPanel northEastPanel = new JPanel(new BorderLayout());

        JPanel southEastPanel = new JPanel(new BorderLayout());

        JPanel player1JPanel = new JPanel();
        JLabel player1JLabel = new JLabel("Player1");
        player1JLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        player1JPanel.setPreferredSize(new Dimension(220, 64));
        player1JPanel.setBackground(Color.orange);
        player1JPanel.add(player1JLabel, BorderLayout.CENTER);
        northEastPanel.add(player1JPanel, BorderLayout.NORTH);

        mgbc.gridy++;
        mgbc.insets = new Insets(0, 0, 200, 0);
        JPanel player2JPanel = new JPanel();
        JLabel player2JLabel = new JLabel("Player2", JLabel.CENTER);
        player2JLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        player2JPanel.setPreferredSize(new Dimension(220, 64));
        player2JPanel.setBackground(new Color(128,0,150));
        player2JPanel.add(player2JLabel, BorderLayout.CENTER);
        northEastPanel.add(player2JPanel, BorderLayout.SOUTH);

        eastPanel.add(northEastPanel, BorderLayout.NORTH);

        // chat box
        JPanel pn3 = new JPanel(new BorderLayout());
        JTextField textLine = new JTextField();
        JButton submitTextButton = new JButton("Send");
  

        textLine.setPreferredSize(new Dimension(300, 50));


        JTextArea chat = new JTextArea();
        chat.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chat);
        scrollPane.setPreferredSize(new Dimension(300, 500));

        submitTextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = textLine.getText();
                    chat.append("Player" + getPlayer() + ": " + message + "\n");
                    textLine.setText(""); // Clear the input field
                }
            });

        pn3.add(submitTextButton, BorderLayout.WEST);
        pn3.add(textLine, BorderLayout.SOUTH);
        pn3.add(scrollPane, BorderLayout.CENTER);
        southEastPanel.add(pn3, BorderLayout.CENTER);
        eastPanel.add(southEastPanel, BorderLayout.SOUTH);

        // makeGameButtons();
        setVisible(true);

        repaint();
    }

    /**
     * Customizes the appearance of the JPanel by painting the background image.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Sets the current player number.
     *
     * @param player The player number to set.
     */
    public void setPlayer(int player) {
        Game.player = player;
    }
 

    /**
     * Retrieves the current player number.
     *
     * @return The current player number.
     */
    public static int getPlayer() {
        System.out.println("current player from method getPlayer: "+player);
        return player;
    }


}
    /*
     * public static boolean getTurn() {
     * return turn;
     * }
     * 
     * // Setter
     * public void setTurn(boolean newTurn) {
     * Game.turn = newTurn;
     * }
     * 
     * public void makeGameButtons() {
     * for (int c = 0; c < 7; c++) {
     * for (int i = 0; i < 6; i++) {
     * JButton gButton = new GameButtons(icon);
     * gbc.gridx = c;
     * gbc.gridy = i;
     * gameBoard.add(gButton, gbc);
     * gButton.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent evt) {
     * 
     * setTurn(getTurn() ? false : true);
     * System.out.println(getTurn());
     * }
     * });
     * }
     * }
     */
