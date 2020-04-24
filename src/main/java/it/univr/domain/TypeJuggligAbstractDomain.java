package it.univr.domain;

public interface TypeJuggligAbstractDomain {

	public AbstractValue juggleToNumber(AbstractValue v);
	public AbstractValue juggleToString(AbstractValue v);
	public AbstractValue juggleToBool(AbstractValue v);
}
