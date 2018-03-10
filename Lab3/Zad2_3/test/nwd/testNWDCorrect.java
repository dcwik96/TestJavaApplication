package nwd;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import nwd.EuclideanImpl;

@RunWith(Parameterized.class)
public class testNWDCorrect {

	
	private EuclideanImpl test;
	private int inputA;
	private int inputB;
	private int output;
	
	public testNWDCorrect(int a, int b, int c){
		inputA = a;
		inputB = b;
		output = c;
	}

	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{4,8,4}, {12,24,12}, {13,12,1}, {100,25,25}
   		};
        return  Arrays.asList(c);
    }
	
	@Before
	public void setUp(){
		 test = new EuclideanImpl();
	}
	
	@Test
	public void testNWDForPositiveNumbers() {
		assertEquals(output,test.NWD(inputA, inputB));
	}

	@After
	public void teardown(){
		test = null;
	}
	
}


