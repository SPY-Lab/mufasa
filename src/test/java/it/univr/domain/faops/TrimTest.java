package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class TrimTest {

    @Test
    public void trimTest001(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("    panda   "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest002(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("   pan    "));
        set.add(Automaton.makeAutomaton(" pa "));
        set.add(Automaton.makeAutomaton("    panda "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("panda"));
        r.add(Automaton.makeAutomaton("pan"));
        r.add(Automaton.makeAutomaton("pa"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest003(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("    a  "));
        set.add(Automaton.makeAutomaton(" a "));
        set.add(Automaton.makeAutomaton("        a"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("a"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest004(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("     material  "));
        set.add(Automaton.makeAutomaton("   pancake "));
        set.add(Automaton.makeAutomaton("   muffin "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("material"));
        r.add(Automaton.makeAutomaton("pancake"));
        r.add(Automaton.makeAutomaton("muffin"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest005(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("   cupcake "));
        set.add(Automaton.makeAutomaton(" pan cake "));
        set.add(Automaton.makeAutomaton("  muff in"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("cupcake"));
        r.add(Automaton.makeAutomaton("pan cake"));
        r.add(Automaton.makeAutomaton("muff in"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest006(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("   w i n d"));
        set.add(Automaton.makeAutomaton(" sunshine "));
        set.add(Automaton.makeAutomaton("  rain   "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("w i n d"));
        r.add(Automaton.makeAutomaton("sunshine"));
        r.add(Automaton.makeAutomaton("rain"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest007(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("  machine "));
        set.add(Automaton.makeAutomaton("     t uring "));
        set.add(Automaton.makeAutomaton(" b ool "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("machine"));
        r.add(Automaton.makeAutomaton("t uring"));
        r.add(Automaton.makeAutomaton("b ool"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest008(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("  math"));
        set.add(Automaton.makeAutomaton("   science"));
        set.add(Automaton.makeAutomaton(" mystery "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("math"));
        r.add(Automaton.makeAutomaton("science"));
        r.add(Automaton.makeAutomaton("mystery"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest009(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("may  "));
        set.add(Automaton.makeAutomaton("    june"));
        set.add(Automaton.makeAutomaton("    july"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("may"));
        r.add(Automaton.makeAutomaton("june"));
        r.add(Automaton.makeAutomaton("july"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest010(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton(" s e a "));
        set.add(Automaton.makeAutomaton("    shire "));
        set.add(Automaton.makeAutomaton(" l ight"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("s e a"));
        r.add(Automaton.makeAutomaton("shire"));
        r.add(Automaton.makeAutomaton("l ight"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest011(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("compute r "));
        set.add(Automaton.makeAutomaton("    bug "));
        set.add(Automaton.makeAutomaton(" millenium "));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("compute r"));
        r.add(Automaton.makeAutomaton("bug"));
        r.add(Automaton.makeAutomaton("millenium"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }

    @Test
    public void trimTest012(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("     m oon   "));
        set.add(Automaton.makeAutomaton("    shine"));
        set.add(Automaton.makeAutomaton(" light"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("m oon"));
        r.add(Automaton.makeAutomaton("shine"));
        r.add(Automaton.makeAutomaton("light"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }


    @Test
    public void trimTest013(){

        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("   nap"));
        set.add(Automaton.makeAutomaton("  adnap  "));
        set.add(Automaton.makeAutomaton("        ap"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> r = new HashSet<>();
        r.add(Automaton.makeAutomaton("nap"));
        r.add(Automaton.makeAutomaton("ap"));
        r.add(Automaton.makeAutomaton("adnap"));
        Automaton result = Automaton.union(r);

        Automaton resultR = Automaton.trim(a);

        Assert.assertEquals(new FA(resultR), new FA(result));
    }
}