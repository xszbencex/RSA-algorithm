package input;

import algorithms.GCD;

import java.util.InputMismatchException;
import java.util.Scanner;

import static algorithms.Prime.isPrime;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    private static long getUserInput(String symbol, InputCondition inputCondition, long phiN) {
        long input;
        while (true) {
            try {
                System.out.print(symbol + " = ");
                input = scanner.nextLong();
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
                    case TASK_CONDITION -> {
                        if (input < 1 || input > 3) {
                            System.err.println("Lehetséges értékek: 1, 2, 3!");
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

    public static long getPrimeInput(String symbol) {
        return getUserInput(symbol, InputCondition.IS_PRIME, 0);
    }

    public static long getNumberEInput(long phiN) {
        return getUserInput("e", InputCondition.IS_RELATIVE_PRIME, phiN);
    }

    public static long getBasicInput(String symbol) {
        return getUserInput(symbol, InputCondition.NO_CONDITION, 0);
    }

    public static long getTaskInput(String symbol) {
        return getUserInput(symbol, InputCondition.TASK_CONDITION, 0);
    }
}
