import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mancala controller
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class MancalaController {

	private MancalaModel mm;	//mancala model

	private MancalaFrame mf;	//mancala view

	private StyleManager sm;	//mancala style manager

	private BoardPanel boardPanel;	//board panel

	public MancalaController(MancalaFrame mf) {
		this.mf = mf;
	}

	/**
	 * set up listeners for buttons of frame
	 */
	public void setFrameListener() {
		mf.getButton1().addActionListener(getStoneNumListener(MancalaUtil.BEGIN_STONES_3, MancalaUtil.CLASSIC_STYLE));
		mf.getButton2().addActionListener(getStoneNumListener(MancalaUtil.BEGIN_STONES_4, MancalaUtil.MODERN_STYLE));
	}

	/**
	 * Set the parameters of the board panel
	 * @param msg	message to display on the panel
	 */
	private void setBoardPanel(String msg) {

		boardPanel.setMancalaImg(sm.getMancalaImg());
		boardPanel.setStoneImg(sm.getStoneImg());
		boardPanel.setPitImg(sm.getPitImg());
		boardPanel.setPitA(mm.getPitA());
		boardPanel.setPitB(mm.getPitB());

		boardPanel.setMouseListener(moveHandler());
		boardPanel.setCurrentPlayer(mm.getCurrentPlayer());
		boardPanel.setMancalaA(mm.getMancalaA());
		boardPanel.setMancalaB(mm.getMancalaB());
		boardPanel.setFontColor(sm.getFontColor());
		boardPanel.setBackGroundImg(sm.getBackgroundImg());
		boardPanel.setUndoListener(getUndoListener());
		
		boardPanel.init(msg);

	}

	/**
	 * refresh the board panel
	 * @param msg	message
	 */
	private void refreshBoardPanel(String msg) {
		boardPanel.removeAll();
		boardPanel.revalidate();
		boardPanel.repaint();
		setBoardPanel(msg);
	}

	/**
	 * action listener for undo button
	 * @return ActionListener
	 */
	private ActionListener getUndoListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				boolean undoF = mm.undo();
				if (undoF) {
					msg = "Undo success, " + mm.getUndoTime() + " undo left";
					refreshBoardPanel(msg);
				}

			}
		};
	}

	/**
	 * ActionListener for 
	 * @param num - number of stone
	 * @param style - user's selection of style
	 * @return ActionListener
	 */
	private ActionListener getStoneNumListener(int num, int style) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sm != null) {	//if style manager is not null, set up the number of stone 
					mf.remove(mf.getInitPanel());
					mf.setNumOfStone(num);
					mm = new MancalaModel(num);
					mm.setPlayer(MancalaUtil.PLAYER_A);

					boardPanel = new BoardPanel(mf.getNumOfStone());
					setBoardPanel("PLAYER A TURN");
					mf.add(boardPanel);
					mf.repaint();
				} else {	//choose style
					if (style == 1) {	// 1 - classic style
						sm = new ClassicStyle();
					} else {	// 2 - modern style
						sm = new ModernStyle();
					}
					mf.getPromptLabel().setText("Please selet stone number: ");
					mf.getButton1().setText("3");
					mf.getButton2().setText("4");
					mf.repaint();
				}
			}
		};
	}

	/**
	 * mouseListener for clicking pit label
	 * @return MouseListener
	 */
	private MouseListener moveHandler() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				PitLabel p = (PitLabel) e.getSource();
				if (p.getPlayer() != mm.getCurrentPlayer()) {	//check if player is valid
					return;
				}
				// get current palyer's name
				String playerStr = mm.getCurrentPlayer() == MancalaUtil.PLAYER_B ? " PLAYER B " : " PLAYER A ";
				int move = mm.takeTurn(p.getValue() + 1);	//mancala take turn

				if (mm.isGameOver() != 0) {	//check if game is over
					String msg = null;
					//get the result
					if (mm.getMancalaB() > mm.getMancalaA()) {
						msg = "GAME OVER PLAYER B WIN!";
					} else if (mm.getMancalaB() < mm.getMancalaA()) {
						msg = "GAME OVER PLAYER A WIN!";
					} else {
						msg = "GAME OVER DRAW!";
					}
					refreshBoardPanel(msg);
					return;
				} else if (move == 0) {	//no move success
					return;
				} else if (move == 2) {	//free turn
					refreshBoardPanel(playerStr + "GET A FREE TURN!");
					return;
				}

				mm.nextPlayer();
				playerStr = mm.getCurrentPlayer() == MancalaUtil.PLAYER_B ? " PLAYER B " : " PLAYER A ";

				refreshBoardPanel(playerStr + "TURN");
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

}
