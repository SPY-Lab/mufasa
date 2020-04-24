package it.univr.domain.coalasced;
//package it.univr.fsm.machine;

import it.univr.domain.coalasced.FA;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class visualizeAutomaton {

    /**
     * Shows an automaton graphic image using ubuntu image viewer
     * @param fa
     * @param fileName
     */
    public static void show(FA fa, String fileName){

        String dotNot = createDotNot(fa);
        createFile(dotNot, fileName);
        execCommand("dot " + fileName +".dot -Tpng -o " + fileName + ".png");
        execCommand("eog " + fileName + ".png");

    }

    /**
     * Creates the dot notation from an automa
     * @param automa automa for which we create the dot notation
     * @return
     */
    private static String createDotNot(FA automa){
        String dotNot = "digraph G {\n";
        dotNot += "\trankdir=LR;\n\tnode [width=0.3 shape=circle]\n";


        for(State finalStates: automa.getAutomaton().getFinalStates()){
            dotNot += "\t" + finalStates.getState() + " [width=0.3 shape=doublecircle]\n";
        }



        for(Transition t : automa.getAutomaton().getDelta()){
            dotNot += "\t" + t.getFrom().getState() + " -> " + t.getTo().getState() + " [label=\"" + t.getInput() + "\"];\n";
        }

        return dotNot + "}";
    }

    /**
     * Creates a new file
     * @param dotNot string to write in the file
     * @param pathName name of the file
     */
    private static void createFile(String dotNot, String pathName){

        try{
            File file = new File(pathName + ".dot");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(dotNot);
            out.close();
        }catch(IOException e){
            System.out.println("Something went wrong in creating the file...");
        }

    }

    /**
     * Executes a command in terminal
     * @param command
     */
    private static void execCommand(String command){
        try {
            Process p = Runtime.getRuntime().exec(command);
        }catch(IOException e){
            System.out.println("Something went wrong in executing the command");
        }
    }
}
