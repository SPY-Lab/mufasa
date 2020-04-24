package it.univr.domain.faops;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.*;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class SubstringTable1Test {
//
//	testSubstringT[1]Case[2][3]_[4] where:
//	- [1] is the table
//	- [2] is the row
//	- [3] is the column
//	- [4] is a progressive number
//
//	Automata to test:
//		1. A
//		2. A1 U A2
//		3. A^*
//		4. A1^* U A2
//	
//	TABLE 1
//	|i, j <= l (i <= k)|l, k in Z|l = -∞, k in Z|l in Z, k = +∞|l = -∞, k = +∞|
//	|------------------|---------|--------------|--------------|--------------|
//	|i, j in Z         |1,2,3,4  |1,2,3,4	   |1,2,3,4       |1,2,3,4       |
//	|i = -∞, j in Z    |√        |√             |√             |√             |
//	|i in Z, j = +∞    |√        |√             |√             |√             |
//	|i = -∞, j = +∞    |√        |√             |√             |√             |
//
	
	@Test
	public void testSubstringT1Case11_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("0", "0"), new Interval("0", "0"));
				
		FA expectedResult = new FA(Automaton.makeEmptyString());
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case11_002() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("5", "9"), new Interval("11", "12"));
		
		FA expectedResult = new FA(Automaton.makeEmptyString());
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case11_003() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("1", "2"), new Interval("5", "10"));

		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("ello", "llo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case11_004() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("world")));
		
		FA result = a.substring(new Interval("1", "2"), new Interval("2", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("e", "el", "l", "o", "or", "r"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case11_005() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "2"), new Interval("4", "6"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("ll", "llo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case11_006() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("2", "2"), new Interval("4", "6"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("ll", "llo", "ng"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case11_007() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "1"), new Interval("3", "4"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("aaa", "aaaa", "aa", "aaa", "aaac", "aac", "aacc", "ac", "acc", "accc", "cc", "ccc", "cccb", "ccb"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case11_008() throws Exception {
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
		FA result = automaton.substring(new Interval("2", "2"), new Interval("3", "4"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("a", "aa", "c", "ac", "cc", "cb", "l", "ll"));
		
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

    @Test
    public void testSubstringT1Case11_009() throws Exception {
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
        FA result = automaton.substring(new Interval("2", "2"), new Interval("3", "4"));

        HashSet<Automaton> automata = new HashSet<>();

        List<String> ss = new ArrayList<>(Arrays.asList("a", "aa", "c", "ac", "cc", "cb"));

        for (String s : ss)
            automata.add(Automaton.makeAutomaton(s));

        FA expectedResult = new FA(Automaton.union(automata));

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubstringT1Case11_010() throws Exception {

        Automaton b = Automaton.makeAutomaton("hello");

        FA automaton = new FA(b);

        FA result = automaton.substring(new Interval("2", "2"), new Interval("3", "4"));

        HashSet<Automaton> automata = new HashSet<>();

        List<String> ss = new ArrayList<>(Arrays.asList("l", "ll"));

        for (String s : ss)
            automata.add(Automaton.makeAutomaton(s));

        FA expectedResult = new FA(Automaton.union(automata));

        Assert.assertEquals(expectedResult, result);
    }


    @Test
	public void testSubstringT1Case12_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("0", "0"), new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case12_002() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("0", "0"), new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "l", "la"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case12_003() throws Exception {

		Automaton a = Automaton.star(Automaton.makeRealAutomaton("a"));
		Automaton b = Automaton.makeRealAutomaton("ccc");
		Automaton c = Automaton.star(Automaton.makeRealAutomaton("b"));
		
		FA automaton = new FA(Automaton.concat(Automaton.concat(a, b), c));
		
		FA result = automaton.substring(new Interval("0", "0"), new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("a", "aa", "ac", "c", "cc"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case12_004() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "0"), new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("a", "aa", "ac", "c", "cc", "h", "he"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case13_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "3"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case13_002() throws Exception {
		
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "2"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case13_003() throws Exception {
		
		Automaton a = Automaton.makeAutomaton("hello");
		Automaton b = Automaton.makeAutomaton("abc");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("2", "2"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "c"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case13_004() throws Exception {
		Automaton a = Automaton.makeAutomaton("helloworld");
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("5", "7"), new Interval("7", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("wo", "wor", "worl", "world", "o", "or",
													   "orl", "orld", "r", "rl", "rld"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case13_005() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "2"), new Interval("2", "+Inf"));
		
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
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
			automata.add(Automaton.concat(Automaton.makeAutomaton(s), bstar));
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
	public void testSubstringT1Case13_006() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("4", "6"), new Interval("6", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case13_007() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "2"), new Interval("2", "+Inf"));

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
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
			automata.add(Automaton.concat(Automaton.makeAutomaton(s), bstar));
		}

		automata.add(Automaton.concat(astar, Automaton.makeEmptyString()));
		automata.add(Automaton.makeEmptyString());
		
		automata.add(new Automaton(delta, states));
		
		ss = new ArrayList<>(Arrays.asList("he", "hel", "hell", "hello", "e", "el", "ell", "ello", "l", "ll", "llo"));
		
		for (String s : ss)
			automata.add(Automaton.makeAutomaton(s));
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);

        visualizeAutomaton.show(automaton, "a");
        visualizeAutomaton.show(expectedResult, "expectation");
        visualizeAutomaton.show(result, "reality");
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case14_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("0", "0"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case14_002() throws Exception {
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("hello"), Automaton.makeAutomaton("lang")));
		
		FA result = a.substring(new Interval("0", "0"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello", "l", "la", "lan", "lang"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case14_003() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "0"), new Interval("-Inf", "+Inf"));

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
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
		}
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		
		automata.add(Automaton.concat(astar, Automaton.makeEmptyString()));
		automata.add(Automaton.makeEmptyString());
		
		automata.add(new Automaton(delta, states));
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case14_004() throws Exception {
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
		
		FA result = automaton.substring(new Interval("0", "0"), new Interval("-Inf", "+Inf"));

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
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
		}
		automata.add(Automaton.concat(Automaton.makeAutomaton("ccc"), bstar));
		
		automata.add(Automaton.concat(astar, Automaton.makeEmptyString()));
		automata.add(Automaton.makeEmptyString());
		
		automata.add(new Automaton(delta, states));
		
		ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello"));
		for (String s : ss)
			automata.add(Automaton.makeAutomaton(s));
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case21_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "2"), new Interval("2", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("he", "hel", "e", "el", "l"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case22_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "0"), new Interval("-Inf", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case23_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "1"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("hel", "hell", "hello", "el", "ell", "ello"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case24_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "0"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case24_002() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "2"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();

		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello", "e", "el",
													   "ell", "ello", "l", "ll", "llo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case31_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("3", "4"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case31_002() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("3", "4"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "lo", "o"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case31_003() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("3", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "lo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case32_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("-Inf", "3"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("he", "e", "l", "hel", "el", "hell", "ell", "ll", "hello", "ello", "llo", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case33_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "+Inf"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case33_002() throws Exception {
		Automaton a = Automaton.makeAutomaton("helloworld");
		
		FA automaton = new FA(a);
		
		FA result = automaton.substring(new Interval("7", "+Inf"), new Interval("7", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("r", "rl", "rld", "r", "l", "ld", "rl", "l", "d"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT1Case33_003() throws Exception {
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
		
		FA result = automaton.substring(new Interval("2", "+Inf"), new Interval("2", "+Inf"));
		
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
		
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
			automata.add(Automaton.concat(astar, Automaton.makeAutomaton(s)));
			automata.add(Automaton.concat(Automaton.makeAutomaton(s), bstar));
		}
		
		automata.add(Automaton.concat(Automaton.makeEmptyString(), bstar));
		automata.add(Automaton.concat(astar, Automaton.makeEmptyString()));
		automata.add(Automaton.makeEmptyString());
		automata.add(new Automaton(delta, states));
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);
		
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case34_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("0", "+Inf"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello", "e", "el", "ell", "ello", "l", "ll", "llo", "l", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case41_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "+Inf"), new Interval("2", "2"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("he", "e", "l", "ll", "llo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case42_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "+Inf"), new Interval("-Inf", "1"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello", "e", "el", "ell", "ello"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case43_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "+Inf"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();

		List<String> ss = new ArrayList<>(Arrays.asList("hel", "hell", "hello", "el", "ell",
													   "ello", "l", "ll", "llo", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT1Case44_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "+Inf"), new Interval("-Inf", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("h", "he", "hel", "hell", "hello", "e", "el", "ell", "ello", "l", "ll", "llo", "lo", "o"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
    public void testSubstringT1Case44_002(){

        Automaton b = Automaton.makeAutomaton("hello");
        FA automaton = new FA(b);

        FA result = automaton.substring(new Interval("0", "2"), new Interval("2", "+Inf"));

        HashSet<Automaton> automata = new HashSet<>();

        List<String> ss =  new ArrayList<>(Arrays.asList("he", "hel", "hell", "hello", "e", "el", "ell", "ello", "l", "ll", "llo"));

        for (String s : ss)
            automata.add(Automaton.makeAutomaton(s));

        automata.add(Automaton.makeEmptyString());

        Automaton automatonResult = Automaton.union(automata);
        automatonResult.minimize();
        FA expectedResult = new FA(automatonResult);

        visualizeAutomaton.show(automaton, "a");
        visualizeAutomaton.show(expectedResult, "expectation");
        visualizeAutomaton.show(result, "reality");

        Assert.assertEquals(expectedResult, result);
    }

}
