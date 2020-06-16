package generationExamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExamplesFromFileGenerationImpl implements EquationPattern {
    BufferedReader reader;
    private final static String PATH_TO_OPEN_FILE = "/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/files/equations.txt";
    private final static String PATH_TO_SAVE_FILE = "/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/files/results.txt";
    private final static String SPLITTER = " ";
    private final static String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";


    @Override
    public Integer[][] generationExamples() {
        int counterExamples = 0;
        try {
            reader = new BufferedReader(new FileReader(PATH_TO_OPEN_FILE));
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

            reader = new BufferedReader(new FileReader(PATH_TO_OPEN_FILE));
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
        try (FileWriter fileWriter = new FileWriter(PATH_TO_SAVE_FILE, false)) {
            fileWriter.write(String.valueOf(listOfArrays));
            fileWriter.write('\n');
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//    public String newArr(List<String> array) {
//        String newArrCollection = "";
//        for (String s : array) {
//            newArrCollection += s;
//        }
//        return newArrCollection;
//    }
}
