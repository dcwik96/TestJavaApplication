package mavenTest2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private App a;

    @BeforeEach
    public void setUp() {
        a = new App();
    }

    @Test
    public void checkIfFindInteger() {

        int searched = 2;
        Integer tab[] = {1, 4, 5, 10, 12};
        assertEquals(searched, a.binarySearch(tab, 5));
    }

    @Test
    public void checkIfFindDouble() {

        int searched = 2;
        Double tab[] = {1.1, 4.1, 5.1, 10.1, 12.1};
        assertEquals(searched, a.binarySearch(tab, 5.1));
    }

    @Test
    public void checkIfFindString() {

        int searched = 1;
        String tab[] = {"czesc", "henryk", "zbigniew"};
        assertEquals(searched, a.binarySearch(tab, "henryk"));
    }

    @Test
    public void checkIfFindIntegerInNotSortedArray() {

        int searched = -1;
        Integer tab[] = {10, 4, 2, 5, 1, 12};
        assertEquals(searched, a.binarySearch(tab, 5));
    }


}
