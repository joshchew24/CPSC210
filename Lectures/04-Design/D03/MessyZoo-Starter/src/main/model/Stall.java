package model;

public class Stall {

    private String animalName;
    private String status;
    private int squareFeet;

    // EFFECTS: creates a Stall object that is messy and of stallSize square feet
    public Stall(String name, String status, int stallSize) {
        animalName = name;
        this.status = status;
        squareFeet = stallSize;
    }

    // MODIFIES: this
    // EFFECTS: resets a stall to messy state
    public void reset() {
        System.out.println(animalName + " has a messy stall!");
        status = "messy";
    }

    // MODIFIES: this
    // EFFECTS: cleans a stall
    public void clean() {
        for (int i = 0; i < squareFeet; i++) {
            System.out.print(".");
        }
        System.out.println("\n" + animalName + " has a clean stall!");
        status = "clean";
    }

    // getters:
    public String getStatus() {
        return status;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    // setters:
    public void setStatus(String status) {
        this.status = status;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }
}
