
public class CircleCalc {

    double circumfence(Circle c) {
        return 2 * Math.PI * c.getR();
    }

    double poleCircle(Circle c) {
        return Math.PI * (Math.pow(c.getR(), 2));
    }
}
