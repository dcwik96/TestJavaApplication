package mocks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestChecker {

    MockSystemEnvironment env;
    Calendar cal;
    Checker checker;
    long t1;

    @BeforeEach
    public void setUp() {
        env = new MockSystemEnvironment();
        checker = new Checker(env);
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.DAY_OF_MONTH, 9);
        cal.set(Calendar.HOUR_OF_DAY, 16);
        cal.set(Calendar.MINUTE, 55);
        t1 = cal.getTimeInMillis();
    }

    @Test
    public void testQuittingTime() {

        long t1 = cal.getTimeInMillis();
        env.setTime(t1);
        checker.remainder();
        assertFalse(env.wavWasPlayed());
    }

    @Test
    public void testSetUpTo17() {
        t1 += (5 * 60 * 1000);
        env.setTime(t1);
        checker.remainder();
        assertTrue(env.wavWasPlayed());
    }

    @Test
    public void testSetUpTo18_55() {
        t1 += 2 * 60 * 60 * 1000;
        env.setTime(t1);
        checker.remainder();
        assertTrue(env.wavWasPlayed());
    }

    @AfterEach
    public void tearDown() {
        env.resetWav();
    }

}
