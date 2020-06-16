package main;

import actions.BasicAction;
import actions.Division;
import actions.ExitBeforeChoosingAction;
import actions.Multiplication;
import generationExamples.EquationPattern;
import generationExamples.ExamplesFromFileGenerationImpl;
import generationExamples.ExamplesFromRandomGenerationImpl;
import generationExamples.ExitBeforeStartedExample;

import java.util.List;
import java.util.Scanner;

public class AskingForMode  {
    public static boolean varKeyOfStart = true; //this variable can help understand the system, where the program is started
    static String chooseModeByUser = "";

//    Main main = new Main();

    protected static EquationPattern askingForMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
        chooseModeByUser = scanner.next();
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

    protected static BasicAction askingForAction() {
        if (chooseModeByUser.equals("0")){
            return new ExitBeforeChoosingAction();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an action of examples: 1 - mult, 2 - div");
            String chooseAction = scanner.next();
            while (true) {
                if (chooseAction.equals("1")) {
                    return new Multiplication();
                } else if (chooseAction.equals("2")) {
                    return new Division();
                } else {
                    System.out.println("You've entered the wrong command. Try again: ");
                    chooseAction = scanner.next();

                }
            }
        }
    }

    protected static Integer[][] askForQuit(List<String> listOfDoneExamples) {
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
                varKeyOfStart = false;
                return Main.equationPattern.generationExamples();
            } else if (tempAskForQuitCommand.equals("0")) {
                Main.equationPattern.saveExamples(listOfDoneExamples);
                System.exit(0);
            } else {
                System.out.println("you've entered wrong value. Try again: ");
            }
        }
    }

}
