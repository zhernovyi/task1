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
        return "\n" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter+(char) 27 + "[0m";
    }
}
