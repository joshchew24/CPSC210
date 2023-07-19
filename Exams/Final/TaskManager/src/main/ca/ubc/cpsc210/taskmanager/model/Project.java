package ca.ubc.cpsc210.taskmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Project extends WorkUnit {

    private List<WorkUnit> subs;

    public Project() {
        subs = new ArrayList<>();
    }

    @Override
    public int hoursToComplete() {
        int totalHours = 0;
        for (WorkUnit w : subs) {
            totalHours += w.hoursToComplete();
        }
        return totalHours;
    }

    public void add(WorkUnit w) {
        subs.add(w);
    }

    public void remove(WorkUnit w) {
        subs.remove(w);
    }
}
