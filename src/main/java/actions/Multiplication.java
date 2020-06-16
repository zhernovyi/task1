package actions;

import main.PositiveNegativeCounters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Multiplication extends PositiveNegativeCounters implements BasicAction {
    List<String> listOfArrays = new ArrayList<>();

    @Override
    public List<String> doingAction(Integer[][] listOfExamples) {
        while (true) {
            if (listOfExamples == null) {
                break;
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
        if (yourResult == rightResult) {
            return "\n" + num1 + " * " + num2 + " = " + rightResult;
        } else {
            return "\n" + num1 + " * " + num2 + " = " + rightResult + " (" + yourResult + ")";
        }
    }

    //===============================
    @Override
    public void printWrongResult(int rightResult) {
        System.out.println((char) 27 + "[31mWrong" + (char) 27 + "[32m (" + rightResult + ")");
    }

    @Override
    public void printRightResult() {
        System.out.println((char) 27 + "[32mRight");
    }

    @Override
    public void printActionWithNumbers(int num1, int num2) {
        System.out.println(num1 + " * " + num2 + " = ");
    }
}
