package actions;

import java.util.List;
public interface BasicAction {
    final static String WRONG_ANSWER = "\u001b[31mWrong[36m(%d)[0m";
    final static String CORRECT_ANSWER = "\u001b[36mRight[0m";

    public List<String> doingAction(List<Integer[]> listOfExamples);
    public String formatEquation(int num1, int num2, int rightResult, int yourResult);
    public void printWrongResult(int rightResult);
    public void printCorrectResult();
    public void printActionWithNumbers(int num1, int num2);
}
