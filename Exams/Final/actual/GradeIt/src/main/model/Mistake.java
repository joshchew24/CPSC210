package model;

// Represents a mistake having a description and a corresponding penalty
// that will be applied if the student makes this mistake on their assignment.
// It is assumed that mistakes have unique descriptions.
public class Mistake {
    private String description;
    private int penalty;

    public Mistake(String description, int penalty) {
        this.description = description;
        this.penalty = penalty;
    }

    public String getDescription() {
        return description;
    }

    public int getPenalty() {
        return penalty;
    }
}
