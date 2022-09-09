import HomeWork.Lesson06HW;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static HomeWork.Lesson06HW.isCheckElementInArray;

public class CheckElementInArrayTest {

    Lesson06HW lesson06HW = new Lesson06HW();
    int element11 = 1;

    @Test
    @DisplayName("По 1-му каждого элемента")
    void test1() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9, 8, 4, 5, 1, 6};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element11, element2));
    }

    @Test
    @DisplayName("По 2-а каждого элемента")
    void test2() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9, 1, 4, 4, 1, 6};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element11, element2));
    }

    @Test
    @DisplayName("элемент в начале")
    void test3() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {1, 4, 6, 5, 8, 6};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("элемент в конце")
    void test4() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9, 8, 3, 5, 1, 4};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нет 1-го элемента")
    void test5() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9, 8, 4, 5, 7, 2};
        boolean result = false;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нет элементов")
    void test6() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9, 8, 2, 5, 7, 2};
        boolean result = false;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нули в массиве")
    void test7_0() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {0, 0, 4, 0, 1, 0};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("пустой массив")
    void test7_2() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {};
        boolean result = false;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("массив из 1го элемента, с вхождением")
    void test7_3() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {1};
        boolean result = false;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("массив из 1го элемента, без вхождения")
    void test7_4() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {0};
        boolean result = false;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("отрицательные числа в массиве")
    void test8() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {-9, -8, 4, -5, 1, -6};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("числа < -128")
    void test9() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {-9000, -800, 4, -5000, 1, -600};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("числа > 128")
    void test10() {
        int element1 = 1;
        int element2 = 4;
        int[] arr = {9000, 800, 4, 5000, 1, 600};
        boolean result = true;
        Assertions.assertEquals(result, isCheckElementInArray(arr, element1, element2));
    }









}
