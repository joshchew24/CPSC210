package homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeworkTest {

    @Test
    void testWorkOnTasksEmpty() {
        Homework h = new Homework();
        assertEquals(0, h.numTasksRemaining());
        assertEquals(0, h.hoursToGo());

        List<String> courseNames = h.workOnTasks(1);
        assertEquals(0, courseNames.size());
        assertEquals(0, h.numTasksRemaining());
        assertEquals(0, h.hoursToGo());
    }

    @Test
    void testWorkOnTasksThree() {
        Homework h = new Homework();

        h.addTask("MATH", 1);
        h.addTask("STAT", 3);
        h.addTask("CHIN", 1);

        List<String> courseNames = h.workOnTasks(2);
        assertEquals("MATH", courseNames.get(0));
        assertEquals("STAT", courseNames.get(1));
        assertEquals(2, h.numTasksRemaining());
        assertEquals(4, h.hoursToGo());

        courseNames = h.workOnTasks(2);
        assertEquals("STAT", courseNames.get(0));
        assertEquals(2, h.numTasksRemaining());
        assertEquals(3, h.hoursToGo());

    }


}