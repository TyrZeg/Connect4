package main;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Settings extends JPanel {
  private int whichOne;
  public boolean settingsOpen = false;

  Settings(boolean language) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    setBackground(new Color(0.0f, 0.0f, 0.0f, 0.35f));
    final JLabel label = new JLabel();
    label.setHorizontalAlignment(JLabel.CENTER);

    if (language) {

    } else {
      JLabel langLabel = new JLabel("Language");
      gbc.gridy = 1;
      gbc.gridx = 1;
      add(langLabel, gbc);

      JRadioButton radioEng = new JRadioButton("English");
      radioEng.setSelected(true);

      JRadioButton radioAra = new JRadioButton("Arabic");

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
          setWhichOne(1);
        }
      });
      radioAra.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
          label.setText("English Checkbox: "
              + (e.getStateChange() == 1 ? "checked" : "unchecked"));
          setWhichOne(2);
        }
      });
    }
    setVisible(false);
  }

  public int getWhichOne() {
    return whichOne;
  }

  // Setter
  public void setWhichOne(int newwhichOne) {
    this.whichOne = newwhichOne;
  }
}
