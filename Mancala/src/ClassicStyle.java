import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * Classic Style concrete class
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class ClassicStyle implements StyleManager{

	private BufferedImage bsckgroundImg;
	private BufferedImage mancalaImg;
	private BufferedImage pitImg;
	private BufferedImage stoneImg;
	
	/**
	 * constructor, load the image
	 */
	public ClassicStyle() {
		bsckgroundImg = MancalaUtil.imgMap.get("classic-bg");
		mancalaImg = MancalaUtil.imgMap.get("classic-player-pit");
		pitImg = MancalaUtil.imgMap.get("classic-pit");
		stoneImg = MancalaUtil.imgMap.get("classic-stone");
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
		return Color.ORANGE;
	}


}
