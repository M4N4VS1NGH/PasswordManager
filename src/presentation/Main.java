package presentation;

import application.PasswordChangeNotifier;
import application.PasswordManager;
import framework.PasswordGenerator;
import domain.PasswordEntry;
import application.UserNotificationObserver;

import java.util.Scanner;

// Presentation Layer

public class Main {
    public static void main(String[] args) {
        // Initialize the components for Main.java
        PasswordManager passwordManager = PasswordManager.getInstance();
        UserInterface userInterface = new UserInterface(passwordManager);
        PasswordChangeNotifier passwordChangeNotifier = new PasswordChangeNotifier(passwordManager);
        UserNotificationObserver userNotificationObserver = new UserNotificationObserver();

        // Connect the components with observers and run the user interface
        passwordChangeNotifier.addObserver(userNotificationObserver);
        userInterface.run();
    }
}

class UserInterface {
    private PasswordManager passwordManager;
    private UserNotificationObserver userNotificationObserver;
    private Scanner scanner;

    public UserInterface(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
        this.userNotificationObserver = new UserNotificationObserver();

        // Connect the observer and initialize the scanner
        this.passwordManager.addObserver(userNotificationObserver);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            // Display the menu and get user choice
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addUserPassword();
                    break;
                case 2:
                    getPassword();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    generatePassword();
                    break;
                case 5:
                    listWebsites();
                    break;
                case 6:
                    deleteUserPassword();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    // Display the menu and get user choice
    private void printMenu() {
        System.out.println("GPT Password Manager");
        System.out.println("1. Add password");
        System.out.println("2. Get password");
        System.out.println("3. Change password");
        System.out.println("4. Generate password");
        System.out.println("5. List websites");
        System.out.println("6. Delete password");
        System.out.println("7. Exit");
        System.out.print("Select an option: ");
    }

    // Get the user's choice from the console input
    private int getUserChoice() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    // Add a user-entered password entry
    private void addUserPassword() {
        // Collect user input for website, username, and password
        System.out.print("Enter website: ");
        String website = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Create a password entry and add it to the password manager
        PasswordEntry entry = new PasswordEntry(username, password);
        passwordManager.addPassword(website, entry);

        // Create a password entry and add it to the password manager
        userNotificationObserver.update(website, "added");
    }

    // Retrieve and display a password entry for a given website
    private void getPassword() {
        System.out.print("Enter website: ");
        String website = scanner.nextLine();
        PasswordEntry passwordEntry = passwordManager.getPasswordEntry(website);
        if (passwordEntry != null) {
            System.out.println("Username: " + passwordEntry.getUsername());
            System.out.println("Password: " + passwordEntry.getPassword());
        } else {
            System.out.println("Website not found.");
        }
    }

    // Retrieve and display a password entry for a given website
    private void changePassword() {
        System.out.print("Enter website: ");
        String website = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        passwordManager.changePassword(website, newPassword);
        userNotificationObserver.update(website, "changed");
    }

    // Retrieve and display a password entry for a given website
    private void generatePassword() {
        System.out.print("Enter website: ");
        String website = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password length: ");
        int passwordLength = Integer.parseInt(scanner.nextLine());
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String generatedPassword = passwordGenerator.generateRandomPassword(passwordLength);
        PasswordEntry generatedPasswordEntry = new PasswordEntry(username, generatedPassword);
        passwordManager.addPassword(website, generatedPasswordEntry);
        System.out.println("Generated password: " + generatedPassword);
        System.out.println("Password added successfully.");
    }

    // Retrieve and display a password entry for a given website
    private void deleteUserPassword() {
        System.out.print("Enter website to delete: ");
        String website = scanner.nextLine();
        passwordManager.deletePassword(website);
        System.out.println("Password entry deleted.");
    }

    // Retrieve and display a password entry for a given website
    private void listWebsites() {
        passwordManager.listWebsites();
        }
}
