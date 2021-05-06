package algorithms;

import java.util.*;

public class GCD {

    public static long gcd(long a, long b) {
        long tmp;
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

    public static Map<String, Long> extendedGcd(long a, long b) {
        long tmp, q;
        long x1 = 1, x2 = 0;
        long y1 = 0, y2 = 1;
        long n = 1;
        while (true) {
            if (a % b == 0) {
                return makeResult(n, b, x2, y2);
            } else {
                ++n;
                q = Math.floorDiv(a, b);
                tmp = b;
                b = a % b;
                a = tmp;
                tmp = x2;
                x2 = x2 * q + x1;
                x1 = tmp;
                tmp = y2;
                y2 = y2 * q + y1;
                y1 = tmp;
            }
        }
    }

    private static Map<String, Long> makeResult(long n, long b, long x2, long y2) {
        if (n % 2 == 0) {
            y2 = -y2;
        }
        Map<String, Long> result = new HashMap<>();
        result.put("gcd", b);
        result.put("x", x2);
        result.put("y", y2);
        return result;
    }

    public static long eulerPhiFunction(long n) {
        long phi = 0;
        for (long i = 1; i <= n; ++i) {
            if (gcd(n, i) == 1) {
                ++phi;
            }
        }
        return phi;
    }

    public static boolean isRelativePrime(long a, long b) {
        return gcd(a, b) == 1;
    }
}
