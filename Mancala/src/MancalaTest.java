/**
 * Test class
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class MancalaTest {
	
	public static void main(String[] args) {
		MancalaUtil.loadImg();
		MancalaFrame mf = new MancalaFrame();
		MancalaController mc = new MancalaController(mf);
		mc.setFrameListener();
	}
	
	
}
