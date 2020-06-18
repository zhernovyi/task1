package generationExamples;

import main.Configurations;
import main.PositiveNegativeCounters;

import java.util.ArrayList;
import java.util.List;

public class ExamplesFromRandomGenerationImpl extends PositiveNegativeCounters implements EquationPattern {
    private final static int SIZE_ARRAY = 5;
    private final static int SIZE_ITEMS_OF_ARRAY = 3;

    @Override
    public List<Integer[]> generationExamples() {
        List<Integer[]> listOfExamples = new ArrayList<>();
        for (int temporaryArrayCounter = 0; temporaryArrayCounter < SIZE_ARRAY; temporaryArrayCounter++) {
            Integer[] arrExample = new Integer[SIZE_ITEMS_OF_ARRAY];
            int num1 = getNum();
            int num2 = getNum();
            int rightResult = num1 * num2;
            arrExample[0] = num1;
            arrExample[1] = num2;
            arrExample[2] = rightResult;

            listOfExamples.add(arrExample);
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
        System.out.println(String.format(Configurations.getPrintCounters(), getPositiveCounter(), getNegativeCounter()));
    }
}
