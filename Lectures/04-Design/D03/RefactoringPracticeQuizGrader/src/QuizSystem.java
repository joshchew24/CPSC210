public class QuizSystem {
    public static void main(String[] args) {

        QuizSolution objectsQuiz = new QuizSolution(true,true,false,true,false);

        Gradeable elisa = new Student();

        elisa.setAnswers(true,false,true,true,false);

        objectsQuiz.gradeStudent(elisa);

        elisa.printReport();

    }
}
