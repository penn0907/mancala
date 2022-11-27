import java.awt.Color;
import java.awt.image.BufferedImage;

public class ModernStyle implements StyleManager {
	
	private BufferedImage bsckgroundImg;
	private BufferedImage mancalaImg;
	private BufferedImage pitImg;
	private BufferedImage stoneImg;
	
	public ModernStyle() {
		
		bsckgroundImg = MancalaUtil.imgMap.get("modern-background");
		mancalaImg = MancalaUtil.imgMap.get("modern-player-pit");
		pitImg = MancalaUtil.imgMap.get("modern-pit");
		stoneImg = MancalaUtil.imgMap.get("modern-stone");
		
	}

	@Override
	public BufferedImage getBackgroundImg() {
		return bsckgroundImg;
	}

	@Override
	public BufferedImage getMancalaImg() {
		return mancalaImg;
	}

	@Override
	public BufferedImage getPitImg() {
		return pitImg;
	}

	@Override
	public BufferedImage getStoneImg() {
		return stoneImg;
	}

	@Override
	public Color getFontColor() {
		return Color.DARK_GRAY;
	}


}
