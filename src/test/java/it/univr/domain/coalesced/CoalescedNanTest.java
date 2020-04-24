package it.univr.domain.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.NaN;
import it.univr.domain.coalasced.Top;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedNanTest {
	
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	private String dir = "src/test/resources/nan/"; 

	@Test
	public void testNan001() throws Exception {
		String file = dir + "nan001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new NaN());
	}

	@Test
	public void testNan002() throws Exception {
		String file = dir + "nan002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new NaN());
	}

	@Test
	public void testNan003() throws Exception {
		String file = dir + "nan003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new NaN());
	}

	@Test
	public void testNan004() throws Exception {
		String file = dir + "nan004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Top());
		Assert.assertEquals(state.getValue(new Variable("z")), new Top());
	}
}
