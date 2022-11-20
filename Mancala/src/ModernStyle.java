import java.awt.image.BufferedImage;

public class ModernStyle implements StyleManager {

	@Override
	public BufferedImage getBackgroundImg() {
		return ImageUtil.getImage("modern-background.jpg");
	}

	@Override
	public BufferedImage getMancalaImg() {
		return ImageUtil.getImage("modern-player-pit.png");
	}

	@Override
	public BufferedImage getPitImg() {
		return ImageUtil.getImage("modern-pit.png");
	}

	@Override
	public BufferedImage getStoneImg() {
		return ImageUtil.getImage("modern-stone.png");
	}


}
