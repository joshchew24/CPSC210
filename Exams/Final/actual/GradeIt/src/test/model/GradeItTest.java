package model;

import model.exception.NoSuchStudentException;
import model.exception.NoSuchSubmissionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// jUnit tests for the GradeIt class
class GradeItTest {
    private GradeIt testGradeIt;

    @BeforeEach
    void runBefore() {
        testGradeIt = new GradeIt();
    }

    // test the case where the getStudentSubmission method is called
    // and a NoSuchSubmissionException is expected
    @Test
    void testGetStudentSubmissionNoSuchSubmission() {
        Student testStudent = new Student("Joshua", "Chew", "95081204");
        Assignment testAss = new Assignment("boring homework", new MarkingScheme(10));
        StudentSubmission testSub = new StudentSubmission(testAss);
        testGradeIt.addStudentSubmission(testStudent, testSub);
        try {
            testGradeIt.getStudentSubmission(testStudent, "epic project");
        } catch (NoSuchStudentException e) {
            fail("NoSuchStudentException should not have been thrown");
        } catch (NoSuchSubmissionException e) {
            // expected;
        }
    }

    // test the case where getStudentSubmission method is called
    // on a GradeIt object when that object has only one student
    // who has only one submission, and that one submission is returned
    // by the call to getStudentSubmission
    @Test
    void testGetStudentSubmission() {
        Student testStudent = new Student("Joshua", "Chew", "95081204");
        Assignment testAss = new Assignment("epic project", new MarkingScheme(42));
        StudentSubmission testSub = new StudentSubmission(testAss);
        testGradeIt.addStudentSubmission(testStudent, testSub);
        try {
            StudentSubmission submission = testGradeIt.getStudentSubmission(testStudent, "epic project");
            assertEquals(submission, testSub);
        } catch (NoSuchStudentException e) {
            fail("NoSuchStudentException should not have been thrown");
        } catch (NoSuchSubmissionException e) {
            fail("NoSuchSubmissionException should not have been thrown");
        }

    }
}