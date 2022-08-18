package ArrayChangeElement;


import java.util.Arrays;

public class Lesson01App {
    public static void main(String[] args) {

        System.out.println("\n––– Array for ArrayChangeElement –––––––––––––––––––––––––––\n");
        //Ввод данных здесь
        Integer[] arrInt = {-2, -1, 0, 1, 2, 3, 4, 5, 6}; //arrLength = 9
        String[] arrStr = {"a", "b", "c", "d", "e", "f", "g"}; //arrLength = 7

        int changeElement_1 = 2;
        int changeElement_2 = 5;

        //======================================================================
        System.out.println("\n––– ArrayChangeElement –––––––––––––––––––––––––––");
        System.out.println("\n--------------------------------------------------\n");
        ArrayChangeElementGeneric<Integer> arrGenInt = new ArrayChangeElementGeneric<>(arrInt);
        System.out.println(arrGenInt.toString());
        arrGenInt.showArr(arrInt);

        System.out.println("\n--------------------------------------------------\n");
        ArrayChangeElementGeneric<String> arrGenStr = new ArrayChangeElementGeneric<>(arrStr);
        System.out.println(arrGenStr.toString());
        arrGenStr.showArr(arrStr);





    }

    /*
    public void showArr2(T... another) {
        System.out.println(Arrays.toString(another));

    }


     */

}
