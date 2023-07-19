package ui;

import collab.CollaborateBasic;
import collab.Question;
import collab.QuestionLogger;
import collab.Student;

import java.util.List;

public class CollaborateBasicDemo {
    private CollaborateBasic cb;
    private Student anna;
    private Student joey;
    private Student mei;

    // EFFECTS: constructs a demo of CollaborateBasic session
    public CollaborateBasicDemo() {
        cb = new CollaborateBasic("Alice");
        anna = cb.addStudent("1234", "Anna");
        joey = cb.addStudent("2345", "Joey");
        mei = cb.addStudent("3456", "Mei");
    }

    // MODIFIES: this
    // EFFECTS: runs the session
    public void runSession() {
        anna.raiseHand();
        mei.raiseHand();
        joey.raiseHand();
    }

    // EFFECTS: prints summary of questions asked during session
    public void summarizeSession() {
        QuestionLogger logger = cb.getLogger();

        List<Question> questions = logger.getQuestions();
        int numQuestions = questions.size();

        if (numQuestions > 0) {
            System.out.println("The following " + numQuestions + " questions were asked in this session:");
            for (Question qn : logger.getQuestions()) {
                System.out.println("\t\t" + qn.getText());
            }
        } else {
            System.out.println("No questions were asked in this session.");
        }
    }

    public static void main(String[] args) {
        CollaborateBasicDemo cbd = new CollaborateBasicDemo();
        cbd.runSession();
        cbd.summarizeSession();
    }
}
