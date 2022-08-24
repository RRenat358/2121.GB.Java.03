import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class FileIOApp {
    public static void main(String[] args) {

        File file = new File("dir01/demo2.txt");


        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            fileOutputStream.write("Java Lava".getBytes());

            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                fileOutputStream.write(65);
            }
            System.out.println(System.currentTimeMillis() - start);

            // VS

            byte[] arr = new byte[1000];
            Arrays.fill(arr, (byte) 65);
            start = System.currentTimeMillis();
            fileOutputStream.write(arr);
            System.out.println(System.currentTimeMillis() - start);


            //очистка файла
//            new FileOutputStream("dir01/demo2.txt").close();
            new FileOutputStream(file).close();



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
