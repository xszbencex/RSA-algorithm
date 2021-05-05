package keygen;

import algorithms.GCD;
import input.InputHandler;

public class KeyGenService {

    private int n;
    private int e;

    private int findD(int phiN) {
        int result = 1;
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
        int p = InputHandler.getPrimeInput("p");
        int q = InputHandler.getPrimeInput("q");
        n = p * q;
        int phiN = GCD.eulerPhiFunction(n);
        e = InputHandler.getNumberEInput(phiN);
    }
    
    public void run() {
        System.out.println("--------------------Alap adatok megadása-------------------------");
        getData();
        int d = findD(e);
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Publikus kulcs: (" + e + ", " + n + ")");
        System.out.println("Privát kulcs: (" + d + ", " + n + ")");
    }

    public static void main(String[] args) {
        KeyGenService keyGenService = new KeyGenService();
        keyGenService.run();
    }
}
