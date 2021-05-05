package algorithms;

import java.util.HashMap;
import java.util.Map;

public class GCD {

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

    public static Map<String, Integer> extendedGcd(int a, int b) {
        int tmp, q;
        int x1 = 1, x2 = 0;
        int y1 = 0, y2 = 1;
        int n = 1;
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

    private static Map<String, Integer> makeResult(int n, int b, int x2, int y2) {
        if (n % 2 == 0) {
            y2 = -y2;
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("gcd", b);
        result.put("x", x2);
        result.put("y", y2);
        return result;
    }

    public static int eulerPhiFunction(int n) {
        int phi = 0;
        for (int i = 1; i <= n; ++i) {
            if (gcd(n, i) == 1) {
                ++phi;
            }
        }
        return phi;
    }

    public static boolean isRelativePrime(int a, int b) {
        return gcd(a, b) == 1;
    }
}
