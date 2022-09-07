import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CalculatorTest {

    Calculator calculator1 = new Calculator();
    Calculator calculator2;






    @Test
    @DisplayName("test sum()")
    void testAddition() {
        Assertions.assertEquals(10, calculator1.sum(3,7), "\n\nсумма должна быть 10");
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testMultiplication() {
        Assertions.assertEquals(15, calculator1.multiply(3, 5));
    }

    @Test
    @Disabled
    void testDivisionWithException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator1.division(5, 0));
    }

    @CsvSource({
            "1, 2, 3",
            "3, 2, 5",
            "13, 2, 15"
    })
    @ParameterizedTest
    void testAdditionMultiple(int a, int b, int result) {
        Assertions.assertEquals(result, calculator1.sum(a, b));
    }


    @MethodSource("dataForAddition")
    @ParameterizedTest
    void testAdditionMultipleWithMethod(int a, int b, int result) {
        Assertions.assertEquals(result, calculator1.sum(a, b));
    }

    public static Stream<Arguments> dataForAddition() {
        List<Arguments> argumentsList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int a = random.nextInt(1000);
            int b = random.nextInt(1000);
            argumentsList.add(Arguments.arguments(a, b, a + b));
        }
        return argumentsList.stream();
    }









}
