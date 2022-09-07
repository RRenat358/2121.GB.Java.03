import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

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
    void testDivisionWithException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator1.division(5, 0));
    }

}
