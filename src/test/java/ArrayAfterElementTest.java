import HomeWork.Lesson06HW.CheckElementInArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static HomeWork.Lesson06HW.arrayAfterElement;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ArrayAfterElementTest {

    int element = 4;

    @BeforeEach
    void init() {
        arrBig = arrayBig();
    }

    static int arrLength = 1_000_000;
    static int[] arrBig = new int[arrLength];
    public static int[] arrayBig() {
        Random random = new Random();
        for (int i = 0; i < arrLength; i++) {
            arrBig[i] = random.nextInt(1000);
        }
        return arrBig;
    }

    @Test
    @DisplayName("1 элемент")
    void test1() {
        int[] arrDfl = {9, 8, 4, 5, 6};
        int[] result = {5, 6};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("2 элемента")
    void test2() {
        int[] arrDfl = {9, 4, 4, 5, 6};
        int[] result = {5, 6};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("элемент в начале")
    void test3() {
        int[] arrDfl = {4, 8, 9, 5, 6};
        int[] result = {8, 9, 5, 6};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("элемент в конце")
    void test4() {
        int[] arrDfl = {9, 8, 6, 5, 4};
        int[] result = {};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("нет элемента, RuntimeException")
    void test5() {
        int[] arrDfl = {9, 8, 1, 5, 6};
        assertThrows(RuntimeException.class, () -> arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("нет элемента, CheckElementInArrayException")
    void test6() {
        int[] arrDfl = {9, 8, 1, 5, 6};
        assertThrows(CheckElementInArrayException.class, () -> arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("нули в массиве")
    void test7_0() {
        int[] arrDfl = {0, 0, 4, 0, 0};
        int[] result = {0, 0};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("пустой массив")
    void test7_1() {
        int[] arrDfl = {};
        assertThrows(RuntimeException.class, () -> arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("отрицательные числа в массиве")
    void test8() {
        int[] arrDfl = {-5, -3, 4, -1, -2};
        int[] result = {-1, -2};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("числа < -128")
    void test9() {
        int[] arrDfl = {-5000, -3000, 4, -8000, -4000};
        int[] result = {-8000, -4000};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("числа > 128")
    void test10() {
        int[] arrDfl = {5000, 3000, 4, 8000, 4000};
        int[] result = {8000, 4000};
        assertArrayEquals(result, arrayAfterElement(arrDfl, element));
    }

    @Test
    @DisplayName("Timeout(500)")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void test11() {
        System.out.println("@Timeout(500). Ссылка на массив(объект) = " + arrayAfterElement(arrBig, element));
    }


}
