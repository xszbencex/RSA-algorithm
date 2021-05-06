package algorithms;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import static algorithms.GCD.isRelativePrime;

public class Prime {

    public static boolean isPrime(BigInteger n) { // TODO long
        if (n.compareTo(BigInteger.TWO) < 0) {
            return false;
        } else if (n.compareTo(BigInteger.TWO) == 0) {
            return true;
        } else if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }
        BigInteger s = BigInteger.ZERO;
        BigInteger d = n.add(BigInteger.ONE.negate());
        while (true) {
            if (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                s = s.add(BigInteger.ONE);
                d = d.divide(BigInteger.TWO);
            } else {
                break;
            }
        }
        int numberOfBases = 6;
        for (int i = 0; i < numberOfBases; ++i) {
            int a = ThreadLocalRandom.current().nextInt(2, 1000);
            if (isRelativePrime(BigInteger.valueOf(a), n)) {
                if (isComposite(BigInteger.valueOf(a), d, n, s)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isComposite(BigInteger a, BigInteger d, BigInteger n, BigInteger s) {
        if (a.modPow(d, n).equals(BigInteger.ONE)) {
            return false;
        }
        for (BigInteger r = BigInteger.ZERO; r.compareTo(s) < 0; r = r.add(BigInteger.ONE)) {
            if (a.modPow(d.multiply(BigInteger.TWO.pow(r.intValue())), n).equals(n.add(BigInteger.ONE.negate()))) {
                return false;
            }
        }
        return true;
    }
}
