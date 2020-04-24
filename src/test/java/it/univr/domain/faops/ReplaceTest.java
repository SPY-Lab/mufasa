package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class ReplaceTest {

    @Test
    public void replaceTest001(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("arco"));
        set.add(Automaton.makeAutomaton("marco"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("co"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("chi"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("marchi"));
        r.add(Automaton.makeAutomaton("archi"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest002(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("contento"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("contento"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("arrabbiato"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("arrabbiato"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest003(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("bubble"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("bb"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("nd"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("bundle"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);


    }

    @Test
    public void replaceTest004(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("bubble"));
        set.add(Automaton.makeAutomaton("bubbles"));
        set.add(Automaton.makeAutomaton("bubbons"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("bb"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("a"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("buale"));
        r.add(Automaton.makeAutomaton("buales"));
        r.add(Automaton.makeAutomaton("buaons"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest005(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("marco"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("rco"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("lto"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("malto"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest006(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("pan"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("lan"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("landa"));
        r.add(Automaton.makeAutomaton("paguro"));
        r.add(Automaton.makeAutomaton("koala"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest007(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("pan"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("lan"));
        replace.add(Automaton.makeAutomaton("man"));
        replace.add(Automaton.makeAutomaton("vi"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("landa"));
        r.add(Automaton.makeAutomaton("manda"));
        r.add(Automaton.makeAutomaton("vida"));
        r.add(Automaton.makeAutomaton("paguro"));
        r.add(Automaton.makeAutomaton("koala"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest008(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("cc"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("lan"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("paguro"));
        r.add(Automaton.makeAutomaton("koala"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest009(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("pa"));
        search.add(Automaton.makeAutomaton("da"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("s"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("snda"));
        r.add(Automaton.makeAutomaton("pans"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest010(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("pa"));
        search.add(Automaton.makeAutomaton("da"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("s"));
        replace.add(Automaton.makeAutomaton("ca"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("snda"));
        r.add(Automaton.makeAutomaton("pans"));
        r.add(Automaton.makeAutomaton("canda"));
        r.add(Automaton.makeAutomaton("panca"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest011(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("s"));
        replace.add(Automaton.makeAutomaton("ti"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("psnda"));
        r.add(Automaton.makeAutomaton("ptinda"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest012(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("un"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("unpanda"));
        r.add(Automaton.makeAutomaton("unpaguro"));
        r.add(Automaton.makeAutomaton("unkoala"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest013(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("lotus"));
        set.add(Automaton.makeAutomaton("poppy"));
        set.add(Automaton.makeAutomaton("lily"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("l"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("waterl"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("waterlotus"));
        r.add(Automaton.makeAutomaton("poppy"));
        r.add(Automaton.makeAutomaton("waterlily"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest014(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("poppy"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("poppy"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("fuffy"));
        replace.add(Automaton.makeAutomaton("totty"));
        replace.add(Automaton.makeAutomaton("mommy"));
        FA replaceWith = new FA(Automaton.union(replace));


        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, replaceWith);

    }

    @Test
    public void replaceTest015(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("aaa"));
        set.add(Automaton.makeAutomaton("bbb"));
        set.add(Automaton.makeAutomaton("ccc"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        search.add(Automaton.makeAutomaton("b"));
        search.add(Automaton.makeAutomaton("c"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("d"));
        replace.add(Automaton.makeAutomaton("e"));
        replace.add(Automaton.makeAutomaton("f"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("daa"));
        r.add(Automaton.makeAutomaton("eaa"));
        r.add(Automaton.makeAutomaton("faa"));
        r.add(Automaton.makeAutomaton("aaa"));
        r.add(Automaton.makeAutomaton("bbb"));
        r.add(Automaton.makeAutomaton("ccc"));
        r.add(Automaton.makeAutomaton("dbb"));
        r.add(Automaton.makeAutomaton("ebb"));
        r.add(Automaton.makeAutomaton("fbb"));
        r.add(Automaton.makeAutomaton("dcc"));
        r.add(Automaton.makeAutomaton("ecc"));
        r.add(Automaton.makeAutomaton("fcc"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest016(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("eggsandham"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("green"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("greeneggsandham"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest017(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("i"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pinda"));
        r.add(Automaton.makeAutomaton("piguro"));
        r.add(Automaton.makeAutomaton("koila"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest018(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("paguro"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("lan"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("lanpanda"));
        r.add(Automaton.makeAutomaton("lanpaguro"));
        r.add(Automaton.makeAutomaton("lankoala"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest019(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("babbabam"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("bam"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("no"));
        replace.add(Automaton.makeAutomaton("ni"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("babbano"));
        r.add(Automaton.makeAutomaton("babbani"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest020(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("cal"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("l"));
        FA searchFor = new FA(Automaton.union(search));

        //ciclo --> , epsilon, s, ss, sss, ssss....
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "s"));
        FA replaceWith = new FA(new Automaton(delta, states));

        //ciclo --> ca, cas, cass, casss...
        HashSet<State> statesR = new HashSet<>();
        HashSet<Transition> deltaR = new HashSet<>();
        State q00 = new State("q0", true, false);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, true);
        statesR.add(q00);
        statesR.add(q1);
        statesR.add(q2);
        deltaR.add(new Transition(q00, q1, "c"));
        deltaR.add(new Transition(q1, q2, "a"));
        deltaR.add(new Transition(q2, q2, "s"));
        FA result = new FA(new Automaton(deltaR, statesR));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest021(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("aaa"));
        set.add(Automaton.makeAutomaton("bbb"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        search.add(Automaton.makeAutomaton("b"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("d"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("aaa"));
        r.add(Automaton.makeAutomaton("bbb"));
        r.add(Automaton.makeAutomaton("daa"));
        r.add(Automaton.makeAutomaton("dbb"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        //visualizeAutomaton.show(resultR, "result");
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest022(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("blue "));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("blue panda"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        //visualizeAutomaton.show(resultR, "result");
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest023(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("aaa"));
        set.add(Automaton.makeAutomaton("bbb"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("c"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("d"));
        FA replaceWith = new FA(Automaton.union(replace));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, a);

    }

    @Test
    public void replaceTest024(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("calm"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        FA searchFor = new FA(Automaton.union(search));

        //ciclo --> epsilon, a, aa, aaa, aaaa....
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q0 = new State("q0", true, true);
        states.add(q0);
        delta.add(new Transition(q0, q0, "a"));
        FA replaceWith = new FA(new Automaton(delta, states));

        //ciclo --> clm, calm, caalm, caaalm, caaaalm...
        HashSet<State> statesR = new HashSet<>();
        HashSet<Transition> deltaR = new HashSet<>();
        State q00 = new State("q0", true, false);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);
        State q3 = new State("q3", false, true);
        statesR.add(q00);
        statesR.add(q1);
        statesR.add(q2);
        statesR.add(q3);
        deltaR.add(new Transition(q00, q1, "c"));
        deltaR.add(new Transition(q1, q1, "a"));
        deltaR.add(new Transition(q1, q2, "l"));
        deltaR.add(new Transition(q2, q3, "m"));
        FA result = new FA(new Automaton(deltaR, statesR));
        
        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest025(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("calm"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("a"));
        FA searchFor = new FA(Automaton.union(search));

        //ciclo --> a, aa, aaa, aaaa....
        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q00 = new State("q0", true, false);
        State q01 = new State("q1", false, true);
        states.add(q00);
        states.add(q01);
        delta.add(new Transition(q00, q01, "a"));
        delta.add(new Transition(q01, q01, "a"));
        FA replaceWith = new FA(new Automaton(delta, states));

        //ciclo --> clm, calm, caalm, caaalm, caaaalm...
        HashSet<State> statesR = new HashSet<>();
        HashSet<Transition> deltaR = new HashSet<>();
        State q0 = new State("q0", true, false);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);
        State q3 = new State("q3", false, false);
        State q4 = new State("q4", false, true);
        statesR.add(q0);
        statesR.add(q1);
        statesR.add(q2);
        statesR.add(q3);
        statesR.add(q4);
        deltaR.add(new Transition(q0, q1, "c"));
        deltaR.add(new Transition(q1, q2, "a"));
        deltaR.add(new Transition(q2, q2, "a"));
        deltaR.add(new Transition(q2, q3, "l"));
        deltaR.add(new Transition(q3, q4, "m"));
        FA result = new FA(new Automaton(deltaR, statesR));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest026(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("aaa"));
        set.add(Automaton.makeAutomaton("bbb"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("c"));
        search.add(Automaton.makeAutomaton("b"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("d"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("aaa"));
        r.add(Automaton.makeAutomaton("bbb"));
        r.add(Automaton.makeAutomaton("dbb"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest027(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("inkjet"));
        set.add(Automaton.makeAutomaton("jetbrain"));
        set.add(Automaton.makeAutomaton("jetcola"));
        set.add(Automaton.makeAutomaton("painjet"));
        set.add(Automaton.makeAutomaton("andyjet"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("jet"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("bob"));
        replace.add(Automaton.makeAutomaton("toby"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("inkbob"));
        r.add(Automaton.makeAutomaton("bobbrain"));
        r.add(Automaton.makeAutomaton("bobcola"));
        r.add(Automaton.makeAutomaton("painbob"));
        r.add(Automaton.makeAutomaton("andybob"));
        r.add(Automaton.makeAutomaton("inktoby"));
        r.add(Automaton.makeAutomaton("tobybrain"));
        r.add(Automaton.makeAutomaton("tobycola"));
        r.add(Automaton.makeAutomaton("paintoby"));
        r.add(Automaton.makeAutomaton("andytoby"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest028(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("alphabravocharlie"));
        set.add(Automaton.makeAutomaton("charliebravoalpha"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("charlie"));
        search.add(Automaton.makeAutomaton("bravo"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton(""));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("bravoalpha"));
        r.add(Automaton.makeAutomaton("charliealpha"));
        r.add(Automaton.makeAutomaton("alphabravo"));
        r.add(Automaton.makeAutomaton("alphacharlie"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest029(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("alpha"));
        FA a = new FA(Automaton.union(set));

        HashSet<State> states = new HashSet<>();
        HashSet<Transition> delta = new HashSet<>();
        State q00 = new State("q0", true, false);
        State q01 = new State("q1", false, true);
        states.add(q00);
        states.add(q01);
        delta.add(new Transition(q00, q01, "a"));
        delta.add(new Transition(q01, q01, "a"));
        FA searchFor = new FA(new Automaton(delta, states));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton(""));
        FA replaceWith = new FA(Automaton.union(replace));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, new FA(Automaton.makeTopLanguage()));

    }

    @Test
    public void replaceTest030(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("charliebravoalpha"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("charlie"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton(""));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("bravoalpha"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest031(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("charliebravoalpha"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("charlie"));
        search.add(Automaton.makeAutomaton("bravo"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton(""));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("bravoalpha"));
        r.add(Automaton.makeAutomaton("charliealpha"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest032(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("charliebravoalpha"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        search.add(Automaton.makeAutomaton("bravo"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("delta"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("deltacharliebravoalpha"));
        r.add(Automaton.makeAutomaton("charliedeltaalpha"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, result);

    }


    @Test
    public void replaceTest033(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("pandapanda"));
        set.add(Automaton.makeAutomaton("pande"));
        FA a = new FA(Automaton.union(set));

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton("pan"));
        FA searchFor = new FA(Automaton.union(search));

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("on"));
        FA replaceWith = new FA(Automaton.union(replace));

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("ondapanda"));
        r.add(Automaton.makeAutomaton("onde"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);
        Assert.assertEquals(resultR, result);

    }

    @Test
    public void replaceTest034(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("pearl"));
        set.add(Automaton.makeAutomaton("garnet"));
        FA a = new FA(Automaton.union(set));
        //visualizeAutomaton.show(a, "a");

        HashSet<Automaton> search = new HashSet<>();
        search.add(Automaton.makeAutomaton(""));
        search.add(Automaton.makeAutomaton("ar"));
        search.add(Automaton.makeAutomaton("rose"));
        search.add(Automaton.makeAutomaton("et"));
        FA searchFor = new FA(Automaton.union(search));
        //visualizeAutomaton.show(searchFor, "searchFor2");

        HashSet<Automaton> replace = new HashSet<>();
        replace.add(Automaton.makeAutomaton("a"));
        replace.add(Automaton.makeAutomaton("en"));
        FA replaceWith = new FA(Automaton.union(replace));
        //visualizeAutomaton.show(replaceWith, "replacewith");


        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("pearl"));
        r.add(Automaton.makeAutomaton("garnet"));
        r.add(Automaton.makeAutomaton("apearl"));
        r.add(Automaton.makeAutomaton("agarnet"));
        r.add(Automaton.makeAutomaton("enpearl"));
        r.add(Automaton.makeAutomaton("engarnet"));
        r.add(Automaton.makeAutomaton("peal"));
        r.add(Automaton.makeAutomaton("ganet"));
        r.add(Automaton.makeAutomaton("peenl"));
        r.add(Automaton.makeAutomaton("gennet"));
        r.add(Automaton.makeAutomaton("garna"));
        r.add(Automaton.makeAutomaton("garnen"));

        FA result = new FA(Automaton.union(r));

        FA resultR = a.replace(searchFor, replaceWith);

        Assert.assertEquals(resultR, result);
    }
    

}