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

public class CoalescedUpdateObjectTest {
	
	private String dir = "src/test/resources/objects/update/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testPropUpdate001() throws Exception {
		String file = dir + "update001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		properties.put(new FA("b"), new Interval("2", "2"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate002() throws Exception {
		String file = dir + "update002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		properties.put(new FA("b"), new Interval("4", "4"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate003() throws Exception {
		String file = dir + "update003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Bool(1));
		properties.put(new FA("b"), new Bool(1));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate004() throws Exception {
		String file = dir + "update004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate005() throws Exception {
		String file = dir + "update005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		AbstractObject object = new AbstractObject(new FA("b"), new Interval("8", "8"));
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		Assert.assertEquals(state.getValue(new Variable("a")), new FA("b"));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate006() throws Exception {
		String file = dir + "update006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("2", "2"));
		properties.put(new FA("b"), new Interval("1", "1"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		Assert.assertEquals(state.getValue(new Variable("a")), new FA("b"));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}

	@Test
	public void testPropUpdate007() throws Exception {
		String file = dir + "update007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new FA("b"));
		properties.put(new FA("b"), new Interval("4", "4"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(2,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		Assert.assertEquals(state.getValue(new Variable("k")), new FA("b"));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate008() throws Exception {
		String file = dir + "update008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("4", "4"));
		properties.put(new FA("b"), new Interval("5", "5"));
		AbstractObject object = new AbstractObject(properties);		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}

	@Test
	public void testPropUpdate009() throws Exception {
		String file = dir + "update009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
	
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("0", "2"));
		AbstractObject object = new AbstractObject(properties);

		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate010() throws Exception {
		String file = dir + "update010.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
	
		MultiHashMap<FA, AbstractValue> properties1 = new MultiHashMap<FA, AbstractValue>();
		properties1.put(new FA("a"), new Interval("1", "3"));
		AbstractObject object1 = new AbstractObject(properties1);
		
		MultiHashMap<FA, AbstractValue> properties2 = new MultiHashMap<FA, AbstractValue>();
		properties2.put(new FA("a"), new Interval("2", "3"));
		AbstractObject object2 = new AbstractObject(properties2);

		AllocationSite site1 = new AllocationSite(1,0);
		AllocationSite site2 = new AllocationSite(2,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("z")), new AllocationSites(site1, site2));
		
		// Heap value
		Assert.assertEquals(state.getValue(site1), object1);
		Assert.assertEquals(state.getValue(site2), object2);
	}
	
	@Test
	public void testPropUpdate011() throws Exception {
		String file = dir + "update011.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
	
		MultiHashMap<FA, AbstractValue> properties1 = new MultiHashMap<FA, AbstractValue>();
		properties1.put(new FA("a"), new Interval("3", "3"));
		AbstractObject object1 = new AbstractObject(properties1);
		
		MultiHashMap<FA, AbstractValue> properties2 = new MultiHashMap<FA, AbstractValue>();
		properties2.put(new FA("a"), new Interval("2", "2"));
		AbstractObject object2 = new AbstractObject(properties2);

		AllocationSite site1 = new AllocationSite(1,0);
		AllocationSite site2 = new AllocationSite(2,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("z")), new AllocationSites(site1));
		
		// Heap value
		Assert.assertEquals(state.getValue(site1), object1);
		Assert.assertEquals(state.getValue(site2), object2);
	}
	
	@Test
	public void testPropUpdate012() throws Exception {
		String file = dir + "update012.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
	
		MultiHashMap<FA, AbstractValue> properties1 = new MultiHashMap<FA, AbstractValue>();
		properties1.put(new FA("a"), new Interval("2", "10"));
		AbstractObject object1 = new AbstractObject(properties1);
		
		MultiHashMap<FA, AbstractValue> properties2 = new MultiHashMap<FA, AbstractValue>();
		properties2.put(new FA("a"), new Interval("10", "10"));
		AbstractObject object2 = new AbstractObject(properties2);

		AllocationSite site1 = new AllocationSite(1,0);
		AllocationSite site2 = new AllocationSite(9,1);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(site1, site2));
		
		// Heap value
		Assert.assertEquals(state.getValue(site1), object1);
		Assert.assertEquals(state.getValue(site2), object2);
	}
	
	@Test
	public void testPropUpdate013() throws Exception {
		String file = dir + "update013.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("15", "15"));
		AbstractObject object = new AbstractObject(properties);

		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate014() throws Exception {
		String file = dir + "update014.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("5", "15"));
		AbstractObject object = new AbstractObject(properties);

		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate015() throws Exception {
		String file = dir + "update015.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		MultiHashMap<FA, AbstractValue> xProperties = new MultiHashMap<FA, AbstractValue>();
		xProperties.put(new FA("a"), new Interval("1", "3"));
		AbstractObject xObject = new AbstractObject(xProperties);
		
		MultiHashMap<FA, AbstractValue> yProperties = new MultiHashMap<FA, AbstractValue>();
		yProperties.put(new FA("a"), new Interval("2", "3"));
		AbstractObject yObject = new AbstractObject(yProperties);

		AllocationSite xSite = new AllocationSite(1,0);
		AllocationSite ySite = new AllocationSite(2,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(xSite));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(ySite));
		Assert.assertEquals(state.getValue(new Variable("z")), new AllocationSites(xSite, ySite));
		
		// Heap value
		Assert.assertEquals(state.getValue(xSite), xObject);
		Assert.assertEquals(state.getValue(ySite), yObject);
	}
		
	@Test
	public void testPropUpdate016() throws Exception {
		String file = dir + "update016.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		MultiHashMap<FA, AbstractValue> xProperties = new MultiHashMap<FA, AbstractValue>();
		xProperties.put(new FA("a"), new Interval("2", "2"));
		AbstractObject xObject = new AbstractObject(xProperties);
		
		AllocationSite xSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(xSite));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(xSite));
		
		// Heap value
		Assert.assertEquals(state.getValue(xSite), xObject);
	}
}
