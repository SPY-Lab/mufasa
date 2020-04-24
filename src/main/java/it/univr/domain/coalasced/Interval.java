package it.univr.domain.coalasced;

import java.util.ArrayList;
import java.util.HashSet;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

/**
 * Interval abstract domain.
 * 
 *  @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 */
public class Interval implements AbstractValue {

	/**
	 * Low value
	 */
	private String low;

	/**
	 * High value
	 */
	private String high;


	/**
	 * Interval constructor
	 * @param low low value
	 * @param high high value
	 */
	public Interval(String low, String high) {
		this.low = low;
		this.high = high;
	}

	/**
	 * Construct top interval [-Inf, +Inf]
	 * @return return top interval [-Inf, +Inf]
	 */
	public static Interval makeTopInterval() {
		return new Interval("-Inf", "+Inf");
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {

		if (other instanceof Interval) {
			Interval otherInterval = (Interval) other;

			String newLow = (getLow().equals("-Inf") || otherInterval.getLow().equals("-Inf")) ? "-Inf" : String.valueOf(Long.min(Long.parseLong(getLow()), Long.parseLong(otherInterval.getLow())));
			String newHigh = (getHigh().equals("+Inf") || otherInterval.getHigh().equals("+Inf")) ? "+Inf" : String.valueOf(Long.max(Long.parseLong(getHigh()), Long.parseLong(otherInterval.getHigh())));

			return new Interval(newLow, newHigh);
		} else if (other instanceof Bottom)
			return clone();

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {

		if (other instanceof Interval) {
			Interval otherInterval = (Interval) other;

			Long maxI1 = getHigh().equals("+Inf") ? Integer.MAX_VALUE : Long.parseLong(getHigh());
			Long maxI2 = otherInterval.getHigh().equals("+Inf") ? Integer.MAX_VALUE : Long.parseLong(otherInterval.getHigh());
			Long minI1 = getLow().equals("-Inf") ? Integer.MIN_VALUE : Long.parseLong(getLow());
			Long minI2 = otherInterval.getLow().equals("-Inf") ? Integer.MIN_VALUE : Long.parseLong(otherInterval.getLow());

			String newLow, newHigh;
			if (minI2 < minI1)
				newLow = "-Inf";
			else
				newLow = getLow();

			if (maxI2 > maxI1)
				newHigh = "+Inf";
			else
				newHigh = getHigh();

			return new Interval(newLow, newHigh);
		}
		return new Top();
	}


	@Override
	public String toString() {
		return "[" + low + ", " + high +  "]";
	}

	/**
	 * Check if this is finite concrete, that is if its concretization is a finite set.
	 * @return true if the concretization of this is a finite set, false otherwise.
	 */
	public boolean isFiniteConcrete() {
		try {
			Long.parseLong(getLow());
			Long.parseLong(getHigh());
			return !low.equals("-Inf") && !high.equals("+Inf");
		} catch (NumberFormatException n){
			return false;
		}
	}

	/**
	 * Plus interval operation.
	 * 
	 * @param other second operand
	 * @return the sum between the intervals, i,e. [l1,h1] + [l2,h2].
	 */
	public Interval plus(Interval other) {
		Interval result = new Interval("", "");


		if (isNegativeInfinite() || other.isNegativeInfinite())
			result.setLow("-Inf");
		else 
			result.setLow(String.valueOf(Long.parseLong(this.getLow()) + Long.parseLong(other.getLow())));

		if (isPositiveInfinite() || other.isPositiveInfinite())
			result.setHigh("+Inf");
		else 
			result.setHigh(String.valueOf(Long.parseLong(this.getHigh()) + Long.parseLong(other.getHigh())));

		return result;
	}

	/**
	 * Minus interval operation.
	 * 
	 * @param other second operand
	 * @return the minus between the intervals, i,e. [l1,h1] - [l2,h2].
	 */
	public Interval diff(Interval other) {
		return this.plus(other.mul(new Interval("-1", "-1")));
	}

	/**
	 * Multiplication interval operation.
	 * 
	 * @param other second operand
	 * @return the multiplication between the intervals, i,e. [l1,h1] * [l2,h2].
	 */
	public Interval mul(Interval other) {
		HashSet<String> boundSet = new HashSet<String>();

		String x1 = this.getLow();
		String x2 = this.getHigh();
		String y1 = other.getLow();
		String y2 = other.getHigh();

		// x1y1
		if (x1.equals("-Inf")) {
			if (y1.equals("-Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(y1) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(y1) < 0)
					boundSet.add("+Inf");
				else
					boundSet.add("0");
			}
		} else if (y1.equals("-Inf")) {
			if (x1.equals("-Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(x1) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(x1) < 0)
					boundSet.add("+Inf");
				else
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x1) * Long.parseLong(y1)));
		}

		// x1y2
		if (x1.equals("-Inf")) {
			if (y2.equals("+Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(y2) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(y2) < 0)
					boundSet.add("+Inf");
				else 
					boundSet.add("0");
			}
		} else if (y2.equals("+Inf")) {
			if (x1.equals("-Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(x1) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(x1) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x1) * Long.parseLong(y2)));
		}

		// x2y1
		if (x2.equals("+Inf")) {
			if (y1.equals("-Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(y1) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(y1) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else if (y1.equals("-Inf")) {
			if (x2.equals("+Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(x2) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(x2) < 0)
					boundSet.add("+Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x2) * Long.parseLong(y1)));
		}

		// x2y2
		if (x2.equals("+Inf")) {
			if (y2.equals("+Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(y2) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(y2) < 0)
					boundSet.add("-Inf");
				else
					boundSet.add("0");
			}
		} else if (y2.equals("+Inf")) {
			if (x2.equals("+Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(x2) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(x2) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x2) * Long.parseLong(y2)));
		}

		return new Interval(getMinValue(boundSet), getMaxValue(boundSet));
	}

	/**
	 * Integers into this interval: before calling this function, check if this is finite concrete.
	 * @return list of integers into this interval.
	 */
	public ArrayList<Long> getIntergers() {

		if (isFiniteConcrete()) {
			long start = Long.parseLong(this.getLow());
			long end = Long.parseLong(this.getHigh());

			ArrayList<Long> result = new ArrayList<Long>();

			result.add(start);

			for (long i = start; i <= end; ++i) 
				if (!result.contains(i))
					result.add(i);
			return result;
		}

		return new ArrayList<Long>();
	}

	private String getMinValue(HashSet<String> set) {
		Long min = Long.MAX_VALUE;
		int count = 0;

		for (String bound : set) 
			if (bound.equals("-Inf"))
				return "-Inf";
			else if (bound.equals("+Inf")) 
				count++;
			else if (Long.parseLong(bound) < min)
				min = Long.parseLong(bound);

		return count == 4 ? "+Inf" : String.valueOf(min);
	}

	private String getMaxValue(HashSet<String> set) {
		Long max = Long.MIN_VALUE;
		int count = 0;

		for (String bound : set) 
			if (bound.equals("+Inf"))
				return "+Inf";
			else if (bound.equals("-Inf")) 
				count++;
			else if (Long.parseLong(bound) > max)
				max = Long.parseLong(bound);

		return count == 4 ? "-Inf" : String.valueOf(max);
	}	

	/**
	 * Return low value.
	 * @return low value.
	 */
	public String getLow() {
		return low;
	}

	/**
	 * Set low value.
	 * @param low low value to set.
	 */
	public void setLow(String low) {
		this.low = low;
	}

	/**
	 * Return high value.
	 * @return high value.
	 */
	public String getHigh() {
		return high;
	}

	/**
	 * Set high value.
	 * @param high high value to set .
	 */
	public void setHigh(String high) {
		this.high = high;
	}

	/**
	 * Check if the low value is -Inf.
	 * @return true if this low value is -Inf, false otherwise.
	 */
	public boolean isNegativeInfinite() {
		return this.getLow().equals("-Inf");
	}

	/**
	 * Check if the high value is +Inf.
	 * @return true if this high value is +Inf, false othewise.
	 */
	public boolean isPositiveInfinite() {
		return this.getHigh().equals("+Inf");
	}

	/**
	 * Check if this is [-Inf, +Inf]
	 * @return true if this is [-Inf, +Inf], false othewise.
	 */
	public boolean isTopInterval() {
		return this.isNegativeInfinite() && this.isPositiveInfinite();
	}

	/**
	 * Check if this is [0,0]
	 * @return true if this is [0,0], false otherwise.
	 */
	public boolean isZeroInterval() {
		return getLow().equals("0") && getHigh().equals("0");
	}

	/**
	 * Check if the parameter n is into this interval.
	 * @param n integer parameter
	 * @return true if n is contained into this interval, false otherwise.
	 */
	public boolean contains(long n) {
		if (isFiniteConcrete()) 
			return n >= Long.parseLong(getLow()) && n <= Long.parseLong(getHigh());
			else if (isNegativeInfinite() && !isPositiveInfinite()) 
				return n <= Long.parseLong(getHigh());
			else if (!isNegativeInfinite() && isPositiveInfinite())
				return n >= Long.parseLong(getLow());
				return true;
	}

	@Override
	public AbstractValue juggleToNumber() {
		return clone();
	}

	@Override
	public AbstractValue juggleToString() {

		// [i, j]
		if (isFiniteConcrete()) {

			HashSet<State> states = new HashSet<>();
			HashSet<Transition> delta = new HashSet<>();

			State q0 = new State("q0", true, false);
			states.add(q0);


			int i = 1;

			for (Long n : getIntergers()) {

				if (n > 0) {
					State p = new State("q" + i, false, true);
					states.add(p);
					delta.add(new Transition(q0, p, String.valueOf(n)));
				} else {

					State p = new State("q" + i, false, false);
					i++;
					State q = new State("q" + i, false, true);

					states.add(p);
					states.add(q);

					delta.add(new Transition(q0, p, "-"));
					delta.add(new Transition(q0, p, String.valueOf(Math.abs(n))));
				}

				i++;
			}

			Automaton result = new Automaton(delta, states);
			return new FA(result);
		} 


		// [i, +Inf]
		else if (isPositiveInfinite() && !isNegativeInfinite()) {

			if (Long.parseLong(getLow()) == 0) 
				return FA.makePositiveNumbersAutomaton();
			else if (Long.parseLong(getLow()) > 0) 
				return new FA(Automaton.minus(FA.makePositiveNumbersAutomaton().getAutomaton(), ((FA) new Interval("0", getLow()).juggleToString()).getAutomaton()));
			else 
				return new FA(Automaton.union(FA.makePositiveNumbersAutomaton().getAutomaton(), ((FA) new Interval(getLow(), "0").juggleToString()).getAutomaton()));				
		}

		// [-Inf, i]
		else if (isPositiveInfinite() && !isNegativeInfinite()) {
			if (Long.parseLong(getHigh()) == 0) 
				return FA.makeNegativeNumbersAutomaton();
			else if (Long.parseLong(getHigh()) > 0) 
				return new FA(Automaton.union(FA.makeNegativeNumbersAutomaton().getAutomaton(), ((FA) new Interval("0", getHigh()).juggleToString()).getAutomaton()));
			else 
				return new FA(Automaton.minus(FA.makeNegativeNumbersAutomaton().getAutomaton(), ((FA) new Interval(getHigh(), "0").juggleToString()).getAutomaton()));				
		} 

		return FA.makeNumberAutomaton();
	}



	private long getMax(ArrayList<Long> list) {
		long max = Long.MIN_VALUE;

		for (int i = 0; i < list.size(); i++)
			if (list.get(i) > max)
				max = list.get(i);

		return max;
	} 

	@Override
	public AbstractValue juggleToBool() {
		if (isZeroInterval())
			return new Bool(0);
		else if (!contains(0))
			return new Bool(1);
		return new Bool(2);
	}

	@Override
	public Interval clone() {
		return new Interval(getLow(), getHigh());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Interval)
			return getLow().equals(((Interval) other).getLow()) && getHigh().equals(((Interval) other).getHigh());
		return false;
	}

	public Bool greater(Interval other) {
		if (getLow().equals(getHigh()) && other.getLow().equals(other.getHigh()) && !getLow().contains("Inf") && !getLow().contains("Inf")) {
			Long a = Long.parseLong(getLow());
			Long b = Long.parseLong(other.getLow());

			if (a > b)
				return new Bool(1);
			return new Bool(0);
		}

		Long x2 = isPositiveInfinite() ? Long.MAX_VALUE : Long.parseLong(getHigh());
		Long y2 = other.isPositiveInfinite() ? Long.MAX_VALUE : Long.parseLong(other.getHigh());
		Long x1 = isNegativeInfinite() ? Long.MIN_VALUE : Long.parseLong(getLow());
		Long y1 = other.isNegativeInfinite() ? Long.MIN_VALUE : Long.parseLong(other.getLow());

		if (x2 > y1) {
			if (x1 > y2)
				return new Bool(1);
			else
				return new Bool(2);
		} else if (x2 < y1) 
			return new Bool(0);

		return new Bool(2);
	}

	public Bool less(Interval other) {
		if (getLow().equals(getHigh()) && other.getLow().equals(other.getHigh()) && !getLow().contains("Inf") && !getLow().contains("Inf")) {
			Long a = Long.parseLong(getLow());
			Long b = Long.parseLong(other.getLow());

			if (a < b)
				return new Bool(1);
			return new Bool(0);
		}

		Long x2 = isPositiveInfinite() ? Long.MAX_VALUE : Long.parseLong(getHigh());
		Long y2 = other.isPositiveInfinite() ? Long.MAX_VALUE : Long.parseLong(other.getHigh());
		Long x1 = isNegativeInfinite() ? Long.MIN_VALUE : Long.parseLong(getLow());
		Long y1 = other.isNegativeInfinite() ? Long.MIN_VALUE : Long.parseLong(other.getLow());

		if (x2 < y1) {
			if (x1 < y2)
				return new Bool(1);
			else
				return new Bool(2);
		} else if (x2 < y1) 
			return new Bool(0);

		return new Bool(2);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue o) {

		if (o instanceof Interval) {
			Interval other = (Interval) o;


			//			if (Integer.parseInt(other.getHigh()) >= Integer.parseInt(getLow()))	
			//				return new Interval("+Inf", "-Inf");
			//			if (Integer.parseInt(getHigh()) >= Integer.parseInt(other.getLow()))	
			//				return new Interval("+Inf", "-Inf");

			String newHigh = "", newLow = "";

			if (isNegativeInfinite())
				newLow = other.getLow();
			else if (other.isNegativeInfinite())
				newLow = getLow();
			else
				newLow = String.valueOf(Long.max(Long.parseLong(getLow()), Long.parseLong(other.getLow())));

			if (isPositiveInfinite())
				newHigh = other.getHigh();
			else if (other.isPositiveInfinite())
				newHigh = getHigh();
			else
				newHigh = String.valueOf(Long.min(Long.parseLong(getHigh()), Long.parseLong(other.getHigh())));


			return new Interval(newLow, newHigh);
		}

		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		String newLow = "";
		String newHigh = "";
		if (value instanceof Interval) {
			if (isNegativeInfinite())
				newLow = ((Interval) value).getLow();
			else
				newLow = getLow();

			if (isPositiveInfinite())
				newHigh = ((Interval) value).getHigh();
			else
				newHigh = getHigh();

			return new Interval(newLow, newHigh);
		}

		return new Bottom();
	}

	public Bool isEqual(Interval other) {
		// Interval concrete case
		if (getLow().equals(other.getHigh()) && other.getLow().equals(other.getHigh()) && !getLow().contains("Inf") && !other.getLow().contains("Inf")) {
			Long a = Long.parseLong(getLow());
			Long b = Long.parseLong(other.getLow());

			if (a == b)
				return new Bool(1);
			else
				return new Bool(0); 
		} 

		Long x2 = getHigh().equals("+Inf") ? Long.MAX_VALUE : Long.parseLong(getHigh());
		Long y2 = other.getHigh().equals("+Inf") ? Long.MAX_VALUE : Long.parseLong(other.getHigh());
		Long x1 = getLow().equals("-Inf") ? Long.MIN_VALUE : Long.parseLong(getLow());
		Long y1 = other.getLow().equals("-Inf") ? Long.MIN_VALUE : Long.parseLong(other.getLow());

		if (x2 > y1) {
			if (x1 > y2)
				return new Bool(0); 
			else
				return new Bool(2);
		} else if (x2 < y1) {
			return new Bool(0); 
		}  

		return new Bool(2);
	}

}
