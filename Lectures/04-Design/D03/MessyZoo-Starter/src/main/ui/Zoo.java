package ui;

import model.Animal;

import java.util.ArrayList;

public class Zoo {
    private String keeper;
    private String cleaner;
    private String receptionist;
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<String> callers = new ArrayList<>();


    public Zoo(String keeper, String cleaner, String receptionist) {
        this.keeper = keeper;
        this.cleaner = cleaner;
        this.receptionist = receptionist;
    }

    public static void main(String[] args) {
        Zoo messyZoo = new Zoo("Jeckyl", "Hyde", "Frankenstein");
        messyZoo.run();
    }

    private void run() {
        initializeAnimals();
        resetAnimals();
        feedAnimals();
        resetStalls();
        cleanStalls();
        resetAnimals();
        feedAnimals();
        putAnimalsToBed();
        printReports();
        addCallers();
        handleCalls();
    }

    private void initializeAnimals() {
        animals.add(new Animal("Koala", "herbivore", 200));
        animals.add(new Animal("Wolverine", "omnivore", 300));
        animals.add(new Animal("Dragon", "carnivore", 1000));
    }

    // MODIFIES: this
    // EFFECTS: feed all the animals in the morning
    private void feedAnimals() {
        System.out.println(keeper + " is now feeding the animals");
        for (Animal a : animals) {
            a.feed();
            //now this animal shouldn't be hungry
        }
    }

    // MODIFIES: this
    // EFFECTS: clean all the stalls out
    private void cleanStalls() {
        System.out.println(cleaner + " is now cleaning the stalls");
        for (Animal a : animals) {
            a.getStall().clean();
            //now this animal should have a clean stall
            //and the animal should be hungry
        }
    }

    // MODIFIES: this
    // EFFECTS: reset all the animals back to being hungry
    private void resetAnimals() {
        System.out.println(keeper + " is now resetting the animals");
        for (Animal a : animals) {
            a.reset();
        }
    }

    // MODIFIES: this
    // EFFECTS: reset all the stalls
    private void resetStalls() {
        System.out.println(cleaner + " is now resetting the stalls");
        for (Animal a : animals) {
            a.getStall().reset();
            //now this animal's stall stall should be a mess
        }
    }

    // MODIFIES: this
    // EFFECTS: puts all animals to bed
    private void putAnimalsToBed() {
        System.out.println(keeper + " is now putting the animals to bed");
        for (Animal a : animals) {
            a.putToBed();
            //now this animal shouldn't be hungry
        }
    }

    // EFFECTS: print out the reports for the animals for the day.
    private void printReports() {
        for (Animal a : animals) {
            String status = a.getHunger() + " and " + a.getStall().getStatus();
            System.out.println("----->This is a daily report for Animal: " + a.getName() + ".");
            System.out.println("----->As of this time, " + a.getName() + " is:");
            System.out.println("----->...................................." + status);
            System.out.println("----->End of report");
        }
    }

    private void addCallers() {
        callers.add("Kristen");
        callers.add("Edward");
        callers.add("Jacob");
    }

    // EFFECTS: processes callers
    private void handleCalls() {
        System.out.println(receptionist + " is now handling the calls");
        //process callers
        for (String caller : callers) {
            //deal with the caller
            System.out.println("Hello, " + caller + ", how might I help you?");
            //make a report about the call
            System.out.println("----->This is a report for Caller: " + caller);
            System.out.println("----->Caller requisitioned animals to join their team");
            System.out.println("----->Request was denied");
            System.out.println("----->End of report");
        }
    }
}
