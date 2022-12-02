import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Mancala Board panel
 * 
 * @author Yupeng Ni
 * CS151, Team Project
 */
public class BoardPanel extends JPanel {

	private JLabel msgL; // msg label
	private JButton undoB; // undo button

	private Color fontColor;
	private BufferedImage backGroundImg;
	private BufferedImage mancalaImg;
	private BufferedImage stoneImg;
	private BufferedImage pitImg;

	private MouseListener mouseListener;
	private ActionListener undoListener;

	private int[] pitA;
	private int[] pitB;
	private int mancalaA; // player pit score
	private int mancalaB;
	private int currentPlayer;

	/**
	 * constructor
	 * @param numOfStone
	 */
	public BoardPanel(int numOfStone) {

		setLayout(null);
		setLocation(0, 0);
		setSize(785, 360);

	}

	/**
	 * init the panel
	 * 
	 * @param msg message to display
	 */
	public void init(String msg) {

		JLabel p1 = new JLabel("PLAYER B");
		p1.setFont(new Font("Bold", Font.BOLD, 16));
		p1.setSize(200, 30);
		p1.setLocation(40, 5);
		p1.setForeground(fontColor);
		JLabel p2 = new JLabel("PLAYER A");
		p2.setFont(new Font("Bold", Font.BOLD, 16));
		p2.setSize(200, 30);
		p2.setLocation(670, 5);
		p2.setForeground(fontColor);

		// add 2 player pits
		PlayerPitLabel mancalaPit1 = new PlayerPitLabel(mancalaImg, stoneImg, mancalaB, 30, 30, 100, 300);
		PlayerPitLabel mancalaPit2 = new PlayerPitLabel(mancalaImg, stoneImg, mancalaA, 660, 30, 100, 300);
		//arrow icon, point to the current player
		ArrowIcon arrow = new ArrowIcon(currentPlayer, 30, fontColor);
		JLabel arrowL = new JLabel(arrow);
		int arrowX = currentPlayer == MancalaUtil.PLAYER_A ? 600 : 150;
		arrowL.setSize(30, 30);
		arrowL.setLocation(arrowX, 165);

		msgL = new JLabel(msg);
		msgL.setFont(new Font("Bold", Font.BOLD, 20));
		msgL.setSize(400, 30);
		msgL.setLocation(280, 165);

		undoB = new JButton("UNDO");
		undoB.setLocation(360, 300);
		undoB.setSize(70, 30);
		undoB.setForeground(Color.WHITE);
		undoB.setBackground(fontColor);
		undoB.addActionListener(undoListener);

		add(undoB);
		add(p1);
		add(p2);
		add(arrowL);
		add(msgL);
		add(mancalaPit1);
		add(mancalaPit2);

		int gap = 85;	//gap length for each pit
		int x = 130 + (pitA.length - 1) * gap;
		int y = 60;
		//add the pits for player B
		for (int i = 0; i < pitB.length; i++) {
			PitLabel p = new PitLabel(pitImg, stoneImg, -1, i, x, y, MancalaUtil.PIT_IMG_SIZE, pitB[i]);
			p.addMouseListener(mouseListener);
			add(p);
			x -= gap;
		}

		x = 130;
		y = 195;
		//add the pits for player A
		for (int i = 0; i < pitA.length; i++) {
			PitLabel p = new PitLabel(pitImg, stoneImg, 1, i, x, y, MancalaUtil.PIT_IMG_SIZE, pitA[i]);
			p.addMouseListener(mouseListener);
			add(p);
			x += gap;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backGroundImg, 0, 0, this.getWidth(), this.getHeight(), this);

	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public void setPitA(int[] pitA) {
		this.pitA = pitA;
	}

	public void setPitB(int[] pitB) {
		this.pitB = pitB;
	}

	public void setBackGroundImg(BufferedImage backGroundImg) {
		this.backGroundImg = backGroundImg;
	}

	public void setMancalaA(int mancalaA) {
		this.mancalaA = mancalaA;
	}

	public void setMancalaB(int mancalaB) {
		this.mancalaB = mancalaB;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setMancalaImg(BufferedImage mancalaImg) {
		this.mancalaImg = mancalaImg;
	}

	public void setStoneImg(BufferedImage stoneImg) {
		this.stoneImg = stoneImg;
	}

	public void setPitImg(BufferedImage pitImg) {
		this.pitImg = pitImg;
	}

	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}

	public void setUndoListener(ActionListener undoListener) {
		this.undoListener = undoListener;
	}

}
