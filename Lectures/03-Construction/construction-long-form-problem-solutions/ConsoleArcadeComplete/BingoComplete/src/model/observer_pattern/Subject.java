package model.observer_pattern;

import model.random.BingoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Subject {

    private List<Observer> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    //MODIFIES: this
    //EFFECTS: adds observer to list of observers
    public void addObserver(Observer o) {
        observers.add(o);
    }

    //EFFECTS: notifies observers of state change
    @Override
    public void notifyObservers(BingoNumber currentCall){
        for (Observer o : getObservers()){
            o.update(currentCall);
        }
    }

}
