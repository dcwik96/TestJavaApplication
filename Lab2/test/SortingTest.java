import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    private Sorting sorting;
    private int[] arr;

    @Test
    public void checkSortAscCorrect() {
        arr = new int[]{1, 3, 4, 2};
        sorting = new Sorting(arr);

        assertTrue(sorting.isSorted(sorting.sort("r")));
    }

    @Test
    public void checkSortDescCorrect() {
        arr = new int[]{1, 3, 4, 2};
        String expectedArray = "[4, 3, 2, 1]";
        sorting = new Sorting(arr);

        assertEquals(expectedArray, sorting.sort("m").printArray());
    }

    @Test
    public void checkPrintArrayCorrect() {
        arr = new int[]{1, 3, 4, 2};
        String expectedArray = "[1, 3, 4, 2]";
        sorting = new Sorting(arr);

        assertEquals(expectedArray, sorting.printArray());
    }

    @Test
    public void checkIsSortedTrue() {
        arr = new int[]{1, 2, 3, 4};
        sorting = new Sorting(arr);

        assertTrue(sorting.isSorted(sorting));
    }

    @Test
    public void checkIsSortedFalse() {
        arr = new int[]{1, 3, 4, 2};
        sorting = new Sorting(arr);

        assertFalse(sorting.isSorted(sorting));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWrongSortOption() {
        arr = new int[]{1, 3, 4, 2};
        sorting = new Sorting(arr);

        assertTrue(sorting.isSorted(sorting.sort("b")));
    }

    @Test
    public void checkWithIncorrectString() {
        int[] temp = { 1, 2, 3, 4 };
        String tmp = "1, 2, 3, 4";
        sorting = new Sorting(temp);
        assertNotEquals(tmp, sorting.printArray());
    }

    @Test(expected = NullPointerException.class)
    public void checkNullArray(){
        int[] arr = {};
        sorting = new Sorting(arr);

        assertTrue(sorting.isSorted(sorting.sort("r")));
    }
}
