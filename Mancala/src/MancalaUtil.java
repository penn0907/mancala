import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class MancalaUtil {
	
	public final static int STONE_IMG_SIZE = 30;
	public final static int BEGIN_STONES_3 = 3;
	public final static int BEGIN_STONES_4 = 4;
	public final static int PIT_LABEL_STONE_START_X = 20;
	public final static int PIT_LABEL_STONE_START_Y = 20;
	public final static int CLASSIC_STYLE = 1;
	public final static int MODERN_STYLE = 2;
	
	public final static int PIT_IMG_SIZE = 100;
	
	public final static int PLAYER_1 = -1;
	public final static int PLAYER_2 = 1;
	
	public static Map<String, BufferedImage> imgMap = new HashMap<String, BufferedImage>();
	
	public static void loadImg() {
		imgMap.put("classic-bg", MancalaUtil.getImage("classic-bg.jpg"));
		imgMap.put("classic-player-pit", MancalaUtil.getImage("classic-player-pit.png"));
		imgMap.put("classic-pit", MancalaUtil.getImage("classic-pit.png"));
		imgMap.put("classic-stone", MancalaUtil.getImage("classic-stone.png"));
		imgMap.put("modern-background", MancalaUtil.getImage("modern-background.jpg"));
		imgMap.put("modern-player-pit", MancalaUtil.getImage("modern-player-pit.png"));
		imgMap.put("modern-pit", MancalaUtil.getImage("modern-pit.png"));
		imgMap.put("modern-stone", MancalaUtil.getImage("modern-stone.png"));
	}

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
