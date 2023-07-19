package ca.ubc.cpsc210.helpdesk.model;

import java.util.LinkedList;

// Represents a queue of incidents to be handled by helpdesk
// with maximum size MAX_SIZE
public class IncidentQueue {

    public static final int MAX_SIZE = 10;
    private LinkedList<Incident> queue;

    // EFFECTS: creates empty IncidentQueue object
    public IncidentQueue() {
        queue = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds i to queue if not full and returns true, otherwise returns false if full
    public boolean addIncident(Incident i) {
        if (queue.size() < MAX_SIZE) {
            queue.add(i);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: queue is not empty
    // MODIFIES: this
    // EFFECTS: removes first incident from queue and returns it
    public Incident getNextIncident() {
        return queue.removeFirst();
    }

    // EFFECTS: returns position in queue of the incident with the given case number, -1 if not found
    public int getPositionInQueueOfCaseNumber(int caseNum) {
        Incident queriedIncident = null;
        for (Incident i : queue) {
            if (i.getCaseNum() == caseNum) {
                queriedIncident = i;
            }
        }
        int index = queue.indexOf(queriedIncident);
        if (index == -1) {
            return index;
        } else {
            return index + 1;
        }
    }

    // EFFECTS: returns the number of incidents in a queue
    public int length() {
        return queue.size();
    }

    // EFFECTS: returns true if queue is empty, false otherwise
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public boolean isFull() {
        return queue.size() == MAX_SIZE;
    }

}
