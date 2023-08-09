package test;

import org.junit.jupiter.api.Test;

import framework.PasswordGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {
    // Test generating a password with valid length
    @Test
    public void generatePassword_ValidLength_Success() {
        // Arrange: Create an instance of the PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        
        // Act: Generate a random password with a length of 8 characters
        String generatedPassword = passwordGenerator.generateRandomPassword(8);
        
        // Assert: Check that the generated password is not null and has the expected length
        assertNotNull(generatedPassword);
        assertEquals(8, generatedPassword.length());
    }

    // Test generating a password with zero length (expecting an exception)
    @Test
    public void generatePassword_ZeroLength_ThrowsIllegalArgumentException() {
        // Arrange: Create an instance of the PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        
        // Assert: Expect an IllegalArgumentException when generating a password with length 0
        assertThrows(IllegalArgumentException.class, () -> passwordGenerator.generateRandomPassword(0));
    }

    // Test generating a password with negative length (expecting an exception)
    @Test
    public void generatePassword_NegativeLength_ThrowsIllegalArgumentException() {
        // Arrange: Create an instance of the PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        
        // Assert: Expect an IllegalArgumentException when generating a password with negative length
        assertThrows(IllegalArgumentException.class, () -> passwordGenerator.generateRandomPassword(-5));
    }
}
