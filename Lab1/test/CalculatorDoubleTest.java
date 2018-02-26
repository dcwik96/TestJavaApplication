import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorDoubleTest {

    private CalculatorDouble calculator;

    @Before
    public void setUp() {
        calculator = new CalculatorDouble();
    }

    @Test
    public void testAdd() {
        double result = calculator.add(1.0, 2.0);
        assertEquals(3.0, result, 0.1);
    }

    @Test
    public void checkAddNegative() {
        double result = calculator.add(-1, 2);
        assertEquals(1, result, 0.1);
    }

    @Test
    public void checkSub() {
        double result = calculator.sub(2, 1);
        assertEquals(1, result, 0.1);
    }

    @Test
    public void checkSubNegative() {
        double result = calculator.sub(-2, 1);
        assertEquals(-3, result, 0.1);
    }

    @Test
    public void checkMulti() {
        double result = calculator.multi(2, 4);
        assertEquals(8, result, 0.1);
    }

    @Test
    public void checkDiv() {
        double result = calculator.div(8, 2);
        assertEquals(4, result, 0.1);
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
