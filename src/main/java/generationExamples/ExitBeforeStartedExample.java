package generationExamples;

import main.Configurations;
import main.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExitBeforeStartedExample implements EquationPattern{
    private final static String MESSAGE = "Loser";

    @Override
    public Integer[][] generationExamples() {
        return null;
    }

    @Override
    public void saveExamples(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter(Configurations.getPathToSaveFile(), false)) {
            System.out.println(MESSAGE);
            fileWriter.write(MESSAGE);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Configurations.getDateFormat());
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
