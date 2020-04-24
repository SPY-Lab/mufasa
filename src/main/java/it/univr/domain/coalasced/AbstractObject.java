package it.univr.domain.coalasced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.collections15.multimap.MultiHashMap;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class AbstractObject implements AbstractValue {

	private MultiHashMap<FA, AbstractValue> properties;

	public AbstractObject(FA fa, AbstractValue abstractValue) {
		this.properties = new MultiHashMap<>();
		this.properties.put(fa, abstractValue);
	}

	public AbstractObject() {
		this.properties = new MultiHashMap<>();
	}

	public MultiHashMap<FA, AbstractValue> getAbstractObjectMap() {
		return this.properties;
	}

	public AbstractObject(MultiHashMap<FA, AbstractValue> abstractObject) {
		this.properties = new MultiHashMap<>();
		this.properties.putAll(abstractObject);
	}

	@Override
	public AbstractValue juggleToNumber() {
		// TODO: 
		return null;
	}

	@Override
	public AbstractValue juggleToString() {
		// TODO: 
		return null;
	}

	@Override
	public AbstractValue juggleToBool() {
		// TODO:
		return null;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		
		if(other instanceof AbstractObject) {
			
			MultiHashMap<FA, AbstractValue> resultAbstractObjectMap = new MultiHashMap<>();

			for (FA abstractProperty: getAbstractObjectMap().keySet())
				resultAbstractObjectMap.put(abstractProperty, this.lookupAbstractObject(abstractProperty));//this.get(abstractProperty));
			
			for (FA abstractProperty: ((AbstractObject) other).getAbstractObjectMap().keySet()) {
				if (resultAbstractObjectMap.containsKey(abstractProperty)) {
					AbstractObject tempAbstractObject = new AbstractObject(resultAbstractObjectMap);
					tempAbstractObject.normalize();
					AbstractValue tempAbstractValue = tempAbstractObject.lookupAbstractObject(abstractProperty);
					resultAbstractObjectMap.remove(abstractProperty);
					resultAbstractObjectMap.put(abstractProperty, tempAbstractValue.leastUpperBound(((AbstractObject) other).lookupAbstractObject(abstractProperty)));
				} else {
					resultAbstractObjectMap.put(abstractProperty, ((AbstractObject) other).lookupAbstractObject(abstractProperty));
				}
			}

			AbstractObject abstractObject = new AbstractObject(resultAbstractObjectMap);
			
			abstractObject.normalize();

			return abstractObject;
		} else if (other instanceof Bottom)
			return clone();

		return new Top();
	}

	@Override
	public AbstractObject clone() {
		return new AbstractObject((MultiHashMap<FA, AbstractValue>) getAbstractObjectMap().clone());
	}

	/**
	 * Produces the widening between two abstract objects.
	 * 
	 * @return AbstractValue object widened
	 */
	@Override
	public AbstractValue widening(AbstractValue other) {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		this.normalize();
		
		if (other instanceof AbstractObject) {
			
			((AbstractObject) other).normalize();
			
			for (FA thisProperty: this.getAbstractObjectMap().keySet()) {
			
				if(((AbstractObject) other).getAbstractObjectMap().containsKey(thisProperty)) {
					// for equal properties do widening
					abstractObjectMap.put(thisProperty, this.lookupAbstractObject(thisProperty).widening(((AbstractObject) other).lookupAbstractObject(thisProperty)));
				} else {
					// otherwise keep this abstract value with its property
					abstractObjectMap.put(thisProperty, this.lookupAbstractObject(thisProperty));
				}
			}
		
			for(FA otherProperty: ((AbstractObject)other).getAbstractObjectMap().keySet()) {
				if (!this.getAbstractObjectMap().containsKey(otherProperty)) {
					// keep the other properties as they are
					abstractObjectMap.put(otherProperty, ((AbstractObject) other).lookupAbstractObject(otherProperty));
				}
			}
			
			return new AbstractObject(abstractObjectMap);
			
		} else if (other instanceof Bottom) {
			return this.clone();
		}
		
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof AbstractObject)
			return null;
		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	@Override
	public String toString() {
		return properties.toString();
	}

	@Override
	public int hashCode() {
		return this.properties.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof AbstractObject)
			return this.properties.equals(((AbstractObject)other).getAbstractObjectMap());

		return false;
	}

	public void put(FA k, AbstractValue v) {
		if (this.properties.containsKey(k)) {
			AbstractValue toPut = new Bottom();
			ArrayList<AbstractValue> other = (ArrayList<AbstractValue>) this.properties.get(k);
			properties.remove(k);

			for (AbstractValue o : other)
				toPut = toPut.leastUpperBound(o);

			properties.put(k, v.leastUpperBound(toPut));

		} else {
			this.properties.put(k, v);

		}

	}

	/**
	 * 
	 * @return normalized this abstract object
	 */
	public void normalize() {
		HashSet<FA> keys = new HashSet<FA>();

		for (FA k : this.properties.keySet()) {
			keys.add(k.clone());
		}

		// first part
		for (FA abstractProperty: keys) {
			Collection<AbstractValue> abstractValue = getAbstractObjectMap().get(abstractProperty);

			if (!abstractProperty.isInfinite() && (!abstractProperty.isSingleString() || abstractProperty.getLanguage().size() != 1)) {
				// this means that the abstract property recognizes only finite languages (not equals to 1)

				properties.remove(abstractProperty);
				for (String s: abstractProperty.getLanguage())
					for(AbstractValue a: abstractValue)
						put(new FA(s), a);
			}
		}

		// second part
		int previousHash;
		do {
			HashSet<Pair<FA, FA>> visited = new HashSet<Pair<FA,FA>>();

			previousHash = properties.hashCode();
			keys = new HashSet<FA>();

			for (FA k : this.properties.keySet()) 
				keys.add(k.clone());

			for (FA k1 : keys)  {

				AbstractValue v1 = get(k1);

				for (FA k2 : keys)  {

					AbstractValue v2 = get(k2);

					Automaton intersectionAutomaton = Automaton.intersection(k1.getAutomaton(), k2.getAutomaton());
					Pair<FA,FA> toCheck1 = new Pair<FA, FA>(k1, k2);
					Pair<FA,FA> toCheck2 = new Pair<FA, FA>(k2, k1);

					if ((!Automaton.isEmptyLanguageAccepted(intersectionAutomaton)) && !k1.equals(k2) && !visited.contains(toCheck1) && !visited.contains(toCheck2)) {

						FA intersectionProperty = new FA(intersectionAutomaton);
						this.properties.remove(k1);
						this.properties.remove(k2);

						FA minusP1P2 = k1.minus(k2); AbstractValue minusP1P2Value = get(minusP1P2).leastUpperBound(v1);
						FA minusP2P1 = k2.minus(k1); AbstractValue minusP2P1Value = get(minusP2P1).leastUpperBound(v2);

						MultiHashMap<FA, AbstractValue> toAdd = new MultiHashMap<FA, AbstractValue>();

						toAdd.put(intersectionProperty, lookupAbstractObject(intersectionProperty).leastUpperBound(v1).leastUpperBound(v2));


						if (!Automaton.isEmptyLanguageAccepted(minusP1P2.getAutomaton()) && !minusP1P2Value.equals(new Bottom())) 
							toAdd.put(minusP1P2, minusP1P2Value);

						if (!Automaton.isEmptyLanguageAccepted(minusP2P1.getAutomaton()) && !minusP2P1Value.equals(new Bottom())) 
							toAdd.put(minusP2P1, minusP2P1Value);


						for (FA k : toAdd.keySet()) 
							for (AbstractValue v : toAdd.get(k))
								put(k, v); 

					}
					visited.add(new Pair<FA, FA>(k1, k2));
					visited.add(new Pair<FA, FA>(k2, k1));
				}
			}

		} while (previousHash != properties.hashCode());
	}


	public AbstractValue lookupAbstractObject(FA p) {

		AbstractValue resultAbstractValue = new Bottom();

		for (FA abstractProperty: getAbstractObjectMap().keySet()) {
			// for each abstract property
			if (!Automaton.intersection(p.getAutomaton(), abstractProperty.getAutomaton()).equals(Automaton.makeEmptyLanguage())) {

				for(AbstractValue currentValue: getAbstractObjectMap().get(abstractProperty)) 
					resultAbstractValue = resultAbstractValue.leastUpperBound(currentValue);	
			}
		}

		return resultAbstractValue;
	}
	
	public AbstractValue get(FA k) {
		AbstractValue v2 = new Bottom();
		ArrayList<AbstractValue> s = (ArrayList<AbstractValue>) properties.get(k);
		if (s != null)
			for (AbstractValue v : s)
				v2 = v;
		return v2;
	}

}