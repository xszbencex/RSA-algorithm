package encryption;

import algorithms.GCD;
import input.InputHandler;

public class EncryptionService {

    private long n;
    private long e;
    private long m;

    private long encryption() {
        return (long) (Math.pow(m, e) % n);
    }

    public void getData() {
        long p = InputHandler.getPrimeInput("p");
        long q = InputHandler.getPrimeInput("q");
        n = p * q;
        long phiN = GCD.eulerPhiFunction(n);
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
