package it.univr.domain.faops;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;


public class IndexOfTest {

	@Test
	public void indexOfTest001() {
		FA automaton = new FA(Automaton.makeAutomaton("abc"));
		FA search = new FA(Automaton.makeAutomaton("bc"));

		Assert.assertEquals(automaton.indexOf(search), new Interval("1", "1"));
	}

	@Test
	public void indexOfTest002() {
		FA automaton = new FA(Automaton.union(Automaton.makeAutomaton("abc"), Automaton.makeAutomaton("s")));
		FA search = new FA(Automaton.makeAutomaton("bc"));

		Assert.assertEquals(automaton.indexOf(search), new Interval("-1", "1"));
	}
	
	@Test
	public void indexOfTest003() {
		FA automaton = new FA(Automaton.union(Automaton.makeAutomaton("abc"), Automaton.makeAutomaton("s")));
		FA search = new FA(Automaton.makeAutomaton("ab"));

		Assert.assertEquals(automaton.indexOf(search), new Interval("-1", "0"));
	}
	
	@Test
	public void indexOfTest004() {
		FA automaton = new FA(Automaton.union(Automaton.makeAutomaton("aaa"), Automaton.makeAutomaton("bbb")));
		FA search = new FA(Automaton.makeAutomaton("c"));

		Assert.assertEquals(automaton.indexOf(search), new Interval("-1", "-1"));
	}
	
	@Test
	public void indexOfTest005() {
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
		FA automaton = new FA(new Automaton(delta, states));
		
		FA search = new FA(Automaton.makeAutomaton("acccb"));
		
		Assert.assertEquals(new Interval("-1", "+Inf"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest006() {
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
		
		FA search = new FA(Automaton.makeAutomaton("he"));
		Assert.assertEquals(new Interval("-1", "+Inf"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest007() {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, false);
		State q4 = new State("q4", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		states.add(q3);
		states.add(q4);
		
		delta.add(new Transition(q0, q1, "a"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q4, "b"));
		
		// accb
		Automaton a = new Automaton(delta, states);
		
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(Automaton.makeEmptyString(), Automaton.union(a, b)));
		
		FA search = new FA(Automaton.makeAutomaton("cb"));
		Assert.assertEquals(new Interval("-1", "2"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest008() {
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
		
		delta.add(new Transition(q0, q1, "a"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// accb^*
		Automaton a = new Automaton(delta, states);
		
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA search = new FA(Automaton.makeAutomaton("f"));
		
		Assert.assertEquals(new Interval("-1", "+Inf"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest009() {
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
		
		delta.add(new Transition(q0, q1, "a"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q3, "c"));
		delta.add(new Transition(q3, q3, "b"));
		
		// accb^*
		Automaton a = new Automaton(delta, states);
		
		Automaton b = Automaton.makeAutomaton("hello");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA search = new FA(Automaton.makeAutomaton("he"));
		
		Assert.assertEquals(new Interval("-1", "+Inf"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest010() {
		Automaton a = Automaton.makeAutomaton("hello");
		Automaton b = Automaton.makeAutomaton("world");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA search = new FA(Automaton.makeAutomaton("o"));
		
		Assert.assertEquals(new Interval("1", "4"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest011() {
		Automaton a = Automaton.makeAutomaton("hello");
		Automaton b = Automaton.makeAutomaton("world");
		
		FA automaton = new FA(Automaton.union(a, b));
		
		FA search = new FA(Automaton.makeAutomaton("a"));
		
		Assert.assertEquals(new Interval("-1", "-1"), automaton.indexOf(search));
	}
	
	@Test
	public void indexOfTest012() {
		Automaton a = Automaton.union(Automaton.makeAutomaton("abc"), Automaton.makeAutomaton("bc"));
		a = Automaton.union(a, Automaton.makeAutomaton("ddd"));
		
		
		FA automaton = new FA(a);
		
		FA search = new FA(Automaton.makeAutomaton("c"));
		
		Assert.assertEquals(new Interval("-1", "2"), automaton.indexOf(search));

	}
}
