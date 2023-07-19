package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

public class LimitedTriesQuiz extends Quiz {

    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        if (correct) {
            return "Correct!";
        } else {
            // if max mark is 1, the last attempt has been used, otherwise decrement and throw exception
            if (super.curQuestion.getMaxMark() == 1) {
                throw new OutOfTriesException("You have used your last attempt.");
            } else {
                decrementMaxMark();
                throw new AnswerIncorrectException("Incorrect, try again!");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: decrements the current question's max mark
    private void decrementMaxMark() {
        int currentMaxMark = super.curQuestion.getMaxMark();
        super.curQuestion.setMaxMark(currentMaxMark - 1);
    }

}
