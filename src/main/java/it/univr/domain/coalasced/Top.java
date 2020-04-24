package it.univr.domain.coalasced;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class Top implements AbstractValue {

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return new Top();
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Top ? true : false;
	}
	
	@Override
	public int hashCode() {
		return "T".hashCode();
	}

	@Override
	public AbstractValue juggleToNumber() {
		return Interval.makeTopInterval();
	}

	@Override
	public AbstractValue juggleToString() {
		return new FA(Automaton.makeTopLanguage());
	}

	@Override
	public AbstractValue juggleToBool() {
		return new Bool(2);
	}
	
	@Override
	public AbstractValue clone() {
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof Interval) return ((Interval) value).clone();
		if (value instanceof Bottom) return new Bottom();
		if (value instanceof FA) return ((FA) value).clone();
		if (value instanceof NaN) return ((NaN) value).clone();
		if (value instanceof Bool) return ((Bool) value).clone();
		
		return new Top();
	}
	
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}
}
