package it.univr.state;

import java.util.HashMap;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;

public class AbstractHeap extends HashMap<AllocationSite, AbstractValue> {

	private static final long serialVersionUID = 1L;
	private AbstractDomain domain;

	public AbstractHeap(AbstractDomain domain) {
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
	public AbstractHeap leastUpperBound(AbstractHeap other) {
		AbstractHeap lub = new AbstractHeap(domain);

		for (AllocationSite v: keySet()) 
			lub.put(v, domain.leastUpperBound(getValue(v),other.getValue(v)));

		for (AllocationSite v: other.keySet()) 
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
	public AbstractHeap widening(AbstractHeap other) {
		AbstractHeap lub = new AbstractHeap(domain);

		for (AllocationSite v: keySet()) 
			lub.put(v, domain.widening(getValue(v),other.getValue(v)));

		for (AllocationSite v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.widening(getValue(v),other.getValue(v)));

		return lub; 
	}
	
	/**
	 * Perform the narrowing of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractHeap narrowing(AbstractHeap other) {
		AbstractHeap lub = new AbstractHeap(domain);

		for (AllocationSite v: keySet()) 
			lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		for (AllocationSite v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		return lub; 
	}

	public AbstractValue getValue(AllocationSite v) {
		if (containsKey(v))
			return get(v);
		return domain.makeBottom();
	}


	public void intersect(AbstractHeap other) {
		for (AllocationSite v : other.keySet()) 
			put(v, domain.greatestLowerBound(getValue(v),(other.getValue(v))));
	}

	@Override
	public String toString() {
		String result = "\n";

		for (AllocationSite v : keySet())
			result += v.toString() + " -> " + getValue(v) + "\n";

		if (isEmpty())
			result += "Empty abstract heap.\n";

		return result;
	}

	@Override
	public AbstractHeap clone() {
		AbstractHeap clone = new AbstractHeap(domain);
		
		for (AllocationSite v : keySet())
			clone.put(v, getValue(v).clone());
		assert(this.equals(clone));
		return clone;
	}

	@Override
	public AbstractValue put(AllocationSite key, AbstractValue v) {		
		super.put(key, v);
		return v;
	}
}
