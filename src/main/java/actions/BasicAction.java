package actions;

import java.util.List;
public interface BasicAction {
    public List<String> doingAction(Integer[][] listOfExamples);
    public String formatEquatione(int num1, int num2, int rightResult, int yourResult);
}
