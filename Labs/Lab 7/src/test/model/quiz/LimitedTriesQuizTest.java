package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class LimitedTriesQuizTest extends QuizTest {

    private LimitedTriesQuiz quiz;
    private int question1MaxMark;
    private int question2MaxMark;
    private int quizMaxMark;

    @BeforeEach
    public void runBefore() {
        QuestionList questionList = generateQuestionList();
        // instantiate a quiz to set the max mark local variables
        quiz = new LimitedTriesQuiz(questionList);
        quiz.getNextQuestion();
        question1MaxMark = quiz.curQuestion.getMaxMark();
        quiz.getNextQuestion();
        question2MaxMark = quiz.curQuestion.getMaxMark();
        quizMaxMark = quiz.getMaxMark();
        // restart the quiz to it's original state to teset with
        quiz = new LimitedTriesQuiz(questionList);
    }

    @Override
    @Test
    public void testConstructor() {
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    public void testSubmitAnswerAllCorrect() {
        quiz.getNextQuestion();
        assertEquals(4, question1MaxMark);
        checkSuccessfulAttemptQ1();
        assertEquals(4, question1MaxMark);
        assertEquals(4, quiz.getMarkSoFar());

        quiz.getNextQuestion();
        assertEquals(2, question2MaxMark);
        checkSuccessfulAttemptQ2();
        assertEquals(2, question2MaxMark);
        assertEquals(6, quiz.getMarkSoFar());
    }

    @Test
    public void testSubmitAnswerMultipleAttemptsWithSuccess() {
        quiz.getNextQuestion();
        // fail attempts until there is only one attempt remaining
        for (int i = 4; i > 1; i--) {
            // make sure question 1 max mark is decrementing properly
            assertEquals(i, question1MaxMark);
            // make sure max mark is not changing
            assertEquals(6, quizMaxMark);
            checkIncorrectAttemptQ1();
        }
        checkSuccessfulAttemptQ1();
        assertEquals(1, quiz.getMarkSoFar());

        quiz.getNextQuestion();
        // fail one attempt and then succeed for q2
        assertEquals(2, question2MaxMark);
        checkIncorrectAttemptQ2();
        assertEquals(1, question1MaxMark);
        checkSuccessfulAttemptQ2();
        assertEquals(2, quiz.getMarkSoFar());
    }

    @Test
    public void testUsedAllAttemptsQ1() {
        quiz.getNextQuestion();
        // fail attempts until one left
        for (int i = 4; i > 1; i--) {
            // make sure question 1 max mark is decrementing properly
            assertEquals(i, question1MaxMark);
            // make sure max mark is not changing
            assertEquals(6, quizMaxMark);
            checkIncorrectAttemptQ1();
        }
        // make sure you cannot gain marks from attempting a question with no attempts left
        for (int i = 0; i < 5; i++) {
            checkNoAttemptsLeftQ1();
        }

        quiz.getNextQuestion();
        checkIncorrectAttemptQ2();
        checkNoAttemptsLeftQ2();
    }

    // EFFECTS: helper for testing a successful attempt at answering question 1
    private void checkSuccessfulAttemptQ1() {
        String feedback;
        try {
            feedback = quiz.submitAnswer("earth");
            assertEquals("Correct!", feedback);
        } catch (AnswerIncorrectException e2) {
            fail("AnswerIncorrectException should not have been thrown");
        } catch (OutOfTriesException e) {
            fail("OutOfTriesException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing a failed attempt at answering question 1
    private void checkIncorrectAttemptQ1() {
        try {
            quiz.submitAnswer("erth");
            fail("AnswerIncorrectException should have been thrown");
        } catch (AnswerIncorrectException e) {
            question1MaxMark = quiz.curQuestion.getMaxMark();
            assertEquals(0, quiz.getMarkSoFar());
        } catch (OutOfTriesException e) {
            fail("OutOfTriesException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing an attempt at answering question 1 with no tries left
    private void checkNoAttemptsLeftQ1() {
        try {
            quiz.submitAnswer("erth");
            fail("OutOfTriesException should have been thrown");
        } catch (AnswerIncorrectException e) {
            fail("AnswerIncorrectException should have been thrown");
        } catch (OutOfTriesException e) {
            // expected, max mark doesn't change but user should not be able to gain marks for this question anymore
            assertEquals(1, question1MaxMark);
            assertEquals(0, quiz.getMarkSoFar());
        }
    }

    // EFFECTS: helper for testing a successful attempt at answering question 2
    private void checkSuccessfulAttemptQ2() {
        String feedback;
        try {
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertFalse(quiz.hasMoreQuestions());
        } catch (AnswerIncorrectException e) {
            fail("AnswerIncorrectException should not have been thrown");
        } catch (OutOfTriesException e) {
            fail("OutOfTriesException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing a failed attempt at answering question 2
    private void checkIncorrectAttemptQ2() {
        try {
            quiz.submitAnswer("Cambodia");
            fail("AnswerIncorrectException should have been thrown");
        } catch (AnswerIncorrectException e) {
            question2MaxMark = quiz.curQuestion.getMaxMark();
        } catch (OutOfTriesException e) {
            fail("OutOfTriesException should not have been thrown");
        }
    }

    // EFFECTS: helper for testing an attempt at answering question 2 with no tries left
    private void checkNoAttemptsLeftQ2() {
        try {
            quiz.submitAnswer("Cambodia");
            fail("OutOfTriesException should have been thrown");
        } catch (AnswerIncorrectException e) {
            fail("AnswerIncorrectException should have been thrown");
        } catch (OutOfTriesException e) {
            // expected, max mark doesn't change but user should not be able to gain marks for this question anymore
            assertEquals(1, question2MaxMark);
            assertEquals(0, quiz.getMarkSoFar());
        }
    }
}
