/* 
package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {

    ImageIcon img = new ImageIcon(getClass().getResource("JavaGameBackround.jpg"));
    private GridBagConstraints gbc = new GridBagConstraints();
    Icon icon = new ImageIcon(getClass().getResource("EmptyConnect.PNG"));
    Icon purpleIcon = new ImageIcon(getClass().getResource("PurpleConnect.png"));
    Icon orangeIcon = new ImageIcon(getClass().getResource("OrangeConnect.png"));
    private boolean turn;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    Game() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        

        
        for (int c = 0; c < 7; c++) {
            for (int i = 0; i < 6; i++) {
                JButton gButton = new GameButtons(icon, getTurn() == true ? filledIcon : icon);
                gbc.gridx = c;
                gbc.gridy = i;
                add(gButton, gbc);
            }
        }
        
        makeGameButtons();
        setVisible(true);

    }

    public boolean getTurn() {
       return turn;
    }
    
      // Setter
      public void setTurn(boolean newTurn) {
        this.turn = newTurn;
      }

    public void makeGameButtons(){
        for (int c = 0; c < 7; c++) {
            for (int i = 0; i < 6; i++) {
                JButton gButton = new GameButtons(icon, getTurn() ? purpleIcon : orangeIcon);
                gbc.gridx = c;
                gbc.gridy = i;
                add(gButton, gbc);
                gButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
        
                        setTurn(getTurn() ? false : true);
                        makeGameButtons();
                        repaint();
                        System.out.println(getTurn());
                    }
                });
            }
        }
    }
    */
    package main;
 
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
   import java.util.ArrayList;
   
   import javax.swing.border.Border;
    import javax.swing.*;
    
    public  class Game extends JPanel{
        ImageIcon img = new ImageIcon(getClass().getResource("JavaGameBackround.jpg"));
        
        JButton globalButton;
        //Dimension buttonDim = new Dimension(50,50);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
        // The game board.
        private int[][] board = new int[6][7];
    
        private Color defaultColour = Color.ORANGE;
        private int player = 1;
        private Color mouseOverColor = Color.BLACK;
        //CustomButton Cbtn = new CustomButton();
    
        Game() {
            JPanel playerPanel = new JPanel(new GridLayout(2,0));
            JLabel player1Label = new JLabel("PLAYER 1");
            JLabel player2Label = new JLabel("PLAYER 2");
            player1Label.setBackground(Color.ORANGE);
            player2Label.setBackground(new Color(128, 0, 128, 255));
            playerPanel.setBackground(Color.YELLOW);
            
            if (player==1) {player1Label.setForeground(Color.RED);}
            else {player2Label.setForeground(Color.RED);}
       
            
            
            
            
            
            
            
            CustomButton [] btn = new CustomButton[42];
            
            // Initialize the game board to be empty.
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    board[i][j] = 0;
                }
            }
    
            JPanel pn1 = new JPanel(new GridLayout(6,7)) {
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
            
            pn1.setMinimumSize(new Dimension(600, 600));
            pn1.setMaximumSize(new Dimension(600, 600));
            pn1.setPreferredSize(new Dimension(600, 600));
            
    
            for (CustomButton button : btn) {
                //button.setText("");
               button = new CustomButton();
                //button = new JButton("");//could number the buttons 
                //button.setPreferredSize(buttonDim);
    
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                //button.setBackground(Color.ORANGE);
   
               // pn1.add(button);
                pn1.add(button);
                //globalButton=button;
                //button.addActionListener(this);
              
    
               // button.setBorder(new RoundedBorder(20));
                 //   or   pn1.add(btn[i*7 + j]);
               // globalButton = button;
              // button.addActionListener(this);
                final CustomButton but =button;
               button.addMouseListener(new MouseAdapter() {
               
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                       but.hoverColor();
                       System.out.println("testing blue color");
                       System.out.println(e.getX()); 
                        System.out.println(e.getY()); 
                        //pn1.add(but); unnecessary for now
                    }
   
                    @Override
                    public void mouseExited(MouseEvent e) {
                        but.getColor();
   
                    }
                    
   
                    @Override
                    public void mousePressed(MouseEvent e) {
                        but.setColor();
                    }
                });
               
               button.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       // TODO Auto-generated method stub
                       System.out.println("HELLO ACTION");
                       //System.out.println("thesource" + e.getSource());
                       if(player == 1) {
                           player = 2;
                           but.setPlayer(player);
                       }else
                           player = 1;
                           but.setPlayer(player);
                       
                   }
               });
                
            }
            /*for (int i = 0; i < btn.length; i++) {
                btn[i] = new CustomButton();
                btn[i].setOpaque(false);
                btn[i].setContentAreaFilled(true);
                pn1.add(btn[i]);
                btn[i].addActionListener(this);
            }*/
            JPanel pn2 = new JPanel(new BorderLayout());
            pn2.setMinimumSize(new Dimension(700, 700));
            pn2.setMaximumSize(new Dimension(800, 800));
            pn2.setPreferredSize(new Dimension(1000, 700));
            //pn2.setPreferredSize(new Dimension(900,700));
            JButton butt = new JButton("HELOOOOOOO");
           // pn2.setPreferredSize(new Dimension(1200,500));
            //globalButton = butt; //Works after first click of button
            //globalButton.addActionListener(this);
            
            //pn1.setSize(100,400);
            
            
            
            
            
            
            
            
            //chat box
            JPanel pn3 = new JPanel(new BorderLayout());
            JTextField textLine = new JTextField();
            JButton submitTextButton = new JButton("Send");
            ArrayList<String> textArr = new ArrayList<String>(); // Create an ArrayList object
            //String[] textArray = new String[textArr.size()]; // Create an array of the same size as the ArrayList 	LESSON 
            //textArray = textArr.toArray(textArray); // Convert the ArrayList to an array								LESSON
   
            textLine.setPreferredSize(new Dimension(150,50));
            
            JTextPane chat = new JTextPane();
            chat.setEditable(false);
            
            submitTextButton.addActionListener( new ActionListener() {
   
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(e.getSource() == submitTextButton ) {
                       textArr.add(textLine.getText());
                       textArr.add("\n");
                       chat.setText(textArr.toString().replace("[", "").replace("]", "").replace(",", ""));
                       
                       String chatHistory = chat.getText();
                       
                       System.out.println(chatHistory);
                       System.out.println(textArr.toString());
   
   
                   }
               }
                
                
            });
   
            chat.setPreferredSize(new Dimension(250,2000));
            pn3.add(submitTextButton,BorderLayout.WEST);
            pn3.add(textLine,BorderLayout.SOUTH);
            pn3.add(chat,BorderLayout.CENTER);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            pn2.add(pn3,BorderLayout.WEST);
            pn2.add(pn1, BorderLayout.CENTER);
            //pn2.add(butt,BorderLayout.EAST);
            playerPanel.add(player1Label);
            playerPanel.add(player2Label);
            pn2.add(playerPanel,BorderLayout.EAST);
   
            add(pn2);
    
            setVisible(true);
        }
    
        // Method to handle a player's move.
        public void makeMove(int column, int player) {
            for (int i = 5; i >= 0; i--) {
                if (board[i][column] == 0) {
                    board[i][column] = player;
                    break;
                }
            }
            repaint();
        }
   
       
    }

