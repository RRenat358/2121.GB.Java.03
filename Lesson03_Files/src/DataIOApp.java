import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataIOApp {
    public static void main(String[] args) {

        String demo4 = "dir01/demo4.txt";

        try (DataOutputStream dataOutputStream =
                new DataOutputStream(new FileOutputStream(demo4))) {
            dataOutputStream.writeUTF(demo4);

        } catch (IOException ex) {
            ex.printStackTrace();
        }





    }




}
