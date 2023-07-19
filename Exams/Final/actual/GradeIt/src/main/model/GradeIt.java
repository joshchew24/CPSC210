package model;

import model.exception.NoSuchStudentException;
import model.exception.NoSuchSubmissionException;

import java.util.ArrayList;
import java.util.List;

// Represents a grading system that stores assignments, students and their corresponding submissions
public class GradeIt {
    // partial list of fields
    private List<Assignment> assignments;

    // EFFECTS: constructs a GradeIt object with no assignments, no students and no submissions
    public GradeIt() {
        assignments = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds assignment to this GradeIt
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // MODIFIES: this
    // EFFECTS: adds a submission for a particular student
    public void addStudentSubmission(Student student, StudentSubmission submission) {
        // implementation deliberately omitted
        // assume that this method does not modify the assignments field
    }

    // EFFECTS: if student has no submissions in this GradeIt object, throws NoSuchStudentException
    // otherwise, if student has submissions but no submission corresponding to the assignment named
    // assignmentName, throws NoSuchSubmissionException
    // otherwise, returns student's submission for assignment with name assignmentName
    public StudentSubmission getStudentSubmission(Student student, String assignmentName)
                throws NoSuchStudentException, NoSuchSubmissionException {
        // implementation deliberately omitted
        // assume that this method does not modify the assignments field
        return null;  // stub
    }
}
