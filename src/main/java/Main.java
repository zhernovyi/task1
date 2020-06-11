import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.print((char)27+"[30m");
        Scanner scanner = new Scanner(System.in);
//        int positiveTrying = 5;
//        int negativeTrying = 3;
        int positiveCounter = 0;
        int negativeCounter = 0;

        List<String> wrongAnswers = new ArrayList<String>();

        for (;;) {
            int num1 = (int) (Math.random() * 6 + 4);
            int num2 = (int) (Math.random() * 6 + 4);
            System.out.print(num1 + " * " + num2 + " = ");
            int result = num1 * num2;
            int yourResult = scanner.nextInt();
            if (yourResult == result) {
                System.out.print((char) 27 + "[32mвірно");
                positiveCounter++;
            } else {
                System.out.print((char) 27 + "[31mне вірно" + (char) 27 + "[32m (" + result + ")");
                wrongAnswers.add(num1 + " * " + num2 + " = " + result + (char) 27 + "[31m (" + yourResult + ")" + (char) 27 + "[0m");
                negativeCounter++;
            }
            System.out.println("\n" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);
            System.out.println((char) 27 + "[39m");

            System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
            String askingForQuit = scanner.next();
            for (;;) {
                if (askingForQuit.equals("1")){
                    break;
                } else if (askingForQuit.equals("0")){
                    if (negativeCounter > 0) {
                        workAgainWith(wrongAnswers);
                    }
                    break;
                } else {
                    System.out.println("You've entered wrong number. Try again");
                }
            } if (askingForQuit.equals("0")){
                break;
            }
        }
        System.out.println("Game over. Your result:" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter);

    }
    public static void workAgainWith(List<String> array){
        System.out.println((char) 27 + "[0mПопрацюй з цими прикладами");
        for (String s : array) {
            System.out.println(s);
        }
    }
}
