package it.univr.state;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;


public class AbstractEnvironment  {


	private AbstractDomain domain;
	private AbstractStore store;
	private AbstractHeap heap;
	
	public AbstractEnvironment(AbstractDomain domain, AbstractStore store, AbstractHeap heap) {
		super();
		this.domain = domain;
		this.store = store;
		this.heap = heap;
	}
	
	public AbstractEnvironment(AbstractDomain domain) {
		super();
		this.domain = domain;
		this.store = new AbstractStore(domain);
		this.heap = new AbstractHeap(domain);
	}

	public AbstractStore getStore() {
		return store;
	}

	public void setStore(AbstractStore store) {
		this.store = store;
	}

	public AbstractHeap getHeap() {
		return heap;
	}

	public void setHeap(AbstractHeap heap) {
		this.heap = heap;
	}

	public AbstractEnvironment leastUpperBound(AbstractEnvironment other) {
		return new AbstractEnvironment(domain, store.leastUpperBound(other.getStore()), heap.leastUpperBound(other.getHeap()));
	}

	/**
	 * Perform the widening of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractEnvironment widening(AbstractEnvironment other) {
		return new AbstractEnvironment(domain, store.widening(other.getStore()), heap.widening(other.getHeap()));
	}

	/**
	 * Perform the narrowing of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractEnvironment narrowing(AbstractEnvironment other) {
		return new AbstractEnvironment(domain, store.narrowing(other.getStore()), heap.narrowing(other.getHeap()));
	}
	
	public AbstractValue getValue(Variable v) {
		return getStore().containsKey(v) ? getStore().get(v) : domain.makeBottom();
	}
	
	public AbstractValue getValue(AllocationSite l) {
		return getHeap().get(l);
	}


	public void intersect(AbstractEnvironment other) {
		for (Variable v : other.getStore().keySet()) 
			put(v, domain.greatestLowerBound(getValue(v),(other.getStore().getValue(v))));
	}

	@Override
	public String toString() {
		String result = "Abstract store\n*******************";

		result += getStore().toString();

		result += "\n\n";
		
		result += "Abstract heap\n*******************";

		result += getHeap().toString();

		result += "*******************\n";
		return result;
	}

	@Override
	public AbstractEnvironment clone() {
		return new AbstractEnvironment(domain, store.clone(), heap.clone());
	}
	
	public int sizeStore() {
		return getStore().size();
	}
	
	public int sizeHeap() {
		return getHeap().size();
	}

	public AbstractValue put(Variable key, AbstractValue v) {		
		return getStore().put(key, v);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof AbstractEnvironment) {
			return store.equals(((AbstractEnvironment) other).getStore()) && heap.equals(((AbstractEnvironment) other).getHeap());
		}
		return false;
	}
}

