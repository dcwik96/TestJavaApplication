package mavenTest2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class App2Test {

    @Test
    public void test() {
        assertEquals(4, App.add());
    }

}
