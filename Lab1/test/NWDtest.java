import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NWDtest {

    private NWD nwd;

    @Before
    public void setUp() {
        nwd = new NWD();
    }

    @Test
    public void testNwd() {
        long nwdResult = nwd.nwd(42, 56);
        assertEquals(14, nwdResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNwdWithZeroFirst() {
        long nwdResult = nwd.nwd(0, 56);
        assertEquals(0, nwdResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNwdWithZeroSecond() {
        long nwdResult = nwd.nwd(42, 0);

        assertEquals(0, nwdResult);

    }

    @Test
    public void checkNwdNegativeArgument() {
        long nwdResult = nwd.nwd(-2, 12);
        assertEquals(1, nwdResult);

        assertEquals(0, nwdResult);
    }


}
