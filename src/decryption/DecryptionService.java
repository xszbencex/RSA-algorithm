package decryption;

import algorithms.GCD;
import input.InputHandler;

import java.util.Map;

public class DecryptionService {

    private long p;
    private long q;
    private long c;
    private long d;

    private long decryption() {
        final long c1 = (long) (Math.pow(c, d % (p-1)) % p);
        final long c2 = (long) (Math.pow(c, d % (q-1)) % q);
        final Map<String, Long> equation = GCD.extendedGcd(q, p);
        return (c1 * equation.get("x") * q + c2 * equation.get("y") * p) % (p * q);
    }

    public void getData() {
        p = InputHandler.getPrimeInput("p");
        q = InputHandler.getPrimeInput("q");
        d = InputHandler.getBasicInput("d");
        c = InputHandler.getBasicInput("c");
    }

    public void run() {
        System.out.println("--------------------Alap adatok megadása-------------------------");
        getData();
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Visszafejtett üzenet: " + decryption());
    }

    public static void main(String[] args) {
        DecryptionService decryptionService = new DecryptionService();
        decryptionService.run();
    }
}
