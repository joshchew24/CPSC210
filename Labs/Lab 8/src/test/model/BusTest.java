package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    private Bus b;
    private Chaperone c1;
    private Chaperone c2;
    private Student s;

    @BeforeEach
    public void setup() {
        b = new Bus(1, 10);
        c1 = new Chaperone("karen");
        c2 = new Chaperone("bob");
        s = new Student(95081204, "josh", 14);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, b.getId());
        assertEquals(10, b.getCapacity());
        assertNull(b.getChaperone());
        assertFalse(b.isFull());
        assertTrue(b.getStudents().isEmpty());
    }

    @Test
    public void testSetChaperoneWhenNone() {
        assertNull(b.getChaperone());
        assertFalse(b.hasChaperone());
        b.setChaperone(c1);
        assertEquals("karen", b.getChaperone().getName());
        assertTrue(b.hasChaperone());
    }

    @Test
    public void testChangeChaperone() {
        b.setChaperone(c1);
        assertEquals("karen", b.getChaperone().getName());
        b.setChaperone(c2);
        assertEquals("bob", b.getChaperone().getName());
        assertTrue(b.hasChaperone());
    }

    @Test
    public void testAddStudentEmpty() {
        assertEquals(0, b.getStudents().size());
        b.addStudent(s);
        assertEquals(1, b.getStudents().size());
        assertEquals(b, s.getAssignedBus());
    }

    @Test
    public void testAddStudentsUntilFull() {
        assertEquals(0, b.getStudents().size());
        for (int i = 1; i <= b.getCapacity(); i++) {
            b.addStudent(new Student(i, "student " + i, i));
            assertEquals(i, b.getStudents().size());
        }
        assertEquals(b.getCapacity(), b.getStudents().size());
        assertTrue(b.isFull());
    }

    @Test
    public void testRemoveAllStudents() {
        // fill the bus to max capacity, ensure bus capacity is maintained
        for (int i = 1; i <= b.getCapacity(); i++) {
            b.addStudent(new Student(i, "student " + i, i));
            assertEquals(i, b.getStudents().size());
        }
        // remove every student, ensure number of students in bus is maintained
        for (int i = 1; i <= b.getCapacity(); i++) {
            b.removeStudent(new Student(i, "student " + i, i));
            assertEquals(b.getCapacity() - i, b.getStudents().size());
        }
    }

    @Test
    public void testRemoveStudentNotInBus() {
        // fill the bus to max capacity, ensure bus capacity is maintained
        for (int i = 1; i <= b.getCapacity(); i++) {
            b.addStudent(new Student(i, "student " + i, i));
            assertEquals(i, b.getStudents().size());
        }
        b.removeStudent(s);
        assertEquals(b.getCapacity(), b.getStudents().size());
    }

    @Test
    public void testEqualsAndHashcode() {
        assertEquals(b, b);

        assertFalse(b.equals(null));
        assertNotEquals(b, s);
        assertNotEquals(new Bus(1234, 1234), b);
        assertEquals(new Bus(1, 10), b);
        assertEquals(new Bus(1, 10).hashCode(), b.hashCode());
    }
}