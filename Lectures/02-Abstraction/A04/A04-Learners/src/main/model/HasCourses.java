package model;

import java.util.List;

public interface HasCourses {

    // EFFECTS: returns a list of courses
    public List<Course> getCourses();

    // MODIFIES: this
    // EFFECTS: registers this in a given course
    void register(Course c);
}
