package ui;

import model.Learner;
import model.School;
import model.Student;

public class main {
    public static void main(String[] args) {

        School school = new School();
        Learner person = new Student();
        school.serveCoffee(person); //why is person not compiling?
        school.teach(person);
    }
}
// because it's apparent type is Learner, and serveCoffee requires it's parameter to have apparent type Student