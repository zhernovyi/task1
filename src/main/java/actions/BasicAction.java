package actions;

import java.util.List;
public interface BasicAction {
    public List<String> doingAction(Integer[][] listOfExamples);
    public String formatEquation(int num1, int num2, int rightResult, int yourResult);
    public void printWrongResult(int rightResult);
    public void printRightResult();
    public void printActionWithNumbers(int num1, int num2);
}
