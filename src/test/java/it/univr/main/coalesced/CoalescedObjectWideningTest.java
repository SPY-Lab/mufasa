package it.univr.main.coalesced;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.AllocationSites;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedObjectWideningTest {
	private String dir = "src/test/resources/objects/widening/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testObjectWidening001() throws Exception {
		String file = dir + "widening001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("1", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening002() throws Exception {
		String file = dir + "widening002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("-Inf", "4"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening003() throws Exception {
		String file = dir + "widening003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("-Inf", "-4"));
		properties.put(new FA("b"), new Interval("6", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening004() throws Exception {
		String file = dir + "widening004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("-Inf", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening005() throws Exception {
		String file = dir + "widening005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("-Inf", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening006() throws Exception {
		String file = dir + "widening006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("-Inf", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	@Test
	public void testObjectWidening007() throws Exception {
		String file = dir + "widening007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Bool(2));
		properties.put(new FA("b"), new Interval("-Inf", "+Inf"));
		properties.put(new FA("c"), new Interval("-Inf", "5"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
	
	
//	@Test
//	public void testObjectWidening008() throws Exception {
//		String file = dir + "widening008.js";
//		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
//		
//		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
//		properties.put(FA.star("a"), new Interval("1", "1"));
//		AbstractObject oObject = new AbstractObject(properties);
//		
//		AllocationSite oSite = new AllocationSite(1,0);
//		
//		// State size
//		Assert.assertEquals(state.sizeStore(), 2);
//		Assert.assertEquals(state.sizeHeap(), 1);
//		
//		// Store values
//		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
//		
//		// Heap value
//		Assert.assertEquals(oObject, state.getValue(oSite));
//	}
	

	@Test
	public void testObjectWidening009() throws Exception {
		String file = dir + "widening009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("0", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(4,1);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		
		// Heap value
		Assert.assertEquals(oObject, state.getValue(oSite));
	}
}
