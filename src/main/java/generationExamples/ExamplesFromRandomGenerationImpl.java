package generationExamples;

import main.PositiveNegativeCounters;

import java.util.List;

public class ExamplesFromRandomGenerationImpl extends PositiveNegativeCounters implements EquationPattern {
    int sizeArray = 5;
    int sizeItemsOfArray = 3;

    @Override
    public Integer[][] generationExamples() {
        Integer[][] listOfExamples = new Integer[sizeArray][sizeItemsOfArray];
        for (int temporaryArrayCounter = 0; temporaryArrayCounter < sizeArray; temporaryArrayCounter++) {
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
        System.out.println("\nYour result: " + (char) 27 + "[36m" + getPositiveCounter() + "/" + (char) 27 + "[31m" + getNegativeCounter());

    }
}
