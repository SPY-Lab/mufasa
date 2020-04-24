package it.univr.domain.coalasced;

import it.univr.domain.AbstractValue;

public class Bottom implements AbstractValue {

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof Bottom) return clone();
		if (other instanceof FA) return ((FA) other).clone();
		if (other instanceof Bool) return ((Bool) other).clone();
		if (other instanceof Interval) return ((Interval) other).clone();
		if (other instanceof NaN) return ((NaN) other).clone();
		if (other instanceof AllocationSites) return ((AllocationSites) other).clone();
		
		return ((Top) other).clone();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public String toString() {
		return "⊥";
	}

	@Override
	public AbstractValue juggleToNumber() {
		return new Bottom();
	}

	@Override
	public AbstractValue juggleToString() {
		return new Bottom();
	}

	@Override
	public AbstractValue juggleToBool() {
		return new Bottom();
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Bottom;
	}
	
	@Override
	public Bottom clone() {
		return new Bottom();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		return new Bottom();
	}
	
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}
}
