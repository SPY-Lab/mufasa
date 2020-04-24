package it.univr.state;

import java.util.HashMap;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;

/**
 * Abstract state class. It is a partial map from Variable to AbstractValue.
 * 
 *  @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 */
public class AbstractStore extends HashMap<Variable, AbstractValue> {


	private static final long serialVersionUID = 1L;
	private AbstractDomain domain;

	public AbstractStore(AbstractDomain domain) {
		super();
		this.domain = domain;
	}

	/**
	 * Perform the least upper bound of two memories.
	 * 
	 * @param m1 first memory
	 * @param m2 second memory
	 * @return the least upper bound of the two memory
	 */
	public AbstractStore leastUpperBound(AbstractStore other) {
		AbstractStore lub = new AbstractStore(domain);

		for (Variable v: keySet()) 
			lub.put(v, domain.leastUpperBound(getValue(v),other.getValue(v)));

		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.leastUpperBound(getValue(v),other.getValue(v)));

		return lub; 
	}

	/**
	 * Perform the widening of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractStore widening(AbstractStore other) {
		AbstractStore lub = new AbstractStore(domain);

		for (Variable v: keySet()) {
			lub.put(v, domain.widening(getValue(v), other.getValue(v)));
		}
		
		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.widening(getValue(v),other.getValue(v)));

		return lub; 
	}
	
	/**
	 * Perform the narrowing of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the narrowing of the two states
	 */
	public AbstractStore narrowing(AbstractStore other) {
		AbstractStore lub = new AbstractStore(domain);

		for (Variable v: keySet()) 
			lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		return lub; 
	}

	public AbstractValue getValue(Variable v) {
		if (containsKey(v))
			return get(v);
		return domain.makeBottom();
	}


	public void intersect(AbstractStore other) {
		for (Variable v : other.keySet()) 
			put(v, domain.greatestLowerBound(getValue(v),(other.getValue(v))));
	}

	@Override
	public String toString() {
		String result = "\n";

		for (Variable v : keySet())
			result += v.toString() + " -> " + getValue(v) + "\n";

		if (isEmpty())
			result += "Empty abstract store.\n";

		result += "*******************\n";
		return result;
	}

	@Override
	public AbstractStore clone() {
		AbstractStore clone = new AbstractStore(domain);
		
		for (Variable v : keySet())
			clone.put(v, getValue(v).clone());
		
		return clone;
	}

	@Override
	public AbstractValue put(Variable key, AbstractValue v) {		
		super.put(key, v);
		return v;
	}
}
