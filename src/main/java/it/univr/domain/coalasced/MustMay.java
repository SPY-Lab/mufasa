package it.univr.domain.coalasced;

public class MustMay {

	/**
	 * May static value
	 */
	private static byte MAY = 0;

	/**
	 * Must static value
	 */
	private static byte MUST = 1;

	/**
	 * Abstract must-may value
	 */
	private byte value;

	/**
	 * Abstract boolean constructor.
	 * 
	 * @param value byte identifying an abstract boolean.
	 */
	public MustMay(byte value) {
		this.value = value;
	}

	public MustMay(int value) {
		this.value = (byte) value;
	}

	/**
	 * Returns the abstract must-may value.
	 * 
	 * @return the abstract must-may value
	 */
	public byte getValue() {
		return value;
	}

	/**
	 * Set the abstract must-may value.
	 * 
	 * @param value the abstract must-may value to set
	 */
	public void setValue(byte value) {
		this.value = value;
	}

	public boolean isMay() {
		return this.getValue() == MAY;
	}

	public boolean isMust() {
		return this.getValue() == MUST;
	}

	public MustMay inverse() {
		return isMust() ? new MustMay(MAY) : new MustMay(MUST);
	}

	@Override
	public String toString() {
		return value == MAY ? "may" : "MUST";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof MustMay)
			return getValue() == ((MustMay) other).getValue();
		return false;
	}

	@Override
	public MustMay clone() {
		return new MustMay(getValue());
	}

	public MustMay leastUpperBound(MustMay other) {
		if (getValue() == other.getValue())
			return clone();
		return new MustMay(MAY);
	}

	public MustMay greatestLowerBound(MustMay other) {
		if (getValue() == other.getValue())
			return clone();
		return new MustMay(MUST);
	}
}