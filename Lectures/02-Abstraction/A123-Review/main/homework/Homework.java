package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of a collection of tasks assigned to a student that have
 * not yet been completed.
 *
 * Tasks can be added to the collection with the addTask method.
 * This method receives two arguments:
 * (1) the name of the course to which this task belongs
 * (2) a measure of how many hours the task will take to complete
 *
 * Tasks are maintained in the order in which they are added. A student starts
 * working when the work method is called. Tasks will then be worked on in the
 * order in which they were added to the collection of tasks.
 * The work method returns a list of course names whose tasks will be worked
 * on in the new work session (no matter if they are only started or
 * also completed).
 *
 * An example:
 *
 * Homework myHomework = new Homework();
 * myHomework.addTask("A", 1);
 * myHomework.addTask("B", 3);
 * myHomework.addTask("C", 1);
 *
 * myHomework.workOnTasks(2) will return [ "A", "B" ]
 * (the first task will be completed ("A") and the second task will be
 * begun ("B") but not completed)
 * myHomework.workOnTasks(1) will return [ "B" ]
 * (the second task will be worked on for an hour, but still not be
 * completed)
 * myHomework.workOnTasks(2) will return [ "B", "C" ]
 * (both the second and third tasks will be completed)
 * myHomework.workOnTasks(1) will return [ ] (the empty list)
 * (because there are no more tasks to be worked on)
 *
 * @author norm, modified by PC *
 */

public class Homework {

    public List<Task> tasks;

    // EFFECTS: constructs an empty collection of tasks
    public Homework() {
        tasks = new ArrayList<Task>();
    }

    // REQUIRES: neededHours > 0
    // MODIFIES: this
    // EFFECTS: adds a new task to the collection of tasks to be completed
    public void addTask(String className, int neededHours) {
        Task t = new Task(className, neededHours);
        tasks.add(t);
    }

    // REQUIRES: hours > 0
    // MODIFIES: this
    // EFFECTS: returns the list of the names of those courses for
    // which tasks will be worked on when hours work are performed;
    // the list returned could be empty (it is never null). Removes
    // tasks that have been completed from the list of tasks to
    // be worked on
    public List<String> workOnTasks( int hours) {
        return null;  // stub
    }

    // EFFECTS: returns number of hours needed to complete all assigned tasks
    public int hoursToGo() {
        int total = 0;
        for (Task t : tasks) {
            total += t.getHours();
        }
        return total;
    }

    // EFFECTS: returns number of tasks remaining
    public int numTasksRemaining() {
        return tasks.size();
    }
}