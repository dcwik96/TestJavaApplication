import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualsTest {

    private Circle circle1;
    private Circle circle2;
    private double r;


    @Before
    public void setUp() {
        r = 2;
        circle1 = new Circle(r);
        circle2 = new Circle(r);
    }


    @Test
    public void checkEquals() {
        assertTrue(circle1.equals(circle2));
    }

    @Test
    public void checkNotEquals() {
        circle2.setR(3);
        assertFalse(circle1.equals(circle2));
    }

    @Test
    public void checkAssertEquals() {
        assertEquals(true, circle1.equals(circle2));
    }

}
