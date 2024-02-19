package main;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * This class represents the settings panel for the application.
 */
public class Settings extends JPanel {
  private int whichOne;
  public boolean settingsOpen = false;
  /**
   * Constructor for the Settings class.
   * Initializes the settings panel with language options.
   * @param language The language setting. If true, the language options are not displayed.
   */
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
    	  /**
    	   * This method is called when the state of the radio button is changed.
    	   * If the Arabic radio button is selected, it sets the language setting to 1.
    	   * @param e The ItemEvent object.
    	   */
        public void itemStateChanged(ItemEvent e) {
          label.setText("Arabic Checkbox: "
              + (e.getStateChange() == 1 ? "checked" : "unchecked"));
          setWhichOne(1);
        }
      });
      radioAra.addItemListener(new ItemListener() {
    	  /**
    	   * This method is called when the state of the radio button is changed.
    	   * If the English radio button is selected, it sets the language setting to 2.
    	   * @param e The ItemEvent object.
    	   */
        public void itemStateChanged(ItemEvent e) {
          label.setText("English Checkbox: "
              + (e.getStateChange() == 1 ? "checked" : "unchecked"));
          setWhichOne(2);
        }
      });
    }
    setVisible(false);
  }
  /**
   * This method returns the current language setting.
   * @return The current language setting.
   */
  public int getWhichOne() {
    return whichOne;
  }
  /**
   * This method sets the current language setting.
   * @param newwhichOne The new language setting.
   */
  // Setter
  public void setWhichOne(int newwhichOne) {
    this.whichOne = newwhichOne;
  }
}
