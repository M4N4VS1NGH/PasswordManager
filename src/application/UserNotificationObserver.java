package application;

// Sending out an update to the user when an action has occurred 
public class UserNotificationObserver implements Observer {
    @Override
    public void update(String website, String action) {
        System.out.println("User notification: Password for website '" + website + "' has been " + action + ".");
    }
}
