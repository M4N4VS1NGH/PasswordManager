package application;

import java.util.List;
import java.util.ArrayList;

public class PasswordChangeNotifier implements Subject {
    private Subject subject;
    private List<Observer> observers;

    public PasswordChangeNotifier(Subject subject) {
        this.subject = subject;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}