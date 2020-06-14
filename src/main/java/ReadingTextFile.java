import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadingTextFile {
//    public Integer[][] arrayFromFile() throws IOException
    public Integer[][] arrayInteger() {
        int counterExamples = 0;
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/equations.txt"));
            int countOfStrings=0;
            {
                BufferedReader readerTemp;
                readerTemp = reader;
                String lineTemp = readerTemp.readLine();
                while (lineTemp != null) {
                    countOfStrings++;
                    lineTemp = readerTemp.readLine();
                }
            }

            reader = new BufferedReader(new FileReader("/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/equations.txt"));
            String line = reader.readLine();
            String[] tempArrayString = line.split(" ");
            Integer[][] arrayInteger = new Integer[countOfStrings][tempArrayString.length];

            while (line != null){

                String[] arrayString = line.split(" ");
                    for (int j = 0; j < arrayString.length; j++) {
                        arrayInteger[counterExamples][j]= Integer.parseInt(arrayString[j]);
                    }
                line=reader.readLine();
                counterExamples++;
                if(counterExamples!=5){

                } else {
                    return arrayInteger;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void printArrayFromFile() {
        ReadingTextFile readingTextFile = new ReadingTextFile();
        Integer[][] arr = readingTextFile.arrayInteger();

        for(Integer[] temp: arr){
            System.out.print(temp[0]+" ");;
            System.out.print(temp[1]+" ");;
            System.out.print(temp[2]+" ");;
            System.out.println();
        }
    }
}






        //-----trying create array with converting string into int items inside-----//

        /*
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
    }*/
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

