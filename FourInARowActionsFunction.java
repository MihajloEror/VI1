package dmi.vi1.search.examples.fourinarow;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;
import dmi.vi1.search.games.GameState;

/**
 * @author Nemanja M. <nmilosev@dmi.uns.ac.rs>
 *
 */

public class FourInARowActionsFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object s) {
		
		List<Action> list = new ArrayList<Action>();
		
		GameState state = ((GameState) s);
		FourInARowBoard board = (FourInARowBoard) state.getBoard();
		
		for (int i = 0; i < FourInARowBoard.X_DIMENSION; i++) {
			
			// proveravamo za svaku vertikalu gde ima slobodnog mesta (unazad)
			
			for (int j = FourInARowBoard.Y_DIMENSION - 1; j >= 0; j--) {
				if (board.getValueAt(j, i) == FourInARowBoard.EMPTY) {
					list.add(new FourInARowAction((int) state.getPlayerToMove(), i));
					break;
				}
			}
		}
		
		return list;
	}

}
