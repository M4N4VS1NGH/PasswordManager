package framework;

import java.security.SecureRandom;
import java.util.Random;

// Frameworks & Drivers Layer

/**
Generate a random password by entering a positive integer representing the length of your password

Example: 

Input: 5, Output: a1b2C
**/

public class PasswordGenerator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    private static final String ALL_CHARACTERS = LOWER_CASE + UPPER_CASE + DIGITS;

    private static final Random RANDOM = new SecureRandom();

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();

        // Check if input is not a positive integer
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be a positive integer.");
        }

        for (int i = 0; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(RANDOM.nextInt(ALL_CHARACTERS.length())));
        }

        return password.toString();
    }
}
