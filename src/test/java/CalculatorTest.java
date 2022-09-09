import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;



public class CalculatorTest {

    //    Calculator calculator1 = new Calculator(); //initialization in @BeforeEach
    Calculator calculator1;
    Calculator calculator2;

    //mock
    //void -- do nothing
    //method -- null
    Battery battery = Mockito.mock(Battery.class);


    @BeforeEach
    void init() {
        System.out.println("test initialization");

        calculator1 = new Calculator();
        calculator2 = new Calculator(battery);

        calculator1.setA(10);
        calculator1.setB(7);
    }

    @AfterEach
    void tearDown() {
        System.out.println("test finished\n");
    }

    @AfterAll
    public static void end(){
        System.out.println("\nEND");
    }



    @Test
    @DisplayName("test sum()")
    void testAddition() {
        Assertions.assertEquals(10, calculator1.sum(3, 7), "\n\nсумма должна быть 10");
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


    @ParameterizedTest
    @MethodSource("dataForAddition")
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


    //mock. For testing Calculator with Battery
    void testWithBattery() {
        Mockito.doReturn(50).when(battery.getPercent());
    }


    @Test
    public void testCalcInnerSum1(){
        calculator1.setA(1);
        calculator1.setB(3);
        Assertions.assertEquals(4, calculator1.sum());
    }


    @Test
    public void testCalcInnerSum2(){
//        calculator1.setA(1); //initialization in @BeforeEach
//        calculator1.setB(3); //initialization in @BeforeEach
        Assertions.assertEquals(17, calculator1.sum());
    }



}
