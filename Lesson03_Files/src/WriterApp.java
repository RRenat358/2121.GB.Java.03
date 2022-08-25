import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriterApp {

    public static void main(String[] args) {

        String demo4 = "dir01/demo4.txt";

        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "yyyy.MM.dd-HHmmss"));

        try (Writer writer = new BufferedWriter(new FileWriter(demo4))) {

            writer.write("=== Start DataUser ==============================\n");
            writer.write(localDateTime + "\n");
            // OR
            writer.append("=== Start DataUser ==============================\n");
            writer.append(localDateTime + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
