package it.univr.domain.coalasced;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class FA implements AbstractValue {

	private static int widening = 3;

	private Automaton automaton;

	private boolean hasCycle() {
		return this.automaton.hasCycle();
	}

	public HashSet<String> getLanguage() {
		assertTrue(!this.automaton.hasCycle());
		return this.automaton.getLanguage();
	}

	public boolean isSingleString() {
		return this.automaton.isSingleString();
	}

	public boolean isInfinite() {
		return hasCycle();
	}

	public static FA star(Automaton a) {
		return new FA(Automaton.star(a));
	}

	public static FA star(String s) {
		return new FA(Automaton.star(Automaton.makeAutomaton(s)));
	}

	public FA minus(FA that) {
		return new FA(Automaton.minus(this.automaton, that.automaton));
	}

	public FA() {
		this.automaton = Automaton.makeEmptyLanguage();
	}

	public FA(String s) {
		this.automaton = Automaton.makeRealAutomaton(s);
		this.automaton.minimize();
	}

	public FA(Automaton automaton) {
		this.automaton = automaton;
		this.automaton.minimize();
	}

	public void minimize() {
		automaton.minimize();
	}

	public static void setWidening(int w) {
		FA.widening = w;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof FA) 
			return new FA(Automaton.union(getAutomaton(), ((FA) other).getAutomaton()));
		else if (other instanceof Bottom)
			return clone();
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		if (other instanceof FA) 
			return new FA(Automaton.union(getAutomaton(), ((FA) other).getAutomaton()).widening(widening));
		else if (other instanceof Bottom)
			return clone();

		return new Top();	
	}

	public Automaton getAutomaton() {
		return automaton;
	}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	@Override
	public String toString() {
		return automaton.toRegex().toString();
	}

	public FA concat(FA other) {
		return new FA(Automaton.concat(automaton, other.getAutomaton()));
	}

	public FA substring(Interval init, Interval end) {
		Automaton result = Automaton.makeEmptyLanguage();

		if (getAutomaton().isSingleString())
			setAutomaton(Automaton.makeRealAutomaton(getAutomaton().getSingleString()));

		if (init.isNegativeInfinite())
			init.setLow("0");

		if (end.isNegativeInfinite())
			end.setLow("0");

		//
		// First row
		//
		if (init.isFiniteConcrete()) {
			if (end.isFiniteConcrete()) {
				ArrayList<Long> initIntegers = init.getIntergers();
				ArrayList<Long> endIntegers = end.getIntergers();

				for (int i = 0; i < initIntegers.size(); i++)
					for (int j = 0; j < endIntegers.size(); j++)
						result = Automaton.union(result, Automaton.substring(automaton, initIntegers.get(i), endIntegers.get(j)));
				result.minimize();
				return new FA(result);
			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(init, new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {

				long i = Integer.parseInt(init.getLow());
				long j = Integer.parseInt(init.getHigh());
				long l = Integer.parseInt(end.getLow());


				// Table 1 case (first row, third column)
				if (i <= l && j <= l) {
					ArrayList<Long> initIntegers = init.getIntergers();

					for (int c = 0; c < initIntegers.size(); ++c)
						result = Automaton.union(result, Automaton.substringWithUnknownEndPoint(automaton, initIntegers.get(c), l));

					return new FA(result);

				}

				// Table 2 case (first row, third column)
				else if (l < i) {
					return FA.union(
							substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(i), String.valueOf(j)))
							, 
							substring(new Interval(String.valueOf(i), String.valueOf(j)), new Interval(String.valueOf(j),"+Inf")));

				}

				// Table 3 (first row, third column)
				else if (i <= l && j > l) {
					FA first = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(l), String.valueOf(j)));
					FA second = substring(new Interval(String.valueOf(i), String.valueOf(l)), new Interval(String.valueOf(l), "+Inf"));
					FA third = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(j), "+Inf"));

					return FA.union(FA.union(first, second), third);

				}
			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(init, new Interval("0", "+Inf"));
			}
		}

		//
		// Second row
		//
		else if (init.isNegativeInfinite() && !init.isPositiveInfinite()) {


			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", init.getHigh()), end);
			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval(end.getLow(), "+Inf"));
			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", "+Inf"));
			}

		}

		//
		// Third row
		//
		else if (!init.isNegativeInfinite() && init.isPositiveInfinite()) {

			if (end.isFiniteConcrete()) {

				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());
				long k = Integer.parseInt(end.getHigh());

				// Table 1 (third row, first column)
				if (i <= l) {
					FA first = substring(new Interval(String.valueOf(i), String.valueOf(k)), end);
					FA second = substring(end, new Interval(end.getLow(), "+Inf"));

					return FA.union(first, second);
				}

				// Table 2 (third row, first column)
				else if (l < i && i <= k) {
					FA first = substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), end.getHigh()));
					FA second = substring(new Interval(end.getLow(), init.getLow()), new Interval(init.getLow(),"+Inf"));
					FA third = substring(new Interval(init.getLow(), end.getHigh()), new Interval(end.getHigh(), "+Inf"));

					return FA.union(FA.union(first, second), third);
				}

				// Table 3 (third row, first column)
				else if (i > k) {

					return substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), "+Inf"));
				}

			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {

				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());

				// Table 1 (third row, third column)
				if (i <= l) {
					FA first = substring(new Interval(init.getLow(), end.getLow()), new Interval(end.getLow(), "+Inf"));
					FA second = new FA(Automaton.factorsStartingAt(automaton, l));

					return FA.union(first, second);
				}

				// Table 2 (third row, third column)
				else if (l < i) {
					return substring(new Interval(end.getLow(), "+Inf"), new Interval(init.getLow(), "+Inf"));
				}

				// Table 3 (third row, third column)
				else 
					return substring(init, end);

			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", "+Inf"));
			}

		}

		//
		// Fourth row
		//
		else if (init.isNegativeInfinite() && init.isPositiveInfinite()) {

			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", "+Inf"), end);
			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval(end.getLow(), "+Inf"));
			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return new FA(Automaton.factors(automaton));
			}
		}

		return null;

	}

	public static FA union(FA a, FA b) {
		return new FA(Automaton.union(a.getAutomaton(), b.getAutomaton()));
	}

	public static FA makeEmptyLanguage() {
		return new FA(Automaton.makeEmptyLanguage());
	}

	public static FA union(String ... strings) {
		FA res = FA.makeEmptyLanguage();

		for (String s : strings)
			res = FA.union(res, new FA(s));

		return res;
	}

	public static FA union(FA ... automata) {
		FA res = FA.makeEmptyLanguage();

		for (FA a : automata)
			res = FA.union(res, a);

		return res;
	}

	public FA charAt(Interval index) {

		Automaton result = Automaton.makeEmptyLanguage();

		if (getAutomaton().isSingleString())
			setAutomaton(Automaton.makeRealAutomaton(getAutomaton().getSingleString()));

		// Case 1
		if (index.isFiniteConcrete()) {

			ArrayList<Long> integers = index.getIntergers();
			for (int i = 0; i < integers.size(); ++i)
				result = Automaton.union(result, Automaton.charAt(automaton, integers.get(i)));
		} 
		// Case 2
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) >= 0) {
			result = Automaton.union(charAt(new Interval("0", index.getHigh())).getAutomaton(), Automaton.makeEmptyString());
		} 
		// Case 3
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) < 0) {
			result = Automaton.makeEmptyString();
		} 
		// Case 4
		else if (!index.isNegativeInfinite() && index.isPositiveInfinite() && Integer.parseInt(index.getLow()) >= 0) {
			//			result = Automaton.intersection(Automaton.factorsStartingAt(automaton, Integer.parseInt(index.getLow())), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(Automaton.chars(Automaton.suffixesAt(Integer.parseInt(index.getLow()), automaton)), Automaton.makeEmptyString());
		} 
		// Case 5
		else {
			//			result = Automaton.intersection(Automaton.factors(automaton), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(Automaton.chars(automaton), Automaton.makeEmptyString());
		}

		return new FA(result);
	}

	@Override
	public AbstractValue juggleToNumber() {
		FA numbers = FA.makeNumberAutomaton();

		Automaton numbersIntoAutomaton = Automaton.intersection(numbers.getAutomaton(), getAutomaton());
		boolean hasOnlyNumbers = Automaton.isContained(getAutomaton(), numbers.getAutomaton());

		if (!Automaton.isEmptyLanguageAccepted(numbersIntoAutomaton) && hasOnlyNumbers) {

			//TODO: extract numbers from automaton.
			return new FA(numbersIntoAutomaton);
		}
		else if (!hasOnlyNumbers)
			return new Top();

		return new NaN();
	}

	@Override
	public AbstractValue juggleToString() {
		return clone();
	}

	@Override
	public AbstractValue juggleToBool() {

		if (getAutomaton().equals(Automaton.makeEmptyString()))
			return new Bool(0);
		else if (Automaton.isContained(Automaton.makeEmptyString(), getAutomaton()))
			return new Bool(2);

		return new Bool(1);
	}

	@Override
	public FA clone() {
		return new FA(getAutomaton().clone());
	}

	public static FA makeNumberAutomaton() {

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();


		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);


		states.add(q0);
		states.add(q1);
		states.add(q2);

		delta.add(new Transition(q0, q1, "+"));
		delta.add(new Transition(q0, q1, "-"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q0, q2, String.valueOf(i)));
			delta.add(new Transition(q1, q2, String.valueOf(i)));
			delta.add(new Transition(q2, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public static FA makeNegativeNumbersAutomaton() {

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);
		State q3 = new State("q3", false, false);


		states.add(q0);
		states.add(q1);
		states.add(q2);
		states.add(q3);

		delta.add(new Transition(q0, q1, "+"));
		delta.add(new Transition(q0, q1, "-"));
		delta.add(new Transition(q1, q2, "0"));
		delta.add(new Transition(q0, q3, "-"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q3, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public static FA makePositiveNumbersAutomaton() {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);

		states.add(q0);
		states.add(q1);
		states.add(q2);

		delta.add(new Transition(q0, q1, "+"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q0, q2, String.valueOf(i)));
			delta.add(new Transition(q1, q2, String.valueOf(i)));
			delta.add(new Transition(q2, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public Interval length() {

		if (getAutomaton().isSingleString())
			return new Interval(String.valueOf(getAutomaton().getSingleString().length()), String.valueOf(getAutomaton().getSingleString().length()));

		if (getAutomaton().hasCycle()) {

			HashSet<Integer> lengths = new HashSet<Integer>();

			for (State f : getAutomaton().getFinalStates()) 
				lengths.add(getAutomaton().minimumDijkstra(f).size() - 1);

			return new Interval(String.valueOf(getMinimumInteger(lengths)), "+Inf");

		} else {

			HashSet<Integer> lengths = new HashSet<Integer>();

			for (State f : getAutomaton().getFinalStates()) {
				lengths.add(getAutomaton().minimumDijkstra(f).size() - 1);
				lengths.add(getAutomaton().maximumDijkstra(f).size() - 1);
			}

			return new Interval(String.valueOf(getMinimumInteger(lengths)), String.valueOf(getMaximumInteger(lengths)));	
		}
	}

	private int getMinimumInteger(HashSet<Integer> set) {
		int min = Integer.MAX_VALUE;

		for (Integer i : set)
			if (i < min)
				min = i;

		return min;	
	}

	private int getMaximumInteger(HashSet<Integer> set) {
		int max = -1;

		for (Integer i : set)
			if (i > max)
				max = i;

		return max;	
	}

	public Interval indexOf(FA search) {

		if (getAutomaton().hasCycle())
			return new Interval("-1", "+Inf");

				
		if (getAutomaton().isSingleString() && search.getAutomaton().isSingleString()) {
			String first =  getAutomaton().getSingleString();
			String second = search.getAutomaton().getSingleString();
			
			if (first.contains(second)) {
				int i = first.indexOf(second);
				return new Interval(String.valueOf(i),String.valueOf(i));
			} else {
				return new Interval("-1","-1");
			}
					
		} else if (!getAutomaton().hasCycle() && !search.getAutomaton().hasCycle()) {
			
			
			HashSet<String> first =  getAutomaton().getLanguage();
			HashSet<String> second = search.getAutomaton().getLanguage();
			
			Interval result = null;
			for (String f1 : first) {
				for (String f2: second) {
					Interval partial;
					
					if (f1.contains(f2)) {
						int i = f1.indexOf(f2);
						partial = new Interval(String.valueOf(i),String.valueOf(i));
					} else {
						partial = new Interval("-1","-1");
					}

					
					result = result == null ? partial : (Interval) partial.leastUpperBound(result);
				}
			}
			
			return result;
		}
		
		
		Automaton build = getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(getAutomaton().getSingleString()) : getAutomaton().clone();
		Automaton search_clone = search.getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(search.getAutomaton().getSingleString()) : search.getAutomaton().clone();

		Automaton original = getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(getAutomaton().getSingleString()) : getAutomaton().clone();

		HashSet<Integer> indexesOf = new HashSet<>();

		for (State s : build.getStates()) {
			if (s.isInitialState())
				s.setInitialState(false);
			s.setFinalState(true);
		}

		for (State q : build.getStates()) {
			q.setInitialState(true);

			if (!Automaton.isEmptyLanguageAccepted(Automaton.intersection(build, search_clone))) 
				indexesOf.add(original.maximumDijkstra(q).size() - 1);


			q.setInitialState(false);	
		}

		// No state in the automaton can read search
		if (indexesOf.isEmpty())
			return new Interval("-1", "-1");
		else if (search_clone.recognizesExactlyOneString() && original.recognizesExactlyOneString())
			return new Interval(String.valueOf(getMinimumInteger(indexesOf)), String.valueOf(getMinimumInteger(indexesOf)));
		else 
			return new Interval("-1", String.valueOf(getMaximumInteger(indexesOf)));

	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof FA)
			return getAutomaton().equals(((FA) other).getAutomaton());
		return false;
	}

	@Override
	public int hashCode() {
		return this.getAutomaton().hashCode();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof FA) 
			return new FA(Automaton.intersection(getAutomaton(), ((FA) value).getAutomaton()));
		return new Bottom();
	}

	public FA repeat(Interval i){

		//TODO per vedere dove serve lanciare eccezione controllare la tabella di riferimento in latex per repeat
		boolean cyclic = getAutomaton().hasCycle();

		if(this.getAutomaton().equals(Automaton.makeEmptyString())){
			return this;
		}

		//cases with -infinity, all need exception
		if(i.getLow() == "-Inf"){
			if(i.getHigh() == "+Inf") {
				if (cyclic) {
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				} else {
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}
			}

			int high = Integer.parseInt(i.getHigh());
			if(high == 0){
				return new FA(Automaton.makeEmptyString());
			}else{
				if(cyclic){
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				}else{
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}
			}

		}

		int low = Integer.parseInt(i.getLow());

		if(i.getHigh() == "+Inf"){
			//need exception
			if(low < 0){
				if(cyclic){
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				}else{
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}
			}
			if(low == 0){
				if(cyclic){
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				}else{
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}

			}
			if(low > 0){
				if(cyclic){
					return this;
				}else{
					return auxRepeat(new Interval(i.getLow(), i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage());
				}

			}
		}

		int high = Integer.parseInt(i.getHigh());

		//TODO all these need exception
		if(low < 0){
			if(high < 0){
				return new FA(Automaton.makeEmptyLanguage());
			}
			if(high == 0){
				return new FA(Automaton.makeEmptyString());
			}else{
				if(cyclic){
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				}else{
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}
			}
		}

		if(low == 0) {
			if(high == 0){
				return new FA(Automaton.makeEmptyString());
			}
			if(high > 0){
				if(cyclic){
					return FA.union(new FA(Automaton.makeEmptyString()), this);
				}else{
					return FA.union(new FA(Automaton.makeEmptyString()),
							auxRepeat(new Interval("" + 1, i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage()));
				}
			}
		}

		if(low > 0 && high > 0){
			if(cyclic){
				return this;
			}else{
				return auxRepeat(new Interval(i.getLow(), i.getHigh()), this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage());
			}
		}

		return new FA(Automaton.makeEmptyLanguage());
	}

	public FA auxRepeat(Interval i, State currentState, HashSet<Transition> delta, Automaton result){

		if(currentState.isFinalState()){

			HashSet<State> states = new HashSet<>();

			for(State s: this.getAutomaton().getStates()){
				State newState = (State)s.clone();
				states.add(newState);
				if(!newState.equals(currentState)){
					newState.setFinalState(false);
				}
			}

			Automaton temp = new Automaton(delta, states);
			Automaton tempResult = temp.clone();

			for(int k = 1; k < Integer.parseInt(i.getLow()); k++){
				tempResult = FA.connectAutomaton(tempResult, temp, tempResult.getFinalStates(), false);
			}

			if(i.getHigh() == "+Inf"){
				tempResult = FA.connectAutomaton(tempResult, FA.makeCyclic((Automaton)temp.clone()).getAutomaton(), tempResult.getFinalStates(), true);
			}else {
				for (int k = Integer.parseInt(i.getLow()); k < Integer.parseInt(i.getHigh()); k++) {
					tempResult = FA.connectAutomaton(tempResult, temp, tempResult.getFinalStates(), true);
				}
			}

			result = Automaton.union(result, tempResult);

		}

		for(Transition t: this.getAutomaton().getOutgoingTransitionsFrom(currentState)){
			HashSet<Transition> clone = (HashSet<Transition>)delta.clone();
			clone.add(t);
			result = FA.union(auxRepeat(i, t.getTo(), clone, result), new FA(result)).getAutomaton();
		}

		return new FA(result);

	}

	/**
	 * Method that creates a cyclic automaton from a given one, the automaton must recognize only one string
	 * (it should be a function for automaton and not for FA)
	 * @return
	 */
	public static FA makeCyclic(Automaton a){

		HashSet<State> newStates = new HashSet<>();
		HashSet<Transition> newDelta = new HashSet<>();
		Transition finalT = null;

		for(State s: a.getStates())
			newStates.add(s);

		for(State s: a.getFinalStates())
			newStates.remove(s);

		a.getInitialState().setFinalState(true);

		for(Transition t: a.getDelta()){
			if(!t.getTo().isFinalState())
				newDelta.add(t);
			else
				finalT = t;
		}

		newDelta.add(new Transition(finalT.getFrom(), a.getInitialState(), finalT.getInput()));
		return new FA(new Automaton(newDelta, newStates));
	}


	/**
	 * Method that connect two automatons
	 * @param first first automaton
	 * @param second second automaton
	 * @param connectOn set of states on which make the connection
	 * @param b if true, the final states of the first automaton, if contained in connectOn, are kept final
	 *          if false, the final states in connectOn are not kept final
	 * @return
	 */
	public static Automaton connectAutomaton(Automaton first, Automaton second, HashSet<State> connectOn, boolean b){
		HashSet<Transition> delta = new HashSet<>();
		HashSet<State> states = new HashSet<>();
		HashMap<State, State> firstMapping = new HashMap<>();
		HashMap<State, State> secondMapping = new HashMap<>();
		int c = 0;

		if(first.equals(Automaton.makeEmptyString())){
			return second;
		}

		if(second.equals(Automaton.makeEmptyString())){
			return first;
		}

		for(State s : first.getStates()) {
			State newState = null;
			if (b) {
				newState = new State("q" + c++, s.isInitialState(), s.isFinalState());
			}else{
				if (connectOn.contains(s)) {
					newState = new State("q" + c++, s.isInitialState(), false);
				} else {
					newState = new State("q" + c++, s.isInitialState(), s.isFinalState());
				}
			}
			states.add(newState);
			firstMapping.put(s, newState);
		}

		for(Transition t: first.getDelta()){
			delta.add(new Transition(firstMapping.get(t.getFrom()), firstMapping.get(t.getTo()), t.getInput()));
		}


		if(second.getStates().size() == 1 && second.getInitialState().isFinalState()) {
			for (Transition t : second.getOutgoingTransitionsFrom(second.getInitialState())) {
				for (State s : connectOn) {
					State newState = new State(firstMapping.get(s).getState(), s.isInitialState(), true);
					states.remove(firstMapping.get(s));
					states.add(newState);
					delta.add(new Transition(newState, newState, t.getInput()));
				}
				second.minimize();
			}
		}else{
			for (State s : second.getStates()) {
				State newState = new State("q" + c++, s.isInitialState(), s.isFinalState());
				states.add(newState);
				secondMapping.put(s, newState);
			}

			states.remove(secondMapping.get(second.getInitialState()));

			for (Transition t : second.getDelta()) {
				if (!t.getFrom().isInitialState() && !t.getTo().isInitialState()) {
					delta.add(new Transition(secondMapping.get(t.getFrom()), secondMapping.get(t.getTo()), t.getInput()));
				}
				if (t.getTo().isInitialState()) {
					//TODO better recheck this function
					for (State s : connectOn) {
						delta.add(new Transition(secondMapping.get(t.getFrom()), firstMapping.get(s), t.getInput()));
					}
				}
			}

			for (Transition t : second.getOutgoingTransitionsFrom(second.getInitialState())) {
				for (State s : connectOn) {
					delta.add(new Transition(firstMapping.get(s), secondMapping.get(t.getTo()), t.getInput()));
				}
			}

		}

		return new Automaton(delta, states);
	}
	
	
	/**
     * Checks if the automaton recognizes only epsilon string
     * @return
     */
    public boolean isEpsilonLanguage() {
        return equals(new FA(Automaton.makeEmptyString()));
    }
	
    /**
     * Optimized version on includes with one parameter
     * @param other
     * @return
     */
    public Bool includes(FA other){

        getAutomaton().minimize();
        Bool result = null;

        if(other.getAutomaton().hasCycle() || getAutomaton().hasCycle())
            return new Bool(2);


        if (other.isEpsilonLanguage())
            return new Bool(1);


        return auxIncludesOpt(other,new HashSet<Transition>(), getAutomaton().getInitialState(), result);
    }


    private Bool auxIncludesOpt(FA other, HashSet<Transition> delta, State currentState, Bool result) {
        int outgoingTrans = this.getAutomaton().getOutgoingTransitionsFrom(currentState).size();

        if ((outgoingTrans > 1 && !(currentState.equals(getAutomaton().getInitialState()))) || currentState.isFinalState()) {

            Automaton factors = Automaton.factors(new Automaton(delta, getAutomaton().getStates()));
            Automaton intersect = Automaton.intersection(factors, other.getAutomaton());

            if (intersect.equals(other.getAutomaton())) {
                if (result == null) {
                    //System.out.println("intersection equals sub and result == null");
                    result = new Bool(1);
                } else if (result.equals(new Bool(0))) {
                    //System.out.println("intersection equals sub and result == 1 --> 2");
                    return new Bool(2);
                }

            } else {
                if (!(Automaton.isEmptyLanguageAccepted(intersect))) {
                    //System.out.println("intersection not empty return new bool 2");
                    return new Bool(2);
                }

                if (currentState.isFinalState()) {
                    if (result == null) {
                        result = new Bool(0);
                        //System.out.println("intersection empty result == null --> 0");
                    }
                    else if (result.equals(new Bool(1))) {
                        //System.out.println("intersection empty result != 0 --> 2");
                        return new Bool(2);
                    }
                }
            }

        }

        for(Transition t : getAutomaton().getOutgoingTransitionsFrom(currentState)){
            HashSet<Transition> clone = (HashSet<Transition>) delta.clone();
            clone.add(t);
            result = auxIncludesOpt(other, clone, t.getTo(), result);
            if(result != null && result.equals(new Bool(2))){
                return result;
            }
        }

        return result;
    }
    
    
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return clone();
	}
	
	/**
     * Auxiliary function for includes() that checks whether automaton contains all the strings in
     * FA other or just some of them. The method is recursive.
     * @param other FA on which the search is set on
     * @param delta set of transitions that lead to current state
     * @param currentState state from which we start to explore the automaton
     * @return
     */
    private Bool auxIncludes(FA other, HashSet<Transition> delta, State currentState){
        int outgoingTrans = this.getAutomaton().getOutgoingTransitionsFrom(currentState).size();

        //we enter in this body only if a state has more than one outgoing transaction and
        //it is not the initial state of the automaton
        //or if we arrived at a final state
        if(( outgoingTrans > 1 && !(currentState.equals(getAutomaton().getInitialState()))) || currentState.isFinalState()) {
            Automaton factors = Automaton.factors(new Automaton(delta, getAutomaton().getStates()));
            //check if the intersection between the factorization on the automaton visited so far
            //and the other automaton are equals, if they are it means the strings are contained
            boolean equalsOther = Automaton.intersection(factors, other.getAutomaton()).equals(other.getAutomaton());

            if (equalsOther) {
                return new Bool(1);
            }

            if (currentState.isFinalState())
                return new Bool(2);
        }

        //for each path we check if the string is contained or not
        for(Transition t : this.getAutomaton().getOutgoingTransitionsFrom(currentState)) {
            HashSet<Transition> clone = (HashSet<Transition>) delta.clone();
            clone.add(t);
            if(auxIncludes(other, clone, t.getTo()).equals(new Bool(2)))
                return new Bool(2);
            
        }

        return new Bool(1);
    }

    public Bool startsWith(FA other) {
    	int result = Automaton.startsWith(getAutomaton(), other.getAutomaton());
    	return result == 0 || result == 1 ? new Bool(result) : new Bool(2);
    }
    
    public Bool endsWith(FA other) {
    	int result = Automaton.endsWith(getAutomaton(), other.getAutomaton());
    	return result == 0 || result == 1 ? new Bool(result) : new Bool(2);
    }
    
    public FA trim() {
    	return new FA(Automaton.trim(getAutomaton()));
    }
    
    public FA trimLeft() {
    	return new FA(Automaton.trimLeft(getAutomaton()));
    }

    public FA trimRight() {
    	return new FA(Automaton.trimRight(getAutomaton()));
    }
    
    public FA toLowerCase() {
    	return new FA(Automaton.toLowerCase(getAutomaton()));
    }
    
    public FA toUpperCase() {
    	return new FA(Automaton.toUpperCase(getAutomaton()));
    }
    
    public FA replace(FA a, FA b) {
    	return new FA(Automaton.replace(getAutomaton(), a.getAutomaton(), b.getAutomaton()));
    }
	
    /**
     * Method that, given the starting index, returns the automaton that recognizes all the substrings from
     * the given index till the end.
     * @param start starting index, negative value possible.
     * @return
     */
    public FA slice(Interval start) {

        if(this.getAutomaton().hasCycle())
            return this;
        
        int s1 = Integer.parseInt(start.getHigh());

        //if the starting index is greater or equal to zero we return the result of Substring
        if(s1 >= 0){
            return new FA(Automaton.singleParameterSubstring(this.getAutomaton(), s1));
        }

        //otherwise the index is negative and we need to transform it in a positive value and return the result
        return auxSlice(s1, this.getAutomaton().getInitialState(), new HashSet<Transition>(), Automaton.makeEmptyLanguage());
    }
    
    public FA slice(Interval start, Interval end) {
    	
    	if (start.isFiniteConcrete() && end.isFiniteConcrete()) {
    		Automaton result = Automaton.makeEmptyLanguage();

    		for (Long i: start.getIntergers())
        		for (Long j: end.getIntergers())
        			result = Automaton.union(result, Automaton.slice(getAutomaton(), i, j));
    		
    		return new FA(result);
    	} else {
    		return new FA(Automaton.makeTopLanguage());
    	}
    }

    /**
     * Recursive auxiliary function that, for each possible path, returns the substring of the automaton
     * in the given indexes.
     * @param start negative starting index
     * @param currentState state we are currently exploring
     * @param delta set of transitions
     * @param result result automaton
     * @return
     */
    private FA auxSlice(int start, State currentState, HashSet<Transition> delta, Automaton result){

        if(currentState.isFinalState()){

            HashSet<State> states = new HashSet<>();

            for(State s: this.getAutomaton().getStates()){
                State newState = (State)s.clone();
                states.add(newState);
                if(!newState.equals(currentState)){
                    newState.setFinalState(false);
                }
            }


            Automaton b = new Automaton(delta, states);
            FA partial = new FA(b);

            int length = Integer.parseInt(partial.length().getHigh()) + start;

            if(length < 0)
            	length = 0;
            
            result = Automaton.union(result, Automaton.singleParameterSubstring(b, length));
        }

        for(Transition t : this.getAutomaton().getOutgoingTransitionsFrom(currentState)){
            HashSet<Transition> clone = (HashSet<Transition>)delta.clone();
            clone.add(t);
            result = Automaton.union(result, auxSlice(start, t.getTo(), clone, result).getAutomaton());
        }

        return new FA(result);
    }

}
