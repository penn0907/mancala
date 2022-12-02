import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Pit label class
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class PitLabel extends JLabel {

	private int value;	// pit Id
	private int numOfStone;
	private int player;
	private BufferedImage pitImg;
	private BufferedImage stoneImg;

	/**
	 * constructor
	 * @param pitImg - pit image
	 * @param stoneImg - stone image
	 * @param player - player of this pit
	 * @param value - pit id
	 * @param x
	 * @param y
	 * @param size
	 * @param numOfStone
	 */
	public PitLabel(BufferedImage pitImg, BufferedImage stoneImg, int player, int value, int x, int y, int size, int numOfStone) {
		super();
		this.value = value;
		this.player = player;
		this.numOfStone = numOfStone;
		this.pitImg = pitImg;
		this.stoneImg = stoneImg;
		
		Image image = pitImg.getScaledInstance(size, size, Image.SCALE_DEFAULT);
		ImageIcon iImage = new ImageIcon(image);
		setSize(size, size);
		setLocation(x, y);
		setIcon(iImage);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Image image = stoneImg.getScaledInstance(MancalaUtil.STONE_IMG_SIZE, MancalaUtil.STONE_IMG_SIZE,
				Image.SCALE_DEFAULT);

		Rectangle2D r = g.getClipBounds();
		int x = MancalaUtil.PIT_LABEL_STONE_START_X;
		int y = MancalaUtil.PIT_LABEL_STONE_START_Y;
		//calculate space for stones
		double avgSpace = (r.getMaxX()) / numOfStone;
		//if each space greater than pit size, use original gap
		double gap = avgSpace > MancalaUtil.PIT_LABEL_STONE_START_X ? MancalaUtil.PIT_LABEL_STONE_START_X : avgSpace;

		for (int i = 0; i < numOfStone; i++) {
			g2.drawImage(image, x, y, this);
			x += gap;
			if (x > (r.getMaxX() / 2)) {	//change to next line
				y += MancalaUtil.PIT_LABEL_STONE_START_Y;
				x = MancalaUtil.PIT_LABEL_STONE_START_X;
			}
		}

	}
	
	public int getValue() {
		return value;
	}

	public int getPlayer() {
		return player;
	}

	public BufferedImage getPitImg() {
		return pitImg;
	}

	public void setPitImg(BufferedImage pitImg) {
		this.pitImg = pitImg;
	}

	public BufferedImage getStoneImg() {
		return stoneImg;
	}

	public void setStoneImg(BufferedImage stoneImg) {
		this.stoneImg = stoneImg;
	}

}
