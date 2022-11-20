import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PitLabel extends JLabel{
	
	private StyleManager sm;
	private int value;

	public PitLabel(StyleManager sm, int value,int x, int y, int size) {
		super();
		this.value = value;
		this.sm = sm;
		Image image = sm.getPitImg().getScaledInstance(size, size, Image.SCALE_DEFAULT);
		ImageIcon iImage = new ImageIcon(image);
		setSize(size, size);
		setLocation(x, y);
		setIcon(iImage);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Image image = sm.getStoneImg().getScaledInstance(ImageUtil.STONE_IMG_SIZE, ImageUtil.STONE_IMG_SIZE, Image.SCALE_DEFAULT);
		g2.drawImage(image, 20, 20, this);
		g2.drawImage(image, 45, 20, this);
		g2.drawImage(image, 20, 45, this);
		g2.drawImage(image, 45, 45, this);
		
	}

}
