package main;

import java.util.List;
import java.util.Scanner;

public class Multiplication extends Main {
    protected List<String> doingMultExamples(Integer[][] listOfExamples) {
        while (true) {
            if (listOfExamples==null){
                break;
            }
            for (Integer[] temp : listOfExamples) {
                int num1 = temp[0];
                int num2 = temp[1];
                int rightResult = temp[2];
                System.out.print(num1 + " * " + num2 + " = ");

                int yourResult = Integer.parseInt((new Scanner(System.in).next()));
                String doneExample = formatEquatione(num1, num2, rightResult, yourResult);
                listOfArrays.add(doneExample);

                if (yourResult == rightResult) {
                    System.out.print((char) 27 + "[32mRight");
                    positiveCounter++;
                } else {
                    System.out.print((char) 27 + "[31mWrong" + (char) 27 + "[32m (" + rightResult + ")");
                    negativeCounter++;
                }
                System.out.println("\n" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);
                System.out.println((char) 27 + "[0m");
            }
            return listOfArrays;
        }
        return null;
    }

    public String formatEquatione(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult) {
            return "\n" + num1 + " * " + num2 + " = " + rightResult;
        } else {
            return "\n" + num1 + " * " + num2 + " = " + rightResult + " (" + yourResult + ")";
        }
    }
}
