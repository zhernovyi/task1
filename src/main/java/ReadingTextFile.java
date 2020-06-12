import java.io.FileReader;
import java.io.IOException;

public class ReadingTextFile {
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
        while ((c = reader.read()) != -1) {
            if (c == space || c == enter) {
                if (tempStr != "") {
                    int i = Integer.parseInt(tempStr);
                    arrayOfExamples[counterExamples][counterNumbers] = i;
                    counterNumbers++;
                }
                if (c == enter) {
                    counterExamples++;
                    counterNumbers = 0;
                }
                tempStr = "";
            } else {
                int a = Character.getNumericValue(c);
                tempStr += a;
            }
        }
        return arrayOfExamples;
    }
    //-----trying create array with String items inside-----//
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
