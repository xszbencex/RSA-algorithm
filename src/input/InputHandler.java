package input;

import algorithms.GCD;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import static algorithms.Prime.isPrime;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    private static BigInteger getUserInput(String symbol, InputCondition inputCondition, BigInteger phiN) {
        BigInteger input;
        while (true) {
            try {
                System.out.print(symbol + " = ");
                 input = scanner.nextBigInteger();
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
                        if (input.compareTo(BigInteger.ONE) < 0 || input.compareTo(BigInteger.valueOf(3)) > 0) {
                            System.out.println("Lehetséges értékek: 1, 2, 3!");
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

    public static BigInteger getPrimeInput(String symbol) {
        return getUserInput(symbol, InputCondition.IS_PRIME, BigInteger.ZERO);
    }

    public static BigInteger getNumberEInput(BigInteger phiN) {
        return getUserInput("e", InputCondition.IS_RELATIVE_PRIME, phiN);
    }

    public static BigInteger getBasicInput(String symbol) {
        return getUserInput(symbol, InputCondition.NO_CONDITION, BigInteger.ZERO);
    }

    public static BigInteger getTaskInput(String symbol) {
        return getUserInput(symbol, InputCondition.TASK_CONDITION, BigInteger.ZERO);
    }
}
