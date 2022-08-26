import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class FileReadLastLine {


    public static void main(String[] args) throws IOException {
        String pathFile = "dir01/bigFile-refactoring.txt";
        String pathFile4 = "dir01/demo2.txt";
        int nLast = 10;

        System.out.println("\n");

//        fileReadLastLines0(pathFile, nLast);
//        fileReadLastLines1(pathFile, nLast);
//        fileReadLastLines2(pathFile, nLast);
//        fileReadLastLines3(pathFile/*, nLast*/);
//        fileReadLastLines4(pathFile, nLast);
//        System.out.println(fileReadLastLines5(pathFile, nLast));
//        System.out.println(toString().fileReadLastLines6(pathFile, nLast).iterator());
        ArrayList list = fileReadLastLines6(pathFile, nLast);
        for (Object o : list) {
            System.out.println(o);
        }


        System.out.println("\n");


    }


    //======================================================================
    //Прочитать весь файл по строчно
    public static void fileReadLastLines0(String pathFile, int nLast) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(pathFile, "r");
        String oneLastLine = randomAccessFile.readLine();

        System.out.println(oneLastLine);
    }


    //======================================================================
    public static void fileReadLastLines1(String pathFile, int nLast) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
//        String oneLastLine2 = ((BufferedReader) reader).readLine();
        int countLine = 0;
        while ((reader.readLine() != null)) {
            countLine++;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < countLine; i++) {

        }
        String oneLastLine2 = ((BufferedReader) reader).readLine();
        System.out.println(oneLastLine2);
    }


    //======================================================================
    public static void fileReadLastLines2(String pathFile, int nLast) {
        try {
            int numOfLastline = 10;
            BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));

            int lines = 0;
            while (reader.readLine() != null)
                lines++;
            reader.close();

            String printedLine = null;
            List<String> listForString = new ArrayList<>();

            for (int i = lines - 1; i >= (lines - numOfLastline); i--) {
//                printedLine = (String) FileUtils.readLines(new File("Text.txt"), "ISO-8859-1").get(i);
                System.out.println(printedLine);
                listForString.add(printedLine);
            }
            System.out.println("\n\n============ Printing in Correct order =============\n\n");
            Collections.reverse(listForString);
            for (int k = 0; k < listForString.size(); k++) {
                System.out.println(listForString.get(k));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //======================================================================
    //Прочитать весь файл по строчно
    public static void fileReadLastLines3(String pathFile, int nLast) throws IOException {

        Files.lines(Paths.get(pathFile), StandardCharsets.UTF_8).forEach(System.out::println);
    }


    //======================================================================
    public static void fileReadLastLines4(String pathFile, int nLast) {
        ArrayList<String> arrayList = new ArrayList<>();

        try (ReversedLinesFileReader readLastLine = new ReversedLinesFileReader(
                new File(pathFile), StandardCharsets.UTF_8)) {
            String lastLine = "";
            int countLine = 0;
            while ((lastLine = readLastLine.readLine()) != null && countLine < nLast) {
                arrayList.add(lastLine);
                countLine++;
            }
            Collections.reverse(arrayList);
            for (String s : arrayList) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //======================================================================
    public static ArrayList fileReadLastLines5(String pathFile, int nLast) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (ReversedLinesFileReader readLastLine = new ReversedLinesFileReader(
                new File(pathFile), StandardCharsets.UTF_8)) {
            String lastLine = "";
            int countLine = 0;
            while ((lastLine = readLastLine.readLine()) != null && countLine < nLast) {
//                arrayList.add("\n" + lastLine);
                arrayList.add("\n" + lastLine);
                countLine++;
            }
            Collections.reverse(arrayList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return arrayList;
    }


    //======================================================================
    public static ArrayList<String> fileReadLastLines6(String pathFile, int nLast) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (ReversedLinesFileReader readLastLine = new ReversedLinesFileReader(
                new File(pathFile), StandardCharsets.UTF_8)) {

            String lastLine;
            int countLine = 0;

            while (countLine < nLast && (lastLine = readLastLine.readLine()) != null) {
                arrayList.add(lastLine);
                countLine++;
            }
            Collections.reverse(arrayList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList;
    }


    //======================================================================


}
