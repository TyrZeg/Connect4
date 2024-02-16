package main;

import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JPanel {

    ImageIcon img = new ImageIcon(getClass().getResource("../Pictures/JavaGameBackround.jpg"));
    private GridBagConstraints gbc = new GridBagConstraints();
    Icon icon = new ImageIcon(getClass().getResource("../Pictures/EmptyConnect.PNG"));
    JPanel gameBoard = new JPanel(new GridBagLayout());
    Icon settingsIcon = new ImageIcon(getClass().getResource("../Pictures/settingsIcon.PNG"));
    private Settings settings = GUI.settings;
    CustomButton but = new CustomButton();
    // static boolean turn;
    static int player = 0;
    private int[][] board = new int[6][7];

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    Game() {
        setLayout(new BorderLayout());

        gameBoard.setOpaque(false);
        add(gameBoard, BorderLayout.CENTER);

        CustomButton[] btn = new CustomButton[42];

        // Initialize the game board to be empty.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }

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
                Color transparent = new Color(140, 200, 0, 210); // Alpha value: 128 (50% transparency)

                // Draw the game board.
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        if (board[i][j] == 0) {
                            g2d.setColor(transparent);
                        } else if (board[i][j] == 1) {
                            g2d.setColor(Color.RED);
                        } else {
                            g2d.setColor(Color.YELLOW);
                        }
                        g2d.drawOval(j * cellWidth, i * cellHeight, cellWidth, cellHeight);

                    }
                }
            }
        };

        for (CustomButton button : btn) {
            button = new CustomButton();

            button.setOpaque(false);
            button.setContentAreaFilled(false);

            pn1.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setPlayer(getPlayer() == 1 ? 2 : 1);

                }
            });

        }
        add(pn1);

        


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

                settings.setWhichOne(1);
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
        player2JPanel.setBackground(Color.pink);
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

    public void setPlayer(int player) {
        Game.player = player;
    }
 

    public static int getPlayer() {
        System.out.println(player);
        return player;
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
}
