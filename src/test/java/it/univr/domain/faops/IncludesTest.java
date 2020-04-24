package it.univr.domain.faops;

import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class IncludesTest {

    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private static final int TOPBOOL = 2;

    @Test
    public void includesTest000(){
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));

        FA a = new FA(Automaton.union(set));

        FA sub = new FA(Automaton.union(Automaton.makeAutomaton("pan"), Automaton.makeAutomaton("koala")));

        Assert.assertEquals(a.includes(sub), new Bool(2));
    }

    @Test
    public void includesTest001() {
        FA automaton = new FA(Automaton.makeAutomaton("panda?#@"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sansa")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("manga")));

        FA search = new FA(Automaton.makeAutomaton("an"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest002() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sansa")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("manga")));

        FA search = new FA(Automaton.makeAutomaton("an"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("p")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest003() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sansa")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("manga")));

        FA search = new FA(Automaton.makeAutomaton("koala"));

        Assert.assertEquals(automaton.includes(search), new Bool(FALSE));
    }

    @Test
    public void includesTest004() {
        FA automaton = new FA(Automaton.makeAutomaton("panda!mc"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("mc!papanda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("polo!mc!panda")));

        FA search = new FA(Automaton.makeAutomaton("panda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("mc")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest005() {
        FA automaton = new FA(Automaton.makeAutomaton("panda!mc"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("mc!papanda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("polopanda")));

        FA search = new FA(Automaton.makeAutomaton("panda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("mc")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest006() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandone")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandina")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandetta")));

        FA search = new FA(Automaton.makeAutomaton("pa"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("pan")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest007() {
        FA automaton = new FA(Automaton.makeAutomaton("ronda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("manga")));

        FA search = new FA(Automaton.makeAutomaton("an"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest008() {
        FA automaton = new FA(Automaton.makeAutomaton("pandaat"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandamat")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pansarat")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pansasat")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("koladat")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("kolabato")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("kosalata")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("kosanaat")));

        FA search = new FA(Automaton.makeAutomaton("at"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest009() {
        FA automaton = new FA(Automaton.makeAutomaton("pan"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandk")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panck")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panrk")));

        FA search = new FA(Automaton.makeAutomaton("an"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest010() {
        FA automaton = new FA(Automaton.makeAutomaton("pan"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandk")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panck")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panrk")));

        FA search = new FA(Automaton.makeAutomaton("k"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest011() {
        FA automaton = new FA(Automaton.makeAutomaton("pan"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandk")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panck")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panrw")));

        FA search = new FA(Automaton.makeAutomaton("k"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest012() {
        FA automaton = new FA("panda");

        FA search = new FA("da");

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest013() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("nda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("a")));

        FA search = new FA(Automaton.makeAutomaton("nda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("a")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest014() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("anda")));

        FA search = new FA(Automaton.makeAutomaton("nda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("a")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest015() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("anda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("orda")));

        FA search = new FA(Automaton.makeAutomaton("nda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("a")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest016() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("koala")));

        FA search = new FA(Automaton.makeAutomaton("nda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("ala")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest017() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("anda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("nda")));

        FA search = new FA(Automaton.makeAutomaton("nda"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest018() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pand")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("nd")));

        FA search = new FA(Automaton.makeAutomaton("panda"));
        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest019() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pand")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("nd")));

        FA search = new FA(Automaton.makeAutomaton("panda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("anda")));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("da")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest020() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pand")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("nd")));

        FA search = new FA(Automaton.makeAutomaton("panda"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("pand")));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("nd")));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("d")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest021() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));

        FA search = new FA(Automaton.makeAutomaton("panda"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest022() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandapanda")));

        FA search = new FA(Automaton.makeAutomaton("panda"));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest023() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandapanda")));

        FA search = new FA(Automaton.makeAutomaton("pandapanda"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest024() {
        FA automaton = new FA(Automaton.makeAutomaton("panda"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("pandapanda")));

        FA search = new FA(Automaton.makeAutomaton("pandaprtretanda"));

        Assert.assertEquals(automaton.includes(search), new Bool(FALSE));
    }

    @Test
    public void includesTest025() {
        FA automaton = new FA(Automaton.makeAutomaton("ordine"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ordine")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ordine")));

        FA search = new FA(Automaton.makeAutomaton("ine"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("dine")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest026() {
        FA automaton = new FA(Automaton.makeAutomaton("ordine"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ordine")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sordine")));

        FA search = new FA(Automaton.makeAutomaton("ine"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("dine")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest027() {
        FA automaton = new FA(Automaton.makeAutomaton("ordine"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ordine")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sordine")));

        FA search = new FA(Automaton.makeAutomaton("e"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("e")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest028() {
        FA automaton = new FA(Automaton.makeAutomaton("ordine"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ordine")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("sordine")));

        FA search = new FA(Automaton.makeAutomaton(""));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest029() {
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "a"));

        FA automaton = new FA(new Automaton(delta, states)); // Automaton: a*
        FA search = new FA(Automaton.makeAutomaton("a"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest030() {
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "a"));

        FA automaton = new FA(Automaton.makeAutomaton("a"));
        FA search = new FA(new Automaton(delta, states)); // Automaton: a*

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest031() {
        FA automaton = new FA("");

        FA search = new FA("e");

        Assert.assertEquals(automaton.includes(search), new Bool(FALSE));
    }

    @Test
    public void includesTest032() {
        FA automaton = new FA("idea");
        FA search = new FA("idea");

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest033() {
        FA automaton = new FA("idea2");
        FA search = new FA("idea");

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest034() {
        FA automaton = new FA(Automaton.makeAutomaton("idea"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("rideva")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("intrinseca")));

        FA search = new FA(Automaton.makeAutomaton("ea"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("va")));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("ca")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest035() {
        FA automaton = new FA(Automaton.makeAutomaton("ea"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ea")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("ea")));

        FA search = new FA(Automaton.makeAutomaton("ea"));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("va")));
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("ca")));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest036() {
        FA automaton = new FA("pandapanda");

        FA search = new FA("panda");
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("da")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest037() {
        FA automaton = new FA("pandapandapandapanda");
        FA search = new FA("pandapanda");
        search = new FA(Automaton.union(search.getAutomaton(), Automaton.makeAutomaton("panda")));

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest038() {
        FA automaton = new FA(Automaton.makeAutomaton("ra"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("bsdifido4v9jsdflsdipa")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("w38ryfw9j8rghwpaksvn8")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("f83n8s8ofrnsd3ruopagg")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("siskehrsnoge8ur30ungr0rfju0jsn39g9rj90sweurf9sn0geruwu4erheotjhfddiogpa9")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("ais8ydbnhiesfnowrnsh98eon3fwhrs9uernhspai8ne4rth9osd9f8fwo98n8hrodsfnoson")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("paksigny43o9shyfroeypangei8tr7g7s8of7os8herpanl8yef8tdn")));

        //AutomatonViewer.show(automaton);

        FA search = new FA(Automaton.makeAutomaton("pa"));

        Assert.assertEquals(automaton.includes(search), new Bool(TOPBOOL));
    }

    @Test
    public void includesTest039() {
        FA automaton = new FA(Automaton.makeAutomaton("an"));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("panda")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("bsdifido4v9jsdflsdipa")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("w38ryfw9j8rghwpaksvn8")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(), Automaton.makeAutomaton("f83n8s8ofrnsd3ruopagg")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("siskehrsnoge8ur30ungr0rfju0jsn39g9rj90sweurf9sn0geruwu4erheotjhfddiogpa9")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("ais8ydbnhiesfnowrnsh98eon3fwhrs9uernhspai8ne4rth9osd9f8fwo98n8hrodsfnoson")));
        automaton = new FA(Automaton.union(automaton.getAutomaton(),
                Automaton.makeAutomaton("paksigny43o9shyfroeypangei8tr7g7s8of7os8herpanl8yef8tdn")));

        FA search = new FA(Automaton.makeAutomaton("tiger99"));

        Assert.assertEquals(automaton.includes(search), new Bool(FALSE));
    }

    @Test
    public void includesTest040() {
        FA automaton = new FA("test path");
        FA search = new FA("");

        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
    }

    @Test
    public void includesTest041() {
        FA automaton = new FA("test path");
        FA search = new FA("test");
        
        Assert.assertEquals(automaton.includes(search), new Bool(TRUE));
     }

}