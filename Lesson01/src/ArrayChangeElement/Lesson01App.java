package ArrayChangeElement;


import java.util.ArrayList;
import java.util.Arrays;

public class Lesson01App {
    public static void main(String[] args) {

        //======================================================================
        //Ввод данных здесь
        Integer[] arrInt = {-2, -1, 0, 1, 2, 3, 4, 5, 6}; //arrLength = 9
        String[] arrStr = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"}; //arrLength = 7

        Double[] arrDb = {1.1, 2.2, 3.3, 4.4, 5.5}; //arrLength = 5
        Character[] arrChr = {'П', 'Р', 'И', 'В', 'Е', 'Т', '!'}; //arrLength = 7

        int posElement_1 = 2;
        int posElement_2 = 5;

        //======================================================================
        System.out.println("\n––– Task1. ArrayChangeElement –––––––––––––––––––––––––––");
        System.out.println("\n––– Вариант01. МетодДжинерик –––\n");
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString((Object[]) arrChang(arrInt, posElement_1, posElement_2)));

        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString((Object[]) arrChang(arrStr, posElement_1, posElement_2)));


        System.out.println("\n––– Вариант02. КлассДжинерик –––\n");

        ArrayChangeElementGeneric<Double> arrDbGen = new ArrayChangeElementGeneric<>();
        System.out.println(Arrays.toString(arrDb));
        System.out.println(Arrays.toString(arrDbGen.arrChangGen(arrDb, posElement_1, posElement_2)));

        ArrayChangeElementGeneric<Character> arrChrGen = new ArrayChangeElementGeneric<>();
        System.out.println(Arrays.toString(arrChr));
        System.out.println(Arrays.toString(arrChrGen.arrChangGen(arrChr, posElement_1, posElement_2)));

        //======================================================================
        System.out.println("\n––– Task2. Array to ArrayList –––––––––––––––––––––––––––");
        System.out.println(Arrays.toString(arrInt));
//        System.out.println(Arrays.toString((Object[]) arrToArrayList(arrInt)));
        System.out.println(arrToArrayList(arrInt));



        System.out.println("\n––– end –––––––––––––––––––––––––––");

    }

    public static <T> Object arrChang(T[] array, int posElement_1, int posElement_2) {
        posElement_1--;
        posElement_2--;
        T temp = array[posElement_2];
        array[posElement_2] = array[posElement_1];
        array[posElement_1] = temp;
        return array;
    }

    public static <T> Object arrToArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (T i: array){
            arrayList.add(i);
        }
        return arrayList;
    }



}
