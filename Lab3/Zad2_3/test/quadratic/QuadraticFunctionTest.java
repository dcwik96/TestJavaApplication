package quadratic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class QuadraticFunctionTest {

	static BufferedReader rdr;
	String line;

	private QuadraticFunction q;
	private double a;
	private double b;
	private double c;

	private double x1;
	private double x2;
	
	public QuadraticFunctionTest(double a, double b, double c, double x1, double x2) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.x1 = x1;
		this.x2 = x2;
		
	}
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{0,1,2,-2,-2}, {1,0,-4,-2,2}, {1,2,1,-1,-1}, {4,4,1,-0.5,-0.5}
   		};
        return  Arrays.asList(c);
    }

	@Test
	public void checkLinear() {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), 0.1);
	}

	@Test
	public void checkFirstX() {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), 0.1);
	}

	@Test
	public void checkSecondX() {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x2, q.getX2(), 0.1);
	}

	@Test
	public void checkDeltaZero() {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), 0.1);
	}

}
