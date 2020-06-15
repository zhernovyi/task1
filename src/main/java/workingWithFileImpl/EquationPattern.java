package workingWithFileImpl;

import java.util.List;

public interface EquationPattern {
    Integer[][] generationExamples(/*Integer[][] listOfExamples*/);
    void saveExamples(List<String> array);
}
