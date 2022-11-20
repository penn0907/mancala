import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
	
	public final static int STONE_IMG_SIZE = 30;

	public static BufferedImage getImage(String fileName) {
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
