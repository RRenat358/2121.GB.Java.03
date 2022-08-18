package ArrayChangeElement;


import java.util.Arrays;

public class Lesson01App {
    public static void main(String[] args) {

        System.out.println("\n––– Array for ArrayChangeElement –––––––––––––––––––––––––––\n");
        //Ввод данных здесь
        Integer[] arrInt = {-2, -1, 0, 1, 2, 3, 4, 5, 6}; //arrLength = 9
        Double[] arrDb = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] arrChr = {'П', 'Р', 'И', 'В', 'Е', 'Т', '!'};
        String[] arrStr = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"}; //arrLength = 7

        int changeElement_1 = 2;
        int changeElement_2 = 5;

        //======================================================================
        System.out.println("\n––– ArrayChangeElement –––––––––––––––––––––––––––");
        System.out.println("\n––– Вариант01. КлассДжинерик –––––––––––––––––––––––––––\n");
        ArrayChangeElementGeneric<Integer> arrIntGen = new ArrayChangeElementGeneric<>(arrInt);
        System.out.println(arrIntGen.toString());
        arrIntGen.arrChangGen(arrInt);

        System.out.println();
        ArrayChangeElementGeneric<String> arrStrGen = new ArrayChangeElementGeneric<>(arrStr);
        System.out.println(arrStrGen.toString());
        arrStrGen.arrChangGen(arrStr);

        System.out.println("\n––– Вариант01. КлассДжинерик –––––––––––––––––––––––––––\n");
        arrChang(arrInt);
        arrChang(arrStr);


    }


    public static <T> double arrChang(T[] array) {
        System.out.println(Arrays.toString(array));
        return 0;
    }


}
