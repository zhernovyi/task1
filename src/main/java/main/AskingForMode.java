package main;

import generationExamples.EquationPattern;
import generationExamples.ExamplesFromFileGenerationImpl;
import generationExamples.ExamplesFromRandomGenerationImpl;
import generationExamples.ExitBeforeStartedExample;

import java.util.List;
import java.util.Scanner;

public class AskingForMode extends Main {
    protected static EquationPattern askingForMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
        String chooseModeByUser = scanner.next();
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
                chooseModeByUser = scanner.next();

            }
        }
    }

    protected Integer[][] askForQuit(List<String> listOfDoneExamples) {
        String tempAskForQuitCommand = "";
        if (listOfDoneExamples!=null){
            System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
            Scanner scanner = new Scanner(System.in);
            tempAskForQuitCommand = scanner.next();
        } else {
            tempAskForQuitCommand = "0";
        }


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
