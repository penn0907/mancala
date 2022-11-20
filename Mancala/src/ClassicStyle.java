import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicStyle implements StyleManager{

	@Override
	public BufferedImage getBackgroundImg() {
		return MancalaUtil.getImage("classic-bg.jpg");
	}

	@Override
	public BufferedImage getMancalaImg() {
		return MancalaUtil.getImage("classic-player-pit.png");
	}

	@Override
	public BufferedImage getPitImg() {
		return MancalaUtil.getImage("classic-pit.png");
	}

	@Override
	public BufferedImage getStoneImg() {
		return MancalaUtil.getImage("classic-stone.png");
		
	}


}
