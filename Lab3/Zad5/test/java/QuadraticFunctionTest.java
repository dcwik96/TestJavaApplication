import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class QuadraticFunctionTest {
	private static final double epsilon = 0.1;

	static BufferedReader rdr;
	String line;

	private QuadraticFunction q;
	private double a;
	private double b;
	private double c;
	private double x1;
	private double x2;

	@Test
	@FileParameters("src/test/java/wyniki.csv")
	public void checkLinear(double a, double b, double c, double x1, double x2) {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), epsilon);
	}

	@Test
	@FileParameters("src/test/java/wyniki.csv")
	public void checkFirstX(double a, double b, double c, double x1, double x2) {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), epsilon);
	}

	@Test
	@FileParameters("src/test/java/wyniki.csv")
	public void checkSecondX(double a, double b, double c, double x1, double x2) {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x2, q.getX2(), epsilon);
	}

	@Test
	@FileParameters("src/test/java/wyniki.csv")
	public void checkDeltaZero(double a, double b, double c, double x1, double x2) {
		q = QuadraticFunction.of(a, b, c);
		assertEquals(x1, q.getX1(), epsilon);
	}
}
