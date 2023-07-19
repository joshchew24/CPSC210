import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Gradeable {
    private ArrayList<Boolean> answers = new ArrayList<>(5);

    //the below is an example of initializing an ArrayList with specific values
    private ArrayList<Boolean> correct = new ArrayList<>(Arrays.asList(false,false,false,false,false));
    private int grade;

    public Student(){
        for (int i=0; i<5; i++){
            answers.add(false);
        }
    }

    //MODIFIES: this
    //EFFECTS:  sets the student's quiz answers
    @Override
    public void setAnswers(boolean zero, boolean one, boolean two, boolean three, boolean four){
        //the below is an example of setting individual elements of an ArrayList
        answers.set(0,zero);
        answers.set(1,one);
        answers.set(2,two);
        answers.set(3,three);
        answers.set(4,four);
    }

    //EFFECTS:  prints out a grade report for the student including each question
    //          individually graded, and a final score for the quiz
    @Override
    public void printReport(){
        for (int i = 0; i < answers.size(); i++) {
            System.out.print("Your answer for question "+i+" was: "+answers.get(i)+".  This was.... ");
            if (correct.get(i)) {
                System.out.println("correct");
            }
            else {
                System.out.println("incorrect");
            }
        }
        System.out.println("Your overall grade was: "+grade);
    }
    @Override
    public Boolean getAnswer(int i) { return answers.get(i); }
    @Override
    public void setCorrect(int i) { this.correct.set(i,true);}
    @Override
    public void setIncorrect(int i) { this.correct.set(i,false); }
    @Override
    public void setGrade(int grade) { this.grade = grade; }
    @Override
    public boolean isCorrect(int question) { return correct.get(question); }
}
