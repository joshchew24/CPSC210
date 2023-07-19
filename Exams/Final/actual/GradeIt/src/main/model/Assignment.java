package model;

// Represents an assignment having a name and a marking scheme
public class Assignment {
    private String name;
    private MarkingScheme markingScheme;

    // EFFECTS: constructs an assignment with a name and a marking scheme
    public Assignment(String name, MarkingScheme markingScheme) {
        this.name = name;
        this.markingScheme = markingScheme;
    }

    public String getName() {
        return name;
    }

    public MarkingScheme getMarkingScheme() {
        return markingScheme;
    }
}
