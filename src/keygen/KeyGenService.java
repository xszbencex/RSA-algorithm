package keygen;

import algorithms.GCD;
import input.InputHandler;

import java.math.BigInteger;

public class KeyGenService {

    private BigInteger n;
    private BigInteger e;

    private BigInteger findD(BigInteger phiN) {
        BigInteger result = BigInteger.ONE;
        while (true) {
            if (result.multiply(e).mod(phiN).equals(BigInteger.ONE))
                break;
            else {
                result = result.add(BigInteger.ONE);
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
        BigInteger d = findD(e);
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Publikus kulcs: (" + e + ", " + n + ")");
        System.out.println("Privát kulcs: (" + d + ", " + n + ")");
    }

    public static void main(String[] args) {
        KeyGenService keyGenService = new KeyGenService();
        keyGenService.run();
    }
}
