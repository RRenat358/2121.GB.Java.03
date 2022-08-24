import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class ByteStreamApp {

    public static void main(String[] args) {


        byte[] arr = {23, 35, 58};

        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        int temp = 0;

        while (inputStream.available() > 0) {
            temp = inputStream.read();
            System.out.println(temp);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(45);
        outputStream.write(69);
        outputStream.write(75);
        System.out.println(Arrays.toString(outputStream.toByteArray()));


    }
}
