import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * ModernStyle concrete class
 * 
 * @author Yupeng Ni
 * CS151, Team Project
 */
public class ModernStyle implements StyleManager {
	
	private BufferedImage bsckgroundImg;
	private BufferedImage mancalaImg;
	private BufferedImage pitImg;
	private BufferedImage stoneImg;
	
	/**
	 * constructor, load the image
	 */
	public ModernStyle() {
		
		bsckgroundImg = MancalaUtil.imgMap.get("modern-background");
		mancalaImg = MancalaUtil.imgMap.get("modern-player-pit");
		pitImg = MancalaUtil.imgMap.get("modern-pit");
		stoneImg = MancalaUtil.imgMap.get("modern-stone");
		
	}
	
	/**
	 * get backgroundImg 
	 */
	@Override
	public BufferedImage getBackgroundImg() {
		return bsckgroundImg;
	}

	/**
	 * get player pit image
	 */
	@Override
	public BufferedImage getMancalaImg() {
		return mancalaImg;
	}

	/**
	 * pit image
	 */
	@Override
	public BufferedImage getPitImg() {
		return pitImg;
	}

	/**
	 * stone image
	 */
	@Override
	public BufferedImage getStoneImg() {
		return stoneImg;
	}

	/**
	 * get font color
	 */
	@Override
	public Color getFontColor() {
		return Color.DARK_GRAY;
	}


}
