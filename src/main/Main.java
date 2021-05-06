package main;

import decryption.DecryptionService;
import encryption.EncryptionService;
import input.InputHandler;
import keygen.KeyGenService;

import java.math.BigInteger;

public class Main {

    private static Tasks chooseTask() {
        System.out.println("Milyen műveletet szeretne végezni? (titkosítás: 1, visszafejtés: 2, kulcsgenerálás: 3)");
        BigInteger taskNum = InputHandler.getTaskInput("Művelet");
        return Tasks.values()[taskNum.intValue() - 1];
    }

    public static void main(String[] args) {
        switch (chooseTask()) {
            case ENCRYPTION -> {
                EncryptionService encryptionService = new EncryptionService();
                encryptionService.run();
            }
            case DECRYPTION -> {
                DecryptionService decryptionService = new DecryptionService();
                decryptionService.run();
            }
            case KEY_GEN -> {
                KeyGenService keygenService = new KeyGenService();
                keygenService.run();
            }
            default -> {
                System.err.println("Lehetséges értékek: 1, 2, 3!");
                chooseTask();
            }
        }
    }
}
