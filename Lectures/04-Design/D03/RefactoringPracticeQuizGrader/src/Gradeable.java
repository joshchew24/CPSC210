public interface Gradeable {

    void setAnswers(boolean zero, boolean one, boolean two, boolean three, boolean four);

    void printReport();

    Boolean getAnswer(int i);

    void setCorrect(int i);

    void setIncorrect(int i);

    void setGrade(int grade);

    boolean isCorrect(int question);

}
