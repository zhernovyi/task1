package generationExamples;

import main.PositiveNegativeCounters;

import java.util.List;

public class ExamplesFromRandomGenerationImpl extends PositiveNegativeCounters implements EquationPattern {
    private final static int SIZE_ARRAY = 5;
    private final static int SIZE_ITEMS_OF_ARRAY = 3;

    @Override
    public Integer[][] generationExamples() {
        Integer[][] listOfExamples = new Integer[SIZE_ARRAY][SIZE_ITEMS_OF_ARRAY];
        for (int temporaryArrayCounter = 0; temporaryArrayCounter < SIZE_ARRAY; temporaryArrayCounter++) {
            int num1 = getNum();
            int num2 = getNum();
            int rightResult = num1 * num2;
            listOfExamples[temporaryArrayCounter][0] = num1;
            listOfExamples[temporaryArrayCounter][1] = num2;
            listOfExamples[temporaryArrayCounter][2] = rightResult;
        }
        return listOfExamples;
    }

    private int getNum() {
        return (int) (Math.random() * 6 + 4);
    }

    @Override
    public void saveExamples(List<String> array) {
        for (String s : array) {
            System.out.print(s);
        }
        String format = "\nYour result: \u001B[36m%d\u001B[30m/\u001B[31m%d\u001B[0m";
        System.out.println(String.format(format, getPositiveCounter(), getNegativeCounter()));
    }
}
