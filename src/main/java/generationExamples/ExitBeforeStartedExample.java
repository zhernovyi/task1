package generationExamples;

import main.Configurations;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExitBeforeStartedExample implements EquationPattern {
    private final static String NUMBERS_SPLITTER_IN_STRING = "Loser";

    @Override
    public List <Integer[]> generationExamples() {
        return null;
    }

    @Override
    public void saveExamples(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter(Configurations.getPathToSaveFile(), false)) {
            System.out.println(NUMBERS_SPLITTER_IN_STRING);
            fileWriter.write(NUMBERS_SPLITTER_IN_STRING);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Configurations.getDateFormat());
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
