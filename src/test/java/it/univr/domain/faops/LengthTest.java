package it.univr.domain.faops;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class LengthTest {

	@Test
	public void lengthTest001() { 
		FA a = new FA(Automaton.makeAutomaton("a"));
		Assert.assertEquals(a.length(), new Interval("1", "1"));
	}

	@Test
	public void lengthTest002() { 
		FA a = new FA(Automaton.makeAutomaton("abc"));
		Assert.assertEquals(a.length(), new Interval("3", "3"));
	}

	@Test
	public void lengthTest003() { 
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("a"), Automaton.makeAutomaton("b")));
		Assert.assertEquals(a.length(), new Interval("1", "1"));
	}

	@Test
	public void lengthTest004() { 
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("abcde"), Automaton.makeAutomaton("b")));
		Assert.assertEquals(a.length(), new Interval("1", "5"));
	}

	@Test
	public void lengthTest005() { 
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("abc"), Automaton.makeAutomaton("def")));
		Assert.assertEquals(a.length(), new Interval("3", "3"));
	}

	@Test
	public void lengthTest006() { 
		FA a = new FA(Automaton.union(Automaton.makeAutomaton("abc"), Automaton.makeAutomaton("def")));
		Assert.assertEquals(a.length(), new Interval("3", "3"));
	}


	@Test
	public void lengthTest007() { 

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, true);

		states.add(q0);

		delta.add(new Transition(q0, q0, "a"));

		// a^*
		FA a = new FA(new Automaton(delta, states));
		
		Assert.assertEquals(a.length(), new Interval("0", "+Inf"));
	}
	
	@Test
	public void lengthTest008() { 

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, true);

		states.add(q0);
		states.add(q1);

		delta.add(new Transition(q0, q1, "a"));
		delta.add(new Transition(q1, q1, "a"));

		// a^+
		FA a = new FA(new Automaton(delta, states));
		
		Assert.assertEquals(a.length(), new Interval("1", "+Inf"));
	}
	
	@Test
	public void lengthTest009() { 

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, true);

		states.add(q0);
		states.add(q1);

		delta.add(new Transition(q0, q1, "a"));
		delta.add(new Transition(q1, q1, "a"));

		// a^+ || sss
		FA a = new FA(Automaton.union(new Automaton(delta, states), Automaton.makeAutomaton("sss")));
		
		Assert.assertEquals(a.length(), new Interval("1", "+Inf"));
	}
	
	@Test
	public void lengthTest010() { 

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
		delta.add(new Transition(q1, q2, "a"));
		delta.add(new Transition(q2, q3, "a"));
		delta.add(new Transition(q3, q0, "a"));

		// (aaa)+
		FA a = new FA(new Automaton(delta, states));
		
		Assert.assertEquals(a.length(), new Interval("3", "+Inf"));
	}
	
	@Test
	public void lengthTest011() {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);
		
		states.add(q0);		
		states.add(q1);
		states.add(q2);
		delta.add(new Transition(q0, q0, "a"));
		delta.add(new Transition(q0, q1, "c"));
		delta.add(new Transition(q1, q2, "c"));
		delta.add(new Transition(q2, q2, "b"));
		
		// a^*ccb^*
		Automaton a = new Automaton(delta, states);
		FA automaton = new FA(a);
		
		Assert.assertEquals(new Interval("2", "+Inf"), automaton.length());
	}
}
