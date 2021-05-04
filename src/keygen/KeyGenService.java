package keygen;

import main.RSAService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static main.Prime.isPrime;

public class KeyGenService implements RSAService {

    private static final Scanner scanner = new Scanner(System.in);

    private int p;

    @Override
    public void getData() {
        System.out.println("Alap adatok megadása:");
        System.out.print("p = ");
        while (true) {
            try {
                p = scanner.nextInt();
                if (isPrime(p)) {
                    System.err.println("A megadott szám nem prím!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Hiba! Rossz bemenet, próbáljuk újra!");
                scanner.next();
            }
        }
    }

    @Override
    public void run() {
        getData();
    }

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cls");
        KeyGenService keyGenService = new KeyGenService();
        keyGenService.run();
    }
}
