package application;

import java.util.List;
import java.util.ArrayList;

public class PasswordChangeNotifier implements Subject {
    private Subject subject;
    private List<Observer> observers;

    **/ Initialize subject and observers
    public PasswordChangeNotifier(Subject subject) {
        this.subject = subject;
        this.observers = new ArrayList<>();
    }

    **/ Add the observer to the observers list
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
