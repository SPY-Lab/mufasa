package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class TrimRightTest {

    @Test
    public void trimTest001(){
        Assert.assertEquals(Automaton.trimRight(Automaton.makeRealAutomaton("panda   ")), Automaton.makeRealAutomaton("panda"));

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda   "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);
        Automaton.printDetails(resultR);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest002(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("pan   "));
        set.add(Automaton.makeAutomaton("pa  "));
        set.add(Automaton.makeAutomaton("panda       "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("pan"));
        r.add(Automaton.makeAutomaton("pa"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest003(){
        HashSet<State> states = new HashSet<>();
        State q0 = new State("q0", true, false);
        State q1 = new State("q1", false, true);
        states.add(q0);
        states.add(q1);

        HashSet<Transition> delta = new HashSet<>();
        delta.add(new Transition(q0, q1, "a"));
        delta.add(new Transition(q1, q1, " "));

        Automaton  a = new Automaton(delta, states);

        HashSet<State> statesR = new HashSet<>();
        HashSet<Transition> deltaR = new HashSet<>();

        State q00 = new State("q0", true, false);
        State q01 = new State("q1", false, true);

        statesR.add(q00);
        statesR.add(q01);

        deltaR.add(new Transition(q0, q1, "a"));

        Automaton r = new Automaton(deltaR, statesR);
        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(resultR, r);
    }

    @Test
    public void trimTest004(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("material   "));
        set.add(Automaton.makeAutomaton("pancake"));
        set.add(Automaton.makeAutomaton("muffin       "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("material"));
        r.add(Automaton.makeAutomaton("pancake"));
        r.add(Automaton.makeAutomaton("muffin"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest005(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("   cupcake "));
        set.add(Automaton.makeAutomaton("pan cake "));
        set.add(Automaton.makeAutomaton("muff in    "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("   cupcake"));
        r.add(Automaton.makeAutomaton("pan cake"));
        r.add(Automaton.makeAutomaton("muff in"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest006(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("w i n d"));
        set.add(Automaton.makeAutomaton("sunshine    "));
        set.add(Automaton.makeAutomaton("  rain"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("w i n d"));
        r.add(Automaton.makeAutomaton("sunshine"));
        r.add(Automaton.makeAutomaton("  rain"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest007(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("machine   "));
        set.add(Automaton.makeAutomaton("t uring "));
        set.add(Automaton.makeAutomaton(" b ool "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("machine"));
        r.add(Automaton.makeAutomaton("t uring"));
        r.add(Automaton.makeAutomaton(" b ool"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest008(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("math"));
        set.add(Automaton.makeAutomaton("science   "));
        set.add(Automaton.makeAutomaton(" mystery "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("math"));
        r.add(Automaton.makeAutomaton("science"));
        r.add(Automaton.makeAutomaton(" mystery"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest009(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("may  "));
        set.add(Automaton.makeAutomaton("    june"));
        set.add(Automaton.makeAutomaton("    july     "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("may"));
        r.add(Automaton.makeAutomaton("    june"));
        r.add(Automaton.makeAutomaton("    july"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest010(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton(" m oon   "));
        set.add(Automaton.makeAutomaton(" shine "));
        set.add(Automaton.makeAutomaton(" light    "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton(" m oon"));
        r.add(Automaton.makeAutomaton(" shine"));
        r.add(Automaton.makeAutomaton(" light"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trimRight(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest012(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("    m oon   "));
        set.add(Automaton.makeAutomaton(" shine "));
        set.add(Automaton.makeAutomaton(" light    "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("m oon"));
        r.add(Automaton.makeAutomaton("shine"));
        r.add(Automaton.makeAutomaton("light"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

}