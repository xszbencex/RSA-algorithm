package decryption;

import algorithms.GCD;
import input.InputHandler;

import java.util.Map;

public class DecryptionService {

    private int p;
    private int q;
    private int c;
    private int d;

    private int decryption() {
        final int c1 = (int) (Math.pow(c, d % (p-1)) % p);
        final int c2 = (int) (Math.pow(c, d % (q-1)) % q);
        final Map<String, Integer> equation = GCD.extendedGcd(q, p);
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
