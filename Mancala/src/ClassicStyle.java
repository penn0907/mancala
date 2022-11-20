import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicStyle implements StyleManager{

	@Override
	public BufferedImage getBackgroundImg() {
		return ImageUtil.getImage("classic-bg.jpg");
	}

	@Override
	public BufferedImage getMancalaImg() {
		return ImageUtil.getImage("classic-player-pit.png");
	}

	@Override
	public BufferedImage getPitImg() {
		return ImageUtil.getImage("classic-pit.png");
	}

	@Override
	public BufferedImage getStoneImg() {
		return ImageUtil.getImage("classic-stone.png");
		
	}


}
