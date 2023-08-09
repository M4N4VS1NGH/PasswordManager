package domain;
// Domain Layer
public class PasswordEntry {
    private String username;
    private String password;

    // Initialize username and password
    public PasswordEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Return username
    public String getUsername() {
        return username;
    }

    // Return password
    public String getPassword() {
        return password;
    }

    // Set the object's password attribute to what is given
    public void setPassword(String password) {
        this.password = password;
    }
}
