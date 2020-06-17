package generationExamples;

import main.Configurations;
import main.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExamplesFromFileGenerationImpl implements EquationPattern {
    private final static String SPLITTER = " ";

    @Override
    public Integer[][] generationExamples() {
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
            String[] tempArrayString = line.split(SPLITTER);
            Integer[][] arrayInteger = new Integer[countOfStrings][tempArrayString.length];

            while (line != null) {

                String[] arrayString = line.split(SPLITTER);
                for (int j = 0; j < arrayString.length; j++) {
                    arrayInteger[counterExamples][j] = Integer.parseInt(arrayString[j]);
                }
                line = reader.readLine();
                counterExamples++;
                if (counterExamples != countOfStrings) {

                } else {
                    return arrayInteger;
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
