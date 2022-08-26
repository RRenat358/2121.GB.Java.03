import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileRandomAccessApp {

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("dir01/demo4.txt", "rw");
        randomAccessFile.seek(2);
        System.out.println((char) randomAccessFile.read());
    }




}
