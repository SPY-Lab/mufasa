package it.univr.domain.lifted;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.NaN;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.domain.lifted.LiftedUnionAbstractValue;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class LiftedUnionNanTest {
	private LiftedUnionAbstractDomain domain = new LiftedUnionAbstractDomain();
	private String dir = "src/test/resources/nan/";
	
	@Test
	public void testNan001() throws Exception {
		String file = dir + "nan001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setNaN(new NaN());
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testNan002() throws Exception {
		String file = dir + "nan002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setNaN(new NaN());
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testNan003() throws Exception {
		String file = dir + "nan003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setNaN(new NaN());
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
	}
	
	@Test
	public void testNan004() throws Exception {
		String file = dir + "nan004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		LiftedUnionAbstractValue x = new LiftedUnionAbstractValue();
		x.setInterval(new Interval("0", "+Inf"));		
		
		LiftedUnionAbstractValue y = new LiftedUnionAbstractValue();
		y.setNaN(new NaN());		
		y.setInterval(new Interval("1", "1"));		
		
		LiftedUnionAbstractValue z = new LiftedUnionAbstractValue();
		z.setNaN(new NaN());
		z.setInterval(new Interval("2", "2"));
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), x);
		Assert.assertEquals(state.getValue(new Variable("y")), y);
		Assert.assertEquals(state.getValue(new Variable("z")), z);
	}
}
