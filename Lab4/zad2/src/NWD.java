public class NWD {
    public long nwd(long a, long b) {
        if (a == 0 || b == 0) throw new IllegalArgumentException();

        long factor = Math.min(a, b);
        for (long loop = factor; loop > 1; loop--) {
            if (a % loop == 0 && b % loop == 0) {
                return loop;
            }
        }
        return 1;
    }
}