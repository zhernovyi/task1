package generationExamples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExitBeforeStartedExample implements EquationPattern{
    private final static String PATH_TO_SAVE_FILE = "/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/files/results.txt";
    private final static String MESSAGE = "Loser";
    private final static String DATE_TIME_FORMAT = "\nyyyy/MM/dd HH:mm:ss";


    @Override
    public Integer[][] generationExamples() {
        return null;
    }

    @Override
    public void saveExamples(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_SAVE_FILE, false)) {
            System.out.println(MESSAGE);
            fileWriter.write(MESSAGE);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
