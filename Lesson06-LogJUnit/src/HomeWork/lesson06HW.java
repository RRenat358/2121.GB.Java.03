package HomeWork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class lesson06HW {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arr2 = {5, 2, 9, 4, 2, 3, 5, 1, 4};
        int[] arr3 = {4, 2, 0, 0, 2, 3, 7, 1, 5};
        int[] arr4 = {400, 200, 1000, 1000, 2000, 300, 700, 10000, 500};

        int a = 4;


        System.out.println(arreyAfterFour(arr1, a));


    }

    public static int[] arreyAfterFour(int[] arr, int a) {
        int[] arr2 = null;

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        ArrayList<?> arrayList = new ArrayList<>();
//        arrayList.as;

//        List<Integer> list = new ArrayList<>();
//        System.out.println(Collections.addAll(new ArrayList<>(), arr));


//        Collections.reverse(list);
//        System.out.println(list.get(1));
//        System.out.println(list.equals((Object)a));


//        Collections.addAll(arrayList, arr);

//        int i = Arrays.asList(arr).indexOf(a);
//        System.out.println(i);
//        arr2 = Arrays.copyOf(arr, i);


        List<Integer> list11 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list11);
        System.out.println(list11.lastIndexOf(a));
//        System.out.println(list11.subList(6 + 1, arr.length));
//        System.out.println(list11.subList(list11.lastIndexOf(a) + 1, arr.length));
//        for (Object o : list11){
//            arr2 = (int[]) o;
//        }
        Collections.reverse(Collections.singletonList(arr));
        System.out.println(arr.equals(a));
        System.out.println(arr);

//        return list11;
        return arr2;

    }

}
