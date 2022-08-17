package ArrayChangeElement;


import java.util.Arrays;
import java.util.Random;

public class ArrayChangeElement {
    public static void main(String[] args) {
        //Ввод данных здесь
        int arrLength = 9;
        int arrRandomDelta = 10;
//        int changeElement_1 = 1;



        System.out.println("\n––– РандомМассив –––––––––––––––––––––––––––\n");
        int[] arrayRandom = new int[arrLength];
        Random random = new Random();
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = random.nextInt(arrRandomDelta);
        }
        System.out.println(Arrays.toString(arrayRandom));


        //======================================================================
        System.out.println("\n--------------------------------------------------\n");


//        Generic_ArrayChange<Integer> genInt = new Generic_ArrayChange<>(5);
//        Generic_ArrayChange<Integer> genInt = new Generic_ArrayChange<>(1,2,3);
        Generic_ArrayChange<Integer> genInt = new Generic_ArrayChange<>(1,2,3);
        System.out.println(genInt.toString());

//        genInt.showArr(arrayRandom);


        genInt.showArr(1,2,3);


        System.out.println("\n--------------------------------------------------\n");
        Generic_ArrayChange<String> genStr = new Generic_ArrayChange<>("1","2","3");
        System.out.println(genStr.toString());


    }

    public static <T> Number showArr2(T[] arrT) {
        System.out.println("Тип T: " + arrT);
        return 0;
    }

}
