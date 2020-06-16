package actions;

import main.Main;

import java.util.ArrayList;
import java.util.List;

public class ExitBeforeChoosingAction extends Main implements BasicAction {
    List<String> listOfArrays = new ArrayList<>();

    @Override
    public List<String> doingAction(Integer[][] listOfExamples) {
        return null;
    }

    @Override
    public String formatEquation(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult) {
            return "\n" + num1 + " / " + num2 + " = " + rightResult;
        } else {
            return "\n" + num1 + " / " + num2 + " = " + rightResult + " (" + yourResult + ")";
        }
    }
}
