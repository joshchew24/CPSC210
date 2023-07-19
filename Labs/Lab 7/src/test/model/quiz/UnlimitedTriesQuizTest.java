package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTriesQuizTest extends QuizTest {

    private UnlimitedTriesQuiz quiz;

    @BeforeEach
    public void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new UnlimitedTriesQuiz(questionList);
    }

    @Override
    @Test
    public void testConstructor() {
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    public void testSubmitAnswerAllCorrect() {
        quiz.getNextQuestion();
        checkSuccessfulAttemptQ1();
        quiz.getNextQuestion();
        checkSuccessfulAttemptQ2();
    }

    @Test
    public void testSubmitAnswerMultipleAttemptsForOne() {
        String feedback = null;
        int numFailAttempts = 4;
        quiz.getNextQuestion();
        for (int i = 1; i <= numFailAttempts; i++) {
            checkFailAttemptQ1();
        }
        checkSuccessfulAttemptQ1();

        quiz.getNextQuestion();
        checkSuccessfulAttemptQ2();
        assertEquals(6, quiz.getNumAttempts());
        assertEquals("It took you 6 attempts to answer 2 questions correctly.", quiz.endQuiz());
    }

    @Test
    public void testSubmitAnswerMultipleForBoth() {
        String feedback;
        quiz.getNextQuestion();
        checkFailAttemptQ1();
        checkSuccessfulAttemptQ1();
        quiz.getNextQuestion();
        checkFailAttemptQ2();
        checkSuccessfulAttemptQ2();
        assertEquals(4, quiz.getNumAttempts());
        assertEquals("It took you 4 attempts to answer 2 questions correctly.", quiz.endQuiz());
    }



    // EFFECTS: helper for testing a successful attempt at answering question 1
    private void checkSuccessfulAttemptQ1() {
        String feedback;
        try {
            feedback = quiz.submitAnswer("earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
        } catch (AnswerIncorrectException e2) {
            fail("AnswerIncorrectException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing a failed attempt at answering question 1
    private void checkFailAttemptQ1() {
        try {
            quiz.submitAnswer("erth");
            fail("AnswerIncorrectException should have been thrown");
        } catch (AnswerIncorrectException e) {
            assertEquals(0, quiz.getMarkSoFar());
        }
    }

    // EFFECTS: helper for testing a successful attempt at answering question 2
    private void checkSuccessfulAttemptQ2() {
        String feedback;
        try {
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
        } catch (AnswerIncorrectException e) {
            fail("AnswerIncorrectException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing a failed attempt at answering question 2
    private void checkFailAttemptQ2() {
        try {
            quiz.submitAnswer("Cambodia");
            fail("AnswerIncorrectException should have been thrown");
        } catch (AnswerIncorrectException e) {
            assertEquals(4, quiz.getMarkSoFar());
        }
    }

}
