import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicStyle implements StyleManager{

	@Override
	public BufferedImage getBackgroundImg() {
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/boardtest.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}


}
