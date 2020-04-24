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

public class CoalescedFunctionTest {
	
	private String dir = "src/test/resources/functions/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

	@Test
	public void testFun001() throws Exception {
		String file = dir + "fun001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("10", "10"));
	}

	@Test
	public void testFun002() throws Exception {
		String file = dir + "fun002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("11", "11"));
	}
	
	@Test
	public void testFun003() throws Exception {
		String file = dir + "fun003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("12", "12"));
	}
	
	@Test
	public void testFun004() throws Exception {
		String file = dir + "fun004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("12", "12"));
	}
	
	@Test
	public void testFun005() throws Exception {
		String file = dir + "fun005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("6", "6"));
	}
	
	@Test
	public void testFun006() throws Exception {
		String file = dir + "fun006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("9", "9"));
	}

	@Test
	public void testFun007() throws Exception {
		String file = dir + "fun007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("9", "9"));
	}
	
	@Test
	public void testFun008() throws Exception {
		String file = dir + "fun008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("4", "4"));
	}
	
	@Test
	public void testFun009() throws Exception {
		String file = dir + "fun009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("9", "9"));
	}
	

	
	@Test
	public void testFun010() throws Exception {
		String file = dir + "fun010.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "+Inf"));
	}
	
	@Test
	public void testFun011() throws Exception {
		String file = dir + "fun011.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "+Inf"));
	}
	
	@Test
	public void testFun012() throws Exception {
		String file = dir + "fun012.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
	}
	
	@Test
	public void testFun013() throws Exception {
		String file = dir + "fun013.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("6", "6"));
	}
	
	@Test
	public void testFun014() throws Exception {
		String file = dir + "fun014.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("4", "4"));
	}
	
	@Test
	public void testFun015() throws Exception {
		String file = dir + "fun015.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("6", "6"));
	}
	
	@Test
	public void testFun016() throws Exception {
		String file = dir + "fun016.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
	}
	
	@Test
	public void testFun017() throws Exception {
		String file = dir + "fun017.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testFun018() throws Exception {
		String file = dir + "fun018.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testFun019() throws Exception {
		String file = dir + "fun019.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}

	@Test
	public void testFun020() throws Exception {
		String file = dir + "fun020.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testFun021() throws Exception {
		String file = dir + "fun021.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testFun022() throws Exception {
		String file = dir + "fun022.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}
	
	@Test
	public void testFun023() throws Exception {
		String file = dir + "fun023.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}
	
	@Test
	public void testFun024() throws Exception {
		String file = dir + "fun024.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}
	
	@Test
	public void testFun025() throws Exception {
		String file = dir + "fun025.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-100", "-100"));
	}
	
	@Test
	public void testFun026() throws Exception {
		String file = dir + "fun026.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("5", "5"));
	}
	
	@Test
	public void testFun027() throws Exception {
		String file = dir + "fun027.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("6", "6"));
	}

	@Test
	public void testFun028() throws Exception {
		String file = dir + "fun028.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("6", "6"));
	}
	
	@Test
	public void testFun029() throws Exception {
		String file = dir + "fun029.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("6", "6"));
	}
	
	@Test
	public void testFun030() throws Exception {
		String file = dir + "fun030.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "+Inf"));
	}
	
	@Test
	public void testFun031() throws Exception {
		String file = dir + "fun031.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("3", "3"));
	}
	
	@Test
	public void testFun032() throws Exception {
		String file = dir + "fun032.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("25", "25"));
	}
	
	@Test
	public void testFun033() throws Exception {
		String file = dir + "fun033.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("4", "4"));
	}
	
	@Test
	public void testFun034() throws Exception {
		String file = dir + "fun034.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "1"));
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	
	@Test
	public void testFun035() throws Exception {
		String file = dir + "fun035.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		AllocationSite xSite = new AllocationSite(2, 1);
		AllocationSites xSites = new AllocationSites(xSite);
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("1", "1"));
		AbstractObject xObject = new AbstractObject(properties);		
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), xSites);
		Assert.assertEquals(state.getValue(xSite), xObject);
	}

}
