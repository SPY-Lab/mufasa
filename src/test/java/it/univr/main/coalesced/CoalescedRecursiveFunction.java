package it.univr.main.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedRecursiveFunction {
	private String dir = "src/test/resources/rec-functions/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	private int maximumCallStringsSize = 3;
	
	@Test
	public void testFun001() throws Exception {
		String file = dir + "rec-fun001.js";
		
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}


	@Test
	public void testFun002() throws Exception {
		String file = dir + "rec-fun002.js";
		maximumCallStringsSize = 10;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("120", "120"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("6", "6"));
	}


	@Test
	public void testFun003() throws Exception {
		String file = dir + "rec-fun003.js";
		maximumCallStringsSize = 6;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("6", "6"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("6", "6"));
	}

	@Test
	public void testFun004() throws Exception {
		String file = dir + "rec-fun004.js";
		maximumCallStringsSize = 3;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-Inf", "240"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("2", "2"));
	}

	@Test
	public void testFun005() throws Exception {
		String file = dir + "rec-fun005.js";
		maximumCallStringsSize = 3;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-Inf", "240"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("-Inf", "+Inf"));
	}
	
	@Test
	public void testFun006() throws Exception {
		String file = dir + "rec-fun006.js";
		maximumCallStringsSize = 3;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}
	
	@Test
	public void testFun007() throws Exception {
		String file = dir + "rec-fun007.js";
		maximumCallStringsSize = 1;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "14"));
	}
	
	@Test
	public void testFun008() throws Exception {
		String file = dir + "rec-fun008.js";
		maximumCallStringsSize = 3;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-Inf", "17"));
	}
	
	@Test
	public void testFun009() throws Exception {
		String file = dir + "rec-fun009.js";
		maximumCallStringsSize = 3;
		
		AbstractEnvironment state = Analyzer.analyze(file, domain, maximumCallStringsSize).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Bottom());
	}
}
