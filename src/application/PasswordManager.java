package application;

import domain.PasswordEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// Use Cases (Application) Layer
public class PasswordManager implements Subject{
    private Map<String, PasswordEntry> passwords;
    private static final String CSV_FILE_PATH = "src\\data\\passwords.csv";
    private static PasswordManager instance;
    private List<Observer> observers;

    public PasswordManager() {
        passwords = new HashMap<>();
        observers = new ArrayList<>();
        loadPasswords();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public static PasswordManager getInstance() {
        if (instance == null) {
            instance = new PasswordManager();
        }
        return instance;
    }

    public void addPassword(String website, PasswordEntry entry) {
        passwords.put(website, entry);
        savePasswords();
    }
    public void deletePassword(String website) {
        passwords.remove(website);
        savePasswords();
    }

    public PasswordEntry getPasswordEntry(String website) {
        return passwords.get(website);
    }

    public void changePassword(String website, String newPassword) {
        PasswordEntry passwordEntry = passwords.get(website);
        if (passwordEntry != null) {
            passwordEntry.setPassword(newPassword);
        }
    }

    public void listWebsites() {
        System.out.println("Stored websites:");
        for (String website : passwords.keySet()) {
            System.out.println(website);
        }
    }
    private void loadPasswords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String website = parts[0];
                    String username = parts[1];
                    String password = parts[2];
                    passwords.put(website, new PasswordEntry(username, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void savePasswords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Map.Entry<String, PasswordEntry> entry : passwords.entrySet()) {
                String website = entry.getKey();
                String username = entry.getValue().getUsername();
                String password = entry.getValue().getPassword();
                writer.write(website + "," + username + "," + password);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}