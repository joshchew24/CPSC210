package collab;

import java.time.LocalTime;

public class Question {
    private Student student;
    private String text;
    private LocalTime time;

    // EFFECTS: constructs a question and records the student who asked the question
    // and the text of that question
    public Question(Student student, String text) {
        this.student = student;
        this.text = text;
        time = LocalTime.now();
    }

    public Student getStudentName() {
        return student;
    }

    public String getText() {
        return text;
    }

    public LocalTime getTime() {
        return time;
    }
}
