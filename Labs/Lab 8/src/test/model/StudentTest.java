package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Bus b1;
    private Bus b2;
    private Chaperone c;
    private Student s;

    @BeforeEach
    public void setup() {
        b1 = new Bus(1, 10);
        b2 = new Bus(2, 5);
        c = new Chaperone("karen");
        s = new Student(95081204, "josh", 14);
    }

    @Test
    public void testConstructor() {
        assertEquals(95081204, s.getId());
        assertEquals("josh", s.getName());
        assertEquals(14, s.getGrade());
        assertFalse(s.isAssignedToBus());
    }

    @Test
    public void testAssignToBus() {
        s.assignToBus(b1);
        assertTrue(s.isAssignedToBus());
        assertEquals(b1, s.getAssignedBus());
        assertTrue(b1.getStudents().contains(s));
    }

    @Test
    public void testAssignToSameBusTwice() {
        s.assignToBus(b1);
        assertEquals(b1, s.getAssignedBus());
        assertTrue(b1.getStudents().contains(s));
        s.assignToBus(b1);
        assertEquals(b1, s.getAssignedBus());
        assertTrue(b1.getStudents().contains(s));
        assertEquals(1, b1.getStudents().size());
    }

    @Test
    public void testChangeBus() {
        s.assignToBus(b1);
        assertEquals(b1, s.getAssignedBus());
        assertTrue(b1.getStudents().contains(s));
        s.assignToBus(b2);
        assertEquals(b2, s.getAssignedBus());
        assertFalse(b1.getStudents().contains(s));
        assertTrue(b2.getStudents().contains(s));
    }

    @Test
    public void testRemoveBus() {
        s.assignToBus(b1);
        assertEquals(b1, s.getAssignedBus());
        assertTrue(b1.getStudents().contains(s));
        s.removeFromBus();
        assertNull(s.getAssignedBus());
        assertFalse(b1.getStudents().contains(s));
    }

    @Test
    public void testEqualsAndHashcode() {
        assertEquals(s, s);

        assertFalse(s.equals(null));
        assertNotEquals(s, new Bus(111, 111));

        assertNotEquals(new Student(40218059, "john", 41), s);
        assertEquals(new Student(95081204, "josh", 14), s);
        assertEquals(s.hashCode(), new Student(95081204, "josh", 14).hashCode());
    }
}