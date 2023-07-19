package model;

public class Pizza {
    private int numToppings;
    private String name;

    public Pizza(String name) {
        this.name = name;
        numToppings = 0;
    }

    public void addATopping() {
        numToppings++;
    }

    public void removeATopping() {
        numToppings--;
    }

    public void print() {
        System.out.println(name + " pizza has " + numToppings + " toppings");
    }
}
