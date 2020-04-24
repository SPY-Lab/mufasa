package it.univr.state;

import java.util.HashMap;

import dnl.utils.text.table.TextTable;
import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.state.functions.KCallStrings;

public class CallStringAbstractEnvironment extends HashMap<KCallStrings, AbstractEnvironment> {

	private AbstractDomain domain;

	public CallStringAbstractEnvironment(AbstractDomain domain) {
		super();
		this.domain = domain;
	}


	@Override
	public AbstractEnvironment get(Object cs) {
		if (cs instanceof KCallStrings) {
			if (containsKey(cs))
				return super.get(cs);
			else
				return new AbstractEnvironment(domain);
		}

		throw new NullPointerException();
	}

	public CallStringAbstractEnvironment(AbstractDomain domain, AbstractStore store, AbstractHeap heap, KCallStrings cs) {
		super();
		this.setAbstractDomain(domain);
		AbstractEnvironment env = new AbstractEnvironment(domain);
		env.setHeap(heap);
		env.setStore(store);
		put(cs, env);
	}

	public CallStringAbstractEnvironment(AbstractDomain domain, AbstractEnvironment env, KCallStrings cs) {
		super();
		this.setAbstractDomain(domain);
		put(cs, env);
	}


	public void printTable() {
		String[] columns = {"Call String", "Abstract environment", "Abstract Value"};

		int i = 0;
		int n = keySet().size();
		String[][] t = new String[n][3];

		for (KCallStrings cs : keySet()) {

			AbstractStore store = getStore(cs);
			AbstractHeap heap = getHeap(cs);

			t[i][0] = cs.toString();

			for (Variable v : store.keySet()) {
				t[i][1] = v.toString();
				t[i][2] = store.getValue(v).toString();
			}

			if (!heap.keySet().isEmpty()) {
				for (AllocationSite l : heap.keySet()) {
					t[i][1] = l.toString();
					t[i][2] = heap.getValue(l).toString();
				}
			}
			i++;
		}

		TextTable table = new TextTable(columns, t);
		table.printTable();
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}

	public AbstractStore getStore(KCallStrings cs) {
		return get(cs).getStore();
	}

	public AbstractHeap getHeap(KCallStrings cs) {
		return get(cs).getHeap();
	}

	public void putVariable(Variable var, AbstractValue v, KCallStrings cs) {
		get(cs).getStore().put(var, v);
	}

	public void removeVariable(Variable var, KCallStrings cs) {
		get(cs).getStore().remove(var);
	}

	@Override
	public CallStringAbstractEnvironment clone() {
		CallStringAbstractEnvironment clone = new CallStringAbstractEnvironment(domain);

		for (KCallStrings cs : keySet())
			clone.put(cs, get(cs).clone());

		return clone;
	}

	public  CallStringAbstractEnvironment leastUpperBound(CallStringAbstractEnvironment other) {
		CallStringAbstractEnvironment lub = new CallStringAbstractEnvironment(domain);

		for (KCallStrings cs : keySet()) 
			lub.put(cs, get(cs).leastUpperBound(other.get(cs)));

		for (KCallStrings cs : other.keySet()) 
			if (!containsKey(cs))
				lub.put(cs, other.get(cs).clone());

		return lub;
	}

	public  CallStringAbstractEnvironment widening(CallStringAbstractEnvironment other) {
		CallStringAbstractEnvironment lub = new CallStringAbstractEnvironment(domain);

		for (KCallStrings cs : keySet()) 
			lub.put(cs, get(cs).widening(other.get(cs)));

		for (KCallStrings cs : other.keySet()) 
			if (!containsKey(cs))
				lub.put(cs, other.get(cs).clone());

		return lub;
	}
}
