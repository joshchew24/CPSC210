package tests;

import model.Transcript;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranscriptTest {
    private Transcript t;

    @BeforeEach
    public void setup(){
        t =  new Transcript("testStudent", 95081204);
        t.addGrade("CPSC-210", 4.0);
        t.addGrade("MATH-200", 3.0);
        t.addGrade("CHIN-131", 1.0);
        t.addGrade("STAT-251", 2.0);
    }

    @Test
    public void testGetCourseAndGrade(){
        assertEquals("CHIN-131: 1.0", t.getCourseAndGrade("CHIN-131"));
        assertEquals("STAT-251: 2.0", t.getCourseAndGrade("STAT-251"));
        assertEquals("MATH-200: 3.0", t.getCourseAndGrade("MATH-200"));
        assertEquals("CPSC-210: 4.0", t.getCourseAndGrade("CPSC-210"));


    }

    @Test
    public void testGetStudentName(){
        assertEquals("testStudent", t.getStudentName());
        t.setStudentName("Joshua");
        assertEquals("Joshua", t.getStudentName());
    }

    @Test
    public void testGetStudentID(){
        assertEquals(95081204, t.getStudentID());
        t.setStudentID(12345678);
        assertEquals(12345678, t.getStudentID());
    }

    @Test
    public void testGetGPA(){
        assertEquals(2.5, t.getGPA());
        t.addGrade("ATSC-113", 4.0);
        t.addGrade("PHIL-220", 4.0);
        t.addGrade("DSCI-100", 4.0);
        assertEquals(22.0/7.0, t.getGPA());
    }

}
