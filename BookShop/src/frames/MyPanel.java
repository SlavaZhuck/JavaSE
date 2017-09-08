package frames;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2222106328272841713L;

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("D:/favicon-1000x1000.png").getImage(), 0, 0, null);
	}

}
