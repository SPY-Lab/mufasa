package it.univr.domain.lifted;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.domain.lifted.LiftedUnionAbstractValue;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class LiftedUnionBooleanTest {
	LiftedUnionAbstractDomain domain = new LiftedUnionAbstractDomain();
	String dir = "src/test/resources/bool/";
	
	@Test
	public void testBool001() throws Exception {
		String file = dir + "bool001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setBool(new Bool(1));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool002() throws Exception {
		String file = dir + "bool002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setBool(new Bool(0));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool003() throws Exception {
		String file = dir + "bool003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}

	@Test
	public void testBool004() throws Exception {
		String file = dir + "bool004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "0"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool005() throws Exception {
		String file = dir + "bool005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool006() throws Exception {
		String file = dir + "bool006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool007() throws Exception {
		String file = dir + "bool007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setBool(new Bool(0));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool008() throws Exception {
		String file = dir + "bool008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setBool(new Bool(2));
		
		LiftedUnionAbstractValue a = new LiftedUnionAbstractValue();
		a.setInterval(new Interval("0", "+Inf"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), a);
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testBool009() throws Exception {
		String file = dir + "bool009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setBool(new Bool(0));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
}
