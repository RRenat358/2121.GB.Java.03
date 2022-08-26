import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SequenceInputStreamApp {

    public static void main(String[] args) throws IOException {

        ArrayList<InputStream> inputStreamArrayList = new ArrayList<>();

        inputStreamArrayList.add(new FileInputStream("dir01/demo2.txt"));
        inputStreamArrayList.add(new FileInputStream("dir01/demo3.txt"));

        SequenceInputStream sequenceInputStream = new SequenceInputStream(
                Collections.enumeration(inputStreamArrayList)
        );

        int a;
        while ((a = sequenceInputStream.read()) != -1) {
            System.out.print((char) a);
        }



    }


}
