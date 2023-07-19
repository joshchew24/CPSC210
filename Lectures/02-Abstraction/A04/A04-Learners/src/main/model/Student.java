package model;

import java.util.List;

public class Student implements Learner, HasCourses {

    @Override
    public void learn(){
        System.out.println("I am learning!");
    }

    public void drinkCoffee(){
        System.out.println("yummy, black like i like my men!");
    }

    @Override
    public List<Course> getCourses() {
        return null;
    }

    @Override
    public void register(Course c) {

    }
}
