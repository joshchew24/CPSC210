import model.IntegerSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests for IntegerSet
public class IntegerSetTest {
    private static final int NUMITEMS = 5000;
    private IntegerSet set;

    @BeforeEach
    public void runBefore() {
        set = new IntegerSet();
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());

        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        assertEquals(NUMITEMS, set.size());
    }

    @Test
    public void testContainsOne() {
        assertFalse(set.contains(1));
        set.insert(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void testContainsLots() {
        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        for (int i = 0; i < NUMITEMS; i++) {
            assertTrue(set.contains(i));
        }
    }

    @Test
    public void testInsert() {
        set.insert(1);

        assertTrue(set.contains(1));
        assertEquals(1, set.size());
    }

    @Test
    public void testDuplicate() {
        set.insert(1);
        set.insert(1);

        assertTrue(set.contains(1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsertLots() {
        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        assertTrue(set.contains(0));
        assertTrue(set.contains(NUMITEMS / 2));
        assertTrue(set.contains(NUMITEMS - 1));
        assertEquals(NUMITEMS, set.size());
    }

    @Test
    public void testRemove() {
        set.insert(1);
        set.remove(1);
        assertFalse(set.contains(1));
        assertEquals(0, set.size());
    }

    @Test
    public void testRemoveLots() {
        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        for (int i = 0; i < NUMITEMS; i++) {
            set.remove(i);
        }

        assertFalse(set.contains(0));
        assertFalse(set.contains(NUMITEMS / 2));
        assertFalse(set.contains(NUMITEMS - 1));
        assertEquals(0, set.size());
    }

    @Test
    public void testIntersectionFullFull() {
        IntegerSet other = new IntegerSet();

        set.insert(1);
        set.insert(3);
        set.insert(5);
        set.insert(7);
        set.insert(9);

        other.insert(1);
        other.insert(2);
        other.insert(4);
        other.insert(5);
        other.insert(6);
        other.insert(7);
        other.insert(8);

        IntegerSet intersection = set.intersection(other);

        assertTrue(intersection.contains(1));
        assertTrue(intersection.contains(5));
        assertTrue(intersection.contains(7));
        assertEquals(3, intersection.size());
    }

    @Test
    public void testIntersectionEmptyFull() {
        IntegerSet other = new IntegerSet();

        other.insert(1);
        other.insert(2);
        other.insert(4);
        other.insert(5);
        other.insert(6);
        other.insert(7);
        other.insert(8);

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersectionFullEmpty() {
        IntegerSet other = new IntegerSet();

        set.insert(1);
        set.insert(3);
        set.insert(5);
        set.insert(7);
        set.insert(9);

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersectionEmptyEmpty() {
        IntegerSet other = new IntegerSet();

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

}
