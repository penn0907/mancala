import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicStyle implements StyleManager{

	private BufferedImage bsckgroundImg;
	private BufferedImage mancalaImg;
	private BufferedImage pitImg;
	private BufferedImage stoneImg;
	
	
	
	public ClassicStyle() {
		bsckgroundImg = MancalaUtil.imgMap.get("classic-bg");
		mancalaImg = MancalaUtil.imgMap.get("classic-player-pit");
		pitImg = MancalaUtil.imgMap.get("classic-pit");
		stoneImg = MancalaUtil.imgMap.get("classic-stone");
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
		return Color.ORANGE;
	}


}
