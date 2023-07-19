package starter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class LoggingCalculator {
    private ArrayList<LogEntry> operationLog;
    private Scanner scanner;
    private HashSet<String> operations;

    public LoggingCalculator() {
        operationLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        operations = new HashSet<>();
        processOperations();
    }

    private void processOperations() {
        String operation = "";
        operations.add("plus");
        operations.add("multiply");
        operations.add("subtract");

        while (true) {
            System.out.println("Please select an option (plus, multiply, subtract or quit):");
            operation = scanner.nextLine();
            System.out.println("you selected: " + operation);

            if (operation.equals("quit")) {
                break;
            }
            if (!operations.contains(operation)) {
                System.out.println(operation + " is not a valid operation, please try again.");
            }
            else {
                int result = processOperation(operation);
                System.out.println("that equals " + result);
            }
        }

        System.out.println("Operation log: " + operationLog);
    }

    private int processOperation(String operation) {
        int result = 0;

        System.out.println("Please enter the first number to " + operation);
        int first = scanner.nextInt();
        System.out.println("Please enter the second number to " + operation);
        int second = scanner.nextInt();
        scanner.nextLine(); // clears the line;
                            // otherwise the carriage return is taken as the
                            // next input and you get a blank "selected" loop

        if (operation.equals("plus")) {
            result = first + second;
        }
        else if (operation.equals("multiply")) {
            result = first * second;
        }
        else if (operation.equals("subtract")) {
            result = first - second;
        }
        else {System.out.println("That is not a valid operation.");}
        logResult(operation, first, second, result);

        return result;
    }

    private void logResult(String operation, int first, int second, int result) {
        LogEntry logEntry = new LogEntry();
        logEntry.setOperation(operation);
        logEntry.addOperand(first);
        logEntry.addOperand(second);
        logEntry.setResult(result);
        operationLog.add(logEntry);
    }

    public static void main(String[] args) {
        new LoggingCalculator();
    }
}

