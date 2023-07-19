import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuizSolutionTest {
    @Test
    public void testFindAllCorrectQuestionTwoAllRight(){
        Gradeable s1 = new Student();
        Gradeable s2 = new Student();
        Gradeable s3 = new Student();
        QuizSolution quiz = new QuizSolution(true,true,true,true,true);
        s1.setAnswers(true,true,true,false,false);
        s2.setAnswers(false,true,true,true,false);
        s3.setAnswers(true,false,true,true,true);
        ArrayList<Gradeable> students = new ArrayList<>();
        students.add(s1); students.add(s2); students.add(s3);
        quiz.gradeStudent(s1);
        quiz.gradeStudent(s2);
        quiz.gradeStudent(s3);
        List<Integer> allRight = quiz.findAllRightQuestion(students);
        assertTrue(allRight.contains(2));
        assertEquals(1,allRight.size());
    }
}
