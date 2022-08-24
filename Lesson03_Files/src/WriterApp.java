import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterApp {

    public static void main(String[] args) {

        String demo4 = "dir01/demo4.txt";

        try (Writer writer = new BufferedWriter(new FileWriter(demo4))) {

            writer.write("LoveIslove\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
