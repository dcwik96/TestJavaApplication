package quadratic;

import java.io.Serializable;

public final class QuadraticFunction implements Serializable {

    public static QuadraticFunction of(final double a, final double b, final double c) {
        return new QuadraticFunction(a, b, c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    private QuadraticFunction(final double a, final double b, final double c) {
        if (a == 0 && b == 0)
            throw new IllegalArgumentException("No real solution for these parameters");
        this.a = a;
        this.b = b;
        this.c = c;

        final double delta = b * b - 4 * a * c;
        if (a == 0) {
            x1 = x2 = -c / b;
        } else if (delta > 0) {
            x1 = (-b - Math.sqrt(delta)) / 2 * a;
            x2 = (-b + Math.sqrt(delta)) / 2 * a;
        } else if (delta == 0) {
            x1 = x2 = -b / 2 / a;
        } else {
            throw new IllegalArgumentException("No real solution for these parameters");
        }
    }

    private final double a;
    private final double b;
    private final double c;
    private final double x1;
    private final double x2;

}
