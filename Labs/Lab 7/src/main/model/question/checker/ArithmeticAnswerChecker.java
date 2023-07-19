package model.question.checker;

public class ArithmeticAnswerChecker extends AnswerChecker {

    private int answer;

    // EFFECTS: constructs checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    // EFFECTS: returns true if the response is correct, otherwise false.
    //          note: will return false if the userResponse is not an int or is an int that is out of range.
    @Override
    public boolean checkAnswer(String userResponse) {
        try {
            return answer == Integer.parseInt(userResponse);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
