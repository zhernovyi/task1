package generationExamples;

import main.Configurations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExamplesFromFileGenerationImpl implements EquationPattern {
    private final static String NUMBERS_SPLITTER_IN_STRING = " ";

    @Override
    public List<Integer[]> generationExamples() {
        BufferedReader reader;
        int counterExamples = 0;
        try {
            reader = new BufferedReader(new FileReader(Configurations.getPathToOpenFile()));
            int countOfStrings = 0;
            {
                BufferedReader readerTemp;
                readerTemp = reader;
                String lineTemp = readerTemp.readLine();
                while (lineTemp != null) {
                    countOfStrings++;
                    lineTemp = readerTemp.readLine();
                }
            }

            reader = new BufferedReader(new FileReader(Configurations.getPathToOpenFile()));
            String line = reader.readLine();
            String[] tempArrayString = line.split(NUMBERS_SPLITTER_IN_STRING);
            List<Integer[]> listOfExamples = new ArrayList<>();

            while (line != null) {
                String[] arrayExampleString = line.split(NUMBERS_SPLITTER_IN_STRING);
                Integer[] arrExampleInt = new Integer[tempArrayString.length];
                for (int j = 0; j < arrayExampleString.length; j++) {
                    arrExampleInt[j] = Integer.parseInt(arrayExampleString[j]);
                }
                listOfExamples.add(arrExampleInt);
                line = reader.readLine();
                counterExamples++;
                if (counterExamples != countOfStrings) {

                } else {
                    return listOfExamples;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


    @Override
    public void saveExamples(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter(Configurations.getPathToSaveFile(), false)) {
            fileWriter.write(String.valueOf(listOfArrays));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Configurations.getDateFormat());
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
