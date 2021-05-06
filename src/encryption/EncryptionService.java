package encryption;

import algorithms.GCD;
import input.InputHandler;

import java.math.BigInteger;

public class EncryptionService {

    private BigInteger n;
    private BigInteger e;
    private BigInteger m;

    private BigInteger encryption() {
        return m.modPow(e, n);
    }

    public void getData() {
        BigInteger p = InputHandler.getPrimeInput("p");
        BigInteger q = InputHandler.getPrimeInput("q");
        n = p.multiply(q);
        BigInteger phiN = GCD.eulerPhiFunction(n);
        e = InputHandler.getNumberEInput(phiN);
        m = InputHandler.getBasicInput("m");
    }

    public void run() {
        System.out.println("--------------------Alap adatok megadása-------------------------");
        getData();
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Titkosított üzenet: " + encryption());
    }


    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService();
        encryptionService.run();
    }
}
