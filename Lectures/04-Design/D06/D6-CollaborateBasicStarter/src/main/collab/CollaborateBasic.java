package collab;

import java.util.ArrayList;
import java.util.List;

public class CollaborateBasic {
    private Moderator moderator;
    private List<Student> students;
    private QuestionLogger logger;

    // EFFECTS: constructs a Collaborate Basic session with named moderator
    public CollaborateBasic(String moderatorName) {
        logger = new QuestionLogger();
        moderator = new Moderator(moderatorName);
        students = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a student to this CB session with given name and id
    // and returns it
    public Student addStudent(String id, String name) {
        Student student = new Student(id, name, moderator);
        student.addObserver(logger);
        students.add(student);
        return student;
    }

    public int getAttendance() {
        return students.size();
    }

    public Moderator getModerator() {
        return moderator;
    }

    public QuestionLogger getLogger() {
        return logger;
    }
}
