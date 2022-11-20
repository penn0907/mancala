import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class BoardPanel extends JPanel{

	private final int pitImgSize = 100;
	private StyleManager sm;

	public BoardPanel(StyleManager sm) {
		setLayout(null);
		setLocation(0, 0);
		setSize(785, 360);
		this.sm = sm;
		
		PlayerPitLabel mancalaPit1 = new PlayerPitLabel(sm, 30, 30, 100, 300);
		PlayerPitLabel mancalaPit2 = new PlayerPitLabel(sm, 660, 30, 100, 300);
		
		setPitLabels(60);
		setPitLabels(195);
		
		add(mancalaPit1);
		add(mancalaPit2);
	}
	
	private void setPitLabels(int y) {
		int x = 130;
		int gap = 85;
		for (int i = 1; i <= 6; i++) {
			PitLabel p = new PitLabel(sm, i, x, y, pitImgSize);
			add(p);
			x+=gap;
		}
		
		
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Image bi = sm.getBackgroundImg();
		g2.drawImage(bi, 0, 0,this.getWidth(),this.getHeight(), this);
		
	}
	
}
