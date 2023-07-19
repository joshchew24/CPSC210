package observer;

import java.util.ArrayList;
import java.util.List;


// The abstract observable
public abstract class Observable {
    private List<Observer> observers;

    // EFFECTS: constructs an observable with an empty list of observers
    public Observable() {
        observers = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds o as an observer
    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    // MODIFIES: this
    // EFFECTS: notifies observers of a change in subject state
    public void notifyObservers(Observable observable, Object arg) {
        for (Observer o : observers) {
            o.update(observable, arg);
        }
    }
}
