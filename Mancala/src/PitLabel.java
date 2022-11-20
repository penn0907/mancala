import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PitLabel extends JLabel {

	private StyleManager sm;
	private int value;
	private int numOfStone;

	public PitLabel(StyleManager sm, int value, int x, int y, int size, int numOfStone) {
		super();
		this.value = value;
		this.sm = sm;
		this.numOfStone = numOfStone;
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
		Image image = sm.getStoneImg().getScaledInstance(MancalaUtil.STONE_IMG_SIZE, MancalaUtil.STONE_IMG_SIZE,
				Image.SCALE_DEFAULT);

		Rectangle2D r = g.getClipBounds();
		int x = MancalaUtil.PIT_LABEL_STONE_START_X;
		int y = MancalaUtil.PIT_LABEL_STONE_START_Y;
		double avgSpace = (r.getMaxX()) / numOfStone;
		double gap = avgSpace > MancalaUtil.PIT_LABEL_STONE_START_X ? MancalaUtil.PIT_LABEL_STONE_START_X : avgSpace;

		for (int i = 0; i < numOfStone; i++) {
			g2.drawImage(image, x, y, this);
			x += gap;
			if (x > (r.getMaxX() / 2)) {
				y += MancalaUtil.PIT_LABEL_STONE_START_Y;
				x = MancalaUtil.PIT_LABEL_STONE_START_X;
			}
		}

	}

}
