package it.univr.domain.faops;

import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class OtherSliceTest {

    @Test
    public void sliceTest001() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("marco"));
        Automaton a = Automaton.union(set);

        long start = 0;
        long end = 2;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pa"));
        r.add(Automaton.makeAutomaton("ma"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void sliceTest002() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = 0;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pand"));
        r.add(Automaton.makeAutomaton("turk"));
        r.add(Automaton.makeAutomaton("crea"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest003() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -2;
        long end = 3;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest004() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -5;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pand"));
        r.add(Automaton.makeAutomaton("urk"));
        r.add(Automaton.makeAutomaton("a"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest005() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -5;
        long end = 8;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("on"));
        r.add(Automaton.makeAutomaton("urkey"));
        r.add(Automaton.makeAutomaton("ature"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest006() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = 3;
        long end = -7;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("d"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest007() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = 0;
        long end = 3;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pan"));
        r.add(Automaton.makeAutomaton("tur"));
        r.add(Automaton.makeAutomaton("cre"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest008() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -10;
        long end = 6;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("andem"));
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("turkey"));
        r.add(Automaton.makeAutomaton("creatu"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest009() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -1;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest010() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("turkey"));
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = 4;
        long end = 0;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest011() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = -9;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("whin"));
        r.add(Automaton.makeAutomaton("tiny"));
        r.add(Automaton.makeAutomaton("type"));
        r.add(Automaton.makeAutomaton("crab"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest012() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = 10;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest013() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = -8;
        long end = 9;

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, a);
    }

    @Test
    public void sliceTest014() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = -4;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("hin"));
        r.add(Automaton.makeAutomaton("tiny"));
        r.add(Automaton.makeAutomaton("type"));
        r.add(Automaton.makeAutomaton("ab"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest015() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = -4;
        long end = -7;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest016() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = 2;
        long end = 8;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("ine"));
        r.add(Automaton.makeAutomaton("ny"));
        r.add(Automaton.makeAutomaton("pe"));
        r.add(Automaton.makeAutomaton("abby"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest017() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("whine"));
        set.add(Automaton.makeAutomaton("tiny"));
        set.add(Automaton.makeAutomaton("type"));
        set.add(Automaton.makeAutomaton("crabby"));
        Automaton a = Automaton.union(set);

        long start = -5;
        long end = 7;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("whine"));
        r.add(Automaton.makeAutomaton("tiny"));
        r.add(Automaton.makeAutomaton("type"));
        r.add(Automaton.makeAutomaton("rabby"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest018() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("creature"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -5;
        long end = 4;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("a"));
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest019(){
        HashSet<State> states = new HashSet<>();
        State q0 = new State("q0", true, true);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);
        states.add(q0);
        states.add(q1);
        states.add(q2);

        HashSet<Transition> delta = new HashSet<>();
        delta.add(new Transition(q0, q1, "a"));
        delta.add(new Transition(q1, q2, "b"));
        delta.add(new Transition(q2, q0, "c"));

        Automaton a = new Automaton(delta, states);
        long start = 1;
        long end = 4;

        HashSet<State> statesR = new HashSet<>();
        State q00 = new State("q0", true, true);
        State q01 = new State("q1", false, false);
        State q02 = new State("q2", false, true);
        State q03 = new State("q3", false, true);
        statesR.add(q00);
        statesR.add(q01);
        statesR.add(q02);
        statesR.add(q03);

        HashSet<Transition> deltaR = new HashSet<>();
        deltaR.add(new Transition(q00, q01, "b"));
        deltaR.add(new Transition(q01, q02, "c"));
        deltaR.add(new Transition(q02, q03, "a"));
        Automaton result = new Automaton(deltaR, statesR);

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(result, resultR);

    }

    @Test
    public void sliceTest020(){
        HashSet<State> states = new HashSet<>();
        State q0 = new State("q0", true, true);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);
        states.add(q0);
        states.add(q1);
        states.add(q2);

        HashSet<Transition> delta = new HashSet<>();
        delta.add(new Transition(q0, q1, "a"));
        delta.add(new Transition(q1, q2, "b"));
        delta.add(new Transition(q2, q0, "c"));

        Automaton a = new Automaton(delta, states);
        long start = 1;
        long end = -4;

        Automaton resultR = Automaton.slice(a, start, end);
        Assert.assertEquals(Automaton.makeTopLanguage(), resultR);

    }

    @Test
    public void sliceTest021() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("abc"));
        set.add(Automaton.makeAutomaton("def"));
        Automaton a = Automaton.union(set);

        long start = -2;
        long end = 3;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("bc"));
        r.add(Automaton.makeAutomaton("ef"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest022() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        set.add(Automaton.makeAutomaton("pandaland"));
        set.add(Automaton.makeEmptyString());
        Automaton a = Automaton.union(set);

        long start = -2;
        long end = 3;

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.slice(a, start, end);

        Assert.assertEquals(resultR, result);
    }


}