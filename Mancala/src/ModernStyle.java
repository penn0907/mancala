import java.awt.image.BufferedImage;

public class ModernStyle implements StyleManager {

	@Override
	public BufferedImage getBackgroundImg() {
		return MancalaUtil.getImage("modern-background.jpg");
	}

	@Override
	public BufferedImage getMancalaImg() {
		return MancalaUtil.getImage("modern-player-pit.png");
	}

	@Override
	public BufferedImage getPitImg() {
		return MancalaUtil.getImage("modern-pit.png");
	}

	@Override
	public BufferedImage getStoneImg() {
		return MancalaUtil.getImage("modern-stone.png");
	}


}
