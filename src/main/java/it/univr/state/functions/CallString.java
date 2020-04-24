package it.univr.state.functions;

public class CallString {

	private int col;
	private int row;
	
	public CallString(int row, int col) {
		this.col = col;
		this.row = row;
	}
	
	
	public int getColumn() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int col) {
		this.col = col;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof CallString)
			return ((CallString) other).getColumn() == col && ((CallString) other).getRow() == row;
		return false;
	}
	
	@Override
	public int hashCode() {
	    return col * 31 + row;
	}
	
	@Override
	public CallString clone() {
		return new CallString(row, col);
	}
	
	@Override
	public String toString() {
		return "["+ row + col +"]";
	}
}
