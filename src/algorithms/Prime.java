package algorithms;

import java.util.concurrent.ThreadLocalRandom;

import static algorithms.GCD.isRelativePrime;

public class Prime {

    public static boolean isPrime(long n) { // TODO long
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        long s = 0;
        long d = n - 1;
        while (true) {
            if (d % 2 == 0) {
                s++;
                d = Math.floorDiv(d, 2);
            } else {
                break;
            }
        }
        long numberOfBases = 5;
        for (long i = 0; i < numberOfBases; i++) {
            long a = ThreadLocalRandom.current().nextLong(2, n);
            if (isRelativePrime(a, n)) {
                if (isComposite(a, d, n, s)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isComposite(long a, long d, long n, long s) {
        if (Math.pow(a, d) % n == 1) {
            return false;
        }
        for (long r = 0; r < s; r++) {
            if (Math.pow(a, d * Math.pow(2, r)) % n == (n - 1)) {
                return false;
            }
        }
        return true;
    }
}
