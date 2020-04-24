package it.univr.domain.lifted;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.domain.lifted.LiftedUnionAbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class LiftedUnionIntervalTest {
	
	private LiftedUnionAbstractDomain domain = new LiftedUnionAbstractDomain();
	
	@Test
	public void testSum001() throws Exception {
		String file = "src/test/resources/intervals/sum001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("7", "7"));
		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setInterval(new Interval("3", "3"));
		
		LiftedUnionAbstractValue z = new LiftedUnionAbstractValue();
		z.setInterval(new Interval("-15", "-15"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
		Assert.assertEquals(state.getValue(new Variable("z")), z);
	}
	
	@Test
	public void testSum002() throws Exception {
		String file = "src/test/resources/intervals/sum002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setFA(new FA(Automaton.makeAutomaton("12")));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testSum003() throws Exception {
		String file = "src/test/resources/intervals/sum003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue i = new LiftedUnionAbstractValue();
		i.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), i);
	}
	
	@Test
	public void testSum004() throws Exception {
		String file = "src/test/resources/intervals/sum004.js";
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
	public void testSum005() throws Exception {
		String file = "src/test/resources/intervals/sum005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "+Inf"));
		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setBool(new Bool(1));	
		y.setInterval(new Interval("1", "1"));	
		
		LiftedUnionAbstractValue z = new LiftedUnionAbstractValue();
		z.setInterval(new Interval("6", "6"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
		Assert.assertEquals(state.getValue(new Variable("z")), z);
	}
	
	@Test
	public void testMul001() throws Exception {
		String file = "src/test/resources/intervals/mul001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
}
