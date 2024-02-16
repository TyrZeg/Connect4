/*
 * package main;
 * 
 * 
 * import java.awt.event.MouseEvent;
 * import java.awt.event.MouseListener;
 * 
 * import javax.swing.Icon;
 * import javax.swing.ImageIcon;
 * import javax.swing.JButton;
 * 
 * public class GameButtons extends JButton implements MouseListener {
 * Icon icon;
 * Icon purpleIcon = new
 * ImageIcon(getClass().getResource("../Pictures/PurpleConnect.png"));
 * Icon orangeIcon = new
 * ImageIcon(getClass().getResource("../Pictures/OrangeConnect.png"));
 * 
 * public GameButtons(Icon icon) {
 * super(icon);
 * this.icon = icon;
 * addMouseListener(this);
 * setBorder(null);
 * setBorderPainted(false);
 * setContentAreaFilled(false);
 * setOpaque(false);
 * }
 * 
 * @Override
 * public void mouseClicked(MouseEvent e) {
 * }
 * 
 * @Override
 * public void mousePressed(MouseEvent e) {
 * }
 * 
 * @Override
 * public void mouseReleased(MouseEvent e) {
 * }
 * 
 * @Override
 * public void mouseEntered(MouseEvent e) {
 * if (e.getSource() == this) {
 * this.setIcon(Game.getTurn() == true ? purpleIcon : orangeIcon);
 * }
 * }
 * 
 * @Override
 * public void mouseExited(MouseEvent e) {
 * if (e.getSource() == this) {
 * this.setIcon(this.icon);
 * }
 * }
 * }
 */