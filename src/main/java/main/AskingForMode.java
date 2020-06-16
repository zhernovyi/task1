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

public class AskingForMode {
    private static String chooseModeByUser = "";
    public static void setChooseModeByUser(String chooseModeByUser) {
        AskingForMode.chooseModeByUser = chooseModeByUser;
    }
    public static String getChooseModeByUser() {
        return chooseModeByUser;
    }

    private final static String START_OF_PROGRAM = "Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit";
    private final static String FIRST_POSITION = "1";
    private final static String SECOND_POSITION = "2";
    private final static String ZERO_POSITION = "0";
    private final static String WRONG_VALUE = "You've entered the wrong command. Try again: ";
    private final static String CHOOSE_AN_ACTION = "Choose an action of examples: 1 - mult, 2 - div";
    private final static String TRY_MORE = "Do you wanna continue?(1 - yes/ 0 - no): ";

    protected EquationPattern askingForMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_OF_PROGRAM);
        setChooseModeByUser(scanner.next());
        while (true) {
            if (getChooseModeByUser().equals(FIRST_POSITION)) {
                return new ExamplesFromRandomGenerationImpl();
            } else if (getChooseModeByUser().equals(SECOND_POSITION)) {
                return new ExamplesFromFileGenerationImpl();
            } else if (getChooseModeByUser().equals(ZERO_POSITION)) {
                return new ExitBeforeStartedExample();
            } else {
                System.out.println(WRONG_VALUE);
                setChooseModeByUser(scanner.next());
            }
        }
    }

    protected BasicAction askingForAction() {
        if (getChooseModeByUser().equals(ZERO_POSITION)) {
            return new ExitBeforeChoosingAction();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println(CHOOSE_AN_ACTION);
            String chooseAction = scanner.next();
            while (true) {
                if (chooseAction.equals(FIRST_POSITION)) {
                    return new Multiplication();
                } else if (chooseAction.equals(SECOND_POSITION)) {
                    return new Division();
                } else {
                    System.out.println(WRONG_VALUE);
                    chooseAction = scanner.next();
                }
            }
        }
    }

    protected Integer[][] askForQuit(List<String> listOfDoneExamples) {
        Scanner scanner = new Scanner(System.in);
        String tempAskForQuitCommand = "";
        if (listOfDoneExamples != null) {
            System.out.print(TRY_MORE);
            tempAskForQuitCommand = scanner.next();
        } else {
            tempAskForQuitCommand = ZERO_POSITION;
        }

        while (true) {
            Main main = new Main();
            if (tempAskForQuitCommand.equals(FIRST_POSITION)) {
                return main.getEquationPattern().generationExamples();
            } else if (tempAskForQuitCommand.equals(ZERO_POSITION)) {
                main.getEquationPattern().saveExamples(listOfDoneExamples);
                System.exit(0);
            } else {
                System.out.println(WRONG_VALUE);
                tempAskForQuitCommand = scanner.next();

            }
        }
    }
}
