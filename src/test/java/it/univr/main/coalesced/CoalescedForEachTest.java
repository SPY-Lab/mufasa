package it.univr.main.coalesced;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.AllocationSites;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedForEachTest {

	
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();


	@Test
	public void testForEach001() throws Exception {
		String file = "src/test/resources/foreach/for001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);

		AllocationSite xSite = new AllocationSite(1, 0);
		AllocationSites xSites = new AllocationSites(xSite);
		

		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1" , "1"));
		properties.put(new FA("b"), new Interval("2" , "2"));
		properties.put(new FA("c"), new Interval("3" , "3"));
		AbstractObject xObject = new AbstractObject(properties);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "6"));
		Assert.assertEquals(state.getValue(new Variable("x")), xSites);
		
		Assert.assertEquals(state.getValue(xSite), xObject);
	}
	

	@Test
	public void testForEach002() throws Exception {
		String file = "src/test/resources/foreach/for002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 2);

		AllocationSite firstSite = new AllocationSite(3, 1);
		AllocationSite secondSite = new AllocationSite(5, 1);
		AllocationSites xSites = new AllocationSites(firstSite, secondSite);

		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1" , "1"));
		properties.put(new FA("b"), new Interval("2" , "2"));
		properties.put(new FA("c"), new Interval("3" , "3"));
		AbstractObject firstObject = new AbstractObject(properties);
		

		MultiHashMap<FA, AbstractValue> properties2 = new MultiHashMap<FA, AbstractValue>();
		properties2.put(new FA("d"), new Interval("4" , "4"));
		properties2.put(new FA("e"), new Interval("5" , "5"));
		properties2.put(new FA("f"), new Interval("6" , "6"));
		AbstractObject secondObject = new AbstractObject(properties2);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "21"));
		Assert.assertEquals(state.getValue(new Variable("x")), xSites);
		
		Assert.assertEquals(state.getValue(firstSite), firstObject);
		Assert.assertEquals(state.getValue(secondSite), secondObject);
	}
}

