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

public class SubstringTable3Test {
//
//	testSubstringT[1]Case[2][3]_[4] where:
//	- [1] is the table
//	- [2] is the row
//	- [3] is the column
//	- [4] is a progressive number
//	
//	TABLE 3
//	|i > k V (i <= l, j > l)|l, k in Z|l = -∞, k in Z|l in Z, k = +∞|l = -∞, k = +∞|
//	|-----------------------|---------|--------------|--------------|--------------|
//	|i, j in Z              |         |              |√             |              |
//	|i = -∞, j in Z         |         |              |√             |              |
//	|i in Z, j = +∞         |√        |              |              |              |
//	|i = -∞, j = +∞         |         |              |              |              |
//
	
	@Test
	public void testSubstringT3Case13_001() throws Exception {
		
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("2", "5"), new Interval("3", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();

		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo", "o", "lo"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT3Case13_002() throws Exception {
		
		Automaton a = Automaton.makeAutomaton("hello");
		Automaton b = Automaton.makeAutomaton("world");
		Automaton c = Automaton.makeAutomaton("abc");
		
		FA automaton = new FA(Automaton.union(Automaton.union(a, b), c));
		
		FA result = automaton.substring(new Interval("1", "3"), new Interval("2", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("e", "el", "ell", "ello", "l", "ll", "llo", "lo",
													   "o", "or", "orl", "orld", "r", "rl", "rld", "ld",
													   "b", "bc", "c"));
		for (String s : ss) {
			automata.add(Automaton.makeAutomaton(s));
		}
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT3Case13_003() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, true);

		states.add(q0);
		
		delta.add(new Transition(q0, q0, "a"));
		
		// a^*
		FA automaton = new FA(new Automaton(delta, states));
		FA expectedResult = automaton.clone();
		
		FA result = automaton.substring(new Interval("2", "3"), new Interval("2", "+Inf"));
				
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT3Case13_004() throws Exception {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, true);

		states.add(q0);
		
		delta.add(new Transition(q0, q0, "a"));
		
		// a^* U hello
		Automaton a = new Automaton(delta, states);
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA result = automaton.substring(new Interval("2", "3"), new Interval("2", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		automata.add(new Automaton(delta, states));
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "ll", "llo", "lo"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		Automaton automatonResult = Automaton.union(automata);
		automatonResult.minimize();
		FA expectedResult = new FA(automatonResult);
			
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT3Case13_005() throws Exception {
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(b);
		
		FA result = automaton.substring(new Interval("2", "3"), new Interval("2", "+Inf"));
		
		HashSet<Automaton> automata = new HashSet<>();
				
		automata.add(Automaton.makeAutomaton("l"));
		automata.add(Automaton.makeAutomaton("ll"));
		automata.add(Automaton.makeAutomaton("llo"));
		automata.add(Automaton.makeAutomaton("lo"));
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void testSubstringT3Case23_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("-Inf", "2"), new Interval("0", "+Inf"));
		
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
	public void testSubstringT3Case31_001() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("3", "+Inf"), new Interval("4", "6"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("l", "lo", "o"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		automata.add(Automaton.makeEmptyString());
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testSubstringT3Case31_002() throws Exception {
		FA a = new FA(Automaton.makeAutomaton("hello"));
		
		FA result = a.substring(new Interval("3", "+Inf"), new Interval("0", "1"));
		
		HashSet<Automaton> automata = new HashSet<>();
		
		List<String> ss = new ArrayList<>(Arrays.asList("hel", "el", "hell", "ell", "hello", "ello"));
		for (String s : ss) 
			automata.add(Automaton.makeAutomaton(s));
		
		FA expectedResult = new FA(Automaton.union(automata));
		
		Assert.assertEquals(expectedResult, result);
	}
}
