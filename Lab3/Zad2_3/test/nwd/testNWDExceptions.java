package nwd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nwd.EuclideanImpl;

public class testNWDExceptions {

	private EuclideanImpl test;
	
	@Before
	public void setUp() throws Exception {
		test = new EuclideanImpl();
	}



	@Test(expected=IllegalArgumentException.class)
	public void FirstArgumentIsNegativeNumber() {
		int a=-4;
		int b=4;
		assertEquals(4,test.NWD(a, b));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void SecondArgumentIsNegativeNumber() {
		int a=-4;
		int b=4;
		assertEquals(4,test.NWD(b, a));
	}
	
	@After
	public void tearDown() throws Exception {
		test = null;
	}

}
