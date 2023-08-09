package application;

public class UserNotificationObserver implements Observer {
    @Override
    public void update(String website, String action) {
        System.out.println("User notification: Password for website '" + website + "' has been " + action + ".");
    }
}