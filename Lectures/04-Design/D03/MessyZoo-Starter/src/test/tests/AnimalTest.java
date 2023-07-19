package tests;

import model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal animal;

    @BeforeEach
    public void setup() {
        animal = new Animal("Biff", "carnivore", 200);
    }

    @Test
    public void testConstructor() {
        assertEquals("carnivore", animal.getDiet());
        assertEquals("Biff", animal.getName());
        assertEquals("hungry", animal.getHunger());
        assertEquals("messy", animal.getStall().getStatus());
        assertEquals(200, animal.getStall().getSquareFeet());
        assertEquals(false, animal.isSleeping());
    }


    @Test
    public void testReset() {
        animal.feed();
        animal.putToBed();
        animal.reset();
        assertEquals(false, animal.isSleeping());
        assertEquals("hungry", animal.getHunger());
    }

    @Test
    public void testFeed() {
        animal.feed();
        assertEquals("fed", animal.getHunger());
    }

    @Test
    public void putToBed() {
        animal.putToBed();
        assertEquals(true, animal.isSleeping());
    }
}
