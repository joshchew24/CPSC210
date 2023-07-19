package tests;

import model.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StallTest {

    Animal testAnimal;

    @BeforeEach
    public void Setup() {
        testAnimal = new Animal("john", "ur mom", 69);
    }

    @Test
    public void testResetStall() {
        testAnimal.getStall().reset();
        Assertions.assertEquals("messy", testAnimal.getStall().getStatus());
    }

    @Test
    public void testCleanStall() {
        testAnimal.getStall().clean();
        Assertions.assertEquals("clean", testAnimal.getStall().getStatus());
    }
}