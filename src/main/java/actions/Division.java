package actions;

import main.PositiveNegativeCounters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Division extends PositiveNegativeCounters implements BasicAction {
    List<String> listOfArrays = new ArrayList<>();

    @Override
    public List<String> doingAction(Integer[][] listOfExamples) {
        while (true) {
            if (listOfExamples == null) {
                break;
            }
            for (Integer[] temp : listOfExamples) {
                int num1 = temp[2];
                int num2 = temp[1];
                int rightResult = temp[0];
                printActionWithNumbers(num1, num2);

                int yourResult = Integer.parseInt((new Scanner(System.in).next()));
                String doneExample = formatEquation(num1, num2, rightResult, yourResult);
                listOfArrays.add(doneExample);

                if (yourResult == rightResult) {
                    printRightResult();
                    positiveCounter++;
                } else {
                    printWrongResult(rightResult);
                    negativeCounter++;
                }
                System.out.println(getCounterResult());
            }
            return listOfArrays;
        }
        return null;
    }

    @Override
    public String formatEquation(int num1, int num2, int rightResult, int yourResult) {
        String format;
        if (yourResult == rightResult) {
            format = "\n%d / %d = %d";
            return String.format(format, num1, num2, rightResult);
        } else {
            format = "\n%d / %d = %d (%d)";
            return String.format(format, num1, num2, rightResult, yourResult);
        }
    }

    @Override
    public void printWrongResult(int rightResult) {
        String format = "\u001B[31mWrong\u001B[36m(%d)\u001B[0m";
        System.out.println(String.format(format, rightResult));
    }

    @Override
    public void printRightResult() {
        String format = "\u001B[36mRight\u001B[0m";
        System.out.println(format);
    }

    @Override
    public void printActionWithNumbers(int num1, int num2) {
        String format = "%d / %d = ";
        System.out.print(String.format(format, num1, num2));
    }
}
