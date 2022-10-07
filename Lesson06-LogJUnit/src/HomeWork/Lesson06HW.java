package HomeWork;


import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class Lesson06HW {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arr2 = {4, 2, 0, 0, 2, 3, 7, 1, 5};
        int[] arr3 = {5, 2, 9, 4, 2, 3, 5, 1, 4};
        int[] arr4 = {400, 200, 1000, 1000, 2000, 4, 300, 700, 10000, 500};
        int[] arr5 = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        int element1 = 4;
        int element2 = 1;


        System.out.println("==============================");

        System.out.println(Arrays.toString(arrayAfterElement(arr1, element1)));
        System.out.println(Arrays.toString(arrayAfterElement(arr2, element1)));
        System.out.println(Arrays.toString(arrayAfterElement(arr3, element1)));
        System.out.println(Arrays.toString(arrayAfterElement(arr4, element1)));
//        System.out.println(Arrays.toString(arrayAfterElement(arr5, element1))); //RuntimeException

        System.out.println("==============================");
        System.out.println(isCheckElementInArray(arr1, element1, element2));
        System.out.println(isCheckElementInArray(arr2, element1, element2));
        System.out.println(isCheckElementInArray(arr3, element1, element2));
        System.out.println(isCheckElementInArray(arr4, element1, element2));
        System.out.println(isCheckElementInArray(arr5, element1, element2));


    }


    public static int[] arrayAfterElement(int[] arr, int element)  throws CheckElementInArrayException{
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i] == element) {
                return Arrays.copyOfRange(arr, i + 1,arr.length);
            }
        }
        throw new CheckElementInArrayException("\nRuntimeException = Element [" + element + "] not found in array");
    }

    public static boolean isCheckElementInArray(int[] arr, int element1, int element2) throws CheckElementInArrayException {
        int checkCount1 = 0;
        int checkCount2 = 0;
        for (int i : arr) {
            if (i == element1) {
                checkCount1++;
            }
            if (i == element2) {
                checkCount2++;
            }
            if (checkCount1 > 0 && checkCount2 > 0) {
                return true;
            }
        }
        return false;
    }

    public static class CheckElementInArrayException extends RuntimeException {
        public CheckElementInArrayException(String message) {
            super(message);
        }
    }

}

