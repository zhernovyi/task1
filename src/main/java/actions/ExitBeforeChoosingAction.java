package actions;

import main.Main;

import java.util.List;

public class ExitBeforeChoosingAction extends Main implements BasicAction {

    @Override
    public List<String> doingAction(List<Integer []> listOfExamples) {
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
    public void printCorrectResult() {
    }

    @Override
    public void printActionWithNumbers(int num1, int num2) {
    }
}
