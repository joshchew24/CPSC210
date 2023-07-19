package people;

import resolutions.ResolutionMaker;

public class Person {
    ResolutionMaker resolutionMaker;

    public Person() {
        resolutionMaker = new ResolutionMaker();
    }

    public void getFit(){
        sayResolution();
        resolutionMaker.workOut();
    }

    public void eatBetter(){
        sayResolution();
        resolutionMaker.eatSalad();
        quitHabits();
        resolutionMaker.iceCream();
        sayResolution();
        resolutionMaker.drinkSmoothies();
    }

    public void beRelaxed(){
        sayResolution();
        resolutionMaker.relaxMore();
        quitHabits();
        resolutionMaker.sleepLate();
    }

    private void sayResolution(){
        System.out.print("I am going to ....");
    }

    private void quitHabits(){
        System.out.print("I am no longer going to ....");
    }

}
