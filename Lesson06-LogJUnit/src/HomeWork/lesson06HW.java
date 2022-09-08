package HomeWork;


import java.util.Arrays;

public class lesson06HW {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arr2 = {5, 2, 9, 4, 2, 3, 5, 1, 4};
        int[] arr3 = {4, 2, 0, 0, 2, 3, 7, 1, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] arr5 = {400, 200, 1000, 1000, 2000, 4, 300, 700, 10000, 500};

        int target = 4;


        System.out.println("==============================");
        System.out.println(Arrays.toString(arrayAfterElement(arr1, target)));
        System.out.println(Arrays.toString(arrayAfterElement(arr2, target)));
        System.out.println(Arrays.toString(arrayAfterElement(arr3, target)));
        System.out.println(Arrays.toString(arrayAfterElement(arr4, target)));
        System.out.println(Arrays.toString(arrayAfterElement(arr5, target)));

        System.out.println("==============================");
        System.out.println(isCheckElementInArray(arr1, target));
        System.out.println(isCheckElementInArray(arr2, target));
        System.out.println(isCheckElementInArray(arr3, target));
        System.out.println(isCheckElementInArray(arr4, target));
        System.out.println(isCheckElementInArray(arr5, target));


    }


    public static int[] arrayAfterElement(int[] arr, int target) {
        int[] arr2;
        int indexLast;
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i] == target) {
                indexLast = i;
                arr2 = Arrays.copyOfRange(arr, i + 1,arr.length);
                return arr2;
            }
        }
        return null;
    }

    public static boolean isCheckElementInArray(int[] arr, int target) {
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

}
