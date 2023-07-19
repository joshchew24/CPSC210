package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private List<Doable> subs;
    private boolean subsComplete;


    public Todo(String description) {
        super(description);
        subs = new LinkedList<>();
        subsComplete = false;
    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + this.description);
        for (Doable d : subs) {
            d.display(indentSpace + indentSpace);
        }
    }

    // getters
    public List<Doable> getSubs() {
        return subs;
    }

    public boolean addDoable(Doable d) {
        if (!subs.contains(d)) {
            subs.add(d);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeDoable(Doable d) {
        if (subs.contains(d)) {
            subs.remove(d);
            return true;
        } else {
            return false;
        }
    }

    public boolean areSubsComplete() {
        boolean areSubsComplete = true;
        for (Doable d : subs) {
            if (!d.isComplete()) {
                areSubsComplete = false;
            }
        }
        subsComplete = areSubsComplete;
        return subsComplete;
    }

    @Override
    public Boolean isComplete() {
        return super.isComplete() && subsComplete;
    }

    @Override
    public void complete() {
        super.complete();
        for (Doable d : subs) {
            d.complete();
        }
        subsComplete = true;
    }
}