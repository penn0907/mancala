import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private StyleManager sm;
	private MancalaModel mancalaM;
	private PlayerPitLabel mancalaPit1;
	private PlayerPitLabel mancalaPit2;
	private JLabel msgL;

	private int[] pitA;
	private int[] pitB;

	public BoardPanel(StyleManager sm, int numOfStone) {
		this.sm = sm;
		mancalaM = new MancalaModel(numOfStone);

		this.pitA = mancalaM.getPitA();
		this.pitB = mancalaM.getPitB();

		setLayout(null);
		setLocation(0, 0);
		setSize(785, 360);

		setPitLabels("PLAYER 1 TURN");

	}

	private void setPitLabels(String msg) {

		JLabel p1 = new JLabel("PLAYER 1");
		p1.setFont(new Font("Bold", Font.BOLD, 16));
		p1.setSize(200, 30);
		p1.setLocation(40, 5);
		p1.setForeground(sm.getFontColor());
		JLabel p2 = new JLabel("PLAYER 2");
		p2.setFont(new Font("Bold", Font.BOLD, 16));
		p2.setSize(200, 30);
		p2.setLocation(670, 5);
		p2.setForeground(sm.getFontColor());

		ArrowIcon arrow = new ArrowIcon(mancalaM.getCurrentPlayer(), 30, sm.getFontColor());
		JLabel arrowL = new JLabel(arrow);
		int arrowX = mancalaM.getCurrentPlayer() == MancalaUtil.PLAYER_1 ? 150 : 600;
		arrowL.setSize(30, 30);
		arrowL.setLocation(arrowX, 165);

		msgL = new JLabel(msg);
		msgL.setFont(new Font("Bold", Font.BOLD, 20));
		msgL.setSize(400, 30);
		msgL.setLocation(280, 165);

		mancalaPit1 = new PlayerPitLabel(sm, mancalaM.getMancalaB(), -1, 30, 30, 100, 300);
		mancalaPit2 = new PlayerPitLabel(sm, mancalaM.getMancalaA(), 1, 660, 30, 100, 300);

		add(p1);
		add(p2);
		add(arrowL);
		add(msgL);
		add(mancalaPit1);
		add(mancalaPit2);

		int gap = 85;
		int x = 130 + (pitA.length - 1) * gap;
		int y = 60;

		for (int i = 0; i < pitB.length; i++) {
			PitLabel p = new PitLabel(sm, -1, i, x, y, MancalaUtil.PIT_IMG_SIZE, pitB[i]);
			p.addMouseListener(moveHandler());
			add(p);
			x -= gap;
		}

		x = 130;
		y = 195;

		for (int i = 0; i < pitA.length; i++) {
			PitLabel p = new PitLabel(sm, 1, i, x, y, MancalaUtil.PIT_IMG_SIZE, pitA[i]);
			p.addMouseListener(moveHandler());
			add(p);
			x += gap;
		}

	}

	private MouseListener moveHandler() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				PitLabel p = (PitLabel) e.getSource();
				if (p.getPlayer() != mancalaM.getCurrentPlayer()) {
					return;
				}

				String playerStr = mancalaM.getCurrentPlayer() == MancalaUtil.PLAYER_1 ? " PLAYER 1 " : " PLAYER 2 ";
				int move = mancalaM.takeTurn(p.getValue() + 1);

				if (mancalaM.isGameOver() != 0) {
					String msg = null;
					if (mancalaM.getMancalaB() > mancalaM.getMancalaA()) {
						msg = "GAME OVER PLAYER 1 WIN!";
					} else if (mancalaM.getMancalaB() < mancalaM.getMancalaA()) {
						msg = "GAME OVER PLAYER 2 WIN!";
					} else {
						msg = "GAME OVER DRAW!";
					}
					refreshPanel(msg);
					return;
				} else if (move == 0) {
					return;
				} else if (move == 2) {
					refreshPanel(playerStr + "GET A FREE TURN!");
					return;
				}

				mancalaM.nextPlayer();
				playerStr = mancalaM.getCurrentPlayer() == MancalaUtil.PLAYER_1 ? " PLAYER 1 " : " PLAYER 2 ";

				refreshPanel(playerStr + "TURN");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

		};
	}

	private void refreshPanel(String msg) {
		removeAll();
		revalidate();
		repaint();
		setPitLabels(msg);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Image bi = sm.getBackgroundImg();
		g2.drawImage(bi, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}
