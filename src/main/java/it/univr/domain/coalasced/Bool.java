package it.univr.domain.coalasced;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class Bool implements AbstractValue {

	/**
	 * True static value
	 */
	private static byte ABS_TRUE = 1;

	/**
	 * False static value
	 */
	private static byte ABS_FALSE = 0;

	/**
	 * Top boolean static value
	 */
	private static byte ABS_TOPBOOL = 2;

	/**
	 * Abstract boolean value
	 */
	private byte value;

	/**
	 * Abstract boolean constructor.
	 * 
	 * @param value byte identifying an abstract boolean.
	 */
	public Bool(byte value) {
		this.value = value;
	}

	public Bool(int value) {
		this.value = (byte) value;
	}

	/**
	 * Returns the abstract boolean value.
	 * 
	 * @return the abstract boolean value
	 */
	public byte getValue() {
		return value;
	}

	/**
	 * Set the abstract boolean value.
	 * 
	 * @param value the abstract boolean value to set
	 */
	public void setValue(byte value) {
		this.value = value;
	}

	/**
	 * Check if this is finite concrete, i.e. is true or false.
	 * 
	 * @return true iff the abstract boolean value is not top, false otherwise.
	 */
	public boolean isFiniteConcrete() {
		return this.value == ABS_TRUE || this.value == ABS_FALSE;
	}

	public boolean isTrue() {
		return this.getValue() == ABS_TRUE;
	}

	public boolean isFalse() {
		return this.getValue() == ABS_FALSE;
	}

	public boolean isTopBool() {
		return this.getValue() == ABS_TOPBOOL;
	}
	
	/**
	 * Abstract not operation
	 * @return not of this: !false = true, !true = false; !{true,false} = {true, false}.
	 */
	public Bool not() {
		if (this.isTrue())
			return new Bool(ABS_FALSE);
		else if (this.isFalse())
			return new Bool(ABS_TRUE);
		else
			return new Bool(ABS_TOPBOOL);
	}
	
	/**
	 * Abstract or operation.
	 * 
	 * @param other other Bool parameter.
	 * @return abstract or operation: if this and other are concrete, typical or operation is applied, otherwise {true, false} is returned.
	 */
	public Bool or(Bool other) {
		if (this.isTrue() || other.isTrue()) 
			return new Bool(ABS_TRUE);
		else if (this.isTopBool() || other.isTopBool()) 
			return new Bool(ABS_TOPBOOL); 
		else
			return new Bool(ABS_FALSE);
	}

	/**
	 * Abstract and operation.
	 * 
	 * @param other other Bool parameter.
	 * @return abstract and operation: if this and other are concrete, typical and operation is applied, otherwise {true, false} is returned.
	 */
	public Bool and(Bool other) {
		if (other.isFalse() || this.isFalse())
			return new Bool(ABS_FALSE);
		else if (other.isTrue() && this.isTrue())
			return new Bool(ABS_TRUE);

		return new Bool(ABS_TOPBOOL);
	}

	@Override
	public String toString() {
		if (value == 0)
			return "false";
		else if (value == 1)
			return "true";
		else
			return "TopBool";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Bool)
			return getValue() == ((Bool) other).getValue();
		return false;
	}

	@Override
	public Bool clone() {
		return new Bool(getValue());
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof Bool) {
			if (getValue() == ((Bool) other).getValue())
				return clone();
			return new Bool(2);
		} else if (other instanceof Bottom)
			return clone();

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue juggleToNumber() {
		if (isTrue())
			return new Interval("1", "1");
		else if (isFalse())
			return new Interval("0", "0");
		else
			return new Interval("0", "1");
	}

	@Override
	public AbstractValue juggleToString() {
		if (isTrue())
			return new FA(Automaton.makeAutomaton("true"));
		else if (isFalse())
			return new FA(Automaton.makeAutomaton("false"));
		else
			return new FA(Automaton.union(Automaton.makeAutomaton("true"), Automaton.makeAutomaton("false")));
	}

	@Override
	public AbstractValue juggleToBool() {
		return clone();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof Bool) {
			if (((Bool) value).isTopBool())
				return clone();
			else if (isTopBool())
				return ((Bool) value).clone();
			else if (value.equals(this))
				return ((Bool) value).clone();	
		}
		
		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

}
