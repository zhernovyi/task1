package main;

import generationExamples.EquationPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositiveNegativeCountersAndOtherParameters {
    public static int getPositiveCounter() {
        return positiveCounter;
    }

    public static int getNegativeCounter() {
        return negativeCounter;
    }

    protected static int positiveCounter = 0;
    protected static int negativeCounter = 0;

    public static Integer[][] listOfGenExamples;

    protected static EquationPattern equationPattern = null;

    public String setTempScannerCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    List<String> listOfArrays = new ArrayList<>();
}
