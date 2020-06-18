package actions;

import main.PositiveNegativeCounters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Multiplication extends PositiveNegativeCounters implements BasicAction {
    List<String> listOfArrays = new ArrayList<>();
    private final static String EXAMPLE_MULT = "%d * %d = ";
    private final static String RIGHT_RESULT_MULT = "\n%d * %d = %d";
    private final static String WRONG_RESULT_MULT = "\n%d * %d = %d (%d)";

    @Override
    public List<String> doingAction(List<Integer[]> listOfExamples) {
        if (listOfExamples == null) {
            return null;
        }
        for (Integer[] temp : listOfExamples) {
            int num1 = temp[0];
            int num2 = temp[1];
            int rightResult = temp[2];
            printActionWithNumbers(num1, num2);

            int yourResult = Integer.parseInt((new Scanner(System.in).next()));
            String doneExample = formatEquation(num1, num2, rightResult, yourResult);
            listOfArrays.add(doneExample);

            if (yourResult == rightResult) {
                printCorrectResult();
                positiveCounter++;
            } else {
                printWrongResult(rightResult);
                negativeCounter++;
            }
            System.out.println(getCounterResult());
        }
        return listOfArrays;
    }

    @Override
    public String formatEquation(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult) {
            return String.format(RIGHT_RESULT_MULT, num1, num2, rightResult);
        } else {
            return String.format(WRONG_RESULT_MULT, num1, num2, rightResult, yourResult);
        }
    }

    @Override
    public void printWrongResult(int rightResult) {
        System.out.println(String.format(WRONG_ANSWER, rightResult));
    }

    @Override
    public void printCorrectResult() {
        System.out.println(CORRECT_ANSWER);
    }

    @Override
    public void printActionWithNumbers(int num1, int num2) {
        System.out.print(String.format(EXAMPLE_MULT, num1, num2));
    }
}
