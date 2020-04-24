package it.univr.domain.coalasced;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

/**
 * NaN abstract domain.
 * 
 * @author  * @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 *
 */
public class NaN implements AbstractValue {

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof NaN)
			return new NaN();
		else if (other instanceof Bottom)
			return new NaN();

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue juggleToNumber() {
		return new Interval("0", "0");
	}

	@Override
	public AbstractValue juggleToString() {
		return new FA(Automaton.makeAutomaton("NaN"));
	}

	@Override
	public AbstractValue juggleToBool() {
		return new Bool(0);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof NaN;
	}

	@Override
	public NaN clone() {
		return new NaN();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof NaN)
			return new NaN();
		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	@Override
	public String toString() {
		return "NaN";
	}

}
