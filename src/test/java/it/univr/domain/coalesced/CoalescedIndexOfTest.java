package it.univr.domain.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedIndexOfTest {
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

	@Test
	public void testIndexOf001() throws Exception {
		String file = "src/test/resources/indexof/io001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testIndexOf002() throws Exception {
		String file = "src/test/resources/indexof/io002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new FA(Automaton.makeAutomaton("helloworld")));
		Assert.assertEquals(state.getValue(new Variable("y")), new FA(Automaton.makeAutomaton("world")));
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("1", "1"));
	}
}
