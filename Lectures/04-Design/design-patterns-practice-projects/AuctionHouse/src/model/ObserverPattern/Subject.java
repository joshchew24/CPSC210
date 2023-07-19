package model.ObserverPattern;

import java.util.LinkedList;
import java.util.List;

public class Subject {

    private List<Observer> observers;

    public Subject() {
        observers = new LinkedList<>();
    }

    public void addObserver(Observer b) {
        if (!observers.contains(b)) {
            observers.add(b);
        }
    }

    public void notifyObservers(Subject Observable, double bid) {
        for (Observer o : observers) {
            o.update(Observable, bid);
        }
    }

}
