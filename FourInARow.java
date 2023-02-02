
package dmi.vi1.search.examples.fourinarow;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.games.Game;
import dmi.vi1.search.games.GameState;

/**
 * @author Nemanja M. <nmilosev@dmi.uns.ac.rs>
 *
 */

public class FourInARow extends Game {

	public FourInARow() {
		this.gameActionsFunction = new FourInARowActionsFunction();
		this.gameResultFunction = new FourInARowResultFunction();
	}
	
	@Override
	protected int computeUtility(GameState state) {
		FourInARowBoard b = (FourInARowBoard) state.getBoard();

		if (b.someOneWon() && state.getPlayerToMove().equals(FourInARowBoard.YELLOW_DOT))
			// crveni je pobedio
			return 1;
		else if (b.someOneWon() && state.getPlayerToMove().equals(FourInARowBoard.RED_DOT))
			// zuti je pobedio
			return -1;

		// nereseno
		return 0;
	}

	@Override
	protected boolean terminalTest(GameState state) {
		return ((FourInARowBoard) state.getBoard()).isTerminalState();
	}

	public static void main(String[] args) {
		
		// 1 - crveni, 2 - zuti, 0 - prazno
		int[][] state = new int[][] {
			  { 2, 1, 2, 0, 0, 0, 2 },
			  { 2, 2, 2, 1, 2, 1, 2 },
			  { 1, 2, 1, 2, 2, 1, 1 },
			  { 1, 2, 1, 1, 2, 1, 1 },
			};
			
		FourInARowBoard f = new FourInARowBoard(state);
		
		System.out.println("Check if terminal state: " + f.isTerminalState());
		
		System.out.println("Initial state: ");
		System.out.println(f);
		
		System.out.println("Starting minimax: ");
		
		FourInARow fiar = new FourInARow();
		
		Action a = fiar.minimaxDecision(new GameState(FourInARowBoard.RED_DOT, f));

		System.out.println(a);
	}

}
