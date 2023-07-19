package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker arithmeticAnswerChecker;

    @BeforeEach
    public void setup() {
        arithmeticAnswerChecker = new ArithmeticAnswerChecker(10);
    }

    @Test
    public void testAnswerCorrect() {
        assertTrue(arithmeticAnswerChecker.checkAnswer("10"));
    }

    @Test
    public void testAnswerIncorrect() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("11"));
    }

    @Test
    public void testAnswerNotInt() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("10.00"));
    }

    @Test
    public void testAnswerNotInRange() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("-2147483649"));    // -2147483648 is min
        assertFalse(arithmeticAnswerChecker.checkAnswer("2147483648"));     //  2147483647 is max
    }

    @Test
    public void testAnswerNoNumber() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("ten"));
    }
}
