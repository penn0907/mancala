import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * Custom arrow icon for pointing current player
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class ArrowIcon implements Icon {
	
	private int size;
	private Color color;

	private int[] xs = new int[4];
	private int[] ys = new int[4];

	public ArrowIcon(int direct, int size, Color color) {
		this.size = size;
		this.color = color;
		setXYPoints(direct);
		
	}
	
	/**
	 * set up the coordinate for painting arrow
	 * @param direct  1: point to right; -1: point to left
	 */
	private void setXYPoints(int direct) {
		if (direct == MancalaUtil.PLAYER_B) {
			xs[0] = size;
			ys[0] = -1;
			xs[1] = size;
			ys[1] = size;
			xs[2] = 0;
			ys[2] = size / 2;
			xs[3] = 0;
			ys[3] = size / 2 - 1;
		} else {
			xs[0] = 0;
			ys[0] = -1;
			xs[1] = 0;
			ys[1] = size;
			xs[2] = size;
			ys[2] = size / 2;
			xs[3] = size;
			ys[3] = size / 2 - 1;
		}
	}

	public int getIconHeight() {
		return size;
	}

	public int getIconWidth() {
		return size;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.translate(x, y);
		g.translate(-x, -y); 
		g.fillPolygon(xs, ys, xs.length);
	}
	
	
}