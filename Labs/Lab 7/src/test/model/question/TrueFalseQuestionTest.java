package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrueFalseQuestionTest extends QuestionTest {
    private TrueFalseQuestion trueFalseQuestion;

    @BeforeEach
    public void runBefore() {
        trueFalseQuestion = new TrueFalseQuestion(3, "1 + 1 = 2?", true);
        question = trueFalseQuestion;
    }

    @Test
    public void testConstructor() {
        assertEquals(3, trueFalseQuestion.getMaxMark());
    }

    @Test
    public void testQuestionString() {
        assertEquals("1 + 1 = 2? [3 points]", trueFalseQuestion.getQuestionString());
    }

    @Test
    public void testCheckAnswerCorrect() {
        assertTrue(trueFalseQuestion.isCorrect("true"));
    }

    @Test
    public void testCheckAnswerIncorrect() {
        assertFalse(trueFalseQuestion.isCorrect("false"));
    }
}