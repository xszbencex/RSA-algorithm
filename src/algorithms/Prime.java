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
        BigInteger d = n.add(BigInteger.ZERO.negate());
        while (true) {
            if (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                s = s.add(BigInteger.ONE);
                d = d.divide(BigInteger.TWO);
            } else {
                break;
            }
        }
        BigInteger numberOfBases = BigInteger.valueOf(6);
        for (BigInteger i = BigInteger.ZERO; i.compareTo(numberOfBases) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger a = ThreadLocalRandom.current().nextInt(2, n.intValue());
            if (isRelativePrime(a, n)) {
                if (isComposite(a, d, n, s)) {
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
