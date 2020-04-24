package it.univr.main.coalesced;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.Top;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedIfTest {

	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();


	@Test
	public void testIf001() throws Exception {
		String file = "src/test/resources/if/if001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf002() throws Exception {
		String file = "src/test/resources/if/if002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("x")), new Top());
	}

	@Test
	public void testIf003() throws Exception {
		String file = "src/test/resources/if/if003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, true);

		states.add(q0);

		delta.add(new Transition(q0, q0, "a"));

		// a^* 
		Automaton a = new Automaton(delta, states);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new FA(a));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}

	@Test
	public void testIf004() throws Exception {
		String file = "src/test/resources/if/if004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}

	@Test
	public void testIf005() throws Exception {
		String file = "src/test/resources/if/if005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}	

	@Test
	public void testIf006() throws Exception {
		String file = "src/test/resources/if/if006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}	

	@Test
	public void testIf007() throws Exception {
		String file = "src/test/resources/if/if007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf008() throws Exception {
		String file = "src/test/resources/if/if008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		Automaton aut = Automaton.union(Automaton.makeAutomaton("h"), Automaton.makeAutomaton("l"));

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), new FA(Automaton.makeAutomaton("helloworld")));
		Assert.assertEquals(state.getValue(new Variable("c")), new FA(aut));
	}

	@Test
	public void testIf009() throws Exception {
		String file = "src/test/resources/if/if009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		Automaton a = Automaton.union(Automaton.union(Automaton.union(Automaton.makeAutomaton("a"), Automaton.makeAutomaton("b")), Automaton.makeAutomaton("c")), Automaton.makeAutomaton("d"));

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), new FA(a));
	}

	@Test
	public void testIf010() throws Exception {
		String file = "src/test/resources/if/if010.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		Automaton a = Automaton.union(Automaton.makeAutomaton("ab"), Automaton.makeAutomaton("ac"));
				
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), new FA(a));
	}
}
