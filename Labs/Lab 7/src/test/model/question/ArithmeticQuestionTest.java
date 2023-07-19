package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.question.ArithmeticQuestion.Operation.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    private ArithmeticQuestion additionQuestion;
    private ArithmeticQuestion subtractionQuestion;
    private ArithmeticQuestion multiplicationQuestion;

    @BeforeEach
    public void setup() {
        additionQuestion = new ArithmeticQuestion(1, ADDITION, 5, 10);
        subtractionQuestion = new ArithmeticQuestion(2, SUBTRACTION, 5, 10);
        multiplicationQuestion = new ArithmeticQuestion(3, MULTIPLICATION, 5, 10);
        question = additionQuestion;
    }

    @Test
    public void testConstructor() {
        assertEquals(1, additionQuestion.getMaxMark());
        assertEquals(2, subtractionQuestion.getMaxMark());
        assertEquals(3, multiplicationQuestion.getMaxMark());
    }

    @Test
    public void testQuestionString() {
        assertEquals("What is 5 + 10? [1 points]", additionQuestion.getQuestionString());
        assertEquals("What is 5 - 10? [2 points]", subtractionQuestion.getQuestionString());
        assertEquals("What is 5 x 10? [3 points]", multiplicationQuestion.getQuestionString());
    }

    @Test
    public void testCheckAnswerCorrect() {
        assertTrue(additionQuestion.isCorrect("15"));
        assertTrue(subtractionQuestion.isCorrect("-5"));
        assertTrue(multiplicationQuestion.isCorrect("50"));
    }

    @Test
    public void testCheckAnswerIncorrect() {
        assertFalse(additionQuestion.isCorrect("-5"));
        assertFalse(subtractionQuestion.isCorrect("50"));
        assertFalse(multiplicationQuestion.isCorrect("15"));
    }


}
