package topovi;

import java.util.Arrays;

public class TopoviState {

	private int[][] board;

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "TopoviState [board=" + Arrays.toString(board) + "]";
	}

	public TopoviState(int[][] board) {
		super();
		this.board = board;
	}
	
	public TopoviState clone() {
		TopoviState newState = new TopoviState(new int[8][8]);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newState.getBoard()[i][j] = this.getBoard()[i][j];
			}
		}
		return newState;
	}
}
