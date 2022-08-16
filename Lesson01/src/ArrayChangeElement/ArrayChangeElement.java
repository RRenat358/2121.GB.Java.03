package ArrayChangeElement;


import java.util.Random;

public class ArrayChangeElement {
    public static void main(String[] args) {
        //Ввод данных здесь
        int arrLength = 9;
        int arrRandomDelta = 10;
//        int changeElement_1 = 1;


        System.out.println("––– РандомМассив –––––––––––––––––––––––––––");
        int[] arrayRandom = new int[arrLength];
        Random random = new Random();
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = random.nextInt(arrRandomDelta);
        }
        //======================================================================


//        Generic_ArrayChange<Integer> genInt = new Generic_ArrayChange<>(5);
        Generic_ArrayChange<> genInt = new Generic_ArrayChange<>(arrayRandom);
        genInt.showArr();









    }


}
