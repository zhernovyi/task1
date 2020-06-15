package generationExamples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExitBeforeStartedExample implements EquationPattern{
    String pathToSaveFile = "/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/files/results.txt";
    String message = "Loser";

    @Override
    public Integer[][] generationExamples() {
        return null;
    }

    @Override
    public void saveExamples(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter(pathToSaveFile, false)) {
            System.out.println(message);
            fileWriter.write(message);
            fileWriter.write('\n');
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
            fileWriter.write("\n---------------------\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
