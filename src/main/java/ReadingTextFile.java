import java.io.*;
import java.util.Arrays;

public class ReadingTextFile {
    public static void main(String[] args) throws IOException {
        //        String [] arrayOfExamples = new String[countExamples];

//        arrayFromFile();
    }

    public Integer[][] arrayFromFile() throws IOException {
        int countExamples = 5;
        int counterExamples = 0;
        int countNumbers = 3;
        int counterNumbers = 0;
        String tempStr = "";


        Integer[][] arrayOfExamples = new Integer[countExamples][countNumbers];
        FileReader reader = new FileReader("/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/equations.txt");
        int c;
        int space = 32;
        int enter = 10;
        while ((c=reader.read())!=-1){
            if (c==space||c==enter){
                if (tempStr!=""){
                    int i = Integer.parseInt(tempStr);
//                    System.out.print(i);
                    arrayOfExamples[counterExamples][counterNumbers]=i;
                    counterNumbers++;

                }
//                System.out.print(" ");
                if(c==enter){
//                    System.out.println();
                    counterExamples++;
                    counterNumbers = 0;
                }
                tempStr ="";
            } else {
                int a =Character.getNumericValue(c);
                tempStr += a;
            }
        }
//        for (Integer[] temp :arrayOfExamples) {
//            System.out.println(Arrays.toString(temp));
//
//        }
        return arrayOfExamples;
    }













/*    private static void testString(int countExamples, int counter, String tempStr, String[] arrayOfExamples, FileReader reader) throws IOException {
        int c;
        int space = 32;
        int enter = 10;
        while ((c=reader.read())!=-1){
            if (counter >= countExamples){
                break;
            }
            int tempInt = (char)c;
            if(tempInt==enter){
                arrayOfExamples[counter]=tempStr;
                counter++;
                tempStr = "";
            } else {
                tempStr += String.valueOf(tempInt);
            }
        }
        for (String temp :arrayOfExamples) {
            String tmpStr=temp;

        }
    }*/

}
