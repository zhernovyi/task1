package main;

import java.util.Scanner;

public class PositiveNegativeCounters {
    public int getPositiveCounter() {
        return positiveCounter;
    }

    public int getNegativeCounter() {
        return negativeCounter;
    }

    protected static int positiveCounter = 0;
    protected static int negativeCounter = 0;

    public String getCounterResult (){
        String format = "\n\u001B[36m%d\u001B[0m/\u001B[31m%d\u001B[0m";
        return String.format(format, positiveCounter, negativeCounter);
    }
}
