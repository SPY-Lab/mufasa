package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class RepeatTest {

	@Test
	public void repeatTest001(){

		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("alpha"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("alphaalpha"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("2", "2"));
		Assert.assertEquals(resultR, result);

	}

	@Test
	public void repeatTest002(){

		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("alpha"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("alphaalpha"));
		r.add(Automaton.makeAutomaton("alphaalphaalpha"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("2", "3"));
		Assert.assertEquals(resultR, result);

	}

	@Test
	public void repeatTest003(){

		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("la"));
		set.add(Automaton.makeAutomaton("al"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("lalala"));
		r.add(Automaton.makeAutomaton("alalal"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("3", "3"));
		Assert.assertEquals(resultR, result);

	}

	@Test
	public void repeatTest004(){

		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("la"));
		set.add(Automaton.makeAutomaton("al"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("lala"));
		r.add(Automaton.makeAutomaton("lalala"));
		r.add(Automaton.makeAutomaton("alal"));
		r.add(Automaton.makeAutomaton("alalal"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("2", "3"));
		Assert.assertTrue(resultR.equals(result));

	}

	@Test
	public void repeatTest005(){

		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("alpha"));
		set.add(Automaton.makeAutomaton("gamma"));
		FA a = new FA(Automaton.union(set));

		HashSet<State> statesR = new HashSet<>();
		HashSet<Transition> deltaR = new HashSet<>();
		State q0 = new State("q0", true, true);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, false);
		State q4 = new State("q4", false, false);
		State q5 = new State("q5", false, true);
		State q6 = new State("q6", false, false);
		State q7 = new State("q7", false, false);
		State q8 = new State("q8", false, false);
		State q9 = new State("q9", false, false);
		State q10 = new State("q10", false, true);
		statesR.add(q0);
		statesR.add(q1);
		statesR.add(q2);
		statesR.add(q3);
		statesR.add(q4);
		statesR.add(q5);
		statesR.add(q6);
		statesR.add(q7);
		statesR.add(q8);
		statesR.add(q9);
		statesR.add(q10);
		deltaR.add(new Transition(q0, q1, "a"));
		deltaR.add(new Transition(q1, q2, "l"));
		deltaR.add(new Transition(q2, q3, "p"));
		deltaR.add(new Transition(q3, q4, "h"));
		deltaR.add(new Transition(q4, q5, "a"));
		deltaR.add(new Transition(q5, q1, "a"));
		deltaR.add(new Transition(q0, q6, "g"));
		deltaR.add(new Transition(q6, q7, "a"));
		deltaR.add(new Transition(q7, q8, "m"));
		deltaR.add(new Transition(q8, q9, "m"));
		deltaR.add(new Transition(q9, q10, "a"));
		deltaR.add(new Transition(q10, q6, "g"));

		FA result = new FA(new Automaton(deltaR, statesR));

		FA resultR = a.repeat(new Interval("0", "+Inf"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest006(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("bugbug"));
		r.add(Automaton.makeAutomaton("bugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcat"));
		r.add(Automaton.makeAutomaton("bugbugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcatcat"));
		r.add(Automaton.makeAutomaton("catcat"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("2", "4"));
		Assert.assertTrue(resultR.equals(result));
	}

	@Test
	public void repeatTest007(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("alpha"));
		set.add(Automaton.makeAutomaton("gamma"));
		FA a = new FA(Automaton.union(set));

		HashSet<State> statesR = new HashSet<>();
		HashSet<Transition> deltaR = new HashSet<>();
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, false);
		State q4 = new State("q4", false, false);
		State q5 = new State("q5", false, true);
		State q6 = new State("q6", false, false);
		State q7 = new State("q7", false, false);
		State q8 = new State("q8", false, false);
		State q9 = new State("q9", false, false);
		State q10 = new State("q10", false, true);
		statesR.add(q0);
		statesR.add(q1);
		statesR.add(q2);
		statesR.add(q3);
		statesR.add(q4);
		statesR.add(q5);
		statesR.add(q6);
		statesR.add(q7);
		statesR.add(q8);
		statesR.add(q9);
		statesR.add(q10);
		deltaR.add(new Transition(q0, q1, "a"));
		deltaR.add(new Transition(q1, q2, "l"));
		deltaR.add(new Transition(q2, q3, "p"));
		deltaR.add(new Transition(q3, q4, "h"));
		deltaR.add(new Transition(q4, q5, "a"));
		deltaR.add(new Transition(q5, q1, "a"));
		deltaR.add(new Transition(q0, q6, "g"));
		deltaR.add(new Transition(q6, q7, "a"));
		deltaR.add(new Transition(q7, q8, "m"));
		deltaR.add(new Transition(q8, q9, "m"));
		deltaR.add(new Transition(q9, q10, "a"));
		deltaR.add(new Transition(q10, q6, "g"));

		FA result = new FA(new Automaton(deltaR, statesR));

		FA resultR = a.repeat(new Interval("1", "+Inf"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest008(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("do"));
		set.add(Automaton.makeAutomaton("mi"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("dodo"));
		r.add(Automaton.makeAutomaton("dododo"));
		r.add(Automaton.makeAutomaton("dodododo"));
		r.add(Automaton.makeAutomaton("mimi"));
		r.add(Automaton.makeAutomaton("mimimi"));
		r.add(Automaton.makeAutomaton("mimimimi"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("2", "4"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest009(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("do"));
		set.add(Automaton.makeAutomaton("mi"));
		FA a = new FA(Automaton.union(set));

		FA result = new FA(Automaton.makeEmptyString());

		FA resultR = a.repeat(new Interval("0", "0"));

		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest010(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("do"));
		set.add(Automaton.makeAutomaton("mi"));
		FA a = new FA(Automaton.union(set));

		FA result = new FA(Automaton.makeEmptyLanguage());

		FA resultR = a.repeat(new Interval("-4", "-2"));

		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest011(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("do"));
		set.add(Automaton.makeAutomaton("re"));
		set.add(Automaton.makeAutomaton("mi"));
		FA a = new FA(Automaton.union(set));

		FA result = new FA(Automaton.makeEmptyString());

		FA resultR = a.repeat(new Interval("-2", "0"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest012(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("alpha"));
		set.add(Automaton.makeAutomaton("gamma"));
		FA a = new FA(Automaton.union(set));

		HashSet<State> statesR = new HashSet<>();
		HashSet<Transition> deltaR = new HashSet<>();
		State q0 = new State("q0", true, true);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, false);
		State q3 = new State("q3", false, false);
		State q4 = new State("q4", false, false);
		State q5 = new State("q5", false, true);
		State q6 = new State("q6", false, false);
		State q7 = new State("q7", false, false);
		State q8 = new State("q8", false, false);
		State q9 = new State("q9", false, false);
		State q10 = new State("q10", false, true);
		statesR.add(q0);
		statesR.add(q1);
		statesR.add(q2);
		statesR.add(q3);
		statesR.add(q4);
		statesR.add(q5);
		statesR.add(q6);
		statesR.add(q7);
		statesR.add(q8);
		statesR.add(q9);
		statesR.add(q10);
		deltaR.add(new Transition(q0, q1, "a"));
		deltaR.add(new Transition(q1, q2, "l"));
		deltaR.add(new Transition(q2, q3, "p"));
		deltaR.add(new Transition(q3, q4, "h"));
		deltaR.add(new Transition(q4, q5, "a"));
		deltaR.add(new Transition(q5, q1, "a"));
		deltaR.add(new Transition(q0, q6, "g"));
		deltaR.add(new Transition(q6, q7, "a"));
		deltaR.add(new Transition(q7, q8, "m"));
		deltaR.add(new Transition(q8, q9, "m"));
		deltaR.add(new Transition(q9, q10, "a"));
		deltaR.add(new Transition(q10, q6, "g"));

		FA result = new FA(new Automaton(deltaR, statesR));

		FA resultR = a.repeat(new Interval("-Inf", "+Inf"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest013(){
		HashSet<State> states = new HashSet<>();
		HashSet<Transition> delta = new HashSet<>();
		State q0 = new State("q0", true, true);
		states.add(q0);
		delta.add(new Transition(q0, q0, "a"));

		FA a = new FA(new Automaton(delta, states));

		FA result = new FA(Automaton.makeEmptyLanguage());

		FA resultR = a.repeat(new Interval("-1", "-1"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest014(){
		HashSet<State> states = new HashSet<>();
		HashSet<Transition> delta = new HashSet<>();
		State q0 = new State("q0", true, true);
		states.add(q0);
		delta.add(new Transition(q0, q0, "a"));
		FA a = new FA(new Automaton(delta, states));

		FA result = FA.union(a, new FA(Automaton.makeEmptyString()));

		FA resultR = a.repeat(new Interval("0", "+Inf"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest015(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("cat"));
		r.add(Automaton.makeAutomaton("bug"));
		r.add(Automaton.makeAutomaton("bugbug"));
		r.add(Automaton.makeAutomaton("bugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcat"));
		r.add(Automaton.makeAutomaton("bugbugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcatcat"));
		r.add(Automaton.makeAutomaton("catcat"));
		r.add(Automaton.makeEmptyString());
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("-2", "4"));
		Assert.assertTrue(resultR.equals(result));
	}

	@Test
	public void repeatTest016(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("cat"));
		r.add(Automaton.makeAutomaton("bug"));
		r.add(Automaton.makeAutomaton("bugbug"));
		r.add(Automaton.makeAutomaton("bugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcat"));
		r.add(Automaton.makeAutomaton("bugbugbugbug"));
		r.add(Automaton.makeAutomaton("catcatcatcat"));
		r.add(Automaton.makeAutomaton("catcat"));
		r.add(Automaton.makeEmptyString());
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("0", "4"));
		Assert.assertTrue(resultR.equals(result));
	}

	@Test
	public void repeatTest017(){
		HashSet<State> states = new HashSet<>();
		HashSet<Transition> delta = new HashSet<>();
		State q0 = new State("q0", true, true);
		states.add(q0);
		delta.add(new Transition(q0, q0, "a"));
		FA a = new FA(new Automaton(delta, states));

		FA resultR = a.repeat(new Interval("2", "5"));
		Assert.assertEquals(resultR, a);
	}

	@Test
	public void repeatTest018(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("a"));
		set.add(Automaton.makeAutomaton("b"));
		FA a = new FA(Automaton.union(set));

		HashSet<State> statesR = new HashSet<>();
		HashSet<Transition> deltaR = new HashSet<>();
		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);
		State q3 = new State("q3", false, false);
		State q4 = new State("q4", false, true);
		statesR.add(q0);
		statesR.add(q1);
		statesR.add(q2);
		statesR.add(q3);
		statesR.add(q4);
		deltaR.add(new Transition(q0, q1, "a"));
		deltaR.add(new Transition(q1, q2, "a"));
		deltaR.add(new Transition(q2, q2, "a"));
		deltaR.add(new Transition(q3, q4, "b"));
		deltaR.add(new Transition(q4, q4, "b"));
		deltaR.add(new Transition(q0, q3, "b"));

		FA result = new FA(new Automaton(deltaR, statesR));

		FA resultR = a.repeat(new Interval("2", "+Inf"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest019(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeEmptyString());
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("-Inf", "0"));
		Assert.assertEquals(resultR,result);
	}

	@Test
	public void repeatTest020(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("cat"));
		r.add(Automaton.makeAutomaton("bug"));
		r.add(Automaton.makeAutomaton("bugbug"));
		r.add(Automaton.makeAutomaton("catcat"));
		r.add(Automaton.makeEmptyString());
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("-Inf", "2"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest021(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("bug"));
		FA a = new FA(Automaton.union(set));

		FA result = new FA(Automaton.makeEmptyLanguage());

		FA resultR = a.repeat(new Interval("-5", "-2"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest022(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("ca"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("cat"));
		r.add(Automaton.makeAutomaton("catcat"));
		r.add(Automaton.makeAutomaton("caca"));
		r.add(Automaton.makeAutomaton("ca"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("1", "2"));
		Assert.assertEquals(resultR, result);
	}

	@Test
	public void repeatTest023(){
		HashSet<Automaton> set = new HashSet<>();
		set.add(Automaton.makeAutomaton("cat"));
		set.add(Automaton.makeAutomaton("c"));
		set.add(Automaton.makeAutomaton("bug"));
		set.add(Automaton.makeAutomaton("b"));
		FA a = new FA(Automaton.union(set));

		HashSet<Automaton> r = new HashSet<>();
		r.add(Automaton.makeAutomaton("catcatcat"));
		r.add(Automaton.makeAutomaton("ccc"));
		r.add(Automaton.makeAutomaton("bugbugbug"));
		r.add(Automaton.makeAutomaton("bbb"));
		FA result = new FA(Automaton.union(r));

		FA resultR = a.repeat(new Interval("3", "3"));
		Assert.assertEquals(resultR, result);
	}



}