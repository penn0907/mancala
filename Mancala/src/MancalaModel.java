/**
 * Mancala Model
 * 
 * @author Heibai Lian
 * CS151, Team Project
 */
public class MancalaModel {

	private int[] pitA;	//pit array, store number of stone
	private int[] pitB;
	private int mancalaA;	//stone number of each player's pit
	private int mancalaB;
	private int perPit;	//number of stone
	// 1:A -1:B
	private int currentPlayer;
	private int nextPlayer;
	private MancalaModel lastState;	//last state for undo function
	private int undoTime;
	private boolean useUndo;
	private boolean isFirstMove;	//if first move on player's turn, use for resetting the undo time
	private static int PLAYER_A = 1;
	private static int PLAYER_B = -1;

	/**
	 * default constructor
	 */
	public MancalaModel() {
	}

	/**
	 * constructor with number of stone
	 * @param perPit - number of stone
	 */
	public MancalaModel(int perPit) {
		reset(perPit);
		this.setPlayer(-1);
	}

	/**
	 * helper method for constructor, initialize model 
	 * @param perPit
	 */
	public void reset(int perPit) {
		if (perPit < 3 || perPit > 4) {
			throw new IllegalArgumentException("the player can enter 3 or 4 for the number of stones/per pit");
		}
		this.perPit = perPit;
		this.pitA = new int[6];
		this.pitB = new int[6];
		for (int i = 0; i < pitA.length; i++) {
			pitA[i] = this.perPit;
		}
		for (int i = 0; i < pitB.length; i++) {
			pitB[i] = this.perPit;
		}
		this.mancalaA = 0;
		this.mancalaB = 0;
		currentPlayer = PLAYER_A;
		nextPlayer = PLAYER_B;
		undoTime = 3;
		useUndo = false;
		isFirstMove = true;
		lastState = new MancalaModel();
		copyBoard(this, lastState);
	}

	/**
	 * set first player
	 * @param player
	 */
	public void setPlayer(int player) {
		this.currentPlayer = player;
		nextPlayer = player * -1;
	}

	/**
	 * change turns
	 * @return currentPlayer
	 */
	public int nextPlayer() {
		currentPlayer = nextPlayer;
		nextPlayer = currentPlayer * -1;

		return currentPlayer;
	}

	/**
	 * take a turn
	 * @param choosePit - pit number
	 * @return 1 - move success; 2 - get a free turn 
	 */
	public int takeTurn(int choosePit) {
		isFirstMove = currentPlayer != lastState.currentPlayer ? true : false;
		copyBoard(this, lastState);
		int[][] array = new int[2][];
		array[0] = pitA;
		array[1] = pitB;
		int player;
		if (currentPlayer == PLAYER_A) {
			player = 0;
		} else {
			player = 1;
		}
		int num = array[player][choosePit - 1];
		if (num == 0) {
			return 0;
		}
		array[player][choosePit - 1] = 0;
		int pit = choosePit;
		for (int i = 0; i < num; i++) {
			if (pit == pitA.length) {
				if ((currentPlayer == PLAYER_A && player == 1) || (currentPlayer == PLAYER_B && player == 0)) {
					if (player == 0) {
						player = 1;
					} else {
						player = 0;
					}
					pit = 0;
				}
			}

			if (pit < pitA.length) {
				if (i == num - 1 && array[player][pit] == 0) {
					if (currentPlayer == PLAYER_A && player == 0 && array[1][5 - pit] > 0) {
						int oppo = array[1][5 - pit];
						array[1][5 - pit] = 0;
						mancalaA += (1 + oppo);

					} else if (currentPlayer == PLAYER_B && player == 1 && array[0][5 - pit] > 0) {
						int oppo = array[0][5 - pit];
						array[0][5 - pit] = 0;
						mancalaB += (1 + oppo);

					} else {
						array[player][pit]++;
						pit++;
					}
				} else {
					array[player][pit]++;
					pit++;
				}
			} else if (pit == pitA.length) {
				if (player == 0) {
					mancalaA++;
					player = 1;
				} else {
					mancalaB++;
					player = 0;
				}
				pit = 0;
				if (i == num - 1) {
					nextPlayer = currentPlayer;
					if (useUndo) {
						useUndo = false;
					}

					return 2;
				}
			}
		}
		nextPlayer = currentPlayer * -1;
		if (useUndo) {
			useUndo = false;
		}
		return 1;
	}

	/**
	 * undo function
	 * @return is undo success
	 */
	public boolean undo() {
		if (isFirstMove) {	//if is the first move of the turn, reset the undo time
			undoTime = 3;
		}
		if (useUndo || undoTime <= 0) {	//if already use undo or reached the max attempt, return false
			return false;
		}
		copyBoard(lastState, this);	//reset the board to last state
		undoTime--;
		useUndo = true;
		return true;
	}

	/**
	 * check if is game over
	 * @return 0 - not; 1 or -1 - yes
	 */
	public int isGameOver() {
		boolean emptyA = true;
		for (int i = 0; i < pitA.length; i++) {
			if (pitA[i] != 0) {
				emptyA = false;
				break;
			}
		}
		if (emptyA) {
			return PLAYER_A;
		}
		boolean emptyB = true;
		for (int i = 0; i < pitB.length; i++) {
			if (pitB[i] != 0) {
				emptyB = false;
				break;
			}
		}
		if (emptyB) {
			return PLAYER_B;
		}
		return 0;
	}
	
	/**
	 * copy the last state to this model
	 * @param from
	 * @param to
	 */
	private void copyBoard(MancalaModel from, MancalaModel to) {
		to.pitA = new int[from.pitA.length];
		for (int i = 0; i < pitA.length; i++) {
			to.pitA[i] = from.pitA[i];
		}
		to.pitB = new int[from.pitB.length];
		for (int i = 0; i < pitB.length; i++) {
			to.pitB[i] = from.pitB[i];
		}
		to.mancalaA = from.mancalaA;
		to.mancalaB = from.mancalaB;
		to.currentPlayer = from.currentPlayer;
		to.nextPlayer = from.nextPlayer;
	}

	public int[] getPitA() {
		return pitA;
	}

	public int[] getPitB() {
		return pitB;
	}

	public int getMancalaA() {
		return mancalaA;
	}

	public int getMancalaB() {
		return mancalaB;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getUndoTime() {
		return undoTime;
	}

}
