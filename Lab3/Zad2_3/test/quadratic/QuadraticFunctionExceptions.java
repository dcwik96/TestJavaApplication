package quadratic;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import org.junit.Test;

public class QuadraticFunctionExceptions {

	static BufferedReader rdr;
	String line;

	private QuadraticFunction q;

	@Test(expected = IllegalArgumentException.class)
	public void checkZeors() {

		q = QuadraticFunction.of(0, 0, 0);
		assertEquals(0, q.getX1(), 0.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkDeltaNegative() {
		q = QuadraticFunction.of(1, -3, 7);

		assertEquals(0, q.getX1(), 0.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkTest() {
		q = QuadraticFunction.of(0, 0, 7);

		assertEquals(0, q.getX1(), 0.1);
	}
}
