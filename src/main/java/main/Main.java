package main;

import actions.BasicAction;
import generationExamples.EquationPattern;

import java.util.List;

public class Main {
    private static EquationPattern equationPattern;//STATIC - because it has an important data, that should be saved for whole runtime of app

    public EquationPattern getEquationPattern() {
        return equationPattern;
    }

    public static void main(String[] args) throws Exception {
        Configurations conf = new Configurations();
        AskingForMode askingForMode = new AskingForMode();
        Main.equationPattern = askingForMode.askingForMode();
        BasicAction basicAction = askingForMode.askingForAction();

        while (true) {
            List<Integer[]> listOfGenExamples = Main.equationPattern.generationExamples();
            List<String> listOfDoneExamples = basicAction.doingAction(listOfGenExamples);
            listOfGenExamples = askingForMode.askForQuit(listOfDoneExamples);
        }
    }
}