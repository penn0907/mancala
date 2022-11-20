import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MancalaUtil {
	
	public final static int STONE_IMG_SIZE = 30;
	public final static int BEGIN_STONES_3 = 3;
	public final static int BEGIN_STONES_4 = 4;
	public final static int PIT_LABEL_STONE_START_X = 20;
	public final static int PIT_LABEL_STONE_START_Y = 20;

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
