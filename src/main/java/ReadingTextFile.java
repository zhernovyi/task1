import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadingTextFile {
    BufferedReader reader;
    public Integer[][] arrayInteger() {
        int counterExamples = 0;
        String pathFile = "/Users/vladislavzhernovii/IdeaProjects/task1/src/main/java/equations.txt";
        try{
            reader = new BufferedReader(new FileReader(pathFile));
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

            reader = new BufferedReader(new FileReader(pathFile));
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