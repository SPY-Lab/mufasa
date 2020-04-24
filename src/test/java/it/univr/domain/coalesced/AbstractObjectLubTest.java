package it.univr.domain.coalesced;

import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.Top;

import static org.junit.Assert.assertEquals;

import org.apache.commons.collections15.multimap.MultiHashMap;

public class AbstractObjectLubTest {
	
	/*
	 * Bottom V Bottom = Bottom
	 */
	@Test
	public void testLeastUpperBound001() throws Exception {
		AbstractValue lub = (new Bottom()).leastUpperBound(new Bottom());
		assertEquals(new Bottom(), lub);
	}
	
	/*
	 * Top V Bottom = Top
	 */
	@Test
	public void testLeastUpperBound002() throws Exception {
		AbstractValue lub = (new Top()).leastUpperBound(new Bottom());
		assertEquals(new Top(), lub);
	}
	
	/*
	 * Bottom V Top = Top
	 */
	@Test
	public void testLeastUpperBound003() throws Exception {
		AbstractValue lub = (new Bottom()).leastUpperBound(new Top());
		assertEquals(new Top(), lub);
	}
	
	/*
	 * Top V Top = Top
	 */
	@Test
	public void testLeastUpperBound004() throws Exception {
		AbstractValue lub = (new Top()).leastUpperBound(new Top());
		assertEquals(new Top(), lub);
	}
	
	/*
	 * Obj V Top = Top
	 */
	@Test
	public void testLeastUpperBound005() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		
		AbstractValue lub = obj.leastUpperBound(new Top());
		assertEquals(new Top(), lub);
	}
	
	/*
	 * Obj V Bottom = Obj
	 */
	@Test
	public void testLeastUpperBound006() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		
		AbstractValue lub = obj.leastUpperBound(new Bottom());
		assertEquals(obj, lub);
	}
	
	/*
	 * obj1: {a : [1, 1]}
	 * obj2: {b : [1, 2]}
	 * expectedLub: {a : [1, 1], b : [1, 2]}
	 */
	@Test
	public void testLeastUpperBound007() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap1 = new MultiHashMap<>();
		MultiHashMap<FA, AbstractValue> abstractObjectMap2 = new MultiHashMap<>();
		
		abstractObjectMap1.put(new FA("a"), new Interval("1", "1"));
		AbstractObject obj1 = new AbstractObject(abstractObjectMap1);
		
		abstractObjectMap2.put(new FA("b"), new Interval("1", "2"));
		AbstractObject obj2 = new AbstractObject(abstractObjectMap2);
		
		AbstractValue lub = obj1.leastUpperBound(obj2);
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "1"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		
		AbstractObject expectedLub = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedLub, lub);
	}
	
	/*
	 * obj1: {a : [1, 2]}
	 * obj2: {a : [3, 4]}
	 * expectedLub: {a : [1, 4]}
	 */
	@Test
	public void testLeastUpperBound008() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap1 = new MultiHashMap<>();
		MultiHashMap<FA, AbstractValue> abstractObjectMap2 = new MultiHashMap<>();
		
		abstractObjectMap1.put(new FA("a"), new Interval("1", "2"));
		AbstractObject obj1 = new AbstractObject(abstractObjectMap1);
		
		abstractObjectMap2.put(new FA("a"), new Interval("3", "4"));
		AbstractObject obj2 = new AbstractObject(abstractObjectMap2);
		
		AbstractValue lub = obj1.leastUpperBound(obj2);
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "4"));
		
		AbstractObject expectedLub = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedLub, lub);
	}
	
	/*
	 * obj1: {a : [1, 2]}
	 * obj2: {a|b : [5, 6]}
	 * expectedLub: {a : [1, 6], b : [5, 6]}
	 */
	@Test
	public void testLeastUpperBound009() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap1 = new MultiHashMap<>();
		MultiHashMap<FA, AbstractValue> abstractObjectMap2 = new MultiHashMap<>();
		
		abstractObjectMap1.put(new FA("a"), new Interval("1", "2"));
		AbstractObject obj1 = new AbstractObject(abstractObjectMap1);
		
		abstractObjectMap2.put(FA.union("a", "b"), new Interval("5", "6"));
		AbstractObject obj2 = new AbstractObject(abstractObjectMap2);
		
		AbstractValue lub = obj1.leastUpperBound(obj2);
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("5", "6"));
		
		AbstractObject expectedLub = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedLub, lub);
	}
	
	/*
	 * obj1: {a|b : [1, 3], c : [4, 4]}
	 * obj2: {a : [2, 4], b : T}
	 * expectedLub: {a : [1, 4], b : T, c : [4, 4]}
	 */
	@Test
	public void testLeastUpperBound010() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap1 = new MultiHashMap<>();
		MultiHashMap<FA, AbstractValue> abstractObjectMap2 = new MultiHashMap<>();
		
		abstractObjectMap1.put(FA.union("a", "b"), new Interval("1", "3"));
		abstractObjectMap1.put(new FA("c"), new Interval("4", "4"));
		AbstractObject obj1 = new AbstractObject(abstractObjectMap1);
		
		abstractObjectMap2.put(new FA("a"), new Interval("2", "4"));
		abstractObjectMap2.put(new FA("b"), new Top());
		AbstractObject obj2 = new AbstractObject(abstractObjectMap2);
		
		AbstractValue lub = obj1.leastUpperBound(obj2);
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "4"));
		expectedAbstractObjectMap.put(new FA("b"), new Top());
		expectedAbstractObjectMap.put(new FA("c"), new Interval("4", "4"));
		
		AbstractObject expectedLub = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedLub, lub);
	}
	
	/*
	 * obj1: {a* : [1, 2], b : true}
	 * obj2: {a* : [3, 4], b : false}
	 * expectedLub: {a* : [1, 4], b : BoolTop}
	 */
	@Test
	public void testLeastUpperBound011() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap1 = new MultiHashMap<>();
		MultiHashMap<FA, AbstractValue> abstractObjectMap2 = new MultiHashMap<>();

		abstractObjectMap1.put(FA.star("a"), new Interval("1", "2"));
		abstractObjectMap1.put(new FA("b"), new Bool(1));
		AbstractObject obj1 = new AbstractObject(abstractObjectMap1);

		abstractObjectMap2.put(FA.star("a"), new Interval("3", "4"));
		abstractObjectMap2.put(new FA("b"), new Bool(0));
		AbstractObject obj2 = new AbstractObject(abstractObjectMap2);

		AbstractValue lub = obj1.leastUpperBound(obj2);
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(FA.star("a"), new Interval("1", "4"));
		expectedAbstractObjectMap.put(new FA("b"), new Bool(2));

		AbstractObject expectedLub = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedLub, lub);
	}
}
