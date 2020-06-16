package main;

import actions.BasicAction;
import actions.Multiplication;
import generationExamples.EquationPattern;

import java.util.List;

public class Main extends PositiveNegativeCounters {
//    private static AskingForMode askingForMode = new AskingForMode();
//    private static AskingForMode ask = new AskingForMode();
    private static BasicAction basicAction = null;
    protected static EquationPattern equationPattern = null;


    public static void main(String[] args) {
        Integer[][] listOfGenExamples=null;

        while (true) {
            if (AskingForMode.varKeyOfStart == true) {
                equationPattern = AskingForMode.askingForMode();
                basicAction = AskingForMode.askingForAction();
                listOfGenExamples = equationPattern.generationExamples();
            }
            List<String> listOfDoneExamples = basicAction.doingAction(listOfGenExamples);
            listOfGenExamples = AskingForMode.askForQuit(listOfDoneExamples);
        }
    }
}
