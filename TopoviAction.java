package topovi;

import java.util.Objects;

import dmi.vi1.search.framework.Action;

public class TopoviAction implements Action {

	private int fromRow, fromCol, toRow, toCol;
	
	public int getFromRow() {
		return fromRow;
	}

	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}

	public int getFromCol() {
		return fromCol;
	}

	public void setFromCol(int fromCol) {
		this.fromCol = fromCol;
	}

	public int getToRow() {
		return toRow;
	}

	public void setToRow(int toRow) {
		this.toRow = toRow;
	}

	public int getToCol() {
		return toCol;
	}

	public void setToCol(int toCol) {
		this.toCol = toCol;
	}
	

	public TopoviAction(int fromRow, int fromCol, int toRow, int toCol) {
		super();
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
	}

	@Override
	public String toString() {
		return "TopoviAction [fromRow=" + fromRow + ", fromCol=" + fromCol + ", toRow=" + toRow + ", toCol=" + toCol
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fromCol, fromRow, toCol, toRow);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopoviAction other = (TopoviAction) obj;
		return fromCol == other.fromCol && fromRow == other.fromRow && toCol == other.toCol && toRow == other.toRow;
	}

	@Override
	public boolean isNoOpAction() {
		// TODO Auto-generated method stub
		return false;
	}

}
