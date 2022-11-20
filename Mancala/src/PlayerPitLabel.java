import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayerPitLabel extends JLabel {
	
	private StyleManager sm;

	public PlayerPitLabel(StyleManager sm, int x, int y, int width, int height) {
		super();
		this.sm = sm;
			
		Image image = sm.getMancalaImg().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon iImage = new ImageIcon(image);
		setSize(width, height);
		setLocation(x, y);
		setIcon(iImage);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int x = 10;
		int y = 10;
		/*for (int i = 1; i <= 48; i++) {
			if (i == 17 || i == 33) {
				x += 20;
				y = 10;
			}
			Image image = sm.getStoneImg().getScaledInstance(ImageUtil.STONE_IMG_SIZE, ImageUtil.STONE_IMG_SIZE, Image.SCALE_DEFAULT);
			g2.drawImage(image, x, y, this);
			y += 15;
		}*/
		
	}
	
	

}
