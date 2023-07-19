package collab;

import java.util.*;

public class QuestionLogger implements Observer {
    private List<Question> questions;

    // EFFECTS: constructs an empty logger
    public QuestionLogger() {
        questions = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a question to this logger
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // EFFECTS: returns ummodifiable list of questions in this logger
    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            Question question = (Question) arg;
            questions.add(question);
        }
    }
}
