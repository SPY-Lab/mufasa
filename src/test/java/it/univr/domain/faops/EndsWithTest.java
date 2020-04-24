package it.univr.domain.faops;

import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class EndsWithTest {

    private static final Bool TRUE = new Bool(1);
    private static final Bool FALSE = new Bool(0);
    private static final Bool TOPBOOL = new Bool(2);

    @Test
    public void endsWithTest001() {
        Automaton a = Automaton.makeAutomaton("panda");
        Automaton search = Automaton.makeAutomaton("da");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest002() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("nda"));
        set.add(Automaton.makeAutomaton("a"));

        Automaton a = Automaton.union(set);
        
        Automaton search = Automaton.makeAutomaton("nda");
        search = Automaton.union(search, Automaton.makeAutomaton("a"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest003() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("anda"));
        set.add(Automaton.makeAutomaton("nda"));

        Automaton a = Automaton.union(set);
        Automaton search = Automaton.makeAutomaton("nda");
        search = Automaton.union(search, Automaton.makeAutomaton("a"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest004() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("anda"));
        set.add(Automaton.makeAutomaton("orda"));
        Automaton a = Automaton.union(set);
        
        Automaton search = Automaton.makeAutomaton("nda");
        search = Automaton.union(search, Automaton.makeAutomaton("a"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest005() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("koala"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("nda");
        search = Automaton.union(search, Automaton.makeAutomaton("ala"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest006() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("anda"));
        set.add(Automaton.makeAutomaton("nda"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("nda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest007() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pand"));
        set.add(Automaton.makeAutomaton("nd"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("panda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest008() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pand"));
        set.add(Automaton.makeAutomaton("nd"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("panda");
        search = Automaton.union(search, Automaton.makeAutomaton("anda"));
        search = Automaton.union(search, Automaton.makeAutomaton("da"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest009() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pand"));
        set.add(Automaton.makeAutomaton("nd"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("panda");
        search = Automaton.union(search, Automaton.makeAutomaton("pand"));
        search = Automaton.union(search, Automaton.makeAutomaton("nd"));
        search = Automaton.union(search, Automaton.makeAutomaton("d"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest010() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("panda"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("panda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest011() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandapanda"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("panda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest012() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandapanda"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("pandapanda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest013() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandapanda"));
        Automaton a = Automaton.union(set);


        Automaton search = Automaton.makeAutomaton("pandaprtretanda");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), FALSE);
    }

    @Test
    public void endsWithTest014() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("ordine"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("ine");
        search = Automaton.union(search, Automaton.makeAutomaton("dine"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest015() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("ordine"));
        set.add(Automaton.makeAutomaton("sordine"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("ine");
        search = Automaton.union(search, Automaton.makeAutomaton("dine"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest016() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("ordine"));
        set.add(Automaton.makeAutomaton("sordine"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("e");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest017() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("ordine"));
        set.add(Automaton.makeAutomaton("sordine"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest018() {
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "a"));

        Automaton a = new Automaton(delta, states); // Automaton: a*
        Automaton search = Automaton.makeAutomaton("a");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest019() {
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "a"));

        Automaton a = Automaton.makeAutomaton("a");
        Automaton search = new Automaton(delta, states); // Automaton: a*

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest020() {
        Automaton a = Automaton.makeAutomaton("");
        Automaton search = Automaton.makeAutomaton("e");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), FALSE);
    }

    @Test
    public void endsWithTest021() {
        Automaton a = Automaton.makeAutomaton("idea");
        Automaton search = Automaton.makeAutomaton("idea");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest022() {
        Automaton a = Automaton.makeAutomaton("idea2");
        Automaton search = Automaton.makeAutomaton("idea");

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), FALSE);
    }

    @Test
    public void endsWithTest023() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("idea"));
        set.add(Automaton.makeAutomaton("rideva"));
        set.add(Automaton.makeAutomaton("intrinseca"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("ea");
        search = Automaton.union(search, Automaton.makeAutomaton("va"));
        search = Automaton.union(search, Automaton.makeAutomaton("ca"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest024() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("ea"));
        Automaton a = Automaton.union(set);

        Automaton search = Automaton.makeAutomaton("ea");
        search = Automaton.union(search, Automaton.makeAutomaton("va"));
        search = Automaton.union(search, Automaton.makeAutomaton("ca"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TOPBOOL);
    }

    @Test
    public void endsWithTest025() {

        Automaton a = Automaton.makeAutomaton("pandapanda");
        Automaton search = Automaton.makeAutomaton("panda");
        search = Automaton.union(search, Automaton.makeAutomaton("da"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }

    @Test
    public void endsWithTest026() {
        Automaton a = Automaton.makeAutomaton("pandapandapandapanda");
        Automaton search = Automaton.makeAutomaton("pandapanda");
        search = Automaton.union(search, Automaton.makeAutomaton("panda"));

        Assert.assertEquals(new FA(a).endsWith(new FA(search)), TRUE);
    }
}