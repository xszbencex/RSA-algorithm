package decryption;

import algorithms.GCD;
import input.InputHandler;

import java.math.BigInteger;
import java.util.Map;

public class DecryptionService {

    private BigInteger p;
    private BigInteger q;
    private BigInteger c;
    private BigInteger d;

    private BigInteger decryption() {
        final BigInteger c1 = c.modPow(d.mod(p.add(BigInteger.ONE.negate())), p);
        final BigInteger c2 = c.modPow(d.mod(q.add(BigInteger.ONE.negate())), q);
        final Map<String, BigInteger> equation = GCD.extendedGcd(q, p);
        return (c1.multiply(equation.get("x")).multiply(q).add(c2.multiply(equation.get("y")).multiply(p)).mod(p.multiply(q)));
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
