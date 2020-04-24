package it.univr.domain;

public interface TypeJuggling {
	public AbstractValue juggleToNumber();
	public AbstractValue juggleToString();
	public AbstractValue juggleToBool();
}
