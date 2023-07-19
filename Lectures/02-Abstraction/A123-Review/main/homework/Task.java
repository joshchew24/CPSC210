package homework;

// Represents a task having a related course and number of hours remaining to complete
// Author: norm, modified by PC
public class Task {
    private String courseName;
    private int hours;

    // EFFECTS: constructs a task with an associated course name
    // and expected number of hours to complete
    public Task(String courseName, int hours) {
        this.courseName = courseName;
        this.hours = hours;
    }

    public String getCourseName() {
        return courseName;
    }

    // EFFECTS: returns number of hours that remain to complete this task
    public int getHours() {
        return hours;
    }

    // MODIFIES: this
    // EFFECTS: applies numHours hours to this task (subtracts
    // numHours from total hours needed to complete the task)
    public void applyHours(int numHours) {
        this.hours -= numHours;
    }
}
