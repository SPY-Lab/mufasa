package it.univr.domain;

public class AllocationSite {

	/**
	 * Allocation site location (column, row)
	 */
	private final int row;
	private final int col;

	public AllocationSite(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public AllocationSite clone() {
		return new AllocationSite(row, col);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof AllocationSite)
			return row == ((AllocationSite) other).getRow() && col == ((AllocationSite) other).getCol();
		return false;
	}

	@Override
	public int hashCode() {
		return this.getRow() * 31 + this.getCol();
	}

	@Override
	public String toString() {
		return "#" +  row +  col;
	}
}
