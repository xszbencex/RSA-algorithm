package main;

public class GCD {

    /**
     * Greatest Common Divisor with Euclid's algorithm
     */
    public static int gcd(int a, int b) {
        int tmp;
        while (true) {
            if (a % b == 0) {
                return b;
            } else {
                 tmp = b;
                 b = a % b;
                 a = tmp;
            }
        }
    }

    public static boolean isRelativePrimes(int a, int b) {
        return gcd(a, b) == 1;
    }
}
