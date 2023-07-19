package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortAnswerCheckerTest {
    private ShortAnswerChecker shortAnswerChecker;

    @BeforeEach
    public void runBefore() {
        shortAnswerChecker = new ShortAnswerChecker("Earth");
    }

    @Test
    public void testCaseMatch() {
        assertTrue(shortAnswerChecker.checkAnswer("Earth"));
    }

    @Test
    public void testCaseInsensitiveMatch() {
        assertTrue(shortAnswerChecker.checkAnswer("eArTh"));
    }

    @Test
    public void testCaseMisMatch() {
        assertFalse(shortAnswerChecker.checkAnswer("erth"));
    }
}