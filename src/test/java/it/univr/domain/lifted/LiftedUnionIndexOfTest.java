package it.univr.domain.lifted;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.domain.lifted.LiftedUnionAbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class LiftedUnionIndexOfTest {

	private LiftedUnionAbstractDomain domain = new LiftedUnionAbstractDomain();

	@Test
	public void testIndexOf001() throws Exception {
		String file = "src/test/resources/indexof/io001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("1", "1"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}

	@Test
	public void testIndexOf002() throws Exception {
		String file = "src/test/resources/indexof/io002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setFA(new FA(Automaton.makeAutomaton("helloworld")));		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setFA(new FA(Automaton.makeAutomaton("world")));		
		LiftedUnionAbstractValue z = new LiftedUnionAbstractValue();
		z.setInterval(new Interval("1", "1"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
		Assert.assertEquals(state.getValue(new Variable("z")), z);
	}
}
