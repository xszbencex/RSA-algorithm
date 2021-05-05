package input;

import algorithms.GCD;

import java.util.InputMismatchException;
import java.util.Scanner;

import static algorithms.Prime.isPrime;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getUserInput(String symbol, InputCondition inputCondition, int phiN) {
        int input;
        while (true) {
            try {
                System.out.print(symbol + " = ");
                input = scanner.nextInt();
                switch (inputCondition) {
                    case NO_CONDITION -> {
                    }
                    case IS_PRIME -> {
                        if (!isPrime(input)) {
                            System.out.println("Hiba! Kérem prímszámot adjon meg!");
                            continue;
                        }
                    }
                    case IS_RELATIVE_PRIME -> {
                        if (!GCD.isRelativePrime(input, phiN)) {
                            System.out.println("Hiba! A szám nem relatív prím phi(n)-hez!");
                            continue;
                        }
                    }
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Hiba! Rossz bemenet, próbáljuk újra!");
                scanner.next();
            }
        }
        return input;
    }

    public static int getPrimeInput(String symbol) {
        return getUserInput(symbol, InputCondition.IS_PRIME, 0);
    }

    public static int getNumberEInput(int phiN) {
        return getUserInput("e", InputCondition.IS_RELATIVE_PRIME, phiN);
    }

    public static int getBasicInput(String symbol) {
        return getUserInput(symbol, InputCondition.NO_CONDITION, 0);
    }
}
