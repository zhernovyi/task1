package actions;

import main.Main;

import java.util.List;

public class ExitBeforeChoosingAction extends Main implements BasicAction {

    @Override
    public List<String> doingAction(Integer[][] listOfExamples) {
        return null;
    }

    @Override
    public String formatEquation(int num1, int num2, int rightResult, int yourResult) {
        return null;
    }

    @Override
    public void printWrongResult(int rightResult) {
    }

    @Override
    public void printRightResult() {
    }

    @Override
    public void printActionWithNumbers(int num1, int num2) {
    }
}
