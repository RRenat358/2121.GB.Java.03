import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIOApp {
    public static void main(String[] args) {

        File file = new File("dir01/demo2.txt");


        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            fileOutputStream.write("Java Lava".getBytes());

            for (int i = 0; i < 1000; i++) {

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            while (fileInputStream.available() > 0) {
                System.out.print((char) fileInputStream.read());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
