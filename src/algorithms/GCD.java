package algorithms;

import java.math.BigInteger;
import java.util.*;

public class GCD {

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        BigInteger tmp;
        while (true) {
            if (a.mod(b).equals(BigInteger.ZERO)) {
                return b;
            } else {
                 tmp = b;
                 b = a.mod(b);
                 a = tmp;
            }
        }
    }

    public static Map<String, BigInteger> extendedGcd(BigInteger a, BigInteger b) {
        BigInteger tmp, q;
        BigInteger x1 = BigInteger.ONE;
        BigInteger x2 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ZERO;
        BigInteger y2 = BigInteger.ONE;
        BigInteger n = BigInteger.ONE;
        while (true) {
            if (a.mod(b).equals(BigInteger.ZERO)) {
                return makeResult(n, b, x2, y2);
            } else {
                n = n.add(BigInteger.ONE);
                q = a.divide(b);
                tmp = b;
                b = a.mod(b);
                a = tmp;
                tmp = x2;
                x2 = x2.multiply(q).add(x1);
                x1 = tmp;
                tmp = y2;
                y2 = y2.multiply(q).add(y1);
                y1 = tmp;
            }
        }
    }

    private static Map<String, BigInteger> makeResult(BigInteger n, BigInteger b, BigInteger x2, BigInteger y2) {
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            y2 = y2.negate();
        }
        Map<String, BigInteger> result = new HashMap<>();
        result.put("gcd", b);
        result.put("x", x2);
        result.put("y", y2);
        return result;
    }

    public static BigInteger eulerPhiFunction(BigInteger n) {
        BigInteger phi = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n.add(BigInteger.ONE)) < 0; i = i.add(BigInteger.ONE)) {
            if (gcd(n, i).equals(BigInteger.ONE)) {
                phi = phi.add(BigInteger.ONE);
            }
        }
        return phi;
    }

    public static boolean isRelativePrime(BigInteger a, BigInteger b) {
        return gcd(a, b).equals(BigInteger.ONE);
    }
}
