package it.univr.domain.coalesced;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.*;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Test;

import it.univr.fsm.machine.Automaton;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

public class CoalescedBenchTest {

    private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

    @Test
    public void testBench001() throws Exception {
        String file = "src/test/resources/bench/bench001.js";
        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
    }

    @Test
    public void testBench002() throws Exception {
        String file = "src/test/resources/bench/bench002.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 2);
        Assert.assertEquals(state.sizeHeap(), 0);
    }

    @Test
    public void testBench003() throws Exception {
        String file = "src/test/resources/bench/bench003.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 2);
        Assert.assertEquals(state.sizeHeap(), 0);

        //State value
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("ERROR1234")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("WARN1234")), state.getValue(new Variable("y")));

    }

    @Test
    public void testBench004() throws Exception {
        String file = "src/test/resources/bench/bench004.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 4);
        Assert.assertEquals(state.sizeHeap(), 0);

        //State value
        HashSet<Automaton> a = new HashSet<>();
        a.add(Automaton.makeAutomaton("null"));
        a.add(Automaton.makeAutomaton("\\u001b12345"));
        Automaton result_a = Automaton.union(a);

        Assert.assertEquals(new FA(result_a), state.getValue(new Variable("x")));

    }

    @Test
    public void testBench005() throws Exception {
        String file = "src/test/resources/bench/bench005.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 3);
        Assert.assertEquals(state.sizeHeap(), 0);


        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("robbie")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("123456")), state.getValue(new Variable("y")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("bobby")), state.getValue(new Variable("z")));
    }

    @Test
    public void testBench006() throws Exception {
        String file = "src/test/resources/bench/bench006.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 3);
        Assert.assertEquals(state.sizeHeap(), 0);

        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("1234")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("12345")), state.getValue(new Variable("y")));

    }

    @Test
    public void testBench007() throws Exception {
        String file = "src/test/resources/bench/bench007.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 3);
        Assert.assertEquals(state.sizeHeap(), 0);

        Assert.assertEquals(new FA(Automaton.makeEmptyString()), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("123")), state.getValue(new Variable("y")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("abc d")), state.getValue(new Variable("z")));


    }

    @Test
    public void testBench008() throws Exception {
        String file = "src/test/resources/bench/bench008.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 3);
        Assert.assertEquals(state.sizeHeap(), 0);

        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("null")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("file://12345")), state.getValue(new Variable("y")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("file://Robbie")), state.getValue(new Variable("z")));

    }

    @Test
    public void testBench009() throws Exception {
        String file = "src/test/resources/bench/bench009.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 2);
        Assert.assertEquals(state.sizeHeap(), 1);

        MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
        properties.put(new FA(Automaton.makeRealAutomaton("outputIndex")), new Interval("0", "0"));
        properties.put(new FA(Automaton.makeRealAutomaton("name")), new FA(Automaton.makeRealAutomaton("123456")));
        AbstractObject oObject = new AbstractObject(properties);
 
        
        AllocationSite xSite = new AllocationSite(4, 8);
        AllocationSites xSites = new AllocationSites(xSite);
        
        
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("null")), state.getValue(new Variable("y")));
        Assert.assertEquals(xSites, state.getValue(new Variable("x")));
        Assert.assertEquals(oObject, state.getValue(xSite));

    }

    @Test
    public void testBench010() throws Exception {
        String file = "src/test/resources/bench/bench010.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 4);
        Assert.assertEquals(state.sizeHeap(), 0);

        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("jajleS")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("jarwaQ")), state.getValue(new Variable("y")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("DISnem")), state.getValue(new Variable("z")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("123 pId")), state.getValue(new Variable("w")));

    }

    @Test
    public void testBench011() throws Exception {

        String file = "src/test/resources/bench/bench011.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 4);
        Assert.assertEquals(state.sizeHeap(), 0);

        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("jajHu")), state.getValue(new Variable("x")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("jarwen")), state.getValue(new Variable("y")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("DISben")), state.getValue(new Variable("z")));
        Assert.assertEquals(new FA(Automaton.makeRealAutomaton("123 ret")), state.getValue(new Variable("w")));

    }

    @Test
    public void testBench013() throws Exception {

        String file = "src/test/resources/bench/bench013.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 1);
        Assert.assertEquals(state.sizeHeap(), 2);

        MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
        properties.put(new FA(Automaton.makeRealAutomaton("a")), new FA(Automaton.makeRealAutomaton("https")));
        properties.put(new FA(Automaton.makeRealAutomaton("b")), new FA(Automaton.makeRealAutomaton("www")));
        properties.put(new FA(Automaton.makeRealAutomaton("c")), new FA(Automaton.makeRealAutomaton("google")));
        properties.put(new FA(Automaton.makeRealAutomaton("d")), new FA(Automaton.makeRealAutomaton("it")));
        AbstractObject oObject = new AbstractObject(properties);

        MultiHashMap<FA, AbstractValue> properties2 = new MultiHashMap<>();
        properties2.put(new FA(Automaton.makeRealAutomaton("a")), new FA(Automaton.makeRealAutomaton("null")));
        AbstractObject oObject2 = new AbstractObject(properties2);

        AllocationSite site2 = new AllocationSite(27, 12);
        AllocationSite site1 = new AllocationSite(13, 16);
        
        AllocationSites xSites = new AllocationSites(site1, site2);  
        
        assertEquals(state.getValue(new Variable("x")), xSites);
        
        assertEquals(state.getValue(site1), oObject);
        assertEquals(state.getValue(site2), oObject2);
    }
    
    @Test
    public void testBench014() throws Exception {

        String file = "src/test/resources/bench/bench014.js";

        AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();

        //State size
        Assert.assertEquals(state.sizeStore(), 6);
        Assert.assertEquals(state.sizeHeap(), 2);

        FA inputValue = FA.union("MANabc;Manchester", "GNFgef;Greenfield");
        Interval semiCValue = new Interval("6", "6");
        FA codeValue = FA.union("MAN", "GNF");
        FA nameValue = FA.union("Manchester", "Greenfield");
        
        assertEquals(state.getValue(new Variable("input")), inputValue);
        assertEquals(state.getValue(new Variable("semiC")), semiCValue);
        assertEquals(state.getValue(new Variable("code")), codeValue);
        assertEquals(state.getValue(new Variable("name")), nameValue);
    }
}
