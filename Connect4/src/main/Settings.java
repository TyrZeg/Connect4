package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Settings extends JPanel {

    boolean whichOne = false;
    public boolean settingsOpen = false;
    private String player1 = "Player1";
    private String player2 = "Player2";

    private JButton player1Button;
    private JButton player2Button;
    private JRadioButton   radioEng;
    private JRadioButton radioAra;

    Settings(boolean language) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);

        if (!language) {
            JLabel langLabel = new JLabel("Language");
            gbc.gridy = 1;
            gbc.gridx = 1;
            add(langLabel, gbc);

            radioEng = new JRadioButton("English");
            radioEng.setSelected(true);

            radioAra = new JRadioButton("Arabic");

            ButtonGroup g1 = new ButtonGroup();

            g1.add(radioEng);
            g1.add(radioAra);

            gbc.gridx = 2;
            add(radioEng, gbc);

            gbc.gridx = 3;
            add(radioAra, gbc);

            add(label);
            radioEng.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    label.setText("Arabic Checkbox: "
                            + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                    setWhichOne(true);
                }
            });
            radioAra.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    label.setText("English Checkbox: "
                            + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                    setWhichOne(false);
                }
            });
            radioEng.setActionCommand("ChangeLanguage");
            radioAra.setActionCommand("ChangeLanguage");

            JLabel player1Name = new JLabel("Player1 Name:");
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(player1Name, gbc);

            JTextField player1Text = new JTextField(20);
            gbc.gridx = 2;
            add(player1Text, gbc);

            player1Button = new JButton("Submit");
            gbc.gridx = 3;
            add(player1Button, gbc);

            JLabel player2Name = new JLabel("Player2 Name:");
            gbc.gridx = 1;
            gbc.gridy = 3;
            add(player2Name, gbc);

            JTextField player2Text = new JTextField(20);
            gbc.gridx = 2;
            add(player2Text, gbc);

            player2Button = new JButton("Submit");
            gbc.gridx = 3;
            add(player2Button, gbc);
        }
        setVisible(false);
    }

    public boolean getWhichOne() {
        return whichOne;
    }

    public void setWhichOne(boolean newwhichOne) {
        this.whichOne = newwhichOne;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void addPlayerNameSubmitActionListener(ActionListener listener) {
        player1Button.addActionListener(listener);
        player2Button.addActionListener(listener);
    }


    public void addChangeEnglishLanguageActionListener(ActionListener listener) {
        radioEng.addActionListener(listener);
    }

    public void addChangeArabicLanguageActionListener(ActionListener listener) {
        radioAra.addActionListener(listener);
    }
}
