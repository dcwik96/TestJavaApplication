import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NWWTest {

    private NWW nww;

    @Before
    public void setUp() {
        nww = new NWW();
    }

    @Test
    public void testNWW() {
        long nwwResult = nww.nww(3, 8);
        assertEquals(24, nwwResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNwwWithZeroFirst() {
        long nwwResult = nww.nww(0, 56);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNwwWithZeroSecond() {
        long nwwResult = nww.nww(42, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNwwNegativeArgument() {
        long nwwResult = nww.nww(-2, 12);
    }

}
