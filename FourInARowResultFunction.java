package dmi.vi1.search.examples.fourinarow;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;
import dmi.vi1.search.games.GameState;

/**
 * @author Nemanja M. <nmilosev@dmi.uns.ac.rs>
 *
 */


public class FourInARowResultFunction implements ResultFunction {

	@Override
	public Object result(Object s, Action a)  {
		
		FourInARowAction action = (FourInARowAction) a;
		GameState state = (GameState) s;
		
		FourInARowBoard newBoard = ((FourInARowBoard) state.getBoard()).clone();
		
		int col = action.getColumn();
		int row = -1;
		
		for (int i = FourInARowBoard.Y_DIMENSION - 1; i >= 0; i--) {
			if (newBoard.getValueAt(i, col) == FourInARowBoard.EMPTY) {
				row = i;
				break;
			}
		}
		
		newBoard.setValueAt(row, col, (int)state.getPlayerToMove());
					
		int newPlayerToMove;
		if ((int)state.getPlayerToMove() == FourInARowBoard.RED_DOT)
			newPlayerToMove = FourInARowBoard.YELLOW_DOT;
		else
			newPlayerToMove = FourInARowBoard.RED_DOT;
		
		GameState newState = new GameState(newPlayerToMove, newBoard);
		
		return newState;
	}

}
