import java.io.File;
import java.io.IOException;

public class FilesApp {


    public static void main(String[] args) throws IOException {

        File dir01 = new File("dir01");
        if (!dir01.exists()) {
            dir01.mkdirs();
        }


        File file1 = new File("demo.txt");
        File file2 = new File(dir01,"demo.txt");


        System.out.println("Файл существует? = " + file2.exists());

        if (!file2.exists()) {
            file2.createNewFile();
        }

        System.out.println("Это файл? = " + file2.isFile());
        System.out.println("Это директория? = " + file2.isDirectory());

        System.out.println("Размер файла (длина) = " + file2.length());


    }



}
