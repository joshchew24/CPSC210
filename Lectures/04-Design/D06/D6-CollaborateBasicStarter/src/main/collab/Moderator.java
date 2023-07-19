package collab;

import java.util.Observable;
import java.util.Observer;

public class Moderator extends Observable implements Observer {
    private String name;

    // EFFECTS: constructs a moderator with name and question logger
    public Moderator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: responds to hand raised by student
    public void handRaised(Student student) {
        System.out.println("Hi " + student.getName() + " what is your question?");

        String text = student.askQuestion();
        System.out.println("\t" + text + "\n\n");
//        logger.addQuestion(new Question(student, text));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg == null) {
            Student student = (Student) o;
            System.out.println("Hi " + student.getName() + " what is your question?");
            String text = student.askQuestion();
            System.out.println("\t" + text + "\n\n");
        }
    }
}
