package keygen;

import algorithms.GCD;
import input.InputHandler;

import java.math.BigInteger;

public class KeyGenService {

    private BigInteger n;
    private BigInteger e;
    private BigInteger phiN;

    private BigInteger findD() {
        BigInteger result = BigInteger.ONE;
        while (true) {
            if (result.multiply(e).mod(phiN).compareTo(BigInteger.ONE) == 0)
                break;
            else {
                result = result.add(BigInteger.ONE);
            }
        }
        return result;
    }

    public void getData() {
        BigInteger p = InputHandler.getPrimeInput("p");
        BigInteger q = InputHandler.getPrimeInput("q");
        n = p.multiply(q);
        phiN = GCD.eulerPhiFunction(n);
        e = InputHandler.getNumberEInput(phiN);
    }
    
    public void run() {
        System.out.println("--------------------Alap adatok megadása-------------------------");
        getData();
        BigInteger d = findD();
        System.out.println("---------------------------Megoldás-----------------------------");
        System.out.println("Publikus kulcs: (" + e + ", " + n + ")");
        System.out.println("Privát kulcs: (" + d + ", " + n + ")");
    }

    public static void main(String[] args) {
        KeyGenService keyGenService = new KeyGenService();
        keyGenService.run();
    }
}
