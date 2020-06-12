import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int positiveCounter = 0;
        int negativeCounter = 0;
        int sizeArray = 5;
        int sizeItemsOfArray = 3;

        Integer[][] listOfExamples = new Integer[sizeArray][sizeItemsOfArray];

        List<String> listOfArrays = new ArrayList<String>();

        for (int temporaryCounter = 0; temporaryCounter < sizeArray; temporaryCounter++) {

            for (int temporaryArrayCounter = 0; temporaryArrayCounter < sizeArray; temporaryArrayCounter++) {
                int num1 = main.getNum();
                int num2 = main.getNum();
                int rightResult = main.multiplication(num1, num2);
                listOfExamples[temporaryArrayCounter][0] = num1;
                listOfExamples[temporaryArrayCounter][1] = num2;
                listOfExamples[temporaryArrayCounter][2] = rightResult;
            }

            int num1 = listOfExamples[temporaryCounter][0];
            int num2 = listOfExamples[temporaryCounter][1];
            int rightResult = listOfExamples[temporaryCounter][2];
            System.out.print(num1 + " * " + num2 + " = ");

            int yourResult = scanner.nextInt();
            String doneExample = main.formatEquatione(num1, num2, rightResult, yourResult);
            listOfArrays.add(doneExample);

            if (yourResult == rightResult) {
                System.out.print((char) 27 + "[32mRight");
                positiveCounter++;
            } else {
                System.out.print((char) 27 + "[31mWrong" + (char) 27 + "[32m (" + rightResult + ")");
                negativeCounter++;
            }
            System.out.println("\n" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);
            System.out.println((char) 27 + "[0m");

            if (temporaryCounter >= sizeArray - 1) {
                System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
                String askingForQuit = scanner.next();

                while (true) {
                    if (askingForQuit.equals("1")) {
                        temporaryCounter = -1;
                        System.out.println("play again");
                        break;
                    } else if (askingForQuit.equals("0")) {
                        System.out.println("game over");
                        break;
                    } else {
                        System.out.println("You've entered wrong number. Try again");
                        askingForQuit = scanner.next();
                    }
                }
            }
        }

        System.out.println("Your result:" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter + (char) 27 + "[0m");
        main.workAgainWith(listOfArrays);
    }

    private int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    private int getNum() {
        return (int) (Math.random() * 6 + 4);
    }

    public void workAgainWith(List<String> array) {
        for (String s : array) {
            System.out.print(s);
        }
    }

    public String formatEquatione(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult) {
            return "\n" + num1 + " * " + num2 + " = " + rightResult + (char) 27 + "[0m";
        } else {
            return "\n" + num1 + " * " + num2 + " = " + rightResult + (char) 27 + "[31m (" + yourResult + ")" + (char) 27 + "[0m";
        }
    }

}
