import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadraticFunctionTest {

    private QuadraticFunction q;

    @Test
    public void checkLinear() {
        q = QuadraticFunction.of(0, 1, 2);
        assertEquals(-2, q.getX1(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkZeors() {

        q = QuadraticFunction.of(0, 0, 0);
        assertEquals(0, q.getX1(), 0.1);
    }

    @Test
    public void checkFirstX() {
        q = QuadraticFunction.of(1, 0, -4);
        assertEquals(-2, q.getX1(), 0.1);
    }

    @Test
    public void checkSecondX() {
        q = QuadraticFunction.of(1, 0, -4);
        assertEquals(2, q.getX2(), 0.1);
    }

    @Test
    public void checkDeltaZero() {
        q = QuadraticFunction.of(1, 2, 1);
        assertEquals(-1, q.getX1(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDeltaNegative() {
        q = QuadraticFunction.of(1, -3, 7);

        assertEquals(0, q.getX1(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTest() {
        q = QuadraticFunction.of(0, 0, 7);

        assertEquals(0, q.getX1(), 0.1);
    }

}
