import HomeWork.Lesson06HW;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static HomeWork.Lesson06HW.isCheckElementInArray;
import static org.junit.jupiter.api.Assertions.*;

public class CheckElementInArrayTest {

    int element1 = 1;
    int element2 = 4;


    @Test
    @DisplayName("По 1-му каждого элемента")
    void test1() {
        int[] arr = {9, 8, 4, 5, 1, 6};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("По 2-а каждого элемента")
    void test2() {
        int[] arr = {9, 1, 4, 4, 1, 6};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("элемент в начале")
    void test3() {
        int[] arr = {1, 4, 6, 5, 8, 6};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("элемент в конце")
    void test4() {
        int[] arr = {9, 8, 3, 5, 1, 4};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нет 1-го элемента")
    void test5() {
        int[] arr = {9, 8, 4, 5, 7, 2};
        assertFalse(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нет элементов")
    void test6() {
        int[] arr = {9, 8, 2, 5, 7, 2};
        assertFalse(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("нули в массиве")
    void test7_0() {
        int[] arr = {0, 0, 4, 0, 1, 0};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("пустой массив")
    void test7_2() {
        int[] arr = {};
        assertFalse(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("массив из 1го элемента, с вхождением")
    void test7_3() {
        int[] arr = {1};
        assertFalse(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("массив из 1го элемента, без вхождения")
    void test7_4() {
        int[] arr = {0};
        assertFalse(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("отрицательные числа в массиве")
    void test8() {
        int[] arr = {-9, -8, 4, -5, 1, -6};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("числа < -128")
    void test9() {
        int[] arr = {-9000, -800, 4, -5000, 1, -600};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }

    @Test
    @DisplayName("числа > 128")
    void test10() {
        int[] arr = {9000, 800, 4, 5000, 1, 600};
        assertTrue(isCheckElementInArray(arr, element1, element2));
    }


}
