import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizSolution {
    ArrayList<Boolean> answers = new ArrayList<>();

    public QuizSolution(boolean zero, boolean one, boolean two, boolean three, boolean four){
        answers.add(zero);
        answers.add(one);
        answers.add(two);
        answers.add(three);
        answers.add(four);
    }

    //MODIFIES: the Gradeable object
    //EFFECTS:  compares a Gradeable's answers to the solution answers
    //          sets the student's grade to the number of correct answers
    //          sets the correct answers on the Gradeable student
    //          sets the incorrect answers on the Gradeable student
    public void gradeStudent(Gradeable student){
        int numCorrect = 0;
        for (int i=0; i<answers.size(); i++){
            if (answers.get(i) == student.getAnswer(i)){
                student.setCorrect(i);
                numCorrect++;
            }
            else {
                student.setIncorrect(i);
            }
        }
        student.setGrade(numCorrect);
    }


    //REQUIRES: students must all be graded
    //EFFECTS:  given a list of already graded students,
    //          finds all the questions that all the students got correct
    //          and returns those as a list.
    public List<Integer> findAllRightQuestion(ArrayList<Gradeable> students){
        List<Integer> retlist = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        for (Gradeable s : students){
            for (Integer question = 0; question<answers.size(); question++){
                if (!s.isCorrect(question)){
                    retlist.remove(question);
                }
            }
        }
        System.out.println(retlist);
        return retlist;
    }
}
