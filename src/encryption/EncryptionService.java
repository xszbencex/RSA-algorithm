package encryption;

import algorithms.GCD;
import input.InputHandler;

public class EncryptionService {

    private int n;
    private int e;
    private int m;

    private int encryption() {
        return (int) (Math.pow(m, e) % n);
    }

    public void getData() {
        int p = InputHandler.getPrimeInput("p");
        int q = InputHandler.getPrimeInput("q");
        n = p * q;
        int phiN = GCD.eulerPhiFunction(n);
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
