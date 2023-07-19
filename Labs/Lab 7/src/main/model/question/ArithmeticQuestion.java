package model.question;

import model.question.checker.ArithmeticAnswerChecker;

public class ArithmeticQuestion extends Question {

    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION }

    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark,
                processString(operation, firstOp, secondOp),
                new ArithmeticAnswerChecker(processOperation(operation, firstOp, secondOp)));
    }

    // MODIFIES: this
    // EFFECTS: processes an operation based on the given parameters
    private static String processString(Operation operation, int firstOp, int secondOp) {
        String operator;
        switch (operation) {
            case ADDITION:
                operator = "+";
                break;
            case SUBTRACTION:
                operator = "-";
                break;
            default:
                operator = "*";
                break;
        }
        return "What is " + firstOp + " " + operator + " " + secondOp + " ?";
    }

    // EFFECTS: processes an operation
    private static int processOperation(Operation operation, int firstOp, int secondOp) {
        switch (operation) {
            case ADDITION:
                return firstOp + secondOp;
            case SUBTRACTION:
                return firstOp - secondOp;
            default:
                return firstOp * secondOp;
        }
    }
}
