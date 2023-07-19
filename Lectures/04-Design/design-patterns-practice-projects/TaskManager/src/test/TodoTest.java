package test;

import model.Doable;
import model.Task;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoTest {

    private Todo todo0;

    private Todo todo1;

    private Todo todo2;
    private Task t1;
    private Task t2;
    private Task t3;

    private Todo todo3;
    private Task t4;
    private Task t5;


    @Before
    public void setup() {
        todo0 = new Todo("Throw Party");

        todo1 = new Todo("Send out invitations");

        todo2 = new Todo("Get cake ingredients");
        t1 = new Task("Buy flour", "09/12/2017", "Whole Foods");
        t2 = new Task("Get a new cake tin", "09/13/2017", "Williams Sonoma");
        t3 = new Task("Buy a dozen eggs", "09/12/2017", "Farmer's Market");
        todo2.addDoable(t1);
        todo2.addDoable(t2);
        todo2.addDoable(t3);

        todo3 = new Todo("Bake cake and food");
        t4 = new Task("Mix flour", "09/14/2017", "Anna's house");
        t5 = new Task("Grill fillet", "09/14/2017", "Anna's grill");
        todo3.addDoable(t4);
        todo3.addDoable(t5);

        todo0.addDoable(todo1);
        todo0.addDoable(todo2);
        todo0.addDoable(todo3);
    }

    @Test
    public void testConstructor() {
        assertEquals("Throw Party", todo0.getDescription());
    }

    @Test
    public void testAddDoable() {
        assertTrue(todo0.getSubs().contains(todo1));
        assertTrue(todo0.getSubs().contains(todo2));
        assertTrue(todo0.getSubs().contains(todo3));

        assertTrue(todo1.getSubs().isEmpty());

        assertTrue(todo2.getSubs().contains(t1));
        assertTrue(todo2.getSubs().contains(t2));
        assertTrue(todo2.getSubs().contains(t3));

        assertTrue(todo3.getSubs().contains(t4));
        assertTrue(todo3.getSubs().contains(t5));

        assertFalse(todo0.getSubs().contains(t1));
        assertFalse(todo1.getSubs().contains(todo0));
        assertFalse(todo1.getSubs().contains(todo2));
    }

    @Test
    public void testRemoveDoable() {
        assertTrue(todo0.getSubs().contains(todo1));
        assertFalse(todo0.getSubs().contains(t1));

        todo0.removeDoable(todo1);

        assertFalse(todo0.getSubs().contains(todo1));
        assertFalse(todo0.getSubs().contains(t1));
    }

    @Test
    public void testComplete() {
        assertFalse(todo0.areSubsComplete());

        for (Doable d : todo0.getSubs()) {
            d.complete();
        }

        assertTrue(todo0.areSubsComplete());
        assertFalse(todo0.isComplete());

        todo0.complete();

        assertTrue(todo0.isComplete());
    }

}
