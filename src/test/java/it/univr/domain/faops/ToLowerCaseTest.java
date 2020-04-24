package it.univr.domain.faops;

import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class ToLowerCaseTest {
    
    @Test
    public void ToLowerCaseTest001() {
        Automaton a = Automaton.makeAutomaton("ABCDE");
        Automaton lower = Automaton.makeAutomaton("abcde");
        Assert.assertEquals(new FA(lower), new FA(Automaton.toLowerCase(a)));
    }

    @Test
    public void ToLowerCaseTest002() {
        HashSet<Automaton> set = new HashSet<>();
        set.add(Automaton.makeAutomaton("abcDEF*"));
        set.add(Automaton.makeAutomaton("ghIL"));
        set.add(Automaton.makeAutomaton("mn0P"));
        Automaton a = Automaton.union(set);

        HashSet<Automaton> setLower = new HashSet<>();
        setLower.add(Automaton.makeAutomaton("abcdef*"));
        setLower.add(Automaton.makeAutomaton("ghil"));
        setLower.add(Automaton.makeAutomaton("mn0p"));
        Automaton lower = Automaton.union(setLower);

        Assert.assertEquals(new FA(lower), new FA(Automaton.toLowerCase(a)));
    }

    @Test
    public void ToLowerCaseTest003(){
        Automaton automaton = Automaton.makeAutomaton("ABcDE*!");
        Automaton lower = Automaton.makeAutomaton("abcde*!");
        Assert.assertEquals(lower, Automaton.toLowerCase(automaton));
    }

    @Test
    public void ToLowerCaseTest004(){
        Automaton automaton = Automaton.makeAutomaton("063abCdEà");
        Automaton lower = Automaton.makeAutomaton("063abcdeà");
        Assert.assertEquals(lower, Automaton.toLowerCase(automaton));
    }

    @Test
    public void ToLowerCaseTest005(){
        Automaton automaton = Automaton.makeAutomaton("abcde");
        Assert.assertEquals(automaton, Automaton.toLowerCase(automaton));
    }

    @Test
    public void ToLowerCaseTest006(){
        State q = new State("q0", true, true);
        HashSet<State> states = new HashSet<>();
        states.add(q);
        Transition t = new Transition(q, q, "a");
        HashSet<Transition> delta = new HashSet<>();
        delta.add(t);
        Automaton a = new Automaton (delta, states);
        Assert.assertEquals(a, Automaton.toLowerCase(a));
    }

    @Test
    public void ToLowerCaseTest007() {
        Automaton automaton = Automaton.makeAutomaton("pANDA #$%");
        automaton = Automaton.union(automaton, Automaton.makeAutomaton("panda!!!KOALa!!!"));
        Automaton result = Automaton.makeAutomaton("panda #$%");
        result = Automaton.union(result, Automaton.makeAutomaton("panda!!!koala!!!"));
        Assert.assertEquals(Automaton.toLowerCase(automaton), result);
    }
    @Test
    public void ToLowerCaseTest008() {
        Automaton automaton = Automaton.makeAutomaton("PAndA?");
        automaton = Automaton.union(automaton, Automaton.makeAutomaton("!KoALA"));
        Automaton result = Automaton.makeAutomaton("panda?");
        result = Automaton.union(result, Automaton.makeAutomaton("!koala"));
        Assert.assertEquals(Automaton.toLowerCase(automaton), result);
    }


}