package keygen;

import algorithms.GCD;
import input.InputHandler;

public class KeyGenService {

    private long n;
    private long e;
    private long phiN;

    private long findD() {
        long result = 1;
        while (true) {
            if ((result * e) % phiN == 1)
                break;
            else {
                ++result;
            }
        }
        return result;
    }

    public void getData() {
        long p = InputHandler.getPrimeInput("p");
        long q = InputHandler.getPrimeInput("q");
        n = p * q;
        phiN = GCD.eulerPhiFunction(n);
        e = InputHandler.getNumberEInput(phiN);
    }

    public void run() {
        System.out.println("--------------------Alap adatok megadása-------------------------");
        getData();
        long d = findD();
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Publikus kulcs: (" + e + ", " + n + ")");
        System.out.println("Privát kulcs: (" + d + ", " + n + ")");
    }

    public static void main(String[] args) {
        KeyGenService keyGenService = new KeyGenService();
        keyGenService.run();
    }
}
