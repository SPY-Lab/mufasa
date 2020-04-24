package it.univr.domain.faops;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class SubstringTable2Test {
//
//	testSubstringCase[1][2]_[3] where:
//	- [1] is the row
//	- [2] is the column
//	- [3] is a progressive number
//
//	Automata to test:
//	1. A
//	2. A1 U A2
//	3. A^*
//	4. A1^* U A2
//	
//	TABLE 2
//	|l < i <= k    |l, k in Z|l = -∞, k in Z|l in Z, k = +∞|l = -∞, k = +∞|
//	|--------------|---------|--------------|--------------|--------------|
//	|i, j in Z     |1,2,3,4  |√             |1,2,3,4       |              |
//	|i = -∞, j in Z|         |              |              |              |
//	|i in Z, j = +∞|1,2,3,4  |              |1,2,3,4       |√             |
//	|i = -∞, j = +∞|         |              |              |              |
//
	
	@Test
	public void testSubstringT2Case11_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("5", "9"), new Interval("2", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("llo", "lo", "o"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case11_002() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("3", "4"), new Interval("2", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "lo", "o", "n", "ng", "g"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case11_003() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("2", "3"), new Interval("1", "4"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("a", "aa", "ac", "c", "cc", "cb", "b"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case11_004() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// cccb^*
		Automaton a = new Automaton(delta, states);
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("2", "4"), new Interval("1", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("c", "cc", "ccb", "cb", "b", "c", "cbb", "bb", "e", "el", "ell", "l", "lo", "ll", "o", "llo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case12_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("1", "2"), new Interval("-Inf", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "e", "el", "l"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case13_001() throws Exception {
		
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "3"), new Interval("1", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("e", "el", "l", "ll", "llo", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case13_002() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("2", "4"), new Interval("1", "+Inf"));
		
		HashSet<State> statesA = new HashSet<>();
		HashSet<Transition> deltaA = new HashSet<>();
		
		// a^*
		State q4 = new State("q4", true, true);
		statesA.add(q4);
		deltaA.add(new Transition(q4, q4, "a"));
		
		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton astar = new Automaton(deltaA, statesA);
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		List<String> ss = new ArrayList<>(Arrays.asList("c", "cc", "ccc"));
		
		// c, a^*c, cb^*
		// cc, a^*cc, ccb^*
		// ccc, a^*ccc, cccb^*
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
			automata.add(Automaton.concat(Automaton.makeAutomaton(s), bstar));
		}
		// b^+
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		
		ss = new ArrayList<>(Arrays.asList("cb", "ccb", "cccb", "ccbb", "cbb", "bb", "b"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		automata.add(Automaton.concat(astar, Automaton.makeEmptyString()));
		automata.add(Automaton.makeEmptyString());
		
		automata.add(new Automaton(delta, states));
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case13_003() throws Exception {
		
		Automaton a = Automaton.makeAutomaton("hello");
		Automaton b = Automaton.makeAutomaton("world");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("4", "6"), new Interval("2", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("rld", "rl", "ld", "d", "llo", "ll", "lo", "o", "l"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case13_004() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// cccb^*
		Automaton a = new Automaton(delta, states);
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("2", "4"), new Interval("1", "+Inf"));

		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("c", "cc", "cb", "ccb", "b", "cbb", "bb", "e", "el", "ell", "l", "lo", "ll", "o", "llo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		automata.add(Automaton.concat(Automaton.makeAutomaton("c"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case14_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "3"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("he", "e", "l", "ll", "llo", "hel", "el", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		System.out.println(Automaton.minus(expectedResult.getAutomaton(), result.getAutomaton()));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT2Case31_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("3", "+Inf"), new Interval("2", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "o", "lo", "ll", "llo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case31_002() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("1", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("e", "el", "ell", "ello", "ll", "llo", "l", "lo", "a", "an", "ang", "n", "ng", "g"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case31_003() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("3", "+Inf"), new Interval("2", "4"));

		HashSet<State> statesA = new HashSet<>();
		HashSet<Transition> deltaA = new HashSet<>();
		
		// a^*
		State q4 = new State("q4", true, true);
		statesA.add(q4);
		deltaA.add(new Transition(q4, q4, "a"));
		
		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton astar = new Automaton(deltaA, statesA);
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		
		automata.add(Automaton.concat(Automaton.makeAutomaton("a"), astar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("c"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("cc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("c")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("cc")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("ccc")));
		automata.add(a);
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case31_004() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("3", "+Inf"), new Interval("2", "4"));

		HashSet<State> statesA = new HashSet<>();
		HashSet<Transition> deltaA = new HashSet<>();
		
		// a^*
		State q4 = new State("q4", true, true);
		statesA.add(q4);
		deltaA.add(new Transition(q4, q4, "a"));
		
		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton astar = new Automaton(deltaA, statesA);
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		
		automata.add(Automaton.concat(Automaton.makeAutomaton("a"), astar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("c"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("cc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("c")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("cc")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("ccc")));
		automata.add(a);
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case33_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("helloworld"));
		
		FA result = a.substring(new Interval("5", "+Inf"), new Interval("4", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("o", "w", "wo", "wor", "worl", "world", "ow", "or", "orl",
													   "orld", "owo", "wo", "r", "rl", "rld", "owor", "l", "ld",
													   "oworl", "worl", "orl", "d", "oworld"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case33_002() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("helloworld"));
		
		FA result = a.substring(new Interval("7", "+Inf"), new Interval("5", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("r", "rl", "rld", "l", "ld", "d", "world", "orld","wo", "wor", "worl", "o", "or", "orl"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case33_003() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("3", "+Inf"), new Interval("2", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo", "o", "n", "ng", "g"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case33_004() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("5", "+Inf"), new Interval("3", "+Inf"));

		HashSet<State> statesA = new HashSet<>();
		HashSet<Transition> deltaA = new HashSet<>();
		
		// a^*
		State q4 = new State("q4", true, true);
		statesA.add(q4);
		deltaA.add(new Transition(q4, q4, "a"));
		
		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton astar = new Automaton(deltaA, statesA);
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		
		automata.add(Automaton.concat(Automaton.makeAutomaton("a"), astar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("c"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("cc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("c")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("cc")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("ccc")));
		automata.add(a);
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case33_005() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// a^*cccb^*
		Automaton a = new Automaton(delta, states);
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("5", "+Inf"), new Interval("3", "+Inf"));

		HashSet<State> statesA = new HashSet<>();
		HashSet<Transition> deltaA = new HashSet<>();
		
		// a^*
		State q4 = new State("q4", true, true);
		statesA.add(q4);
		deltaA.add(new Transition(q4, q4, "a"));
		
		HashSet<State> statesB = new HashSet<>();
		HashSet<Transition> deltaB = new HashSet<>();
		
		// b^*
		State q5 = new State("q5", true, true);
		statesB.add(q5);
		deltaB.add(new Transition(q5, q5, "b"));
		
		Automaton astar = new Automaton(deltaA, statesA);
		Automaton bstar = new Automaton(deltaB, statesB);
		
		HashSet<Automaton> automata = new HashSet<>();
		
		automata.add(Automaton.concat(Automaton.makeAutomaton("a"), astar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("c"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("cc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		automata.add(Automaton.concat(Automaton.makeAutomaton("b"), bstar));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("c")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("cc")));
		automata.add(Automaton.concat(astar, Automaton.makeAutomaton("ccc")));
		automata.add(a);
		
		automata.add(Automaton.makeAutomaton("lo"));
		automata.add(Automaton.makeAutomaton("o"));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT2Case34_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("4", "+Inf"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("hell", "ell", "ll", "l", "o", "hello", "ello", "llo", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
}
