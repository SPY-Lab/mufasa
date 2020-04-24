package it.univr.domain.coalesced;

import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;

import static org.junit.Assert.assertEquals;

import org.apache.commons.collections15.multimap.MultiHashMap;
public class AbstractObjectNormalizeTest {
	
	/*
	 * obj: {a|b : [1, 2]}
	 * expectedObj (Norm(obj)): {a : [1, 2], b : [1, 2]}
	 */
	@Test
	public void testNormalization001() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union("a", "b"), new Interval("1", "2"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
	
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a : [2, 4], a|b : [3, 6]}
	 * expectedObj (Norm(obj)): {a : [2, 6], b : [3, 6]}
	 */
	@Test
	public void testNormalization002() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("2", "4"));
		abstractObjectMap.put(FA.union("a", "b"), new Interval("3", "6"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("3", "6"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a : [5, 5], b : [7, 7], a|b : [1, 1]}
	 * expectedObj (Norm(obj)): {a : [1, 5], b : [1, 7]}
	 */
	@Test
	public void testNormalization003() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("5", "5"));
		abstractObjectMap.put(new FA("b"), new Interval("7", "7"));
		abstractObjectMap.put(FA.union("a", "b"), new Interval("1", "1"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "7"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a|b : [1, 2], a|c : [4, 5]}
	 * expectedObj (Norm(obj)): {a : [1, 5], b : [1, 2], c : [4, 5]}
	 */
	@Test
	public void testNormalization004() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union("a", "b"), new Interval("1", "2"));
		abstractObjectMap.put(FA.union("a", "c"), new Interval("4", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("4", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a|b : [1, 3], a|c : [6, 6], b|c : [5, 8]}
	 * expectedObj (Norm(obj)): {a : [1, 6], b : [1, 8], c : [5, 8]}
	 */
	@Test
	public void testNormalization005() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union("a", "b"), new Interval("1", "3"));
		abstractObjectMap.put(FA.union("a", "c"), new Interval("6", "6"));
		abstractObjectMap.put(FA.union("b", "c"), new Interval("5", "8"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "8"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("5", "8"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a|b|c : [3, 3], b|c : [4, 4], c : [5, 5]}
	 * expectedObj (Norm(obj)): {a : [3, 3], b : [3, 4], c : [3, 5]}
	 */
	@Test
	public void testNormalization006() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), FA.union("b", "c")), new Interval("3", "3"));
		abstractObjectMap.put(FA.union("b", "c"), new Interval("4", "4"));
		abstractObjectMap.put(new FA("c"), new Interval("5", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("3", "3"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("3", "4"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("3", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a|b|c : [4, 4], a|b : [1, 2], b|c : [5, 5]}
	 * expectedObj (Norm(obj)): {a : [1, 4], b : [1, 5], c : [5, 5]}
	 */
	@Test
	public void testNormalization007() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), FA.union("b", "c")), new Interval("4", "4"));
		abstractObjectMap.put(FA.union("a", "b"), new Interval("1", "2"));
		abstractObjectMap.put(FA.union("b", "c"), new Interval("5", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "4"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("4", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a : [1, 2], a* : [3, 3]}
	 * expectedObj (Norm(obj)): {a : [1, 3], a*\a : [3, 3]}
	 */
	@Test
	public void testNormalization008() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		abstractObjectMap.put(FA.union(FA.star("a")), new Interval("3", "3"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "3"));
		expectedAbstractObjectMap.put(FA.star("a").minus(new FA("a")), new Interval("3", "3"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {b : [1, 1], a*|b : [4, 5]}
	 * expectedObj (Norm(obj)): {b : [1, 5], a*|b : [4, 5]}
	 */
	@Test
	public void testNormalization009() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("b"), new Interval("1", "1"));
		abstractObjectMap.put(FA.union(FA.star("a"), new FA("b")), new Interval("4", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(FA.union(FA.star("a"), new FA("b").minus(new FA("b"))), new Interval("4", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a : [1, 1], a*|b* : [2, 2]}
	 * expectedObj (Norm(obj)): {a : [1, 2], a*|b* \ a : [2, 2]}
	 */
	@Test
	public void testNormalization010() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("1", "1"));
		abstractObjectMap.put(FA.union(FA.star("a"), FA.star("b")), new Interval("2", "2"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		expectedAbstractObjectMap.put(FA.union(FA.star("a"), FA.star("b")).minus(new FA("a")), new Interval("2", "2"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a|b : [2, 2], a*|b* : [4, 4]}
	 * expectedObj (Norm(obj)): {a : [2, 4], b : [2, 4], a*|b* \ a \ b : [4, 4]}
	 */
	@Test
	public void testNormalization011() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union("a", "b"), new Interval("2", "2"));
		abstractObjectMap.put(FA.union(FA.star("a"), FA.star("b")), new Interval("4", "4"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "4"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("2", "4"));
		expectedAbstractObjectMap.put(FA.union(FA.star("a"), FA.star("b")).minus(new FA("a")).minus(new FA("b")), new Interval("4", "4"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	/*
	 * obj: {a*|b : [2, 4], a|b* : [3, 5], a : [6, 6], b : [1, 1]}
	 * expectedObj (Norm(obj)): {a : [2, 6], b : [1, 5], a* \ a : [2, 4], b* \ b : [3, 5]}
	 */
	@Test
	public void testNormalization012() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), FA.star("b")), new Interval("3", "5"));
		abstractObjectMap.put(new FA("a"), new Interval("6", "6"));
		abstractObjectMap.put(new FA("b"), new Interval("1", "1"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("3", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(FA.star("b").minus(new FA("b")), new Interval("3", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	

	/*
	 * obj: {a*|b : [2, 4], a|b* : [3, 5], a : [6, 6], b : [1, 1]}
	 * expectedObj (Norm(obj)): {a : [2, 6], b : [1, 5], a* \ a : [2, 4], b* \ b : [3, 5]}
	 */
	@Test
	public void testNormalization013() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(FA.star("a"), new FA("b")), new Interval("2", "4"));
		abstractObjectMap.put(new FA("a"), new Interval("6", "6"));
		abstractObjectMap.put(new FA("b"), new Interval("1", "1"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "4"));
		expectedAbstractObjectMap.put(FA.star("a").minus(new FA("a")), new Interval("2", "4"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	@Test
	public void testNormalization014() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		abstractObjectMap.put(new FA("b"), new Interval("1", "4"));
		abstractObjectMap.put(FA.star("a").minus(new FA("a")), new Interval("2", "4"));
		abstractObjectMap.put(FA.union(FA.star("b"), new FA("a")), new Interval("3", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(FA.star("a").minus(new FA("a")).minus(new FA("")), new Interval("2", "4"));
		expectedAbstractObjectMap.put(FA.star("b").minus(new FA("b")).minus(new FA("")), new Interval("3", "5"));
		expectedAbstractObjectMap.put(new FA(Automaton.makeEmptyString()), new Interval("2", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
	
	@Test
	public void testNormalization015() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("3", "6"));
		abstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		abstractObjectMap.put(FA.star("b").minus(new FA("b")), new Interval("3", "5"));
		abstractObjectMap.put(FA.union(FA.star("a"), new FA("b")), new Interval("2", "4"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(FA.star("a").minus(new FA("a")).minus(new FA("")), new Interval("2", "4"));
		expectedAbstractObjectMap.put(new FA(""), new Interval("2", "5"));
		expectedAbstractObjectMap.put(FA.star("b").minus(new FA("b")).minus(new FA("")), new Interval("3", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(expectedObj, obj);
	}
}
