package test;

import org.junit.jupiter.api.Test;

import framework.PasswordGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {
    @Test
    public void generatePassword_ValidLength_Success() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String generatedPassword = passwordGenerator.generateRandomPassword(8);
        assertNotNull(generatedPassword);
        assertEquals(8, generatedPassword.length());
    }

    @Test
    public void generatePassword_ZeroLength_ThrowsIllegalArgumentException() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        assertThrows(IllegalArgumentException.class, () -> passwordGenerator.generateRandomPassword(0));
    }

    @Test
    public void generatePassword_NegativeLength_ThrowsIllegalArgumentException() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        assertThrows(IllegalArgumentException.class, () -> passwordGenerator.generateRandomPassword(-5));
    }
}