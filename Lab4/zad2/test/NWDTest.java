import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NWDtest {

    private NWD nwd;

    @BeforeEach
    public void setUp() {
        nwd = new NWD();
    }

    @Test
    public void testNwd() {
        long nwdResult = nwd.nwd(42, 56);
        assertEquals(14, nwdResult);
    }

    @Test
    @DisplayName("Throws illegalArgumentException when first argument is zero")
    public void checkNwdWithZeroFirst() {
        assertThrows(IllegalArgumentException.class, () -> nwd.nwd(0, 56));
    }

    @Test
    public void checkNwdWithZeroSecond() {
//        long nwdResult = nwd.nwd(42, 0);
//        assertEquals(0, nwdResult);
        assertThrows(IllegalArgumentException.class, () -> nwd.nwd(42, 0));
    }

    @Test
    public void checkNwdNegativeArgument() {
        long nwdResult = nwd.nwd(-2, 12);
        assertEquals(1, nwdResult);
    }


}