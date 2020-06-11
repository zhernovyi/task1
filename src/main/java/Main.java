import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.print((char)27+"[30m");
        Scanner scanner = new Scanner(System.in);
//        int positiveTrying = 5;
//        int negativeTrying = 3;
        int positiveCounter = 0;
        int negativeCounter = 0;
        int temporaryCounter;
        int countTrying = 5;

        List<String> wrongAnswers = new ArrayList<String>();
        List<String> listOfExamples = new ArrayList<String>();

        for (temporaryCounter = 1; temporaryCounter <= countTrying; temporaryCounter++) {
            int num1 = getNum();
            int num2 = getNum();
            System.out.print(num1 + " * " + num2 + " = ");
            int rightResult = num1 * num2;
            int yourResult = scanner.nextInt();
            String doneExample = main.toString(num1, num2, rightResult, yourResult);
            if (yourResult == rightResult) {
                System.out.print((char) 27 + "[32mRight");
                positiveCounter++;
            } else {
                System.out.print((char) 27 + "[31mWrong" + (char) 27 + "[32m (" + rightResult + ")");
                wrongAnswers.add(doneExample);
                negativeCounter++;
            }
            listOfExamples.add(doneExample);
            System.out.println("\n" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);
            System.out.println((char) 27 + "[39m");

            if (temporaryCounter >= countTrying) {
                System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
                String askingForQuit = scanner.next();

                while (true) {
                    if (askingForQuit.equals("1")) {
                        temporaryCounter = 0;
                        break;
                    } else if (askingForQuit.equals("0")) {
                        if (negativeCounter > 0) {
                            System.out.println((char) 27 + "[0mWork again with these examples");
                            main.workAgainWith(wrongAnswers);
                        }
                        System.out.println("----------------");
                        main.workAgainWith(listOfExamples);
                        break;
                    } else {
                        System.out.println("You've entered wrong number. Try again");
                        askingForQuit = scanner.next();
                    }
                }
            }
        }

        System.out.println("Game over. Your result:" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);

    }

    private static int getNum() {
        return (int) (Math.random() * 6 + 4);
    }

    public void workAgainWith(List<String> array) {
        for (String s : array) {
            System.out.println(s);
        }
    }

    public String toString(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult){
            return num1 + " * " + num2 + " = " + rightResult + (char) 27 + "[36m (" + yourResult + ")" + (char) 27 + "[0m";
        } else {
            return num1 + " * " + num2 + " = " + rightResult + (char) 27 + "[31m (" + yourResult + ")" + (char) 27 + "[0m";
        }
    }

}
