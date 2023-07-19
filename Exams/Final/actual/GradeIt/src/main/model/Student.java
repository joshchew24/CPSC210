package model;

// Represents a student having a preferred name, last name and id
public class Student {
    private String id;
    private String preferredName;
    private String lastName;

    // EFFECTS: constructs student with preferred name, last name and id
    public Student(String preferredName, String lastName, String id) {
        this.id = id;
        this.preferredName = preferredName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getLastName() {
        return lastName;
    }
}
