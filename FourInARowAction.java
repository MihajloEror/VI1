package dmi.vi1.search.examples.fourinarow;

import dmi.vi1.search.framework.Action;

/**
 * @author Nemanja M. <nmilosev@dmi.uns.ac.rs>
 *
 */

public class FourInARowAction implements Action {

	private int color;
	private int column;
		
	@Override
	public boolean isNoOpAction() {
		return false;
	}

	public FourInARowAction(int color, int column) {
		this.color = color;
		this.column = column;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		String colorString = color == FourInARowBoard.RED_DOT ? "red" : "yellow";
		return "FourInARowAction: Put " + colorString + " dot to column " + column;
	}
	
}
