package it.univr.domain;


public interface AbstractValue  extends TypeJuggling {

	public AbstractValue leastUpperBound(AbstractValue other);
	public AbstractValue widening(AbstractValue other);
	public String toString();
	public AbstractValue clone();
	public AbstractValue greatestLowerBound(AbstractValue value);
	public AbstractValue narrowing(AbstractValue value);
}
