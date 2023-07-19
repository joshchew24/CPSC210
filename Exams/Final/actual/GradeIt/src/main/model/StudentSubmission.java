package model;

import java.util.ArrayList;
import java.util.List;

// Represents a student submission for an assignment that has a list
// of mistakes
public class StudentSubmission {
    private Assignment assignment;
    private List<Mistake> mistakes;

    // EFFECTS: constructs a student submission for a particular assignment
    public StudentSubmission(Assignment assignment) {
        this.assignment = assignment;
        mistakes = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds the mistake having description
    public void addMistake(String description) {
        Mistake mistake = assignment.getMarkingScheme().getMistake(description);
        mistakes.add(mistake);
    }

    // MODIFIES: this
    // EFFECTS: removes mistake having description
    public void removeMistake(String description) {
        Mistake mistake = assignment.getMarkingScheme().getMistake(description);
        mistakes.remove(mistake);
    }

    // EFFECTS: gets grade for this submission
    public int getGrade() {
        int maxGrade = assignment.getMarkingScheme().getMaxMarks();

        for (Mistake mistake : mistakes) {
            maxGrade -= mistake.getPenalty();
        }

        return maxGrade;
    }

    // EFFECTS: returns list of mistakes applied to this submission
    public List<Mistake> getMistakes() {
        return mistakes;
    }

    public Assignment getAssignment() {
        return assignment;
    }
}
