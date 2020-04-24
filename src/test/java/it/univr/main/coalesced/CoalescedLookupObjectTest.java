package it.univr.main.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedLookupObjectTest {
	
	private String dir = "src/test/resources/objects/lookup/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testPropLookup001() throws Exception {
		String file = dir + "lookup001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("1", "1"));
	}
	
	@Test
	public void testPropLookup002() throws Exception {
		String file = dir + "lookup002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Bottom());
		Assert.assertEquals(state.getValue(new Variable("z")), new Bottom());
	}
	
	@Test
	public void testPropLookup003() throws Exception {
		String file = dir + "lookup003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("4", "4"));
	}
	
	@Test
	public void testPropLookup004() throws Exception {
		String file = dir + "lookup004.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("1", "1"));
	}
	
	@Test
	public void testPropLookup005() throws Exception {
		String file = dir + "lookup005.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("1", "1"));
	}
	
	@Test
	public void testPropLookup006() throws Exception {
		String file = dir + "lookup006.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("1", "1"));
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("1", "1"));
	}
	
	@Test
	public void testPropLookup007() throws Exception {
		String file = dir + "lookup007.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new Bottom());
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("2", "2"));
	}

	@Test
	public void testPropLookup008() throws Exception {
		String file = dir + "lookup008.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("a")), new FA("a"));
		Assert.assertEquals(state.getValue(new Variable("b")), new FA("a"));
	}
	
	@Test
	public void testPropLookup009() throws Exception {
		String file = dir + "lookup009.js";
				AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("15", "15"));
	}
}
