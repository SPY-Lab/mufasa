package it.univr.domain.faops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class CharAtTest {
//	
//	CASES:
//		1. l, h in Z
//		2. l = -∞, h >= 0 in Z
//		3. l = -∞, h < 0 in Z
//		4. l >= 0 in Z, h = +∞
//		5. l = -∞ V l < 0 in Z, h = +∞
//	
	
	@Test
	public void charAtTestCase1_001() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("0", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "e", "l"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase1_002() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("-1", "1"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "e"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase1_003() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("-1", "6"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "e", "l", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase1_004() {
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
		
		FA result = automaton.charAt(new Interval("0", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		List<String> ss = new ArrayList<>(Arrays.asList("a", "c", "b"));
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase1_005() {
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
		
		FA result = automaton.charAt(new Interval("-1", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		List<String> ss = new ArrayList<>(Arrays.asList("a", "c"));
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase1_006() {
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
		
		// hello
		Automaton b = Automaton.makeAutomaton("hello");
		
		// a^*cccb^* U hello
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.charAt(new Interval("2", "5"));
		
		HashSet<Automaton> automata = new HashSet<>();
		List<String> ss = new ArrayList<>(Arrays.asList("a", "c", "b", "l", "o"));
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase2_001() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "e", "l"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}

		automata.add(Automaton.makeEmptyString());
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase3_001() {
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
		
		// hello
		Automaton b = Automaton.makeAutomaton("hello");
		
		// a^*cccb^* U hello
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.charAt(new Interval("4", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		List<String> ss = new ArrayList<>(Arrays.asList("a", "c", "b", "o"));
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}

		automata.add(Automaton.makeEmptyString());
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase4_001() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		automata.add(Automaton.makeEmptyString());
		FA expectedResult = new FA(Automaton.union(automata));
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charAtTestCase5_001() {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.charAt(new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "e", "l", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		

		automata.add(Automaton.makeEmptyString());
		FA expectedResult = new FA(Automaton.union(automata));
		Assert.assertEquals(expectedResult, result);
	}

    @Test
    public void charAtTestCase6() {
        FA a = new FA(Automaton.makeRealAutomaton("www.google.it"));

        FA result = a.charAt(new Interval("0", "0"));

        FA expectedResult = new FA(Automaton.makeRealAutomaton("w"));

        Assert.assertEquals(expectedResult, result);
    }
}
