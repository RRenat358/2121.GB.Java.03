import java.io.*;



public class BufferedIOApp {

    public static void main(String[] args) {

        String demo3 = "dir01/demo3.txt";

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(demo3);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 10000)
        ) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                bufferedOutputStream.write(65);
            }
            System.out.println(System.currentTimeMillis() - start);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(new FileInputStream(new File(demo3)))) {


            new FileOutputStream(demo3).close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }




    }

}
