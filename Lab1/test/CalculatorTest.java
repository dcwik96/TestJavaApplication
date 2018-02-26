import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void checkAddNegative() {
        int result = calculator.add(-1, 2);
        assertEquals(1, result);
    }

    @Test
    public void checkSub() {
        int result = calculator.sub(2, 1);
        assertEquals(1, result);
    }

    @Test
    public void checkSubNegative() {
        int result = calculator.sub(-2, 1);
        assertEquals(-3, result);
    }

    @Test
    public void checkMulti() {
        int result = calculator.multi(2, 4);
        assertEquals(8, result);
    }

    @Test
    public void checkDiv() {
        int result = calculator.div(8, 2);
        assertEquals(4, result);
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivWithZero() {
        int result = calculator.div(2, 0);

        assertEquals(0, result);
    }

    @Test
    public void checkGreater() {
        boolean result = calculator.greater(4, 2);
        assertTrue(result);
    }

    @Test
    public void checkLess() {
        boolean result = calculator.less(2, 4);
        assertTrue(result);
    }

    @Test
    public void checkEquality() {
        boolean result = calculator.equality(2, 2);
        assertTrue(result);
    }


}
