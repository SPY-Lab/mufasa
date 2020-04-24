package it.univr.domain.lifted;

import java.util.HashMap;

import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.NaN;
import it.univr.fsm.machine.Automaton;

public class LiftedUnionAbstractValue implements AbstractValue {

	enum Type {Interval,FA, Bool, NaN};

	private HashMap<Type, AbstractValue> tuple;
	
	
	public LiftedUnionAbstractValue() {
		this.tuple = new HashMap<>();

		tuple.put(Type.Bool, new Bottom());
		tuple.put(Type.FA, new Bottom());
		tuple.put(Type.Interval, new Bottom());
		tuple.put(Type.NaN, new Bottom());
	}
	
	public HashMap<Type, AbstractValue> getTuple() {
		return tuple;
	}

	public void setTuple(HashMap<Type, AbstractValue> tuple) {
		this.tuple = tuple;
	}

	public void set(AbstractValue v) {
		if (v instanceof Interval)
			setInterval((Interval) v);

		if (v instanceof FA)
			setFA((FA) v);
		
		if (v instanceof Bool)
			setBool((Bool) v);	
		
		if (v instanceof NaN)
			setNaN((NaN) v);
	}
	
	public void lub(AbstractValue v) {
		if (v instanceof Interval)
			setInterval((Interval) getInterval().leastUpperBound((Interval) v));

		if (v instanceof FA)
			setFA((FA) getFA().leastUpperBound((FA) v));
		
		if (v instanceof Bool)
			setBool((Bool) getBool().leastUpperBound((Bool) v));	
		
		if (v instanceof NaN)
			setNaN((NaN) getNaN().leastUpperBound((NaN) v));
	}
	
	 
	public void setInterval(AbstractValue i) {
		tuple.put(Type.Interval, i);
	}
	
	public void setFA(AbstractValue fa) {
		tuple.put(Type.FA, fa);
	}
	
	public void setBool(AbstractValue abstractValue) {
		tuple.put(Type.Bool, abstractValue);
	}
	
	public void setNaN(AbstractValue nan) {
		tuple.put(Type.NaN, nan);
	}
	
	public AbstractValue getInterval() {
		return  tuple.get(Type.Interval);
	}
	
	public AbstractValue getFA() {
		return  tuple.get(Type.FA);
	}
	
	public AbstractValue getBool() {
		return  tuple.get(Type.Bool);
	}
	
	public AbstractValue getNaN() {
		return  tuple.get(Type.NaN);
	}
	
	@Override
	public AbstractValue juggleToNumber() {
		return getInterval().leastUpperBound(getBool().juggleToNumber()).leastUpperBound(getFA().juggleToNumber().leastUpperBound(getNaN()).juggleToNumber());
	}

	@Override
	public AbstractValue juggleToString() {
		return getFA().leastUpperBound(getBool().juggleToString()).leastUpperBound(getFA().juggleToString().leastUpperBound(getNaN()).juggleToString());
	}

	@Override
	public AbstractValue juggleToBool() {
		return getBool().leastUpperBound(getInterval().juggleToBool()).leastUpperBound(getFA().juggleToBool()).leastUpperBound(getNaN().juggleToBool());
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof LiftedUnionAbstractValue) {
			
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
			
			result.setBool(getBool().leastUpperBound(((LiftedUnionAbstractValue) other).getBool()));
			result.setNaN(getNaN().leastUpperBound(((LiftedUnionAbstractValue) other).getNaN()));
			result.setInterval( getInterval().leastUpperBound(((LiftedUnionAbstractValue) other).getInterval()));
			result.setFA(getFA().leastUpperBound(((LiftedUnionAbstractValue) other).getFA()));
			
			return result;
		}
		
		return LiftedUnionAbstractValue.makeTopUnionValue();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		if (other instanceof LiftedUnionAbstractValue) {
			
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
			
			result.setBool(getBool().widening(((LiftedUnionAbstractValue) other).getBool()));
			result.setNaN(getNaN().widening(((LiftedUnionAbstractValue) other).getNaN()));
			result.setInterval(getInterval().widening(((LiftedUnionAbstractValue) other).getInterval()));
			result.setFA(getFA().widening(((LiftedUnionAbstractValue) other).getFA()));
			
			return result;
		}
		
		return LiftedUnionAbstractValue.makeTopUnionValue();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue other) {
		if (other instanceof LiftedUnionAbstractValue) {
			
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
			
			result.setBool(getBool().greatestLowerBound(((LiftedUnionAbstractValue) other).getBool()));
			result.setNaN(getNaN().greatestLowerBound(((LiftedUnionAbstractValue) other).getNaN()));
			result.setInterval( getInterval().greatestLowerBound(((LiftedUnionAbstractValue) other).getInterval()));
			result.setFA(getFA().greatestLowerBound(((LiftedUnionAbstractValue) other).getFA()));
			
			return result;
		}
		
		return LiftedUnionAbstractValue.makeTopUnionValue();
	}

	@Override
	public AbstractValue narrowing(AbstractValue other) {
		if (other instanceof LiftedUnionAbstractValue) {
			
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
			
			result.setBool(getBool().narrowing(((LiftedUnionAbstractValue) other).getBool()));
			result.setNaN(getNaN().narrowing(((LiftedUnionAbstractValue) other).getNaN()));
			result.setInterval(getInterval().narrowing(((LiftedUnionAbstractValue) other).getInterval()));
			result.setFA(getFA().narrowing(((LiftedUnionAbstractValue) other).getFA()));
			
			return result;
		}
		
		return LiftedUnionAbstractValue.makeTopUnionValue();
	}
	
	public static LiftedUnionAbstractValue makeTopUnionValue() {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
		
		result.setBool(new Bool(2));
		result.setInterval(Interval.makeTopInterval());
		result.setFA(new FA(Automaton.makeTopLanguage()));
		result.setNaN(new NaN());
		
		return result;
	}
	
	public boolean isFA() {
		return getFA() instanceof FA && (getBool() instanceof Bottom) && (getInterval() instanceof Bottom) && (getNaN() instanceof Bottom);
	}
	
	@Override
	public String toString() {
		String result = "(";

		result += getInterval().toString() + ", ";
		result += getBool().toString() + ", ";
		result += getFA().toString() + ", ";
		result += getNaN().toString() + ")";
		
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof LiftedUnionAbstractValue) {
			return getFA().equals(((LiftedUnionAbstractValue) other).getFA()) &&
				getInterval().equals(((LiftedUnionAbstractValue) other).getInterval()) &&
				getNaN().equals(((LiftedUnionAbstractValue) other).getNaN()) &&
				getBool().equals(((LiftedUnionAbstractValue) other).getBool());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getInterval().hashCode() + getFA().hashCode() + getBool().hashCode() + getNaN().hashCode();
	}
	
	@Override
	public LiftedUnionAbstractValue clone() {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

		result.setInterval((getInterval()).clone());
		result.setFA(getFA().clone());
		result.setNaN(getNaN().clone());
		result.setBool(getBool().clone());
		
		return result;
	}
}
