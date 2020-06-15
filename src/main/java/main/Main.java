package main;

import workingWithFileImpl.EquationPattern;
import workingWithFileImpl.ExamplesFromFileGenerationImpl;
import workingWithFileImpl.ExamplesFromRandomGenerationImpl;
import workingWithFileImpl.ExitBeforeStartedExample;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Integer[][] listOfGenExamples;
    public static boolean varKeyOfStart = true;

    protected static EquationPattern equationPattern = null;

    public static int getPositiveCounter() {
        return positiveCounter;
    }

    public static int getNegativeCounter() {
        return negativeCounter;
    }

    protected static int positiveCounter = 0;
    protected static int negativeCounter = 0;

    public String setTempScannerCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    List<String> listOfArrays = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        while (true) {
            if (Main.varKeyOfStart == true) {
                main.equationPattern = chosenGenMode();
                Main.listOfGenExamples = main.equationPattern.generationExamples();
            }
            List<String> listOfDoneExamples = main.doingMultExamples(Main.listOfGenExamples);
            listOfGenExamples = main.askForQuit(listOfDoneExamples);
        }
    }

    private List<String> doingMultExamples(Integer[][] listOfExamples) {
        while (true) {
            for (Integer[] temp : listOfExamples) {
                int num1 = temp[0];
                int num2 = temp[1];
                int rightResult = temp[2];
                System.out.print(num1 + " * " + num2 + " = ");

                int yourResult = Integer.parseInt(setTempScannerCommand());
                String doneExample = formatEquatione(num1, num2, rightResult, yourResult);
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
            return listOfArrays;
        }
    }

    private static EquationPattern chosenGenMode() {
//        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
        String chooseModeByUser = main.setTempScannerCommand();
        Integer[][] listOfExamples = null;
        while (true) {
            if (chooseModeByUser.equals("1")) {
                return new ExamplesFromRandomGenerationImpl();
            } else if (chooseModeByUser.equals("2")) {
                return new ExamplesFromFileGenerationImpl();
            } else if (chooseModeByUser.equals("0")) {
                return new ExitBeforeStartedExample();
            } else {
                System.out.println("You've entered the wrong command. Try again: ");
                chooseModeByUser = main.setTempScannerCommand();
            }
        }
    }


    /*
    Main main = new Main();
    ReadingTextFile readingTextFile = new ReadingTextFile();
    Scanner scanner = new Scanner(System.in);
    EquationPattern equationPattern = null;
    int positiveCounter = 0;
    int negativeCounter = 0;
    int sizeArray = 5;
    int sizeItemsOfArray = 3;

    List<String> listOfArrays = new ArrayList<>();

    System.out.println("Choose a mode of learning mult examples: 1 - random, 2 - from file, 0 - exit");
    main.setTempScannerCommand(scanner.next());
    String tempScannerCommand = main.getTempScannerCommand();
    //-----realization with generation math examples by hand with help Scanner-----//
    for (int temporaryCounter = 0; temporaryCounter < sizeArray; temporaryCounter++) {
        while (true) {
            if (tempScannerCommand.equals("1")) {
                listOfExamples = main.autoGeneratorByRandom(sizeArray, listOfExamples);
                break;
            } else if (tempScannerCommand.equals("2")) {
                listOfExamples = readingTextFile.arrayInteger();//examples from a file
                break;
            } else if (tempScannerCommand.equals("0")) {
                String loserStr = "Loser";
                listOfArrays.add(loserStr);
                System.out.println(loserStr);
                main.createResultFile(listOfArrays);

                System.exit(0);
            } else {
                System.out.println("You've entered wrong number. Try again");
                tempScannerCommand = scanner.next();
            }
        }*/
    public Integer[][] askForQuit(List<String> listOfDoneExamples) {
        System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
        Main main = new Main();
        String tempAskForQuitCommand = main.setTempScannerCommand();

        while (true) {
            if (tempAskForQuitCommand.equals("1")) {
                Main.varKeyOfStart = false;
                return equationPattern.generationExamples();
            } else if (tempAskForQuitCommand.equals("0")) {
                equationPattern.saveExamples(listOfDoneExamples);
                System.exit(0);
            } else {
                System.out.println("you've entered wrong value. Try again: ");
            }
        }
    }


    /*


       //there was a code -where user solves  examples
            System.out.print("Do you wanna continue?(1 - yes/ 0 - no): ");
            String askingForQuit = scanner.next();

            while (true) {
                if (askingForQuit.equals("1")) {
                    System.out.println("play again");
                    break;
                } else if (askingForQuit.equals("0")) {
                    System.out.println("Your result: " + positiveCounter + "/"+ negativeCounter);

                    if (tempScannerCommand.equals("1")){
                        main.workAgainWith(listOfArrays);
                    } else if (tempScannerCommand.equals("2")){
                        main.createResultFile(listOfArrays);
                    }
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
*/
    public void createResultFile(List<String> listOfArrays) {
        try (FileWriter fileWriter = new FileWriter("/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/results.txt", false)) {
            Main main = new Main();
//            String tempScannerCommand = main.getTempScannerCommand();
            String tempScannerCommand = "main.getTempScannerCommand()";
            if (tempScannerCommand.equals("0")) {
                fileWriter.write(String.valueOf(listOfArrays));
            } else {
                fileWriter.write(newArr(listOfArrays));
            }
            fileWriter.write('\n');
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            fileWriter.write(dtf.format(now));
            fileWriter.write("\n---------------------\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    public Integer[][] autoGeneratorByRandom(int sizeArray, Integer[][] listOfExamples) {
//        for (int temporaryArrayCounter = 0; temporaryArrayCounter < sizeArray; temporaryArrayCounter++) {
//            Main main = new Main();
//            int num1 = main.getNum();
//            int num2 = main.getNum();
//            int rightResult = main.multiplication(num1, num2);
//            listOfExamples[temporaryArrayCounter][0] = num1;
//            listOfExamples[temporaryArrayCounter][1] = num2;
//            listOfExamples[temporaryArrayCounter][2] = rightResult;
//        }
//        return listOfExamples;
//    }


    public String newArr(List<String> array) {
        String newArrCollection = "";
        for (String s : array) {
            newArrCollection += s;
        }
        return newArrCollection;
    }

    public String formatEquatione(int num1, int num2, int rightResult, int yourResult) {
        if (yourResult == rightResult) {
            return "\n" + num1 + " * " + num2 + " = " + rightResult;
        } else {
            return "\n" + num1 + " * " + num2 + " = " + rightResult + " (" + yourResult + ")";
        }
    }

}
