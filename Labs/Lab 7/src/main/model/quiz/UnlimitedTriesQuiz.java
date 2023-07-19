package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.question.QuestionList;

public class UnlimitedTriesQuiz extends Quiz {

    private int numAttempts = 0;

    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        numAttempts++;
        boolean correct = super.checkAnswer(answer);
        if (correct) {
            return "Correct!";
        } else {
            throw new AnswerIncorrectException("Incorrect, try again!");
        }
    }

    @Override
    public String endQuiz() {
        int n = numAttempts;
        int m = questions.length();
        return "It took you " + n + " attempts to answer " + m + " questions correctly.";
    }

    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return numAttempts;
    }
}
