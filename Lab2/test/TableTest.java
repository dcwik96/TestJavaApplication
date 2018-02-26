import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TableTest {

    private Table table;
    private int[] arr = {1, 3, 4, 2};

    @Before
    public void setUp() {
        table = new Table(arr);
    }

    @Test
    public void checkLargest() {
        int result = table.largest(table);
        assertEquals(4, result);
    }

    @Test
    public void checkSmallest() {
        int result = table.smallest(table);
        assertEquals(1, result);
    }

    @Test
    public void checkIsSorted() {
        boolean result = table.isSorted(table);
        assertFalse(result);
    }

}
