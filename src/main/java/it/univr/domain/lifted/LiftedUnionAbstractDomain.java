package it.univr.domain.lifted;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;

public class LiftedUnionAbstractDomain extends AbstractDomain {

	@Override
	public AbstractValue juggleToNumber(AbstractValue v) {
		return v.juggleToNumber();
	}

	@Override
	public AbstractValue juggleToString(AbstractValue v) {
		return v.juggleToString();
	}

	@Override
	public AbstractValue juggleToBool(AbstractValue v) {
		return v.juggleToBool();
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue v1, AbstractValue v2) {
		return v1.leastUpperBound(v2);

	}

	@Override
	public AbstractValue widening(AbstractValue v1, AbstractValue v2) {
		return v1.widening(v2);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue v1, AbstractValue v2) {
		return v1.greatestLowerBound(v2);
	}

	@Override
	public AbstractValue narrowing(AbstractValue v1, AbstractValue v2) {
		return v1.narrowing(v2);
	}

	@Override
	public AbstractValue greater(AbstractValue v1, AbstractValue v2) {

		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.greater(left, right));

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue less(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.less(left, right));

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue sum(AbstractValue v1, AbstractValue v2) {

		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) {
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.sum(left, right));
				}

			return result;

		}

		return new LiftedUnionAbstractValue();
	}
	
	@Override
	public AbstractValue slice(AbstractValue v1, AbstractValue v2, AbstractValue v3) {

		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					for (AbstractValue c : ((LiftedUnionAbstractValue) v3).getTuple().values()) {
					if (!(a instanceof Bottom) && !(b instanceof Bottom) && !(c instanceof Bottom))
						result.lub(cdom.slice(a, b, c));
				}

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue diff(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.diff(left, right));

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue mul(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.mul(left, right));

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue substring(AbstractValue v1, AbstractValue v2, AbstractValue v3) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue && v3 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					for (AbstractValue c : ((LiftedUnionAbstractValue) v3).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom) && !(c instanceof Bottom)) 
							result.lub(cdom.substring(a, b, c));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}


	@Override
	public AbstractValue replace(AbstractValue v1, AbstractValue v2, AbstractValue v3) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue && v3 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					for (AbstractValue c : ((LiftedUnionAbstractValue) v3).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom) && !(c instanceof Bottom)) 
							result.lub(cdom.replace(a, b, c));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
	
	@Override
	public AbstractValue charAt(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom)) 
						result.lub(cdom.charAt(left, right));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}


	@Override
	public AbstractValue trim(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
					if (!(left instanceof Bottom)) 
						result.lub(cdom.trim(left));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue toLowerCase(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
					if (!(left instanceof Bottom)) 
						result.lub(cdom.toLowerCase(left));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
	
	@Override
	public AbstractValue toUpperCase(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
					if (!(left instanceof Bottom)) 
						result.lub(cdom.toUpperCase(left));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue trimLeft(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
					if (!(left instanceof Bottom)) 
						result.lub(cdom.trimLeft(left));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
	
	@Override
	public AbstractValue trimRight(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
					if (!(left instanceof Bottom)) 
						result.lub(cdom.trimRight(left));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue not(AbstractValue v1) {
		Bool result = (Bool) v1.juggleToBool();
		return result.not();
	}

	@Override
	public AbstractValue makeInterval(AbstractValue v) {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
		result.set(v);
		return result;
	}

	@Override
	public AbstractValue makeFA(AbstractValue v) {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
		result.set(v);
		return result;
	}

	@Override
	public AbstractValue makeNaN(AbstractValue v) {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
		result.set(v);
		return result;
	}

	@Override
	public AbstractValue makeBool(AbstractValue v) {
		LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
		result.set(v);
		return result;
	}

	@Override
	public AbstractValue length(AbstractValue v1) {
		if (v1 instanceof LiftedUnionAbstractValue) {
			if (((LiftedUnionAbstractValue) v1).isFA()) {
				LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();
				result.setInterval(((FA) ((LiftedUnionAbstractValue) v1).getFA()).length());
				return result;
			}
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue equals(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.equals(left, right));
				

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue indexOf(AbstractValue v1, AbstractValue v2) {

		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) {
					if (!(left instanceof Bottom) && !(right instanceof Bottom)) 
						result.lub(cdom.indexOf(left, right));
				}
			return result;
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue and(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) {
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.and(left, right));
				}

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue or(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) {
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.or(left, right));
				}

			return result;

		}

		return new LiftedUnionAbstractValue();
	}
	
	@Override
	public AbstractValue div(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {
			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue left : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue right : ((LiftedUnionAbstractValue) v2).getTuple().values()) {
					if (!(left instanceof Bottom) && !(right instanceof Bottom))
						result.lub(cdom.div(left, right));
				}

			return result;

		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue makeBottom() {
		return new LiftedUnionAbstractValue();
	}

	@Override
	public boolean isTrue(AbstractValue v) {
		return v instanceof Bool && ((Bool) v).isTrue(); 
	}

	@Override
	public boolean isFalse(AbstractValue v) {	
		return v instanceof Bool && ((Bool) v).isFalse(); 
	}

	@Override
	public boolean isTopBool(AbstractValue v) {	
		return v instanceof Bool && ((Bool) v).isTopBool(); 

	}

	@Override
	public AbstractValue makeUnknownInteger() {
		LiftedUnionAbstractValue r = new LiftedUnionAbstractValue();
		r.setInterval(new Interval("-Inf", "+Inf"));
		return r;
	}

	@Override
	public AbstractValue includes(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom)) 
							result.lub(cdom.includes(a, b));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}

	@Override
	public AbstractValue repeat(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom)) 
							result.lub(cdom.repeat(a, b));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
	


	@Override
	public AbstractValue startsWith(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom)) 
							result.lub(cdom.startsWith(a, b));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
	


	@Override
	public AbstractValue endsWith(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof LiftedUnionAbstractValue && v2 instanceof LiftedUnionAbstractValue) {

			CoalascedAbstractDomain cdom = new CoalascedAbstractDomain();
			LiftedUnionAbstractValue result = new LiftedUnionAbstractValue();

			for (AbstractValue a : ((LiftedUnionAbstractValue) v1).getTuple().values())
				for (AbstractValue b : ((LiftedUnionAbstractValue) v2).getTuple().values()) 
						if (!(a instanceof Bottom) && !(b instanceof Bottom)) 
							result.lub(cdom.endsWith(a, b));

			return result;
		}

		return new LiftedUnionAbstractValue();
	}
}
