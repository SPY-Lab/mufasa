package it.univr.state;

public class KeyAbstractState {
	
	private int row;
	private int col;
	
	public KeyAbstractState(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof KeyAbstractState)
			return getRow() == ((KeyAbstractState) other).getRow() && getCol() == ((KeyAbstractState) other).getCol();
		return false;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public int hashCode() {
	    return getCol() * 31 + getRow();
	}
	
	@Override
	public String toString() {
		return row + "-" + col;
	}
}
