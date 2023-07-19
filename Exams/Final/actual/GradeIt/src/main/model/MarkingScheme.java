package model;

import model.exception.DuplicateMistakeException;

import java.util.ArrayList;
import java.util.List;

// Represents a marking scheme having a maximum number of marks and a list of
// associated mistakes for which penalties will be applied.
public class MarkingScheme {
    private int maxMarks;
    private List<Mistake> mistakes;

    // EFFECTS: constructs a marking scheme with maxMarks maximum marks and
    // an empty list of mistakes
    public MarkingScheme(int maxMarks) {
        this.maxMarks = maxMarks;
        mistakes = new ArrayList<>();
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    // MODIFIES: this
    // EFFECTS: if this marking scheme has a mistake with a description equal to the
    // that of the mistake passed as an argument, throws DuplicateMistakeException
    // otherwise, adds mistake to list of mistakes for which marks will be deducted
    public void addMistake(Mistake mistake) throws DuplicateMistakeException {
        if (getMistake(mistake.getDescription()) != null) {
            throw new DuplicateMistakeException();
        }

        mistakes.add(mistake);
    }

    // MODIFIES: this
    // EFFECTS: deletes mistake from this marking scheme
    public void deleteMistake(Mistake mistake) {
        mistakes.remove(mistake);
    }

    // EFFECTS: returns mistake with given description or null if there is
    // no such mistake
    public Mistake getMistake(String description) {
        for (Mistake mistake : mistakes) {
            if (mistake.getDescription().equals(description)) {
                return mistake;
            }
        }

        return null;
    }

    public List<Mistake> getMistakes() {
        return mistakes;
    }
}
