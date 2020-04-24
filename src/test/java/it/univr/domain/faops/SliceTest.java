package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class SliceTest {

    @Test
    public void sliceTest001() {

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("marco"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("0", "0");

        FA resultR = a.slice(start);
        Assert.assertEquals(resultR, a);
    }

    @Test
    public void sliceTest002(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("arco"));
        set.add(Automaton.makeAutomaton("marco"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-1", "-1");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("o"));
        FA result = new FA(Automaton.union(r));

        FA resultR = a.slice(start);
        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest003(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-3", "-3");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("nda"));
        r.add(Automaton.makeAutomaton("ala"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest004(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pan"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-3", "-3");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("nda"));
        r.add(Automaton.makeAutomaton("pan"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);

    }

    @Test
    public void sliceTest005(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-6", "-6");

        FA resultR = a.slice(start);
        Assert.assertEquals(resultR, a);
    }

    @Test
    public void sliceTest006(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandemonium"));
        FA a = new FA(Automaton.union(set));


        Interval start = new Interval("6", "6");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("onium"));
        r.add(Automaton.makeEmptyString());

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest007(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandas"));
        set.add(Automaton.makeAutomaton("pandaros"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("2", "2");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("nda"));
        r.add(Automaton.makeAutomaton("ndas"));
        r.add(Automaton.makeAutomaton("ndaros"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest008(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandas"));
        set.add(Automaton.makeAutomaton("pandaros"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-2", "-2");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("da"));
        r.add(Automaton.makeAutomaton("as"));
        r.add(Automaton.makeAutomaton("os"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest009(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pandas"));
        set.add(Automaton.makeAutomaton("pandaros"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("-5", "-5");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("andas"));
        r.add(Automaton.makeAutomaton("daros"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest0010(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("6", "6");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest011(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton(""));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("6", "6");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);
    }

    @Test
    public void sliceTest012(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("panda"));
        set.add(Automaton.makeAutomaton("pan"));
        set.add(Automaton.makeAutomaton("p"));
        set.add(Automaton.makeAutomaton("manda"));
        set.add(Automaton.makeAutomaton("koala"));
        FA a = new FA(Automaton.union(set));

        Interval start = new Interval("1", "1");

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeEmptyString());
        r.add(Automaton.makeAutomaton("an"));
        r.add(Automaton.makeAutomaton("anda"));
        r.add(Automaton.makeAutomaton("oala"));

        FA result = new FA(Automaton.union(r));
        FA resultR = a.slice(start);

        Assert.assertEquals(resultR, result);

    }

}