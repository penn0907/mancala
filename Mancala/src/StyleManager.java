import java.awt.Color;
import java.awt.image.BufferedImage;

public interface StyleManager {
	
	BufferedImage getBackgroundImg();
	
	BufferedImage getMancalaImg();
	
	BufferedImage getPitImg();
	
	BufferedImage getStoneImg();
	
	Color getFontColor();

}
