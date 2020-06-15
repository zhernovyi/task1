package main;

import java.util.List;

public class Main extends PositiveNegativeCountersAndOtherParameters {
    public static boolean varKeyOfStart = true; //this variable can help understand the system, where the program is started

    public static void main(String[] args) {
        Main main = new Main();
        Multiplication mult = new Multiplication();
        AskingForMode ask = new AskingForMode();

        while (true) {
            if (Main.varKeyOfStart == true) {
                main.equationPattern = ask.chosenGenMode();
                Main.listOfGenExamples = main.equationPattern.generationExamples();
            }
            List<String> listOfDoneExamples = mult.doingMultExamples(Main.listOfGenExamples);
            listOfGenExamples = ask.askForQuit(listOfDoneExamples);
        }
    }
}
