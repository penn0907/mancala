import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	
	private StyleManager sm;
	private BufferedImage bi;
	

	public BoardPanel(StyleManager sm) {
		setLayout(null);
		setLocation(100, 100);
		setSize(500, 500);
		this.sm = sm;
	}


	@Override
	public void paint(Graphics g) {
		
		bi = sm.getBackgroundImg();
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(bi, 0, 0, this);
		
	}

	
	
	
}
