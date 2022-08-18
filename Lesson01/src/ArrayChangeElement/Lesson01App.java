package ArrayChangeElement;


import java.util.Arrays;

public class Lesson01App {
    public static void main(String[] args) {

        //======================================================================
        System.out.println("\n––– Task1. ArrayChangeElement –––––––––––––––––––––––––––");
        //Ввод данных здесь
        Integer[] arrInt = {-2, -1, 0, 1, 2, 3, 4, 5, 6}; //arrLength = 9
        Double[] arrDb = {1.1, 2.2, 3.3, 4.4, 5.5}; //arrLength = 5
        Character[] arrChr = {'П', 'Р', 'И', 'В', 'Е', 'Т', '!'}; //arrLength = 7
        String[] arrStr = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"}; //arrLength = 7

        int posElement_1 = 2;
        int posElement_2 = 5;

        System.out.println("\n––– Вариант01. КлассДжинерик –––\n");
        /*
        ArrayChangeElementGeneric<Integer> arrIntGen = new ArrayChangeElementGeneric<>(arrInt);
        System.out.println(arrIntGen.toString());
        arrIntGen.arrChangGen(arrInt);

        System.out.println();
        ArrayChangeElementGeneric<String> arrStrGen = new ArrayChangeElementGeneric<>(arrStr);
        System.out.println(arrStrGen.toString());
        arrStrGen.arrChangGen(arrStr);
*/
        System.out.println("\n––– Вариант02. МетодДжинерик –––\n");
//        arrChang(arrInt);
//        arrChang(arrStr);
        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString((Object[]) arrChang(arrStr, posElement_1, posElement_2)));


    }

/*

    public static <T> double arrChang(T[] array) {
        System.out.println(Arrays.toString(array));
        return 0;
    }
*/
/*

    public static <T> double arrChang(T[] array, int changePosElement_1, int changePosElement_2) {
        System.out.println(Arrays.toString(array));
        System.out.println(changePosElement_1 + changePosElement_2 + 50);
        return 0;
    }
*/

    public static <T> Object arrChang(T[] array, int posElement_1, int posElement_2) {
        posElement_1--;
        posElement_2--;
        T temp = array[posElement_2];
        array[posElement_2] = array[posElement_1];
        array[posElement_1] = temp;
        return array;
    }

}
