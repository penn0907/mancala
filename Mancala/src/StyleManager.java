import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * Board Style manager strategy
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public interface StyleManager {
	
	/**
	 * get board background image
	 * @return BufferedImage
	 */
	BufferedImage getBackgroundImg();
	
	/**
	 * get get player mancala image
	 * @return BufferedImage
	 */
	BufferedImage getMancalaImg();
	
	/**
	 * get pit image
	 * @return BufferedImage
	 */
	BufferedImage getPitImg();
	
	/**
	 * get stone image
	 * @return BufferedImage
	 */
	BufferedImage getStoneImg();
	
	/**
	 * get font color
	 * @return Color
	 */
	Color getFontColor();

}
