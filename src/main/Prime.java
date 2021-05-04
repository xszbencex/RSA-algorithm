package main;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static main.GCD.isRelativePrimes;

public class Prime {

    private static final Random random = new Random();

    /**
     * Miller-Rabin test
     */
    public static boolean isPrime(int n) { // TODO long
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        int s = 0;
        int d = n - 1;
        while (true) {
            if (d % 2 == 0) {
                s++;
                d = Math.floorDiv(d, 2);
            } else {
                break;
            }
        }
        int numberOfBases = 5;
        for (int i = 0; i < numberOfBases; i++) {
            // int a = random.nextInt(n - 3) + 2;
            int a = ThreadLocalRandom.current().nextInt(2, n);
            if (isRelativePrimes(a, n)) {
                if (isComposite(a, d, n, s)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isComposite(int a, int d, int n, int s) {
        if (Math.pow(a, d) % n == 1) {
            return false;
        }
        for (int r = 0; r < s; r++) {
            if (Math.pow(a, d * Math.pow(2, r)) % n == (n - 1)) {
                return false;
            }
        }
        return true;
    }
}
