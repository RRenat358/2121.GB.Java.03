import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator1;
    Calculator calculator2 = new Calculator();


    @Test
    @DisplayName("test sum()")
    void testAddition() {
        Assertions.assertEquals(10, calculator2.sum(3,7), "\n\nсумма должна быть 10");
    }


}
