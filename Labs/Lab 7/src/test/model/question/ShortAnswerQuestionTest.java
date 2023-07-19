package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortAnswerQuestionTest extends QuestionTest {
    private ShortAnswerQuestion shortAnswerQuestion;

    @BeforeEach
    public void runBefore() {
        shortAnswerQuestion = new ShortAnswerQuestion(5, "What colour is the sky?", "blue");
        question = shortAnswerQuestion;
    }

    @Test
    public void testConstructor() {
        assertEquals(5, shortAnswerQuestion.getMaxMark());
    }

    @Test
    public void testQuestionString() {
        assertEquals("What colour is the sky? [5 points]", shortAnswerQuestion.getQuestionString());
    }

    @Test
    public void testCheckAnswerCorrect() {
        assertTrue(shortAnswerQuestion.isCorrect("blue"));
    }

    @Test
    public void testCheckAnswerIncorrect() {
        assertFalse(shortAnswerQuestion.isCorrect("black"));
    }
}