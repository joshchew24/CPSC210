package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Represents a bus having an id, capacity, chaperone and set of students assigned to travel on bus
public class Bus {

    private final int id;
    private final int capacity;
    private Chaperone chaperone;
    private final Set<Student> students;

    // EFFECTS: constructs bus with id and capacity
    public Bus(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        students = new HashSet<>();
    }

    // getters:

    public int getId() {
        return id;   // stub
    }

    public int getCapacity() {
        return capacity;   // stub
    }

    public Chaperone getChaperone() {
        return chaperone;   // stub
    }

    // EFFECTS: returns true if bus has a chaperone assigned, false otherwise
    public boolean hasChaperone() {
        return chaperone != null;
    }

    // EFFECTS: returns an unmodifiable set of students assigned to travel on this bus
    public Set<Student> getStudents() {
        return students;
    }

    // MODIFIES: this
    // EFFECTS: assigns the chaperone for this bus
    public void setChaperone(Chaperone chaperone) {
        this.chaperone = chaperone;
    }

    // EFFECTS: returns true if bus is full, false otherwise
    public boolean isFull() {
        return students.size() == capacity;
    }

    // REQUIRES: !isFull()
    // MODIFIES: this, student
    // EFFECTS: adds student to this bus
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.assignToBus(this);
        }
    }

    // MODIFIES: this, student
    // EFFECTS: removes student from this bus
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.removeFromBus();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Bus bus = (Bus) o;
        return id == bus.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
