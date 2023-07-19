package model;

public class School {

    public void serveCoffee(Student student){
        student.drinkCoffee();
    }

    public void teach(Learner learner){
        learner.learn();
        learner.drinkCoffee(); //why can't we call this method?
    }
}

// drinkCoffee is not specified in the learner interface