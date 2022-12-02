import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * player's mancala label
 * 
 * @author Yupeng Ni
 * CS151, Team Project
 */
public class PlayerPitLabel extends JLabel {
	
	private int numOfStone;
	
	private BufferedImage stoneImg;

	/**
	 * constructor
	 * @param mancalaImg - background image
	 * @param stoneImg - stone image
	 * @param numOfStone - number of stone
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public PlayerPitLabel(BufferedImage mancalaImg, BufferedImage stoneImg, int numOfStone, int x, int y, int width, int height) {
		super();
		this.numOfStone = numOfStone;
		this.stoneImg = stoneImg;
		
		Image image = mancalaImg.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon iImage = new ImageIcon(image);
		setSize(width, height);
		setLocation(x, y);
		setIcon(iImage);
	}

	/**
	 * draw stone
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int x = 10;
		int y = 10;
		for (int i = 1; i <= numOfStone; i++) {
			if (i == 17 || i == 33) {	//each column draw max 17 stones
				x += 20;
				y = 10;
			}
			Image image = stoneImg.getScaledInstance(MancalaUtil.STONE_IMG_SIZE, MancalaUtil.STONE_IMG_SIZE, Image.SCALE_DEFAULT);
			g2.drawImage(image, x, y, this);
			y += 15;
		}
		
	}

}
