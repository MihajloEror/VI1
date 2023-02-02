package dmi.vi1.search.examples.fourinarow;

/**
 * @author Nemanja M. <nmilosev@dmi.uns.ac.rs>
 *
 */

public class FourInARowBoard {

	public static int EMPTY = 0;
	public static int RED_DOT = 1;
	public static int YELLOW_DOT = 2;

	public static final int X_DIMENSION = 7;
	public static final int Y_DIMENSION = 4;
	
	private int[][] matrix;
	
	public FourInARowBoard() {
		matrix = new int[Y_DIMENSION][X_DIMENSION];
	}
	
	public FourInARowBoard(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public boolean isTerminalState() {
		return getEmptyPositionsNumber() == 0 || someOneWon();
	}
	
	public int getValueAt(int x, int y) {
		return matrix[x][y];
	}
	
	public void setValueAt(int x, int y, int value) {
		matrix[x][y] = value;
	}
	
	public FourInARowBoard clone() {
		FourInARowBoard newBoard = new FourInARowBoard();
		
		for (int i = 0; i < Y_DIMENSION; i++)
			for (int j = 0; j < X_DIMENSION; j++) {
				newBoard.setValueAt(i, j, this.getValueAt(i, j));
			}
				
		return newBoard;
	}
	
	private int getEmptyPositionsNumber() {
		
		int emptyFields = 0;
		
		for (int i = 0; i < Y_DIMENSION; i++) {
			for (int j = 0; j < X_DIMENSION; j++) {
				if (matrix[i][j] == EMPTY)
					emptyFields++;
			}
		}
		
		return emptyFields;
	}
	
	public boolean someOneWon() {		
		return checkHorizontal() || checkVertical() || checkDiagonalFromLeftToRight() || checkDiagonalFromRightToLeft();
	}
	
	private boolean checkVertical() {
		for (int j = 0; j < X_DIMENSION; j++) {
			
			boolean completeVertical = true;
			
			for (int i = 0; i < Y_DIMENSION - 1; i++) {
				
				if (matrix[i][j] == EMPTY) {
					completeVertical = false;
					break;
				}
				
				if (matrix[i][j] != matrix[i + 1][j])
					completeVertical = false;
				
			}
			
			if (completeVertical) {
				//System.out.println("Found complete vertical at: " + j + ", 0");
				return true;
			}
						
		}
		return false;
	}
	
	private boolean checkHorizontal() {
		for (int j = 0; j < Y_DIMENSION; j++) {
			for (int i = 0; i < X_DIMENSION - 4; i++) {
				if (matrix[i][j] != EMPTY && matrix[i][j] == matrix[i][j+1] && matrix[i][j+1] == matrix[i][j+2] && matrix[i][j+2] == matrix[i][j+3]) {
					//System.out.println("Found complete horizontal at: " + i + ", " + j);
					return true;
				}									
			}			
		}
		return false;
	}
	
	private boolean checkDiagonalFromLeftToRight() {
		
		for (int i = 0; i < 4; i++) {
			int[] cache = new int[4];
			
			for (int j = 0; j < 4; j++) {
					//System.out.println(j + "," + (j + i));
					cache[j] = matrix[j][j + i];
			}		
			
			if (cache[0] != EMPTY && cache[0] == cache[1] && cache[1] == cache[2] && cache[2] == cache[3]) {
				//System.out.println("Found complete LtR diagonal at: " + i + ", 0");
				return true;
			}
		}
		return false;		
	}
	
	private boolean checkDiagonalFromRightToLeft() {
		
		for (int i = 0; i < 4; i++) {
			int[] cache = new int[4];
			
			for (int j = 3; j >= 0; j--) {
					//System.out.println(j + "," + (i + 3 - j));
					cache[j] = matrix[j][i + 3 - j];
			}		
			
			if (cache[0] != EMPTY && cache[0] == cache[1] && cache[1] == cache[2] && cache[2] == cache[3]) {
				//System.out.println("Found complete RtL diagonal at: " + i + ", 3");
				return true;
			}			
		}
		return false;		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < Y_DIMENSION; i++) {
			for (int j = 0; j < X_DIMENSION; j++) {
				sb.append("|").append(this.getValueAt(i, j)).append("|");
			}
			sb.append("\n");
		}
		
		return sb.toString()
				.replace("||", "|")
				.replace(String.valueOf(RED_DOT), "R")
				.replace(String.valueOf(YELLOW_DOT), "Y")
				.replace("0", " ");
	}	
}
