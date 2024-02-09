package main;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings extends JPanel {
  int whichOne;

  Settings(boolean language) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    setBackground(new Color(0.0f, 0.0f, 0.0f, 0.35f));

    JButton button = new MenuButtons("Hello", Color.WHITE, Color.YELLOW);
    add(button);

    if (language) {

    } else {

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
