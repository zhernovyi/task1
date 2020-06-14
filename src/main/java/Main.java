import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        ReadingTextFile readingTextFile = new ReadingTextFile();
        Scanner scanner = new Scanner(System.in);
        int positiveCounter = 0;
        int negativeCounter = 0;
        int sizeArray = 5;
        int sizeItemsOfArray = 3;

        Integer[][] listOfExamples = new Integer[sizeArray][sizeItemsOfArray];
        List<String> listOfArrays = new ArrayList<>();

        System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
        String tempScannerCommand = scanner.next();
        //-----realization with generation math examples by hand with help Scanner-----//
        for (int temporaryCounter = 0; temporaryCounter < sizeArray; temporaryCounter++) {
            while(true){
                if (tempScannerCommand.equals("1")){
                    listOfExamples = main.autoGeneratorByRandom(sizeArray, listOfExamples);
                    break;
                } else if (tempScannerCommand.equals("2")){
                    listOfExamples = readingTextFile.arrayInteger();//examples from a file
                    break;
                } else if (tempScannerCommand.equals("0")){
                    System.out.println("Not started");
                    System.exit(0);
                } else {
                    System.out.println("You've entered wrong number. Try again");
                    tempScannerCommand = scanner.next();
                }
            }



            while (true) {
//            listOfExamples = readingTextFile.arrayInteger();//examples from a file
//            listOfExamples = listOfExamples;
                for (Integer[] temp : listOfExamples) {
                    int num1 = temp[0];
                    int num2 = temp[1];
                    int rightResult = temp[2];
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
                }

                System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
                String askingForQuit = scanner.next();

                while (true) {
                    if (askingForQuit.equals("1")) {
                        System.out.println("play again");
                        break;
                    } else if (askingForQuit.equals("0")) {
                        System.out.println("game over");
                        System.out.println("Your result:" + (char) 27 + "[36m" + positiveCounter + "/" + (char) 27 + "[31m" + negativeCounter + (char) 27 + "[0m");
                        main.workAgainWith(listOfArrays);

                        System.exit(0);
                    } else {
                        System.out.println("You've entered wrong number. Try again");
                        askingForQuit = scanner.next();
                    }
                }
                break;
            }
        }
    }

    public Integer[][] autoGeneratorByRandom(int sizeArray, Integer[][] listOfExamples) {
        for (int temporaryArrayCounter = 0; temporaryArrayCounter < sizeArray; temporaryArrayCounter++) {
            Main main = new Main();
            int num1 = main.getNum();
            int num2 = main.getNum();
            int rightResult = main.multiplication(num1, num2);
            listOfExamples[temporaryArrayCounter][0] = num1;
            listOfExamples[temporaryArrayCounter][1] = num2;
            listOfExamples[temporaryArrayCounter][2] = rightResult;
        }
        return listOfExamples;
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
