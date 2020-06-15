package main;

import generationExamples.EquationPattern;
import generationExamples.ExamplesFromFileGenerationImpl;
import generationExamples.ExamplesFromRandomGenerationImpl;
import generationExamples.ExitBeforeStartedExample;

import java.util.List;

public class AskingForMode extends Main {
    protected static EquationPattern chosenGenMode() {
        Main main = new Main();
        System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
        String chooseModeByUser = main.setTempScannerCommand();
        Integer[][] listOfExamples = null;
        while (true) {
            if (chooseModeByUser.equals("1")) {
                return new ExamplesFromRandomGenerationImpl();
            } else if (chooseModeByUser.equals("2")) {
                return new ExamplesFromFileGenerationImpl();
            } else if (chooseModeByUser.equals("0")) {
                return new ExitBeforeStartedExample();
            } else {
                System.out.println("You've entered the wrong command. Try again: ");
                chooseModeByUser = main.setTempScannerCommand();
            }
        }
    }

    protected Integer[][] askForQuit(List<String> listOfDoneExamples) {
        System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
        Main main = new Main();
        String tempAskForQuitCommand = main.setTempScannerCommand();

        while (true) {
            if (tempAskForQuitCommand.equals("1")) {
                Main.varKeyOfStart = false;
                return equationPattern.generationExamples();
            } else if (tempAskForQuitCommand.equals("0")) {
                equationPattern.saveExamples(listOfDoneExamples);
                System.exit(0);
            } else {
                System.out.println("you've entered wrong value. Try again: ");
            }
        }
    }

}
