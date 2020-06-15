package main;

import generationExamples.EquationPattern;

import java.util.ArrayList;
import java.util.List;

public class Main extends PositiveNegativeCounters {
    public static boolean varKeyOfStart = true; //this variable can help understand the system, where the program is started
    protected static EquationPattern equationPattern = null;
    public static Integer[][] listOfGenExamples;
    List<String> listOfArrays = new ArrayList<>();

    public static void main(String[] args) {
        Multiplication mult = new Multiplication();
        AskingForMode ask = new AskingForMode();

        while (true) {
            if (varKeyOfStart == true) {
                equationPattern = ask.askingForMode();
                listOfGenExamples = equationPattern.generationExamples();
            }
            List<String> listOfDoneExamples = mult.doingMultExamples(Main.listOfGenExamples);
            listOfGenExamples = ask.askForQuit(listOfDoneExamples);
        }
    }
}
