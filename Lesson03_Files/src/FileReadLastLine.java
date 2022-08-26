import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReadLastLine {


    public static void main(String[] args) throws IOException {
        String pathFile = "dir01/bigFile-refactoring.txt";
        int nLast = 10;

        fileReadLastLines(pathFile, nLast);



    }


    public static void fileReadLastLines(String pathFile, int nLast) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(pathFile, "r");
        String oneLastLine = randomAccessFile.readLine();


        System.out.println("\n");
        System.out.println(oneLastLine);
        System.out.println("\n");






    }





}
