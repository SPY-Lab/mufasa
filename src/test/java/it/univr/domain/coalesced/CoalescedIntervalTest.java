package it.univr.domain.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.Top;
import it.univr.fsm.machine.Automaton;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedIntervalTest {

	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testSum001() throws Exception {
		String file = "src/test/resources/intervals/sum001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("7", "7"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("3", "3"));
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("-15", "-15"));
	}
	
	@Test
	public void testSum002() throws Exception {
		String file = "src/test/resources/intervals/sum002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new FA(Automaton.makeAutomaton("12")));
	}
	
	@Test
	public void testSum003() throws Exception {
		String file = "src/test/resources/intervals/sum003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("2","2"));
	}
	
	@Test
	public void testSum004() throws Exception {
		String file = "src/test/resources/intervals/sum004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1","1"));
	}
	
	@Test
	public void testSum005() throws Exception {
		String file = "src/test/resources/intervals/sum005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0","+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Top());
		Assert.assertEquals(state.getValue(new Variable("z")), new Top());
	}
	
	@Test
	public void testMul001() throws Exception {
		String file = "src/test/resources/intervals/mul001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2","2"));
	}
}
