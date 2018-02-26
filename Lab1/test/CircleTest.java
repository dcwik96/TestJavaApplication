import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    private Circle circle;
    private CircleCalc circleCalc;
    private double r;

    @Before
    public void setUp() {
        r = 2;
        circle = new Circle(r);
        circleCalc = new CircleCalc();
    }

    @Test
    public void checkCircumFence() {
        double expected = 2 * Math.PI * r;
        double result = circleCalc.circumfence(circle);

        assertEquals(expected, result, 0.01);
    }

    @Test
    public void checkPoleCircle() {
        double expected = Math.PI * (Math.pow(r, 2));
        double result = circleCalc.poleCircle(circle);

        assertEquals(expected, result, 0.01);
    }

    @Test
    public void checkCircumFenceWithDelta() {
        double expected = 2 * 3.14 * r;
        double result = circleCalc.circumfence(circle);

        assertEquals(expected, result, 0.01);
        assertNotEquals(expected, result, 0.001);
    }

}
